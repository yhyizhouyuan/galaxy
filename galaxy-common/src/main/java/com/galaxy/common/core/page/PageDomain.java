package com.galaxy.common.core.page;

import com.galaxy.common.utils.StringUtils;
import org.yaml.snakeyaml.events.Event;

/**
 * <p>分页数据</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/14 16:42
 */
public class PageDomain {
    /** 当前记录起始索引 */
    private Integer pageNum;

    /** 每页显示记录数 */
    private Integer pageSize;

    /** 排序列 */
    private String orderByColumn;

    /** 排序的方向desc或者asc */
    private String isAsc = "asc";

    public String getOrderBy(){
        if (StringUtils.isEmpty(orderByColumn)){
            return "";
        }
        return StringUtils.toUnderScoreCase(orderByColumn);
    }

    public Integer getPageNum()
    {
        return pageNum;
    }

    public void setPageNum(Integer pageNum)
    {
        this.pageNum = pageNum;
    }

    public Integer getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(Integer pageSize)
    {
        this.pageSize = pageSize;
    }

    public String getOrderByColumn()
    {
        return orderByColumn;
    }

    public void setOrderByColumn(String orderByColumn)
    {
        this.orderByColumn = orderByColumn;
    }

    public String getIsAsc()
    {
        return isAsc;
    }

    public void setIsAsc(String isAsc)
    {
        this.isAsc = isAsc;
    }
}
