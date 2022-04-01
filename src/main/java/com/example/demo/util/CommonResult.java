package com.example.demo.util;

import com.github.pagehelper.PageInfo;

/**
 *功能描述
 * @author shaoyu
 * @date 2022/3/23
    * @param null
 * @return
 * @Description :
 */

public class CommonResult{
    // 操作成功
    private static final int SUCCESS = 200;
    // 操作失败
    private static final int FAILED = 500;
    // 分页成功
    private static final int PAGECODE = 0;

    private int code;
    private String message;
    private Object data;
    private Object data1;
    private Object data2;
    private Object data3;
    private Long count;
    private int pageNum;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    /**
     * 普通成功返回
     *
     * @param msg 操作后返回的信息
     */
    public CommonResult success(String msg) {
        this.code = SUCCESS;
        this.message = msg;
        return this;
    }


    public CommonResult success(Object data) {
        this.code = SUCCESS;
        this.message = "操作成功";
        this.data = data;
        return this;
    }

    /**
     * 普通成功返回
     *
     * @param data 获取的数据
     * @param data1 获取的数据
     * @param data2 获取的数据
     * @param data3 获取的数据
     */
    public CommonResult success(Object data,Object data1,Object data2,Object data3) {
        this.code = SUCCESS;
        this.message = "操作成功";
        this.data = data;
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
        return this;
    }

    /**
     * 普通成功返回
     */
    public CommonResult success(String message,Object data) {
        this.code = SUCCESS;
        this.message = message;
        this.data = data;
        return this;
    }

    /**
     * 返回分页成功数据
     * @param pageInfo
     */
    public CommonResult pageSuccess(PageInfo<PageData> pageInfo) {

        this.code = SUCCESS;
        this.pageNum = pageInfo.getPageNum();
        this.message = "操作成功";
        this.count = pageInfo.getTotal();
        this.data = pageInfo.getList();
        return this;
    }

    public CommonResult pageSuccess(String msg, PageInfo pageInfo) {

        this.code = SUCCESS;
        this.pageNum = pageInfo.getPageNum();
        this.message = msg;
        this.count = pageInfo.getTotal();
        this.data = pageInfo.getList();
        return this;
    }

    /**
     * 普通失败提示信息
     */
    public CommonResult failed() {
        this.code = FAILED;
        this.message = "操作失败";
        return this;
    }

    public CommonResult failed(String message){
        this.code = FAILED;
        this.message = message;
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getData1() {
        return data1;
    }

    public void setData1(Object data1) {
        this.data1 = data1;
    }

    public Object getData2() {
        return data2;
    }

    public void setData2(Object data2) {
        this.data2 = data2;
    }

    public Object getData3() {
        return data3;
    }

    public void setData3(Object data3) {
        this.data3 = data3;
    }
}
