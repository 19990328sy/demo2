package com.example.demo.controller;

import com.example.demo.model.StuStudent;
import com.example.demo.model.User;
import com.example.demo.model.Users;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    public Users hello2(String userName) {
        Users user = new Users ("张三","123");
        return user;
    }

    @GetMapping("/hello3")
    public Users hello3(@ApiParam("用户名") Users user) {
        return user;
    }

    public String login(Users user){
        System.out.println ( StuStudent.class);
        return null;
    }
    @RequestMapping(value = "/loginO")
    public String login(User user){

            ModelAndView mv = new ModelAndView();
            user = userService.get(user);

            if (user != null) {
                mv.addObject("user", user);
                return "user";
            } else {
                return "login";
            }
        }




}
