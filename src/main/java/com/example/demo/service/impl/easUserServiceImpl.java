package com.example.demo.service.impl;


import com.example.demo.mapper.EasUserMapper;
import com.example.demo.model.easUser;
import com.example.demo.service.EasUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lenovo
 */
@Service
@Transactional(rollbackFor = Exception.class)

public class easUserServiceImpl implements EasUserService {

@Autowired
    private EasUserMapper easUserMapper;

    public easUserServiceImpl(EasUserMapper easUserMapper) {
        this.easUserMapper = easUserMapper;
    }


    @Override
    public int deleteByUserId(Integer id) {
        return easUserMapper.deleteByPrimaryKey ( id );
    }

    /**
     *功能描述
     * @author shaoyu
     * @date 2022/3/17
        * @param null
     * @return
     * @Description :
     */

    @Override
    public PageInfo<easUser> findAllUser(easUser easUser, Integer page, Integer limit) {


        PageHelper.startPage (page,limit );
        List<easUser> list=easUserMapper.findAll(easUser,page,limit);
        if ( list!=null ){
            PageInfo<easUser> pg=new PageInfo<> (list);
            return pg;
        }
        return null;
    }

    @Override
    public List<easUser> findUserName(String username) {

        return easUserMapper.findUserName ( username );
    }


}
