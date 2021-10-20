package com.galaxy.system.service.impl;

import com.galaxy.common.annotation.DataScope;
import com.galaxy.common.annotation.DataSource;
import com.galaxy.common.core.domain.entity.SysDept;
import com.galaxy.system.mapper.SysDeptMapper;
import com.galaxy.system.service.ISysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>TODO</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/19 15:38
 */
@Service
public class SysDeptServiceImpl implements ISysDeptService {

    @Autowired
    private SysDeptMapper deptMapper;
    /**
     * 查询部门管理数据
     *
     * @param dept 部门信息
     * @return 部门信息集合
     */
    @Override
    @DataScope(deptAlias = "d")
    public List<SysDept> selectDeptList(SysDept dept) {
        return deptMapper.selectDeptList(dept);
    }
}
