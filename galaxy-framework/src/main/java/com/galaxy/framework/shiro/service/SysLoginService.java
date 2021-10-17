package com.galaxy.framework.shiro.service;

import com.galaxy.common.constant.Constants;
import com.galaxy.common.constant.ShiroConstants;
import com.galaxy.common.constant.UserConstants;
import com.galaxy.common.core.domain.entity.SysUser;
import com.galaxy.common.exception.user.CaptchaException;
import com.galaxy.common.exception.user.UserNotExistsException;
import com.galaxy.common.exception.user.UserPasswordNotMatchException;
import com.galaxy.common.utils.MessageUtils;
import com.galaxy.common.utils.ServletUtils;
import com.galaxy.common.utils.ShiroUtils;
import com.galaxy.common.utils.StringUtils;
import com.galaxy.framework.manager.AsyncFactory;
import com.galaxy.framework.manager.AsyncManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.websocket.RemoteEndpoint;

/**
 * <p>TODO</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/16 20:00
 */
@Component
public class SysLoginService {
    public SysUser login(String username, String password) {
        if (ShiroConstants.CAPTCHA_ERROR.equals(ServletUtils.getRequest().getAttribute(ShiroConstants.CURRENT_CAPTCHA))) {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.jcaptcha.error")));
            throw new CaptchaException();
        }
        // 用户名或密码为空 错误
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("not.null")));
            throw new UserNotExistsException();
        }
        // 密码如果不在指定范围内 错误
        if (password.length() < UserConstants.PASSWORD_MIN_LENGTH
                || password.length() > UserConstants.PASSWORD_MAX_LENGTH) {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match")));
            throw new UserPasswordNotMatchException();
        }

        // 用户名不在指定范围内 错误
        if (username.length() < UserConstants.USERNAME_MIN_LENGTH
                || username.length() > UserConstants.USERNAME_MAX_LENGTH) {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match")));
            throw new UserPasswordNotMatchException();
        }
        return null;

    }
}
