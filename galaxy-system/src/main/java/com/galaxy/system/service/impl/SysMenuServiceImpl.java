package com.galaxy.system.service.impl;

import com.galaxy.common.core.domain.entity.SysMenu;
import com.galaxy.common.core.domain.entity.SysUser;
import com.galaxy.common.utils.StringUtils;
import com.galaxy.system.mapper.SysMenuMapper;
import com.galaxy.system.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>TODO</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/15 8:29
 */
@Service
public class SysMenuServiceImpl implements ISysMenuService {

    @Autowired
    private SysMenuMapper menuMapper;
    /**
     * 根据用户查询菜单
     *
     * @param user 用户信息
     * @return 菜单列表
     */
    @Override
    public List<SysMenu> selectMenuByUser(SysUser user) {
        List<SysMenu> menus = new LinkedList<SysMenu>();
        if (user.isAdmin()){
            menus = menuMapper.selectMenuNormalAll();
        }else {
            menus = menuMapper.selectMenusByUserId(user.getUserId());
        }
        return null;
    }

    /**
     * 根据用户ID查询权限
     *
     * @param userId 用户ID
     * @return 权限列表
     */
    @Override
    public Set<String> selectPermsByUserId(Long userId) {
        menuMapper.selectPermsByUserId(userId);
        Set<String> permsSet = new HashSet<>();
        for (String perm : permsSet) {
            if (StringUtils.isNotEmpty(perm)){
                permsSet.addAll(Arrays.asList(perm.trim().split(",")));
            }
        }
        return permsSet;
    }

    /**
     * 根据父节点的ID获取所有子节点
     *
     * @param list 分类表
     * @param parentId 传入的父节点ID
     * @return String
     */
    public List<SysMenu> getChildPerms(List<SysMenu>list,int parentId){
        List<SysMenu> returnList = new ArrayList<SysMenu>();
        for (Iterator<SysMenu> iterator = list.iterator();iterator.hasNext();){
            SysMenu t = (SysMenu) iterator.next();
            if (t.getParentId() == parentId){
                recursionFn(list,t);
                returnList.add(t);
            }
        }
        return returnList;
    }

    /**
     * 递归列表
     *
     * @param list
     * @param t
     */
    private void recursionFn(List<SysMenu> list, SysMenu t) {
        List<SysMenu> childList = getChildList(list, t);
        t.setChildren(childList);
        for (SysMenu tChild : childList) {
            if (hasChild(list,tChild)){
                recursionFn(list,tChild);
            }
        }
    }

    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<SysMenu> list, SysMenu t) {
        return getChildList(list, t).size()>0?true:false;
    }

    /**
     * 得到子节点列表
     */
    private List<SysMenu> getChildList(List<SysMenu> list, SysMenu t) {
        List<SysMenu> tlist = new ArrayList<SysMenu>();
        Iterator<SysMenu> it = list.iterator();
        while (it.hasNext()) {
            SysMenu n = (SysMenu) it.next();
            if (n.getParentId().longValue() == t.getMenuId().longValue()){
                tlist.add(n);
            }

        }
        return tlist;
    }
}
