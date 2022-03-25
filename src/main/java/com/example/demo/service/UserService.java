package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {
    //注册用户方法
    void register(User user);
    //根据用户名查找用户
    User findByUsername(String username);

    User get(User user);
}
