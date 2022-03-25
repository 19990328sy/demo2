package com.example.demo.mapper;

import com.example.demo.model.easUser;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author lenovo
 */
public interface EasUserMapper {
    /***
     *功能描述
     * @author shaoyu
     * @date 2022/3/23
        * @param id
     * @return int
     * @Description :
     */

    int deleteByPrimaryKey(Integer id);

    /***
     *功能描述
     * @author shaoyu
     * @date 2022/3/23
        * @param record
     * @return int
     * @Description :
     */
    int insert(easUser record);

    /***
     *功能描述
     * @author shaoyu
     * @date 2022/3/23
        * @param record
     * @return int
     * @Description :
     */
    int insertSelective(easUser record);

    /***
     *功能描述
     * @author shaoyu
     * @date 2022/3/23
        * @param id
     * @return com.example.demo.model.easUser
     * @Description :
     */
    easUser selectByPrimaryKey(Integer id);

    /***
     *功能描述
     * @author shaoyu
     * @date 2022/3/23
        * @param record
     * @return int
     * @Description :
     */
    int updateByPrimaryKeySelective(easUser record);

    /***
     *功能描述
     * @author shaoyu
     * @date 2022/3/23
        * @param record
     * @return int
     * @Description :
     */
    int updateByPrimaryKey(easUser record);

    /***
     *功能描述
     * @author shaoyu
     * @date 2022/3/23
        * @param easUser
     * @param page
     * @param limit
     * @return com.github.pagehelper.PageInfo<com.example.demo.model.easUser>
     * @Description :
     */
    PageInfo<easUser> findAllUser(easUser easUser, Integer page, Integer limit);

    /***
     *功能描述
     * @author shaoyu
     * @date 2022/3/23
        * @param username
     * @return java.util.List<com.example.demo.model.easUser>
     * @Description :
     */
    List<easUser> findUserName(String username);

    /***
     *功能描述
     * @author shaoyu
     * @date 2022/3/23
        * @param easUser
     * @param page
     * @param limit
     * @return java.util.List<com.example.demo.model.easUser>
     * @Description :
     */
    List<easUser> findAll(easUser easUser, Integer page, Integer limit);
}
