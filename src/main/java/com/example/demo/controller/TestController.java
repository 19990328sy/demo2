package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shaoyu
 */
@RestController//使用这个后面的方法就不用再加@ResponseBody  如果用的是@Controller 重定向的话必须要加上@ResponseBody
@RequestMapping("/test")
@Api(value = "/test", tags = "测试模块")

public class TestController {

    @Autowired
    private UserService userService;

    /**
     * 功能描述
     *
     * @return
     * @author shaoyu
     * @date 2022/3/17
     * @Description :
     */
    @RequestMapping(value = "/hello")
    public String hello1() {
        return "index";
    }

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public String test(String name) {
        return name;
    }


    @RequestMapping("logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject ();
        subject.logout ();
        return "redirect:/login.jsp";
    }

    @RequestMapping("/login")
    public String login(String username, String password) {
        //获取主题对象
        Subject subject = SecurityUtils.getSubject ();
        try {
            subject.login ( new UsernamePasswordToken ( username, password ) );
            System.out.println ( "登录成功！！！" );
            return "redirect:/index.jsp";
        } catch (UnknownAccountException e) {
            e.printStackTrace ();
            System.out.println ( "用户错误！！！" );
        } catch (IncorrectCredentialsException e) {
            System.out.println ( "密码错误！！！" );
        }
        return "redirect:/login.jsp";
    }


    /***
     *功能描述
     * @author shaoyu
     * @date 2022/3/24
        * @param user
     * @return java.lang.String
     * @Description :用户注册验证
     */

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(User user) {
        try {
            userService.register(user);
            return "redirect:/login.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/register.jsp";
        }
    }
}
