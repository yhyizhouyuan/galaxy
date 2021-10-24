package com.galaxy.web.controller.system;

import com.galaxy.common.core.controller.BaseController;
import com.galaxy.common.core.domain.entity.SysDept;
import com.galaxy.common.core.page.TableDataInfo;
import com.galaxy.domain.SysPost;
import com.galaxy.system.service.ISysPostService;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>岗位信息操作处理</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/21 16:23
 */
@Controller
@RequestMapping("/system/post")
public class SysPostController extends BaseController {
    private String prefix = "system/post";

    @Autowired
    private ISysPostService postService;

    @RequiresPermissions("system:post:view")
    @GetMapping()
    public String operlog(){
        return prefix + "/post";
    }

    @RequiresPermissions("system:post:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysPost post){
        startPage();
        List<SysPost> list = postService.selectPostList(post);
        return getDataTable(list);
    }
}
