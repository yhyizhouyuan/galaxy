package com.galaxy.system.service;

import com.galaxy.common.core.domain.entity.SysMenu;
import com.galaxy.common.core.domain.entity.SysUser;

import java.util.List;
import java.util.Set;

/**
 * <p>TODO</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/15 8:18
 */
public interface ISysMenuService {
    /**
     * 根据用户ID查询菜单
     *
     * @param user 用户信息
     * @return 菜单列表
     */
    public List<SysMenu> selectMenuByUser(SysUser user);

    /**
     * 根据用户ID查询权限
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    public Set<String> selectPermsByUserId(Long userId);


    /**
     * 查询系统菜单列表
     *
     * @param menu 菜单信息
     * @param userId 用户ID
     * @return 菜单列表
     */
    List<SysMenu> selectMenuList(SysMenu menu, Long userId);
}
