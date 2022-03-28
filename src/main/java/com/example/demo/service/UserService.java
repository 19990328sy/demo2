package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {
    //注册用户方法
    void register(User user);
    //根据用户名查找用户
    User findByUsername(String name);

    User get(User user);

    User login(String name,String password);

    /**根据id查询*/
    User  selectById(int id);

    /**根据用户名字查询
     * @param name*/


    /**用户注册
     * @return*/
    int insertUser(User  user);
}
