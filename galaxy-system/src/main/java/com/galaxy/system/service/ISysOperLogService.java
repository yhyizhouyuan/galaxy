package com.galaxy.system.service;

import com.galaxy.domain.SysOperLog;

/***
 * <p>TO 在线用户 服务层DO</p>
 *
 *
 * @author Hance
 * @date 2021/10/16 22:47
 */
public interface ISysOperLogService {

    /**
     * 新增操作日志
     *
     * @param operLog 操作日志对象
     */
    public void insertOperlog(SysOperLog operLog);
}
