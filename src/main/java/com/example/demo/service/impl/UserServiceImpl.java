package com.example.demo.service.impl;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(User user) {

    }

    @Override
    public User findByUsername(String name) {
        User n=userMapper.findByUsername ( name );
        if ( n!=null ){
            System.out.println ("查询成功");
            return n;

        }
        return null;
    }

    @Override
    public User get(User user) {
        return userMapper.get ( user );
    }

    @Override
    public User login(String name, String password) {
        return userMapper.login ( name,password );
    }

    @Override
    public User selectById(int id) {
        return userMapper.selectById ( id );
    }


    @Override
    public int insertUser(User user) {
       return userMapper.insertUser ( user );
    }
}
