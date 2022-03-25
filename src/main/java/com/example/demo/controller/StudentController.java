package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.StuStudent;
import com.example.demo.service.StudentService;
import com.example.demo.util.CommonResult;
import com.example.demo.util.PageData;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author lenovo
 */
@Api(value = "/findAll",tags = "学生系统")
@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @ResponseBody
    @RequestMapping(value ="/findAll",method = RequestMethod.POST)
    public String findAllStudent(StuStudent student,@RequestParam(defaultValue ="1")Integer page,@RequestParam(defaultValue ="10")Integer limit){

        PageInfo<PageData> pageInfo = studentService.findAllStudent1 (student,page,limit);
        if (pageInfo!=null){
            System.out.println (student.getSex ()+ student.getTelphone ()+student.getAddress ()+student.getSex ()+student.getPassword ()+student.getStuname ());
            return JSONObject.toJSONString ( new CommonResult ().pageSuccess ( pageInfo ) );
        }
        return JSONObject.toJSONString ( new CommonResult ().failed () );
    }

    @ResponseBody
    @RequestMapping(value = "add",method = RequestMethod.POST)//这个方法没有问题 怎么在postman上运行
    public String add(@RequestParam("stuname")String stuname, @RequestParam("id")Integer id
    ,@RequestParam("password")String password,@RequestParam("sex")String sex,@RequestParam("telphone")String telphone,@RequestParam("address")String address){
        System.out.println ("11111111111");
        StuStudent stu=new StuStudent ();
        stu.setStuname (stuname);
        stu.setId (id);
        stu.setAddress (address);
        stu.setPassword (password);
        stu.setSex (sex);
        stu.setTelphone (telphone);
        if ( stu!=null ){
            int insert = studentService.insert ( stu );
            if(insert<1){
                return "数据添加失败";
            }else{
                return "数据添加成功";
            }
        }
        return "数据未添加";

    }


    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)//这个方法我写的不对 等一会看一下
    public String update(@RequestBody StuStudent student){ //zheyang de zuihao yong json  laijieshou  @requestbody
        System.out.println ("22222222222222222222"); //haiyou  shiti lei de mingzi  buyao yong tuofeng  kaitou  daxie
        StuStudent stuStudent=new StuStudent ();
        stuStudent.getId ();
        stuStudent.getAddress ();
        stuStudent.getTelphone ();
        int m=studentService.update (student);
        if ( m!=0 ){
            return "修改成功！";
        }
        return "修改失败！";
    }
}
