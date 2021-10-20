package com.galaxy.system.service;

import com.galaxy.common.core.domain.entity.SysDept;

import java.util.List;

public interface ISysDeptService {
    /**
     * 查询部门管理数据
     *
     * @param dept 部门信息
     * @return 部门信息集合
     */
    List<SysDept> selectDeptList(SysDept dept);
}
