package com.example.demo.mapper;

import com.example.demo.model.User;

public interface UserMapper {

    void save(User user);

    User findByUsername(String username);

    User select(User user);
}
