package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exception.TrackAlreadyExistsException;
import com.stackroute.muzix.exception.TrackNotFoundException;

import java.util.List;

public interface TrackService {

    public Track saveTrack(Track track) throws TrackAlreadyExistsException;

    public List<Track>getAllTracks() throws TrackNotFoundException;

    public int deleteTrack(long id);

    public Track getTrackById(int id);

    public List<Track> getTrackbyName(String name);


    public Track UpdateTrack(int id, Track track)throws TrackNotFoundException;
}
