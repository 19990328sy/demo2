package com.example.demo.shiro.config;

import com.example.demo.shiro.realm.CustomerRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //ShiroFilter过滤所有请求
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean ();
        //给shiroUtils配置安全管理器
        shiroFilterFactoryBean.setSecurityManager ( securityManager );
        //配置系统的受限资源和公共资源
        Map<String, String> map = new HashMap<String, String> ();
        //表示这个资源需要认证和授权
        //map.put ( "/index.jsp", "authc" );
        /*map.put("/user/login","anon");//表示这个为公共资源 一定是在受限资源上面
        map.put("/**","authc");//表示这个受限资源需要认证和授权*/
        map.put("/user/login","anon");//表示这个为公共资源 一定是在受限资源上面
        map.put("/user/register","anon");//表示这个为公共资源 一定是在受限资源上面
        map.put("/register.jsp","anon");//表示这个为公共资源 一定是在受限资源上面
        map.put("/**","authc");//表示这个受限资源需要认证和授权
        //设置认证路径页面
        shiroFilterFactoryBean.setLoginUrl ( "/login.jsp" );
        shiroFilterFactoryBean.setFilterChainDefinitionMap ( map );

        return shiroFilterFactoryBean;
    }

    //创建安全管理器
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(Realm realm){

        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        return securityManager;
    }

    //创建自定义的Bean
    @Bean
    public Realm getRealm(){
        /*CustomerRealm realm=new CustomerRealm ();
        return realm;*/
        /*CustomerRealm realm = new CustomerRealm();
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //设置使用MD5加密算法
        credentialsMatcher.setHashAlgorithmName("md5");
        //散列次数
        credentialsMatcher.setHashIterations(1024);
        realm.setCredentialsMatcher(credentialsMatcher);
        return realm;*/


        //这个是用于判断的
        CustomerRealm realm=new CustomerRealm ();
        HashedCredentialsMatcher credentialsMatcher=new HashedCredentialsMatcher ();
        //设置使用MD5加密算法
        credentialsMatcher.setHashAlgorithmName ( "md5" );
        //散列次数
        credentialsMatcher.setHashIterations ( 10240 );
        realm.setCredentialsMatcher ( credentialsMatcher );
        return realm;
    }

}
