package com.galaxy.common.utils;

import com.galaxy.common.core.domain.entity.SysUser;
import com.galaxy.common.utils.bean.BeanUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;

/**
 * <p>shiro 工具类</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/14 21:45
 */
public class ShiroUtils {
    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    public static void logout() {
        getSubject().logout();
    }

    public static SysUser getSysUser() {
        SysUser user = null;
        Object obj = getSubject().getPrincipal();
        if (StringUtils.isNotNull(obj)) {
            user = new SysUser();
            BeanUtils.copyBeanProp(user, obj);
        }
        return user;
    }

    public static void setSysUser(SysUser user){
        Subject subject = getSubject();
        PrincipalCollection principalCollection = subject.getPrincipals();
        String realmName = principalCollection.getRealmNames().iterator().next();
        PrincipalCollection newPrincipalCollection = new SimplePrincipalCollection(user,realmName);
        subject.runAs(newPrincipalCollection);
    }

    public static Long getUserId(){
        return getSysUser().getUserId().longValue();
    }

    public static String getLoginName(){
        return getSysUser().getLoginName();
    }

    public static String getIp(){
        return getSubject().getSession().getHost();
    }

    public static String getSessionId(){
        return String.valueOf(getSubject().getSession().getId());
    }

    /***
     * <p>生成随机盐</p>
     *
     * @param null TODO
     * @author Hance
     * @date 2021/10/14 23:51
     */
    public static String randomSalt(){
        SecureRandomNumberGenerator secureRandom = new SecureRandomNumberGenerator();
        String hex = secureRandom.nextBytes(3).toHex();
        return hex;
    }

}
