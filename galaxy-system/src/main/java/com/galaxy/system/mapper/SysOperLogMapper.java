package com.galaxy.system.mapper;

import com.galaxy.domain.SysOperLog;

import java.util.List;
/***
 * <p>操作日志 数据层</p>
 *
 * @param null TODO
 * @author Hance
 * @date 2021/10/25 9:51
 */
public interface SysOperLogMapper {
    /**
     * 新增操作日志
     *
     * @param operLog 操作日志对象
     */
    public void insertOperlog(SysOperLog operLog);

    /**
     * 查询系统操作日志集合
     *
     * @param operLog 操作日志对象
     * @return 操作日志集合
     */
    public List<SysOperLog> selectOperLogList(SysOperLog operLog);
}
