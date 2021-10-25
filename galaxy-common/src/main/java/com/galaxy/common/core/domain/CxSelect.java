package com.galaxy.common.core.domain;

import java.io.Serializable;
import java.util.List;

/**
 * <p>CxSelect树结构实体类</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/25 10:42
 */
public class CxSelect implements Serializable {
    private static final long serialVersionUID = 4962069620328015879L;

    /**
     * 数据值字段名称
     */
    private String v;

    /**
     * 数据标题字段名称
     */
    private String n;

    /**
     * 子集数据字段名称
     */
    private List<CxSelect> s;

    public CxSelect()
    {
    }

    public CxSelect(String v, String n)
    {
        this.v = v;
        this.n = n;
    }

    public List<CxSelect> getS()
    {
        return s;
    }

    public void setN(String n)
    {
        this.n = n;
    }

    public String getN()
    {
        return n;
    }

    public void setS(List<CxSelect> s)
    {
        this.s = s;
    }

    public String getV()
    {
        return v;
    }

    public void setV(String v)
    {
        this.v = v;
    }
}
