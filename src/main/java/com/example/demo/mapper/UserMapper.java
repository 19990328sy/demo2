package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Service;

public interface UserMapper {

    void register(User user);
    //根据用户名查找用户
    User findByUsername(String username);

    User get(User user);

    /**根据id查询*/
    User  selectById(int id);


    /**用户注册*/
    @Insert ("insert into  user (name,password) values(#{name},#{password}) ")
    int insertUser(User  user);


    User login(String name,String password);
}
