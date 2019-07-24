package com.stackroute.muzix.service;

import com.stackroute.muzix.exceptions.UserAlreadyExistsException;
import com.stackroute.muzix.exceptions.UserNotFoundException;
import com.stackroute.muzix.model.User;
import com.stackroute.muzix.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }
    @Override
    public User saveUser(User user) {

        User savedUser=userRepository.save(user);
        if(userRepository.existsById(user.getId()))
        {
            try {
                throw new UserAlreadyExistsException("User already exists");
            } catch (UserAlreadyExistsException e) {
                e.printStackTrace();
            }
        }
        if(savedUser==null)
        {
            try {
                throw new UserAlreadyExistsException("User alraedy exists");
            } catch (UserAlreadyExistsException e) {
                e.printStackTrace();
            }
        }
        return savedUser;
    }

    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public void deleteUser(int id)
    {

        userRepository.deleteById(id);
    }

    @Override
    public User getUserById(int userid) {
        return null;
    }

    @Override
    public List<User> getUserbyName(String firstName) {
        List<User> user=userRepository.getUserbyName(firstName);
        if(user.isEmpty())
        {
            try {
                throw new UserNotFoundException("User not found");
            } catch (UserNotFoundException e) {
                e.printStackTrace();
            }
        }

        return userRepository.getUserbyName(firstName);
    }


    @Override
    public User updateUser(int id,User user) {
        User updateUser=userRepository.save(user);
        return updateUser;
    }

}