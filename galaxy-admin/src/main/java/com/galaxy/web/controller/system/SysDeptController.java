package com.galaxy.web.controller.system;

import com.galaxy.common.core.controller.BaseController;
import com.galaxy.common.core.domain.entity.SysDept;
import com.galaxy.common.core.domain.entity.Ztree;
import com.galaxy.system.service.ISysDeptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 新增部门
     */
    @GetMapping("/add/{parentId}")
    public String add(@PathVariable("parentId")Long parentId, ModelMap mmap){
        if (!getSysUser().isAdmin()){
            parentId = getSysUser().getDeptId();
        }
        mmap.put("dept",deptService.selectDeptById(parentId));
        return prefix + "/add";
    }

    /**
     * 选择部门树
     *
     * @param deptId 部门ID
     * @param excludeId 排除ID
     */
    @GetMapping(value = {"/selectDeptTree/{deptId}/{excludeId}", "/selectDeptTree/{deptId}"})
    public String selectDeptTree(@PathVariable("deptId")Long deptId,@PathVariable(value = "excludeId",required = false)String excludeId,
                                 ModelMap mmap){
        mmap.put("dept",deptService.selectDeptById(deptId));
        mmap.put("excludeId",excludeId);
        return prefix + "/tree";
    }

    /**
     * 加载部门列表树
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData(){
        List<Ztree> ztrees = deptService.selectDeptTree(new SysDept());
        return ztrees;
    }

    /**
     * 校验部门名称
     */
    @PostMapping("/checkDeptNameUnique")
    @ResponseBody
    public String checkDeptNameUnique(SysDept dept){
        return deptService.checkDeptNameUnique(dept);
    }



}
