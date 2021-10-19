package com.galaxy.system.service;

import com.galaxy.domain.SysUserOnline;

import java.util.Date;
import java.util.List;

/***
 * <p>在线用户 服务层</p>
 *
 * @param null TODO
 * @author Hance
 * @date 2021/10/16 21:51
 */
public interface ISysUserOnlineService {
    /**
     * 保存会话信息
     *
     * @param online 会话信息
     */
    public void saveOnline(SysUserOnline online);

    /**
     * 查询会话集合
     *
     * @param expiredDate 有效期
     * @return 会话集合
     */
    public List<SysUserOnline> selectOnlineByExpired(Date expiredDate);

    /**
     * 清理用户缓存
     *
     * @param loginName 登录名称
     * @param sessionId 会话ID
     */
    public void removeUserCache(String loginName, String sessionId);

    /**
     * 通过会话序号删除信息
     *
     * @param sessions 会话ID集合
     * @return 在线用户信息
     */
    public void batchDeleteOnline(List<String> sessions);

    /**
     * 通过会话序号删除信息
     *
     * @param sessionId 会话ID
     * @return 在线用户信息
     */
    public void deleteOnlineById(String sessionId);

    /**
     * 通过会话序号查询信息
     *
     * @param sessionId 会话ID
     * @return 在线用户信息
     */
    public SysUserOnline selectOnlineById(String sessionId);
}
