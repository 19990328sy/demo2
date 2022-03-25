package com.example.demo.util;

import java.util.List;
/***
 *功能描述
 * @author shaoyu
 * @date 2022/3/23
    * @param null
 * @return
 * @Description :
 */

public class LayData<T> {
    private int code;
    private String msg;
    private long count;
    private List<T> data;

    public LayData() {

    }

    @Override
    public String toString() {
        return "LayData{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
