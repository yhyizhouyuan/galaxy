package com.galaxy.system.service;

import com.galaxy.common.core.domain.entity.SysUser;

/**
 * <p>用户 业务层</p>
 *
 *
 * @author Hance
 * @date 2021/10/19 11:25
 */
public interface ISysUserService {

    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    public SysUser selectUserByLoginName(String userName);
}
