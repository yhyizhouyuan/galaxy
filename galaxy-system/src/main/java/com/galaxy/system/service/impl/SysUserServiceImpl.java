package com.galaxy.system.service.impl;

import com.galaxy.common.core.domain.entity.SysUser;
import com.galaxy.system.mapper.SysUserMapper;
import com.galaxy.system.service.ISysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>TODO</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/19 11:26
 */
@Service
public class SysUserServiceImpl implements ISysUserService {
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);


    @Autowired
    private SysUserMapper userMapper;
    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    @Override
    public SysUser selectUserByLoginName(String userName) {
        return userMapper.selectUserByLoginName(userName);
    }
}
