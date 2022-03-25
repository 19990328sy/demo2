package com.example.demo.config;

import org.apache.ibatis.io.ResolverUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author shaoyu
 */
@Configuration/*配置到springboot配置里*/
@EnableSwagger2//开启swagger2

public class SwaggerConfig {

    @Bean
    /**配置swagger的Docket的bean实例*/
    public Docket docket(Environment environment){

        Profiles profiles = Profiles.of("dev","test");
        //通过判断是否处在自己设定的环境当中,是处在"dev","test"就返回true
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket ( DocumentationType.SWAGGER_2 )
                /*这个是配置swagger的信息*/
                .apiInfo(apiInfo())
                /*选择哪些路径和api会生成document*/
                .select ()
                //配置要扫描的接口方式
                .apis ( RequestHandlerSelectors
                        /*basePackage 指定要扫描的包---这个是最常用的*/
                        .basePackage ("com.example.demo.controller"))
                .build ();
    }

    /**这个是配置swagger的信息*/
    private ApiInfo apiInfo(){

        //文档个人的信息
        Contact contact =new Contact ( "shaoyu","https://blog.csdn.net/qq_42557032?type=blog","3263899279@qq.com" );
        return new ApiInfo ( "long time encounter文档"
        ,"shaoyu"
        ,"1.0"
        ,"urn:tos"
        ,contact
        ,"Apache 2.0"
        ,"http://www.apache.org/licenses/LICENSE-2.0"
        ,new ArrayList());


    }

    /**
     *功能描述
     * @author shaoyu
     * @date 2022/3/17
        * @param null
     * @return
     * @Description :这个是创建的一个实例
     */
    public Docket docket1(){
        return new Docket ( DocumentationType.SWAGGER_2).groupName ( "One" );
    }
}


