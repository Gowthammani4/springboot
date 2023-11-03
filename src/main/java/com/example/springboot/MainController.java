package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(path = "/demo")
public class MainController {
    @Autowired
    private UserRepository userRepository;
    @PostMapping(path = "/add")
    public @ResponseBody User addNewUser(@RequestParam String name,@RequestParam String email){
        User springuser=new User();
        springuser.setName(name);
        springuser.setEmail(email);
        userRepository.save(springuser);
        return springuser;
    }
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllusers(){
        return userRepository.findAll();
    }
}
