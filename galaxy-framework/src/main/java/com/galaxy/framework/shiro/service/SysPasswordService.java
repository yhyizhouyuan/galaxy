package com.galaxy.framework.shiro.service;

import com.galaxy.common.constant.Constants;
import com.galaxy.common.constant.ShiroConstants;
import com.galaxy.common.core.domain.entity.SysUser;
import com.galaxy.common.exception.user.UserPasswordNotMatchException;
import com.galaxy.common.utils.MessageUtils;
import com.galaxy.framework.manager.AsyncFactory;
import com.galaxy.framework.manager.AsyncManager;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>登录密码方法</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/19 14:34
 */
@Component
public class SysPasswordService {
    @Autowired
    private CacheManager cacheManager;


    private Cache<String, AtomicInteger> loginRecordCache;
    @PostConstruct
    public void init(){
        loginRecordCache = cacheManager.getCache(ShiroConstants.LOGINRECORDCACHE);
    }

    public void validate(SysUser user, String password) {
        String loginName = user.getLoginName();
        AtomicInteger retryCount = loginRecordCache.get(loginName);
        if (!matches(user,password)){
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(loginName, Constants.LOGIN_FAIL, MessageUtils.message("user.password.retry.limit.count",retryCount)));
            loginRecordCache.put(loginName,retryCount);
            throw new UserPasswordNotMatchException();
        }else {
            clearLoginRecordCache(loginName);
        }
    }

    public boolean matches(SysUser user, String newPassword)
    {
        return user.getPassword().equals(encryptPassword(user.getLoginName(), newPassword, user.getSalt()));
    }

    public void clearLoginRecordCache(String loginName)
    {
        loginRecordCache.remove(loginName);
    }

    public String encryptPassword(String loginName, String password, String salt)
    {
        return new Md5Hash(loginName + password + salt).toHex();
    }
}
