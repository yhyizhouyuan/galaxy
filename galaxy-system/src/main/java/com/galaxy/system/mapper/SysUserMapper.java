package com.galaxy.system.mapper;


import com.galaxy.common.core.domain.entity.SysUser;

public interface SysUserMapper {
    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    SysUser selectUserByLoginName(String userName);
}
