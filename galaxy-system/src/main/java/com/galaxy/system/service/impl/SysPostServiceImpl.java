package com.galaxy.system.service.impl;

import com.galaxy.domain.SysPost;
import com.galaxy.system.mapper.SysPostMapper;
import com.galaxy.system.service.ISysPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>岗位信息 服务层处理</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/21 16:39
 */
@Service
public class SysPostServiceImpl implements ISysPostService {

    @Autowired
    private SysPostMapper postMapper;
    /**
     * 查询岗位信息集合
     *
     * @param post 岗位信息
     * @return 岗位信息集合
     */
    @Override
    public List<SysPost> selectPostList(SysPost post) {
        return postMapper.selectPostList(post);
    }
}
