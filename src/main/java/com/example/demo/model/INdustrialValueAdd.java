package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class INdustrialValueAdd {
    private Integer id;

    @JsonFormat(pattern = "yyyy",timezone = "GMT+8")
    private String statYear;

    private String status;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date insertTime;

    private String valueAdd;

    private String valueRate;

    private String scaleValueAdd;

    private String scaleValueRate;

    private String provincesRate;

    private String countryRate;

    private Integer orgNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatYear() {
        return statYear;
    }

    public void setStatYear(String statYear) {
        this.statYear = statYear;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public String getValueAdd() {
        return valueAdd;
    }

    public void setValueAdd(String valueAdd) {
        this.valueAdd = valueAdd;
    }

    public String getValueRate() {
        return valueRate;
    }

    public void setValueRate(String valueRate) {
        this.valueRate = valueRate;
    }

    public String getScaleValueAdd() {
        return scaleValueAdd;
    }

    public void setScaleValueAdd(String scaleValueAdd) {
        this.scaleValueAdd = scaleValueAdd;
    }

    public String getScaleValueRate() {
        return scaleValueRate;
    }

    public void setScaleValueRate(String scaleValueRate) {
        this.scaleValueRate = scaleValueRate;
    }

    public String getProvincesRate() {
        return provincesRate;
    }

    public void setProvincesRate(String provincesRate) {
        this.provincesRate = provincesRate;
    }

    public String getCountryRate() {
        return countryRate;
    }

    public void setCountryRate(String countryRate) {
        this.countryRate = countryRate;
    }

    public Integer getOrgNo() {
        return orgNo;
    }

    public void setOrgNo(Integer orgNo) {
        this.orgNo = orgNo;
    }
}