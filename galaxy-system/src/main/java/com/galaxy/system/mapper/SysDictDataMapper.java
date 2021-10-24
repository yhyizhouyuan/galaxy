package com.galaxy.system.mapper;

import com.galaxy.common.core.domain.entity.SysDictData;
import com.galaxy.common.core.domain.entity.SysDictType;

import java.util.List;
/***
 * <p>字典表 数据层</p>
 *
 *
 * @author Hance
 * @date 2021/10/22 11:27
 */
public interface SysDictDataMapper {

    /**
     * 根据字典类型和字典键值查询字典数据信息
     *
     * @param dictType 字典类型
     * @param dictValue 字典键值
     * @return 字典标签
     */
    String selectDictLabel(String dictType, String dictValue);

    /**
     * 根据字典类型查询字典数据
     *
     * @param dictType 字典类型
     * @return 字典数据集合信息
     */
    List<SysDictData> selectDictDataByType(String dictType);

    /**
     * 根据条件分页查询字典数据
     *
     * @param dictData 字典数据信息
     * @return 字典数据集合信息
     */
    public List<SysDictData> selectDictDataList(SysDictData dictData);

}
