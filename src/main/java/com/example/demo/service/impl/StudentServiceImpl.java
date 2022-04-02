package com.example.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.mapper.StudentSMapper;
import com.example.demo.model.StuStudent;
import com.example.demo.service.StudentService;
import com.example.demo.util.CommonResult;
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
    public StuStudent selectByStudent(StuStudent stuStudent) {
        StuStudent s=studentMapper.selectByStudent ( stuStudent );
        if ( s!=null ) {
            return s;
        }
        return null;
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
        StuStudent s=new StuStudent ();
        s.setId ( id );
        if ( id!=null){
            return studentMapper.selectByPrimaryKey ( id );
        }
        return null;
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
