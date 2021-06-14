package com.example.sm.service;

import com.example.sm.dao.userMapper;
import com.example.sm.model.User;
import com.sun.istack.internal.NotNull;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements userService {
    private final userMapper userMapper;

    public UserServiceImp(userMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User findUser(String email) {
        User temp = userMapper.FindUser(email);
        if (temp != null) System.out.println("根据邮箱查询的密码：" + temp);
        else System.out.println(email + "没有查询到结果！");
        return temp;
    }

    @Override
    public String confirmUser(@NotNull User user) {
        System.out.println("用户输入值：" + user.toString());
        try {
            User temp = userMapper.FindUser(user.getEmail());
            if (temp == null) return "-1";//信息出错，该用户不存在！
            if (temp.getPassword().trim().equals(user.getPassword())) {
                return "1";//登录成功！
            } else return "0";//密码错误！
        } catch (Exception e) {
            e.printStackTrace();
            return "-1";
        }
    }

    @Override
    public String addUser(User user) {
        String out = "0";
        try {
            out = String.valueOf(userMapper.Register(user.getEmail(), user.getName(), user.getPassword()));
            if (out.compareTo("1") == 0) {//成功注册！插入一行
                System.out.println("返回的信息为：" + out);
            } else {//无法注册，邮箱重复！插入为0行
                out = "0";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out;
    }
}
