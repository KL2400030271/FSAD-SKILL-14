package com.klu.backend_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.backend_1.model.User;
import com.klu.backend_1.repository.UserRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository repo;

    // ✅ REGISTER
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        repo.save(user);
        return "User registered successfully";
    }

    // ✅ LOGIN (IMPORTANT CHANGE)
    @PostMapping("/login")
    public User login(@RequestBody User user) {

        Optional<User> existingUser = repo.findByUsername(user.getUsername());

        if (existingUser.isPresent()) {
            User dbUser = existingUser.get();

            if (dbUser.getPassword().equals(user.getPassword())) {
                return dbUser; // ✅ return full user object
            }
        }

        throw new RuntimeException("Invalid credentials");
    }

    // ✅ GET USER PROFILE
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }
}