package com.magatella.onlinestore.controllers;

import com.magatella.onlinestore.models.Role;
import com.magatella.onlinestore.models.User;
import com.magatella.onlinestore.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView greetingPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration.html");
        return modelAndView;
    }
    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User userFromDb = userRepository.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "registration.html";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);

        return "redirect:/app/a";
    }
}
