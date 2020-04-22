package com.intern.spring.controllers;

import com.intern.spring.models.Users;
import com.intern.spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Users> getAllUser() {
        return userService.findAll();
    }

    @PostMapping
    public Users createUse(@RequestBody Users users) {
        users.setId(0);
        userService.save(users);
        return users;
    }

}
