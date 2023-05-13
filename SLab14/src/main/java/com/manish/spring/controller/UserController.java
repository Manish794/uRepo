package com.manish.spring.controller;

import com.manish.spring.model.Response;
import com.manish.spring.model.User;
import com.manish.spring.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
            },
            method= RequestMethod.GET )
    public Response<List<User>> getUsers(){
        log.info("UserController-> getUsers called");
        return userService.getUsers();
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method= RequestMethod.POST)
    public Response<User> addUser(@RequestBody User user){
        log.info("UserController-> addUser called");
        return userService.addUser(user);
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method= RequestMethod.PUT)
    public Response<User> updateUser(@RequestBody User user){
        log.info("UserController-> updateUser called");
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/searchByPhone",produces = MediaType.APPLICATION_JSON_VALUE,
            method= RequestMethod.GET)
    public Response<User> getUserByPhone(@RequestParam("phone") long phone){
        log.info("UserController-> getUserByPhone called");
        return userService.getUserByPhone(phone);
    }

    @RequestMapping(value = "/email/{userEmail}", produces = MediaType.APPLICATION_JSON_VALUE,
            method= RequestMethod.GET)
    public Response<User> getUserByEmail(@PathVariable("userEmail") String email){
        log.info("UserController-> getUserByPhone called");
        return userService.getUserByEmail(email);
    }

    @RequestMapping(value = "/{uid}" , produces = MediaType.APPLICATION_JSON_VALUE,
            method= RequestMethod.GET)
    public Response<User> getUserById(@PathVariable("uid") String id){
        log.info("UserController-> getUserById called");
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/{uid}" , produces = MediaType.APPLICATION_JSON_VALUE,
            method= RequestMethod.DELETE)
    public Response<Boolean> deleteUserById(@PathVariable("uid") String id){
        log.info("UserController-> deleteUserById called");
        return userService.deleteUserById(id);
    }

}
