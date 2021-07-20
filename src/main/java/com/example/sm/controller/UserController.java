package com.example.sm.controller;

import com.example.sm.model.User;
import com.example.sm.service.UserServiceImp;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {
    private final UserServiceImp userServiceImp;

    public UserController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @GetMapping("/findUser")
    public User findUser(@RequestParam(value = "email", defaultValue = "123456@qq.com") String email) {
        return userServiceImp.findUser(email);
    }

    @RequestMapping("/login")
    public String confirmUser(@RequestBody User user) {
        return userServiceImp.confirmUser(user);
    }

    @RequestMapping("/addUser")
    public String addUser(@RequestBody User user) {
        return userServiceImp.addUser(user);
    }


}
