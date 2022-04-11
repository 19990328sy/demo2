package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.TimeParent.TimeParent;
import com.example.demo.model.INdustrialValueAdd;
import com.example.demo.service.INdustrialValueAddService;
import com.example.demo.util.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "年度工业和规模工业增加值数据")
@RequestMapping("/sys")
public class INdustrialValueAddController {

    @Autowired
    private INdustrialValueAddService ndustrialValueAddService;

    @GetMapping("/expore")
    @ApiOperation(value = "导出工业规模化的数据和GDP的耗量")
    public Object selectDateDust(TimeParent timeParent) {
        List<INdustrialValueAdd> list = ndustrialValueAddService.selectDust ( timeParent );
        if ( !list.isEmpty () ) {

            return JSONObject.toJSONString ( new CommonResult ().success ( list ) );
        }
        return JSONObject.toJSONString ( new CommonResult ().failed () );

    }

    @GetMapping("/select")
    @ApiOperation(value = "导出工业规模化的数据和GDP的耗量")
    public List<INdustrialValueAdd> selectDust(TimeParent timeParent) {
        List<INdustrialValueAdd> list = ndustrialValueAddService.selectDust ( timeParent );
        if ( !list.isEmpty () ) {
            return list;
        }
        return null;
    }
}
