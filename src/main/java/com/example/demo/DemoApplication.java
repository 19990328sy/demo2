package com.example.demo;

import com.example.demo.util.FileProperty;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author shaoyu
 */

/**开启ConfigurationProperties的功能
 * @author lenovo*/
@EnableConfigurationProperties(FileProperty.class)
@EnableSwagger2
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@Controller
@MapperScan("com.example.demo.mapper")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run ( DemoApplication.class, args );
        System.out.println("=========项目启动成功=========");
    }
    @RequestMapping(value = "/index1")
    public String aa(){
            return "index1";
    }
}
