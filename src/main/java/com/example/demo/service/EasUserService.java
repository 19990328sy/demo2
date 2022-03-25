package com.example.demo.service;

import com.example.demo.model.easUser;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *功能描述
 * @author shaoyu
 * @date 2022/3/17
    * @param null
 * @return
 * @Description :
 *
*/
@Service
public interface EasUserService {


    /**
     *功能描述
     * @author shaoyu
     * @date 2022/3/17
        * @param id
     * @return int
     * @Description :删除学生
     *
    */
    int deleteByUserId(Integer id);



    /**
     *功能描述
     * @author shaoyu
     * @date 2022/3/17
        * @param easUser
     * @param page
     * @param limit
     * @return com.github.pagehelper.PageInfo<com.example.demo.model.easUser>
     * @Description :查询所有的学生
     * */
    PageInfo<easUser> findAllUser(easUser easUser,Integer page,Integer limit);

    /***
     *功能描述
     * @author shaoyu
     * @date 2022/3/23
        * @param username
     * @return java.util.List<com.example.demo.model.easUser>
     * @Description :
     */
    List<easUser> findUserName(String username);

}
