package com.galaxy.system.mapper;

import com.galaxy.common.core.domain.entity.SysMenu;

import java.util.List;

public interface SysMenuMapper {
    /**
     * 查询系统正常显示菜单（不含按钮）
     *
     * @return 菜单列表
     */
    public List<SysMenu> selectMenuNormalAll();

    public List<SysMenu> selectMenusByUserId(Long userId);

    /**
     * 根据用户ID查询权限
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    public List<SysMenu> selectPermsByUserId(Long userId);
}
