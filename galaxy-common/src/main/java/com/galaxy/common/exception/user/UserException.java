package com.galaxy.common.exception.user;

import com.galaxy.common.exception.base.BaseException;

/**
 * <p>用户信息异常类</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/16 23:26
 */
public class UserException extends BaseException {
    private static final long serialVersionUID = -6501526454359916007L;

    public UserException(String code, Object[] args) {
        super("user",code, args,null);
    }
}
