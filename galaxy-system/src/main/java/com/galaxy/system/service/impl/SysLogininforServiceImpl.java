package com.galaxy.system.service.impl;

import com.galaxy.domain.SysLogininfor;
import com.galaxy.system.mapper.SysLogininforMapper;
import com.galaxy.system.service.ISysLogininforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>TODO</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/16 23:05
 */
@Service
public class SysLogininforServiceImpl implements ISysLogininforService {
    @Autowired
    private SysLogininforMapper logininforMapper;
    @Override
    public void insertLogininfor(SysLogininfor logininfor) {
        logininforMapper.insertLogininfor(logininfor);
    }
}
