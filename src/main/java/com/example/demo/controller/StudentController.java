package com.example.demo.controller;

import com.example.demo.model.StuStudent;
import com.example.demo.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.Soundbank;
import java.util.HashMap;
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

    @RequestMapping(value = "findAll",method = RequestMethod.POST)
    public PageInfo<StuStudent> findAll(StuStudent stuStudent,@RequestParam(required = false) Integer page,@RequestParam(required = false) Integer limit){
        PageHelper.startPage (page,limit);
        HashMap<Object, Object> map = new HashMap<> ();
        map.put ("stuStudent",stuStudent);
        List<StuStudent> list=studentService.findAllStudent ( stuStudent );
        if ( list!=null ){
            //System.out.println ("查询出来的数据是"+"第"+stuStudent.getPage ()+"页"+"  "+"总"+stuStudent.getLimit ()+"条");
            PageInfo<StuStudent> pageInfo=new PageInfo<> (list);
            System.out.println ("----------------------查询成功------------------");
            return  pageInfo;
        }
        return null;
    }

    @PostMapping("selectByStudent")
    public StuStudent selectByStudent(StuStudent stuStudent, @RequestParam(required = false)String stuname, @RequestParam(required = false)String address){
        StuStudent s=studentService.selectByStudent ( stuStudent );
        if ( s.getStuname ()!=null && s.getId ()!=null ){
            return stuStudent;
        }
        return null;
    }

    @RequestMapping(value = "selectConfigById",method = RequestMethod.POST)
    public StuStudent findById(@RequestParam("id") Integer id){
        return (StuStudent) studentService.selectByPrimaryKey ( id );
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

    @PostMapping("count")
    public int countStudent(int id){
        return studentService.countStudent ( id );
    }

    @RequestMapping(value = "deleteByPrimaryKey",method = RequestMethod.POST)
    public String del(int id){
        System.out.println ("删除成功！！！");
        return studentService.deleteByPrimaryKey ( id );
    }

}
