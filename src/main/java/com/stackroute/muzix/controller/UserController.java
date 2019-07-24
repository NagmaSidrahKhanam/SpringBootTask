package com.stackroute.muzix.controller;

import com.stackroute.muzix.model.User;
import com.stackroute.muzix.service.UserService;
import com.stackroute.muzix.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value=  "/api/v1")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController() {
    }

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("user")
    public ResponseEntity<?> saveUser(@RequestBody User user){
    ResponseEntity responseEntity;
    try{
    userService.saveUser(user);
    responseEntity = new ResponseEntity<String>("Successfully Created ",HttpStatus.CREATED);
    }
    catch(Exception e){
    responseEntity= new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
    }
    return responseEntity;
    }

    @GetMapping("user")
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.OK);
    }



        @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id){
        ResponseEntity responseEntity;
        try{
            userService.deleteUser(id);
            responseEntity = new ResponseEntity<String>("Successfully deleted ",HttpStatus.OK);
        }
        catch(Exception e){
            responseEntity= new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
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


}