package com.example.sm.controller;

import com.example.sm.model.Weather;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.util.Date;

@RestController
public class HelloController {
    @RequestMapping("/")
    public String test(Model m) {
        m.addAttribute("now", DateFormat.getDateInstance().format(new Date()));
        return "欢迎来到测试界面，测试今天日期是：" + DateFormat.getDateInstance().format(new Date());
    }

    @RequestMapping("/findWeather")
    public Weather listWeather(@RequestParam(value = "location", defaultValue = "北京") String location) {
        Weather temp = new Weather();
        temp.setLocation(location);
        temp.setWeatherInfo("小雨转大雨");
        return temp;
    }
}
