package com.example.demo.service;

import com.example.demo.TimeParent.TimeParent;
import com.example.demo.model.INdustrialValueAdd;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface INdustrialValueAddService {

    List<INdustrialValueAdd> selectDust(TimeParent timeParent);

    Map findDateDust(TimeParent timeParent);
}
