package com.galaxy.system.mapper;

import com.galaxy.domain.SysUserOnline;

import java.util.List;

public interface SysUserOnlineMapper {
    public int saveOnline(SysUserOnline online);

    /**
     * 查询过期会话集合
     *
     * @param lastAccessTime 过期时间
     * @return 会话集合
     */
    public List<SysUserOnline> selectOnlineByExpired(String lastAccessTime);


    /**
     * 通过会话序号查询信息
     *
     * @param sessionId 会话ID
     * @return 在线用户信息
     */
    public SysUserOnline selectOnlineById(String sessionId);

    /**
     * 通过会话序号删除信息
     *
     * @param sessionId 会话ID
     * @return 在线用户信息
     */
    public int deleteOnlineById(String sessionId);
}
