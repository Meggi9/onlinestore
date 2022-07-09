package com.magatella.onlinestore.controllers;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.magatella.onlinestore.services.UserService;
import com.magatella.onlinestore.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    private UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/add")
    public User begin(){
        User user = userService.generationDataUser();
        userService.save(user);
        return user;
    }


    @PostMapping("/add")
    @ResponseBody
    public User create(@RequestBody User user) {
        userService.save(user);
        return user;
    }
}
