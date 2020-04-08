package com.example.mysqlspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Email;


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

    @GetMapping(path="/getfromemailandpwd")
    public @ResponseBody User getUserFromEmailAndPwd(@RequestParam String email, @RequestParam String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

}
