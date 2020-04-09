package com.example.mysqlspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(path="/mysqlspring")
public class MainController {
    @Autowired

    private UserRepository userRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email, @RequestParam String password) {
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

    @DeleteMapping(path="/deleteall")
    public @ResponseBody String deleteAllUsers() {
        userRepository.deleteAll();
        return "Database Cleared";
    }

    @GetMapping(path="/findbyemail")
    public @ResponseBody String findUserFromEmail(@RequestParam String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return "Yes";
        } else {
            return "No";
        }
    }

    @GetMapping(path="/getbyemail")
    public @ResponseBody User getUserFromEmail(@RequestParam String email) {
        return userRepository.findByEmail(email);
    }

    @GetMapping(path="/findbyemailandpwd")
    public @ResponseBody String findUserFromEmailAndPwd(@RequestParam String email, @RequestParam String password) {
        User user = userRepository.findByEmailAndPassword(email, password);
        if (user != null) {
            return "Yes";
        } else {
            return "No";
        }
    }
}
