package com.galaxy.system.service.impl;

import com.galaxy.domain.SysOperLog;
import com.galaxy.system.mapper.SysOperLogMapper;
import com.galaxy.system.service.ISysOperLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>TODO</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/16 23:13
 */
@Service
public class SysOperLogServiceImpl implements ISysOperLogService {
    @Autowired
    private SysOperLogMapper operLogMapper;

    /**
     * 新增操作日志
     *
     * @param operLog 操作日志对象
     */
    @Override
    public void insertOperlog(SysOperLog operLog) {
        operLogMapper.insertOperlog(operLog);
    }
}
