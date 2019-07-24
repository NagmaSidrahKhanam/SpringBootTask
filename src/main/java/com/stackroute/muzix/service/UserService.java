package com.stackroute.muzix.service;

import com.stackroute.muzix.exceptions.UserAlreadyExistsException;
import com.stackroute.muzix.exceptions.UserNotFoundException;
import com.stackroute.muzix.model.User;

import java.util.List;

public interface UserService {


    public User saveUser(User user) throws UserAlreadyExistsException;

    public List<User> getAllUsers();

    public void deleteUser(int id)throws UserNotFoundException;

    public User getUserById(int userid);

    public User updateUser(int id,User user);

    public List<User> getUserbyName(String name)throws UserNotFoundException ;

}
