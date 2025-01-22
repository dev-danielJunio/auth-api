package com.example.login_CRUD.controller;

import com.example.login_CRUD.model.entities.User;
import com.example.login_CRUD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> postUser(@RequestBody User user){
        User createUser = userService.createUser(user);
        return ResponseEntity.ok(createUser);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
        User updateUser = userService.updateUser(id, user);
        return ResponseEntity.ok(updateUser);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        if (userService.deleteById(id)) {
            return ResponseEntity.ok("User deleted"); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }


}
