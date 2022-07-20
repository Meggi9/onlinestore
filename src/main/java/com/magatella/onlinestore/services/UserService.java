package com.magatella.onlinestore.services;

import com.github.javafaker.Faker;
import com.magatella.onlinestore.models.Role;
import com.magatella.onlinestore.models.User;
import com.magatella.onlinestore.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> allUsers(){
        return userRepository.findAll();
    }


    public User generationDataUser() {
        User user = new User();
        Faker faker = new Faker(new Locale("ru"));

        user.setSurname(faker.name().lastName());
        user.setFirstname(faker.name().firstName());
        user.setRoles(Collections.singleton(Role.USER));
        user.setUsername(faker.name().username());
        user.setPassword(faker.internet().password(4,8));
        user.setLastname(null);
        user.setActive(true);
        return user;
    }
}
