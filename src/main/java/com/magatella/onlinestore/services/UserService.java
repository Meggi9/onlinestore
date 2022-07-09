package com.magatella.onlinestore.services;

import com.github.javafaker.Faker;
import com.magatella.onlinestore.models.User;
import com.magatella.onlinestore.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public User generationDataUser() {
        User user = new User();
        Faker faker = new Faker(new Locale("ru"));

        user.setSurname(faker.name().lastName());
        user.setFirstname(faker.name().firstName());
        user.setLastname(null);

        return user;
    }
}
