package com.example.springsecurityresful.controller;

import com.example.springsecurityresful.entity.User;
import com.example.springsecurityresful.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    public UserRepository userRepository;


    @GetMapping
    public ResponseEntity<List> fetchAll(){
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }


    @GetMapping("{id}")
    public ResponseEntity<User> fetchById(@PathVariable("id") Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user.get());

    }



}
