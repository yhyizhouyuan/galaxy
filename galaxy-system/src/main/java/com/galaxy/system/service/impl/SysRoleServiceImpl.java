package com.galaxy.system.service.impl;

import com.galaxy.system.mapper.SysRoleMapper;
import com.galaxy.system.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * <p>角色 业务层处理</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/16 20:07
 */
@Service
public class SysRoleServiceImpl implements ISysRoleService {

    @Autowired
    private SysRoleMapper roleMapper;

    /**
     * 根据用户ID查询权限
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    @Override
    public Set<String> selectRoleKeys(Long userId) {
        roleMapper.selectRolesByUserId(userId);
        return null;
    }
}
