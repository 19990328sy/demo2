package com.example.demo.model;

import org.springframework.stereotype.Repository;


public class UserRole {
    private Integer id;

    private String rName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }
}