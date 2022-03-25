package com.example.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author lenovo
 */
@ApiModel("用户主表")
public class Users {

    @ApiModelProperty("用户名字")
    private String username;

    @ApiModelProperty("用户密码")
    private String password;

    public Users(String username, String password) {
        this.password = password;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
