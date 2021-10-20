package com.galaxy.web.controller.system;

import com.galaxy.common.constant.ShiroConstants;
import com.galaxy.common.core.controller.BaseController;
import com.galaxy.common.core.domain.entity.SysMenu;
import com.galaxy.common.utils.ShiroUtils;
import com.galaxy.system.service.ISysMenuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>菜单信息</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/19 15:55
 */
@Controller
@RequestMapping("/system/menu")
public class SysMenuController extends BaseController {
    private String prefix = "system/menu";

    @Autowired
    private ISysMenuService menuService;

    @RequiresPermissions("system:menu:view")
    @GetMapping()
    @ResponseBody
    public String menu(){
        return prefix + "/menu";
    }

    @RequiresPermissions("system:menu:list")
    @PostMapping("/list")
    @ResponseBody
    public List<SysMenu> list(SysMenu menu){
        Long userId = ShiroUtils.getUserId();
        List<SysMenu> menuList = menuService.selectMenuList(menu, userId);
        return menuList;
    }
}
