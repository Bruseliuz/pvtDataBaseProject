package com.example.mysqlspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/mysqlspring")
public class MainController {
    @Autowired

    private UserRepository userRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        if (name == null || email == null || password == null) {
            return "Error in input";
        }
        User n = new User();
        n.setName(name);
        n.setEmail(email);
        n.setPassword(password);
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

//    @GetMapping(path="/password")
//    public @ResponseBody Optional<User> getUserFromPassword() {
//        return userRepository.findById(1);
//    }
}
