package com.galaxy.system.service.impl;

import com.galaxy.domain.SysLogininfor;
import com.galaxy.system.mapper.SysLogininforMapper;
import com.galaxy.system.service.ISysLogininforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>系统访问日志情况信息 服务层处理</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/16 23:05
 */
@Service
public class SysLogininforServiceImpl implements ISysLogininforService {
    @Autowired
    private SysLogininforMapper logininforMapper;

    /**
     * 新增系统登录日志
     *
     * @param logininfor 访问日志对象
     */
    @Override
    public void insertLogininfor(SysLogininfor logininfor) {
        logininforMapper.insertLogininfor(logininfor);
    }

    /**
     * 查询系统登录日志集合
     *
     * @param logininfor 访问日志对象
     * @return 登录记录集合
     */
    @Override
    public List<SysLogininfor> selectLogininforList(SysLogininfor logininfor) {
        return logininforMapper.selectLogininforList(logininfor);
    }
}
