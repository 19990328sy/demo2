package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(@Param ( "user" ) User user){
       int u= userService.insertUser ( user );
       if ( u!=0 ){
           System.out.println ("看到这个就说明添加成功了");
           return "添加成功";
       }
        return "添加失败！";
    }
    @RequestMapping(value = "/loginHtml")
    public String loginHtml() {
        return "login";
    }


}
