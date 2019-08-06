package com.stackroute.muzix.service;

import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackNotFoundException;
import com.stackroute.muzix.model.Track;
import com.stackroute.muzix.repositories.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    TrackRepository userRepository;
    @Autowired
    public UserServiceImpl(TrackRepository userRepository)
    {
        this.userRepository=userRepository;
    }
    @Override
    public Track saveUser(Track user) {

        Track savedUser=userRepository.save(user);
        if(userRepository.existsById(user.getId()))
        {
            try {
                throw new TrackAlreadyExistsException("User already exists");
            } catch (TrackAlreadyExistsException e) {
                e.printStackTrace();
            }
        }
        if(savedUser==null)
        {
            try {
                throw new TrackAlreadyExistsException("User alraedy exists");
            } catch (TrackAlreadyExistsException e) {
                e.printStackTrace();
            }
        }
        return savedUser;
    }

    @Override
    public List<Track> getAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public void deleteUser(int id)
    {

        userRepository.deleteById(id);
    }

    @Override
    public Track getUserById(int userid) {
        return null;
    }

    @Override
    public List<Track> getUserbyName(String firstName) {
        List<Track> user=userRepository.getUserbyName(firstName);
        if(user.isEmpty())
        {
            try {
                throw new TrackNotFoundException("User not found");
            } catch (TrackNotFoundException e) {
                e.printStackTrace();
            }
        }

        return userRepository.getUserbyName(firstName);
    }


    @Override
    public Track updateUser(int id, Track user) {
        Track updateUser=userRepository.save(user);
        return updateUser;
    }

}