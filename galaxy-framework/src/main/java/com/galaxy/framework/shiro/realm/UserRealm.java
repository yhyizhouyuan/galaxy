package com.galaxy.framework.shiro.realm;

import com.galaxy.common.core.domain.entity.SysUser;
import com.galaxy.common.exception.user.CaptchaException;
import com.galaxy.common.utils.ShiroUtils;
import com.galaxy.framework.shiro.service.SysLoginService;
import com.galaxy.system.service.ISysMenuService;
import com.galaxy.system.service.ISysRoleService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>TODO</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/16 16:35
 */
public class UserRealm  extends AuthorizingRealm {

    private static final Logger log = LoggerFactory.getLogger(UserRealm.class);

    @Autowired
    private ISysMenuService menuService;

    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private SysLoginService loginService;
    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SysUser user = ShiroUtils.getSysUser();
        //角色列表
        Set<String> roles = new HashSet<String>();
        //功能列表
        Set<String> menus = new HashSet<String>();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if (user.isAdmin()){
            info.addRole("admin");
            info.addStringPermission("*:*:*");
        }else {
            roles = roleService.selectRoleKeys(user.getUserId());
            menus = menuService.selectPermsByUserId(user.getUserId());
            info.setRoles(roles);
            info.setStringPermissions(menus);
        }
        return info;
    }

    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        String password = "";
        if (usernamePasswordToken.getPassword()!=null){
            password = new String(usernamePasswordToken.getPassword());
        }
        SysUser user = null;
        try {
            loginService.login(username,password);
        }catch (CaptchaException e){
            throw new AuthenticationException(e.getMessage(),e);
        }
        return null;
    }
}
