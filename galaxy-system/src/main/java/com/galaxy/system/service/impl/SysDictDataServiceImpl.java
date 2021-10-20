package com.galaxy.system.service.impl;

import com.galaxy.common.core.domain.entity.SysDictData;
import com.galaxy.system.mapper.SysDictDataMapper;
import com.galaxy.system.service.ISysDictDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>字典 业务层处理</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/20 14:23
 */
@Service
public class SysDictDataServiceImpl implements ISysDictDataService {

    @Autowired
    private SysDictDataMapper dictDataMapper;
    /**
     * 根据字典类型和字典键值查询字典数据信息
     *
     * @param dictType 字典类型
     * @param dictValue 字典键值
     * @return 字典标签
     */
    @Override
    public String selectDictLabel(String dictType, String dictValue) {
        return dictDataMapper.selectDictLabel(dictType,dictValue);
    }
}
