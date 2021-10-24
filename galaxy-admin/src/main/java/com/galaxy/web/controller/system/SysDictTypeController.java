package com.galaxy.web.controller.system;

import com.galaxy.common.core.controller.BaseController;
import com.galaxy.common.core.domain.entity.SysDictData;
import com.galaxy.common.core.domain.entity.SysDictType;
import com.galaxy.common.core.page.TableDataInfo;
import com.galaxy.system.service.ISysDictTypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>数据字典信息</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/22 10:30
 */
@Controller
@RequestMapping("/system/dict")
public class SysDictTypeController extends BaseController {
    private String prefix = "system/dict/type";

    @Autowired
    private ISysDictTypeService dictTypeService;

    @RequiresPermissions("system:dict:view")
    @GetMapping()
    public String dictData(){
        return prefix + "/type";
    }

    @RequiresPermissions("system:dict:list")
    @RequestMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysDictType dictType){
        startPage();
        List<SysDictType> list = dictTypeService.selectDictTypeList(dictType);
        return getDataTable(list);
    }
}
