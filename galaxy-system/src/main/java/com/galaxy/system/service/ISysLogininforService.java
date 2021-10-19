package com.galaxy.system.service;

import com.galaxy.domain.SysLogininfor;

/***
 * <p>系统访问日志情况信息 服务层</p>
 *
 *
 * @author Hance
 * @date 2021/10/16 23:04
 */
public interface ISysLogininforService {

    /**
     * 新增系统登录日志
     *
     * @param logininfor 访问日志对象
     */
    public void insertLogininfor(SysLogininfor logininfor);

}
