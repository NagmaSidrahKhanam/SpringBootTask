package com.stackroute.muzixassignment.service;

import com.stackroute.muzixassignment.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixassignment.exceptions.TrackNotFoundException;
import com.stackroute.muzixassignment.model.Track;
import com.stackroute.muzixassignment.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TrackServiceImpl implements TrackService {
    TrackRepository trackRepository;
    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository)
    {
        this.trackRepository=trackRepository;
    }
    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        if(trackRepository.existsById(track.getId()))
        {
            throw new TrackAlreadyExistsException("user already exists");
        }
        Track savedTrack=trackRepository.save(track);
        if(savedTrack==null)
        {
            throw new TrackAlreadyExistsException("user alraedy exists");
        }
        return savedTrack;

    }


    @Override
    public List<Track> getAllTrack() {
        return trackRepository.findAll();
    }

    @Override
    public boolean deleteTrack(int id) throws TrackNotFoundException {
        Optional<Track> track1 = trackRepository.findById(id);

        if(!track1.isPresent())
        {
            throw new TrackNotFoundException("User Not Found");
        }

        try {

            trackRepository.delete(track1.get());

            return true;

        }
        catch (Exception exception)
        {
            return false;
        }
    }

    @Override
    public List<Track> getTrackByName(String firstName) throws TrackNotFoundException {
        List<Track> track=trackRepository.getUserByName(firstName);
        if(track.isEmpty())
        {
            throw new TrackNotFoundException("User not found");
        }

        return trackRepository.getUserByName(firstName);
    }

    @Override
    public Track updateTrack(int id,Track track) {
        Track updateTrack=trackRepository.save(track);
        return updateTrack;
    }
}
