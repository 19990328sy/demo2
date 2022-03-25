package com.example.demo.service.impl;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.util.SaltUtil;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(User user) {
        //1.获取随机盐
        String salt = SaltUtil.getSalt ( 8 );
        //2.将随机盐保存到数据
        user.setSalt(salt);
        //3.明文密码进行md5 + salt + hash散列
        Md5Hash MD5 = new Md5Hash(user.getPassword(),salt,1024);
        user.setPassword(MD5.toHex());
        userMapper.save ( user );

    }

    /***
     *功能描述
     * @author shaoyu
     * @date 2022/3/24
        * @param username
     * @return com.example.demo.model.User
     * @Description :用于根据名字查询的
     */

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername ( username );
    }

    @Override
    public User get(User user) {
        return userMapper.select ( user );
    }
}
