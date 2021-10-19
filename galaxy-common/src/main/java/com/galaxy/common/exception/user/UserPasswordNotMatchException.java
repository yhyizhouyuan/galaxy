package com.galaxy.common.exception.user;

import com.galaxy.common.exception.base.BaseException;

/**
 * <p>TODO</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/16 23:30
 */
public class UserPasswordNotMatchException extends UserException {

    private static final long serialVersionUID = 2044655955437456267L;

    public UserPasswordNotMatchException()
    {
        super("user.password.not.match", null);
    }
}
