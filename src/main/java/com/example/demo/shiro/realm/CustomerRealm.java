package com.example.demo.shiro.realm;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.util.ObjectUtils;


/***
 *功能描述
 * @author shaoyu
 * @date 2022/3/24
 * @param null
 * @return
 * @Description :自定义Realm
 */

public class CustomerRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String principal = (String) authenticationToken.getPrincipal ();
        /*if ("zhangsan".equals(principal)) {
            return new SimpleAuthenticationInfo (principal,"123456",this.getName());
        }*/
        /*//获取UserService对象
        UserService userService = (UserService) ApplicationContextUtil.getBean("userService");
        //System.out.println(userService);
        User user = userService.findByUsername(principal);
        if (!ObjectUtils.isEmpty(user)) {
            return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), ByteSource.Util.bytes(user.getSalt()), this.getName());
        }*/
        //获取UserService对象
        UserService userService = (UserService) ApplicationContextUtil.getBean ( "userService" );
        System.out.println (userService);
        User user=userService.findByUsername ( principal );
        if ( !ObjectUtils.isEmpty ( user ) ){
            return new SimpleAuthenticationInfo (user.getUsername (),user.getPassword (),ByteSource.Util.bytes ( user.getSalt () ),this.getName ());
        }
        return null;
    }
}
