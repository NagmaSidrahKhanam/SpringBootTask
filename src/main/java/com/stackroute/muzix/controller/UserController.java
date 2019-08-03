package com.stackroute.muzix.controller;
import com.stackroute.muzix.exceptions.UserAlreadyExistsException;
import com.stackroute.muzix.exceptions.UserNotFoundException;
import com.stackroute.muzix.model.User;
import com.stackroute.muzix.service.UserService;
import com.stackroute.muzix.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
//represents rest controller
//It’s a convenience annotation that combines @Controller and @ResponseBody and as a result,
// simplifies the controller implementation:
@RequestMapping("/api/v1")
//Annotation for mapping web requests onto methods in request-handling
// classes with flexible method signatures.
@ControllerAdvice(basePackages="com.stackroute.muzix")
public class UserController {
    UserService userService;


    public UserController(UserService userService)
    {
        this.userService=userService;
    }

    @PostMapping("user")
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<?> saveuser(@RequestBody User user)
    {
        ResponseEntity responseEntity;
        try
        {
            userService.saveUser(user);
            responseEntity=new ResponseEntity<String>("successfully created",HttpStatus.CREATED);
        }
        catch(UserAlreadyExistsException ex)
        {
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("user")
    public ResponseEntity<?> getAllUser(){
        return new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.OK);
    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id){
        ResponseEntity responseEntity;
        try
        {
            userService.deleteUser(id);
            responseEntity=new ResponseEntity("successfully deleted",HttpStatus.OK);
        }
        catch(Exception ex)
        {
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }


    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id,@RequestBody User user)
    {
        ResponseEntity responseEntity;
        try
        {
            userService.updateUser(id,user);
            responseEntity=new ResponseEntity("successfully updated",HttpStatus.OK);
        }
        catch(Exception ex)
        {
            responseEntity=new ResponseEntity(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
    @GetMapping("user/{firstName}")
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> getTrackbyName(@PathVariable String firstName) {

        ResponseEntity responseEntity;

        try {
            responseEntity = new ResponseEntity<List<User>>(userService.getUserbyName(firstName), HttpStatus.CREATED);


        } catch (UserNotFoundException e) {
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);

        }
        return responseEntity;

    }
}

