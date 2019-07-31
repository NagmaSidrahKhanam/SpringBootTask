package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exception.TrackAlreadyExistsException;
import com.stackroute.muzix.exception.TrackNotFoundException;
import com.stackroute.muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {

    TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {

        if (trackRepository.existsById(track.getId())) {
            throw new TrackAlreadyExistsException("Track already exists");
        }
        Track track1 = trackRepository.save(track);
        if (track1 == null) {
            throw new TrackAlreadyExistsException("Track already exists");

        }
        return track1;
    }

    @Override
    public List<Track> getAllTracks() throws TrackNotFoundException {

        System.out.println(trackRepository.findAll().size());
        if (trackRepository.findAll().size() == 0) {
            throw new TrackNotFoundException("No track found");
        }
        return trackRepository.findAll();
    }

    @Override
    public int deleteTrack(long id) {
        System.out.println(id);

        Long l = new Long(id);
        int i = l.intValue();
        Track track = new Track();
        try {
            trackRepository.deleteById(i);
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }

    }

    @Override
    public Track getTrackById(int id) {
        Track track2 = trackRepository.getOne(id);
        return track2;
    }

    @Override
    public List<Track> getTrackbyName(String name) {

        return trackRepository.getTrackbyName(name);
    }

    @Override
    public Track UpdateTrack(int id, Track track) throws TrackNotFoundException {

        Track track1;
        if (trackRepository.existsById(id)) {
            track1 = trackRepository.save(track);
        } else {
            throw new TrackNotFoundException("No track found with id:" + id);

        }
        return track1;

    }
}
