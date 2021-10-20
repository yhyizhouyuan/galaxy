package com.galaxy.common.exception.user;

/**
 * <p>用户账号已被删除</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/19 13:51
 */
public class UserDeleteException extends UserException {

    private static final long serialVersionUID = 4729388866065129003L;

    public UserDeleteException()
    {
        super("user.password.delete", null);
    }
}
