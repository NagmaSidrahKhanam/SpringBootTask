package com.stackroute.muzix.service;

import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackNotFoundException;
import com.stackroute.muzix.model.Track;

import java.util.List;

public interface UserService {


    public Track saveUser(Track user) throws TrackAlreadyExistsException;

    public List<Track> getAllUsers();

    public void deleteUser(int id)throws TrackNotFoundException;

    public Track getUserById(int userid);

    public Track updateUser(int id, Track user);

    public List<Track> getUserbyName(String name)throws TrackNotFoundException;

}
