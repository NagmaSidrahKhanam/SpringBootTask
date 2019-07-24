package com.stackroute.muzix.service;

import com.stackroute.muzix.model.User;
import com.stackroute.muzix.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User add(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        User user1 = userRepository.save(user);
        return user1;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public User getUserById(int id){

        return userRepository.getOne(id);
    }

    @Override
    public User updateUser(int id,User user) {
        return userRepository.save(user);
    }

}