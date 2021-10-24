package com.galaxy.system.mapper;

import com.galaxy.domain.SysPost;

import java.util.List;

/***
 * <p>岗位信息 数据层</p>
 *
 *
 * @author Hance
 * @date 2021/10/21 16:41
 */
public interface SysPostMapper {

    /**
     * 查询岗位数据集合
     *
     * @param post 岗位信息
     * @return 岗位数据集合
     */
    public List<SysPost> selectPostList(SysPost post);


    /**
     * 根据用户ID查询用户所属岗位组
     *
     * @param userId 用户ID
     * @return 结果
     */
    public List<SysPost> selectPostsByUserId(Long userId);
}
