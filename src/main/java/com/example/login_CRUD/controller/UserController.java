package com.example.login_CRUD.controller;

import com.example.login_CRUD.model.entities.User;
import com.example.login_CRUD.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")

public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<User> postUser(@RequestBody User user){
        User savedUser = userRepository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping(value = "{id}")
    public User findById(@PathVariable Long id){
        return userRepository.findById(id).get();
    }

    @GetMapping
    public List<User> getAllUser(){
        return userRepository.findAll();
    }


}
