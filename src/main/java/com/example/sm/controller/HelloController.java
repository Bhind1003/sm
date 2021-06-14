package com.example.sm.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.util.Date;

@RestController
public class HelloController {
    @RequestMapping("/")
    public String test(Model m) {
        m.addAttribute("now", DateFormat.getDateInstance().format(new Date()));
        return "欢迎来到欢迎界面，今天日期是：" + DateFormat.getDateInstance().format(new Date());
    }
}
