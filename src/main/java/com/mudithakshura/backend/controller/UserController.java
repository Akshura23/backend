package com.mudithakshura.backend.controller;

import com.mudithakshura.backend.model.User;
import com.mudithakshura.backend.repository.UserRepostitory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* Created by mudith akshura */

@RestController
@RequestMapping("/api/user") // can be like this ("/api/v1/user") See SecurityConfig.securityFilterChain
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class UserController {
    @Autowired
    private UserRepostitory userRepostitory;

    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hi User");
    }

    @GetMapping("/users")
    List<User> getAllUsers(){

        return userRepostitory.findAll();
    }
}
