package com.galaxy.common.exception.user;

/**
 * <p>TODO</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/16 23:29
 */
public class UserNotExistsException extends UserException {


    private static final long serialVersionUID = -8570333884797648584L;

    public UserNotExistsException()
    {
        super("user.not.exists", null);
    }
}
