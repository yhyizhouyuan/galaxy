package com.galaxy.web.controller.system;

import com.galaxy.common.core.controller.BaseController;
import com.galaxy.common.core.domain.entity.SysDictData;
import com.galaxy.common.core.page.TableDataInfo;
import com.galaxy.system.service.ISysDictDataService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import oshi.jna.platform.mac.SystemB;

import java.util.List;

/**
 * <p>数据字典信息 data</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/22 10:42
 */
@Controller
@RequestMapping("/system/dict/data")
public class SysDictDataController extends BaseController {
    private String prefix = "system/dict/data";

    @Autowired
    private ISysDictDataService dictDataService;

    @RequiresPermissions("system:dict:view")
    @GetMapping()
    public String dictData(){
        return prefix + "/data";
    }

    @RequiresPermissions("system:dict:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysDictData dictData){
        startPage();
        List<SysDictData> list = dictDataService.selectDictDataList(dictData);
        return getDataTable(list);
    }
}
