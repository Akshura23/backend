package com.mudithakshura.backend.controller;

import com.mudithakshura.backend.model.User;
import com.mudithakshura.backend.repository.UserRepostitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* Created by mudith akshura */
@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
    @Autowired
    private UserRepostitory userRepostitory;

    @PostMapping("/user")
    User newUser(@RequestBody User newUser){
        return userRepostitory.save(newUser);
    }

    @GetMapping("/users")
    List<User> getAllUsers(){
        return userRepostitory.findAll();
    }
}
