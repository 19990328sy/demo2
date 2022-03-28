package com.example.demo.controller;

import com.example.demo.model.StuStudent;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.Soundbank;

/**
 * @author shaoyu
 */
@Api(tags = "用户的实体类")
@RestController

public class UserController {

    @Autowired
    private UserService userService;

    /**
     *功能描述
     * @author shaoyu
     * @date 2022/3/17
        * @param userName
     * @return com.example.demo.model.User
     * @Description :
     *
     *功能描述
     * @author shaoyu
     * @date 2022/3/17
     * @return
     * @Description :
     */
    @ApiOperation("hello的控制方法")
    @GetMapping("/hello2")
    public User hello2(String userName) {
        User user = new User ("张三","123");
        return user;
    }

    @GetMapping("/hello3")
    public User hello3(@ApiParam("用户名") User user) {
        return user;
    }

    public String login(User user){
        System.out.println ( StuStudent.class);
        return null;
    }


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public User loginO(@RequestParam("name") String name,@RequestParam("password") String password){
        User u1=userService.login (name, password );
        if ( u1!=null){
            System.out.println ("-----------------------查询成功-----------------------");
            System.out.println ("登录用户:"+u1.getName ());
            return u1;
        }

        return null;
    }

    @RequestMapping(value = "/findByUsername",method = RequestMethod.GET)
    public String findName(@RequestParam("name")String name){
        User n=userService.findByUsername ( name );
        if ( n!=null ){
            System.out.println ("查询的名字:"+n.getName ());
            return n.getName ();
        }
        return null;
    }





}
