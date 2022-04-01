package com.example.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;

/**
 * @author lenovo
 */
@ApiModel
public class StuStudent {

    @ApiModelProperty(value = "学生id" ,example ="1")
    private Integer id;
    @ApiModelProperty("学生姓名")
    private String stuname;
    @ApiModelProperty("学生密码")
    private String password;
    @ApiModelProperty("学生性别")
    private String sex;
    @ApiModelProperty("学生地址")
    private String address;
    @ApiModelProperty("学生电话")
    private String telphone;
    //分页
    /*private Integer page;
    private Integer limit;*/

    /*public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

}