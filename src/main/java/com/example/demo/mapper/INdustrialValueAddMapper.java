package com.example.demo.mapper;

import com.example.demo.TimeParent.TimeParent;
import com.example.demo.model.INdustrialValueAdd;

import java.util.List;

public interface INdustrialValueAddMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(INdustrialValueAdd record);

    int insertSelective(INdustrialValueAdd record);

    INdustrialValueAdd selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(INdustrialValueAdd record);

    int updateByPrimaryKey(INdustrialValueAdd record);

    List<INdustrialValueAdd> selectDust(TimeParent timeParent);
}