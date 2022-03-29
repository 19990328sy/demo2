package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;
import javax.servlet.http.HttpSession;


/**
 * @author shaoyu
 */
@Api(tags = "用户的实体类")
@Controller

public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private DefaultKaptcha defaultKaptcha;

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

   /* public String login(User user){
        System.out.println ( StuStudent.class);
        return null;
    }*/



    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String loginO(@RequestParam(value = "name",required = false) String name, @RequestParam(value = "password",required = false) String password, HttpSession session){
        User u1=userService.login (name, password );
        session.setAttribute ( "name",name );
        if ( u1!=null){
            System.out.println ("-----------------------查询成功-----------------------");
            System.out.println ("登录用户:"+u1.getName ());
            return "/success.html";
        }else {
            System.out.println ("登录失败！请重新登录！");
            return "/error.html";
        }


    }

    /***
     *功能描述
     * @author shaoyu
     * @date 2022/3/28
        * @param name
     * @return java.lang.String
     * @Description :根据用户名字查询
     */

    @ResponseBody
    @RequestMapping(value = "/findByUsername",method = RequestMethod.POST)
    public String findName(@RequestParam("name")String name){
        User n=userService.findByUsername ( name );
        if ( n!=null ){
            System.out.println ("查询的名字:"+n.getName ());
            return n.getName ();
        }
        return null;
    }

    @RequestMapping(value = "/regist",method = RequestMethod.GET)
    public String add(@Param("user") User user){
        int n=userService.insertUser (user);
        if ( n>0){
            System.out.println ("用户注册成功！亲跳转登录页面");
            return "/regist.html";
        }
        return "请重新注册，用户注册不成功！";
    }






}
