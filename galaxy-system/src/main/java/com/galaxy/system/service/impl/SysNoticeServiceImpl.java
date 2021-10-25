package com.galaxy.system.service.impl;

import com.galaxy.domain.SysNotice;
import com.galaxy.system.mapper.SysNoticeMapper;
import com.galaxy.system.service.ISysNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>公告 服务层实现</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/25 9:39
 */
@Service
public class SysNoticeServiceImpl implements ISysNoticeService {
    @Autowired
    private SysNoticeMapper noticeMapper;
    /**
     * 查询公告列表
     *
     * @param notice 公告信息
     * @return 公告集合
     */
    @Override
    public List<SysNotice> selectNoticeList(SysNotice notice) {
        return noticeMapper.selectNoticeList(notice);
    }
}
