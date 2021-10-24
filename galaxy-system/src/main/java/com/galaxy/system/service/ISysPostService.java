package com.galaxy.system.service;

import com.galaxy.domain.SysPost;

import java.util.List;

/***
 * <p>岗位信息 服务层</p>
 *
 *
 * @author Hance
 * @date 2021/10/21 16:30
 */
public interface ISysPostService {

    /**
     * 查询岗位信息集合
     *
     * @param post 岗位信息
     * @return 岗位信息集合
     */
    public List<SysPost> selectPostList(SysPost post);
}
