package com.example.demo.service;

import com.example.demo.model.StuStudent;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lenovo
 */
@Service
public interface StudentService {

    /***
     *功能描述
     * @author shaoyu
     * @date 2022/3/23
        * @param id
     * @return java.util.List<com.example.demo.model.StuStudent>
     * @Description :
     */
    String selectByStudent(StuStudent stuStudent);

    List<StuStudent> findAllStudent(StuStudent student);




    /***
     *功能描述
     * @author shaoyu
     * @date 2022/3/23
        * @param record
     * @return int
     * @Description :
     */
    int insert(StuStudent record);

    /***
     *功能描述
     * @author shaoyu
     * @date 2022/3/23
        * @param id
     * @return com.example.demo.model.StuStudent
     * @Description :
     */
    StuStudent selectByPrimaryKey(Integer id);

    /***
     *功能描述
     * @author shaoyu
     * @date 2022/3/23
        * @param id
     * @return int
     * @Description :
     */
    int updateByPrimaryKeySelective(Integer id);

    /***
     *功能描述
     * @author shaoyu
     * @date 2022/3/23
        * @param record
     * @return int
     * @Description :
     */
    int updateByPrimaryKey(StuStudent record);

    /***
     *功能描述
     * @author shaoyu
     * @date 2022/3/23
        * @param id
     * @return int
     * @Description :
     */
    String deleteByPrimaryKey(Integer id);

    /***
     *功能描述
     * @author shaoyu
     * @date 2022/3/23
        * @param student
     * @return int
     * @Description :
     */
    int add(StuStudent student);

    /***
     *功能描述
     * @author shaoyu
     * @date 2022/3/23
        * @param student
     * @return int
     * @Description :
     */
    int update(StuStudent student);

    /***
     *功能描述
     * @author shaoyu
     * @date 2022/3/31
        * @param id
     * @return int
     * @Description :
     */

    int countStudent(int id);



}
