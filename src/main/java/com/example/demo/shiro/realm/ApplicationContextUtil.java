package com.example.demo.shiro.realm;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextUtil implements ApplicationContextAware {
    private static ApplicationContext context;

    /*public static Object getBean(String userService) {
        return null;
    }*/

    //根据bean名字获取工厂中指定bean 对象
    public static Object getBean(String beanName) {
        return context.getRealPath(beanName);
    }


    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
       context = applicationContext;
    }

    @Override
    public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext) throws BeansException {
        context = (ApplicationContext) applicationContext;
    }
}
