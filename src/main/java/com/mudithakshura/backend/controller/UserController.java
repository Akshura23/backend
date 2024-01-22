package com.mudithakshura.backend.controller;

import com.mudithakshura.backend.model.User;
import com.mudithakshura.backend.repository.UserRepostitory;
import com.mudithakshura.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* Created by mudith akshura */

@RestController
@RequestMapping("/api") // can be like this ("/api/v1/user") See SecurityConfig.securityFilterChain
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class UserController {
    @Autowired
    private final UserRepostitory userRepostitory;

    @Autowired
    private final UserService userService;

    @GetMapping("/user")
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hi User");
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){

        return userRepostitory.findAll();
    }

    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable("userId") Integer id){
        return userRepostitory.findUserById(id);
    }
    @GetMapping("/users/profile")
    public User getUserFromToken(@RequestHeader ("Authorization") String jwt){
        String token = jwt.startsWith("Bearer ") ? jwt.substring(7) : jwt;
        return userService.findUserByJwt(token);
    }

}
