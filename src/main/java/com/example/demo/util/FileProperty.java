package com.example.demo.util;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author lenovo
 */
@ConfigurationProperties(prefix = "file")
public class FileProperty {

    private String filePath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
