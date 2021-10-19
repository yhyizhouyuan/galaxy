package com.galaxy.common.core.page;

import com.galaxy.common.constant.Constants;
import com.galaxy.common.utils.ServletUtils;

/**
 * <p>表格数据处理</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/14 16:48
 */
public class TableSupport {
    /**
     * 封装分页对象
     */
    public static PageDomain getPageDomain(){
        PageDomain pageDomain = new PageDomain();
        pageDomain.setPageNum(ServletUtils.getParameterToInt(Constants.PAGE_NUM));
        pageDomain.setPageSize(ServletUtils.getParameterToInt(Constants.PAGE_SIZE));
        pageDomain.setOrderByColumn(ServletUtils.getParameter(Constants.ORDER_BY_COLUMN));
        pageDomain.setIsAsc(ServletUtils.getParameter(Constants.IS_ASC));
        return pageDomain;
    }

    public static PageDomain buildPageRequest(){
        return getPageDomain();
    }
}
