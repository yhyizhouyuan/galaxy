package com.galaxy.system.service;

import com.galaxy.domain.SysNotice;

import java.util.List;

/**
 * <p>公告 服务层</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/25 9:16
 */
public interface ISysNoticeService {
    /**
     * 查询公告列表
     *
     * @param notice 公告信息
     * @return 公告集合
     */
    List<SysNotice> selectNoticeList(SysNotice notice);
}
