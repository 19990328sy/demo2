package com.example.demo.service.impl;

import com.example.demo.mapper.StudentSMapper;
import com.example.demo.model.StuStudent;
import com.example.demo.service.StudentService;
import com.example.demo.util.PageData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public List<StuStudent> findAge(Integer id) {

        return studentMapper.findAge ( id );
    }

    @Override
    public List<StuStudent> findAllStudent(StuStudent student) {
        return studentMapper.findAllStudent (student);
    }

    @Override
    public PageInfo<PageData> findAllStudent1(StuStudent student,Integer page,Integer limit) {
        PageHelper.startPage (page,limit);
        List<PageData> list=studentMapper.findAllStudent1 (student);
        if (list !=null && list.isEmpty ()){
            /*PageInfo<PageData> pg = new PageInfo<>( list);
            return pg;*/
            PageInfo<PageData> pg =new PageInfo<> (list);
            return pg;
        }
        return null;
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
    public int deleteByPrimaryKey(Integer id) {
        return studentMapper.deleteByPrimaryKey ( id );
    }

    @Override
    public int add(StuStudent student) {
        return studentMapper.insert ( student );
    }

    @Override
    public int update(StuStudent student) {
        return studentMapper.update ( student );
    }


}
