package com.magatella.onlinestore.controllers;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.magatella.onlinestore.models.Role;
import com.magatella.onlinestore.services.UserService;
import com.magatella.onlinestore.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public User begin(){
        User user = userService.generationDataUser();
        userService.save(user);
        return user;
    }

    @GetMapping("/userlist")
    public List<User> userList(){
        return userService.allUsers();
    }
}
