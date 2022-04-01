package com.example.demo.mapper;

import com.example.demo.model.StuStudent;
import com.example.demo.util.PageData;
import com.github.pagehelper.PageInfo;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
/***
 *功能描述
 * @author shaoyu
 * @date 2022/3/23
    * @param null
 * @return
 * @Description :
 */
public interface StudentSMapper {
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
    int insert(StuStudent record);

    /***
     *功能描述
     * @author shaoyu
     * @date 2022/3/23
        * @param record
     * @return int
     * @Description :
     */
    int insertSelective(StuStudent record);

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
        * @param record
     * @return int
     * @Description :
     */
    int updateByPrimaryKeySelective(Integer record);

    /***
     *功能描述
     * @author shaoyu
     * @date 2022/3/23
        * @param record
     * @return int
     * @Description :
     */
    //@Update("update student set stuname=#{stuname},address=#{address},telphone=#{telphont},sex=#{sex},password=#{password} where id=#{id}")
    int updateByPrimaryKey(StuStudent record);
    /***
     *功能描述
     * @author shaoyu
     * @date 2022/3/21
        * @param id
     * @return java.util.List<com.example.demo.model.stuStudent>
     * @Description :通过年纪查询
     */

    @Select ( "select * from student where id = #{id}" )
    public List<StuStudent> findAge(Integer id);

    /***
     *功能描述
     * @author shaoyu
     * @date 2022/3/23
        * @param student
     * @return java.util.List<com.example.demo.model.StuStudent>
     * @Description :
     */
    @Select ( "select * from student" )
     List<StuStudent> findAllStudent(StuStudent student);

    /***
     *功能描述
     * @author shaoyu
     * @date 2022/3/23
        * @param student
     * @return java.util.List<com.example.demo.util.PageData>
     * @Description :
     */
    List<PageData> findAllStudent1(@Param ("student")StuStudent student);


    /**
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
    * @Description :记总数
    */
    int countStudent(int id);

    //模糊查询
    StuStudent selectByStudent(StuStudent stuStudent);

}