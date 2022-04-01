package com.example.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.mapper.StudentSMapper;
import com.example.demo.model.StuStudent;
import com.example.demo.service.StudentService;
import com.example.demo.util.CommonResult;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author lenovo
 */
@Component
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentSMapper studentMapper;


    @Override
    public String selectByStudent(StuStudent stuStudent) {
        StuStudent s=new StuStudent ();
        if ( s!=null ){
            return JSONObject.toJSONString ( new CommonResult ().success ( "查询成功！" ) );
        }
        return JSONObject.toJSONString ( new CommonResult ().failed () );
    }

    @Override
    public List<StuStudent> findAllStudent(StuStudent student) {
        return studentMapper.findAllStudent ( student );
    }


    @Override
    public int insert(StuStudent record) {
        return studentMapper.insert ( record );
    }

    @Override
    public StuStudent selectByPrimaryKey(Integer id) {
        return studentMapper.selectByPrimaryKey ( id );
    }

    @Override
    public int updateByPrimaryKeySelective(Integer id) {
        return studentMapper.updateByPrimaryKeySelective ( id );
    }


    @Override
    public int updateByPrimaryKey(StuStudent record) {
        return studentMapper.updateByPrimaryKey ( record );
    }

    @Override
    public String deleteByPrimaryKey(Integer id) {
        int m=studentMapper.deleteByPrimaryKey ( id);
        if ( m>0){
            return "删除成功";
        }
        return "删除失败";
    }

    @Override
    public int add(StuStudent student) {
        return studentMapper.insert ( student );
    }

    @Override
    public int update(StuStudent student) {
        return studentMapper.update ( student );
    }

    @Override
    public int countStudent(int id) {
        int count=studentMapper.countStudent ( id );
        System.out.println ("学生总数"+count);
        return studentMapper.countStudent ( id );
    }






}
