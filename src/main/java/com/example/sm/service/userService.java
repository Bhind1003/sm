package com.example.sm.service;

import com.example.sm.model.User;

public interface userService {
    User findUser(String email) throws Exception;

    String confirmUser(User user) throws Exception;

    String addUser(User user) throws Exception;
}
