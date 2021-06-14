package com.example.sm.controller;

import com.example.sm.model.User;
import com.example.sm.model.Weather;
import com.example.sm.service.UserServiceImp;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    private final UserServiceImp userServiceImp;

    public UserController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @RequestMapping("/findUser")
    public User findUser(@RequestParam(value = "email", defaultValue = "18045214@qq.com") String email) {
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

    @RequestMapping("/findWeather")
    public Weather listWeather(@RequestParam(value = "location", defaultValue = "北京") String location) {
        Weather temp = new Weather();
        temp.setLocation(location);
        temp.setWeatherInfo("小雨转大雨");
        return temp;
    }
}
