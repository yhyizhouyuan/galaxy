package com.galaxy.web.controller.system;

import com.galaxy.common.annotation.Log;
import com.galaxy.common.config.GalaxyConfig;
import com.galaxy.common.core.controller.BaseController;
import com.galaxy.common.core.domain.AjaxResult;
import com.galaxy.common.core.domain.entity.SysUser;
import com.galaxy.common.enums.BusinessType;
import com.galaxy.common.utils.file.FileUploadUtils;
import com.galaxy.framework.shiro.service.SysPasswordService;
import com.galaxy.system.service.ISysUserService;
import org.apache.shiro.cache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>个人信息 业务处理</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/22 15:41
 */
@Controller
@RequestMapping("/system/user/profile")
public class SysProfileController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(SysProfileController.class);

    private String prefix = "system/user/profile";

    @Autowired
    private ISysUserService userService;

    @Autowired
    private SysPasswordService passwordService;

    /**
     * 个人信息
     */
    @GetMapping()
    public String profile(ModelMap mmap) {
        SysUser user = getSysUser();
        mmap.put("user", user);
        mmap.put("roleGroup", userService.selectUserRoleGroup(user.getUserId()));
        mmap.put("postGroup", userService.selectUserPostGroup(user.getUserId()));
        return prefix + "/profile";
    }

    /**
     * 修改头像
     */
    @GetMapping("/avatar")
    public String avator(ModelMap mmap) {
        SysUser user = getSysUser();
        mmap.put("user", userService.selectUserById(user.getUserId()));
        return prefix + "/avatar";
    }

    /**
     * 保存头像
     */
    @Log(title = "个人信息", businessType = BusinessType.UPDATE)
    @PostMapping("/updateAvatar")
    @ResponseBody
    public AjaxResult updateAvatar(@RequestParam("avatarfile") MultipartFile file) {
        SysUser currentUser = getSysUser();
        try {
            if (!file.isEmpty()) {
                String avatar = FileUploadUtils.upload(GalaxyConfig.getAvatarPath(), file);
                System.out.println(avatar);
                currentUser.setAvatar(avatar);
                if (userService.updateUserInfo(currentUser) > 0) {
                    setSysUser(userService.selectUserById(currentUser.getUserId()));
                    return success();
                }
            }
            return error();
        } catch (Exception e) {
            log.error("修改头像失败！", e);
            return error(e.getMessage());
        }
    }
}
