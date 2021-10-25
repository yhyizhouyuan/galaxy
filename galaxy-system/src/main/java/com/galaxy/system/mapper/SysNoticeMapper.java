package com.galaxy.system.mapper;

import com.galaxy.domain.SysNotice;

import java.util.List;

/***
 * <p>公告 数据层</p>
 *
 *
 * @author Hance
 * @date 2021/10/25 9:41
 */
public interface SysNoticeMapper {

    /**
     * 查询公告列表
     *
     * @param notice 公告信息
     * @return 公告集合
     */
    List<SysNotice> selectNoticeList(SysNotice notice);
}
