package com.galaxy.system.mapper;

import com.galaxy.common.core.domain.entity.SysDictType;

import java.util.List;

public interface SysDictTypeMapper {
    /**
     * 根据条件分页查询字典类型
     *
     * @param dictType 字典类型信息
     * @return 字典类型集合信息
     */
    public List<SysDictType> selectDictTypeList(SysDictType dictType);
}
