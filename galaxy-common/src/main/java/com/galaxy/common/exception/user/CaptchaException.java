package com.galaxy.common.exception.user;

import com.galaxy.common.exception.base.BaseException;

/**
 * <p>TODO</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/16 23:25
 */
public class CaptchaException extends UserException {

    private static final long serialVersionUID = -6377122905624987701L;

    public CaptchaException() {
        super("user.jcaptcha.error", null);
    }
}
