package com.stackroute.muzix.service;

import com.stackroute.muzix.model.Track;

import java.util.List;

public interface UserService {


    public Track saveUser(Track user);

    public List<Track> getAllUsers();

    public void deleteUser(int id);

    public Track getUserById(int userid);

    public Track updateUser(int id, Track user);

    public List<Track> getUserbyName(String name);

}
