package com.galaxy.system.service;

import com.galaxy.common.core.domain.entity.SysDictData;
import com.galaxy.common.core.domain.entity.SysDictType;
import com.galaxy.common.utils.DictUtils;
import com.galaxy.common.utils.StringUtils;
import com.galaxy.system.mapper.SysDictDataMapper;
import com.galaxy.system.mapper.SysDictTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>字典 业务层处理</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/20 14:27
 */
@Service
public class SysDictTypeServiceImpl implements ISysDictTypeService {

    @Autowired
    private SysDictTypeMapper dictTypeMapper;

    @Autowired
    private SysDictDataMapper dictDataMapper;
    /**
     * 根据字典类型查询字典数据
     *
     * @param dictType 字典类型
     * @return 字典数据集合信息
     */
    @Override
    public List<SysDictData> selectDictDataByType(String dictType) {
        List<SysDictData> dictDatas = DictUtils.getDictCache(dictType);
        if (StringUtils.isNotEmpty(dictDatas)){
            return dictDatas;
        }
        dictDatas = dictDataMapper.selectDictDataByType(dictType);
        if (StringUtils.isNotEmpty(dictDatas)){
            DictUtils.setDictCache(dictType,dictDatas);
            return dictDatas;
        }
        return null;
    }

    /**
     * 根据条件分页查询字典类型
     *
     * @param dictType 字典类型信息
     * @return 字典类型集合信息
     */
    @Override
    public List<SysDictType> selectDictTypeList(SysDictType dictType) {
        return dictTypeMapper.selectDictTypeList(dictType);
    }
}
