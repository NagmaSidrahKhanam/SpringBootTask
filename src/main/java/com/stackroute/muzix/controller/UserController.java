package com.stackroute.muzix.controller;

import com.stackroute.muzix.model.User;
import com.stackroute.muzix.service.UserService;
import com.stackroute.muzix.service.UserServiceImpl;
import com.wordnik.swagger.annotations.ApiOperation;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //represents rest controller
//It’s a convenience annotation that combines @Controller and @ResponseBody and as a result,
// simplifies the controller implementation:
@RequestMapping(value = "api/v1")
//Annotation for mapping web requests onto methods in request-handling
// classes with flexible method signatures.
//@Api(value="onlinestore", description="Operations pertaining to products in Online Store")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController() {
    }
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @ApiOperation(value = "View a list of available products",response = Iterable.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successfully retrieved list"),
//            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
//            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
//            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
//    }
//    )
@RequestMapping(value="/user", method = RequestMethod.POST, produces = "application/json")

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

//    @ApiOperation(value = "get all useres",response = User.class)
    @GetMapping("user")
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.OK);
    }


    @ApiOperation(value = "Delete a product")
    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
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



//    @ApiOperation(value = "Update a user")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT,
            produces = "application/json")
    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id,@RequestBody User user)
    {
        ResponseEntity responseEntity;
        try
        {
            userService.updateUser(id,user);
            responseEntity=new ResponseEntity("successfully updated",HttpStatus.OK);
            return new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.OK);

        }
        catch(Exception ex)
        {
            responseEntity=new ResponseEntity(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

//    @ApiOperation(value = "get user by name a product")
    @RequestMapping(value="/user/{name}", method = RequestMethod.GET, produces = "application/json")
    @GetMapping("/user/{name}")
    public ResponseEntity<?> getUserbyName(@PathVariable("name") String name)
    {
        ResponseEntity responseEntity;
        try
        {
            userService.getUserbyName(name);
            return new ResponseEntity<List<User>>(userService.getUserbyName(name),HttpStatus.OK);

        }
        catch(Exception ex)
        {
            responseEntity=new ResponseEntity(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

}