package com.galaxy.web.controller.system;

import com.galaxy.common.core.controller.BaseController;
import com.galaxy.common.core.domain.entity.SysDept;
import com.galaxy.system.service.ISysDeptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>部门信息</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/19 15:31
 */
@Controller
@RequestMapping("/system/dept")
public class SysDeptController extends BaseController {
    private String prefix = "system/dept";

    @Autowired
    private ISysDeptService deptService;

    @RequiresPermissions("system:dept:view")
    @GetMapping()
    public String dept(){
        return prefix + "/dept";
    }

    @RequiresPermissions("system:dept:list")
    @PostMapping("/list")
    @ResponseBody
    public List<SysDept> list(SysDept dept){
        List<SysDept> deptList = deptService.selectDeptList(dept);
        return deptList;
    }
}
