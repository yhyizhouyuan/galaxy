package com.galaxy.common.exception.user;

/**
 * <p>用户锁定异常类</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/19 13:52
 */
public class UserBlockedException extends UserException {

    private static final long serialVersionUID = -8461640451926825657L;

    public UserBlockedException()
    {
        super("user.blocked", null);
    }
}
