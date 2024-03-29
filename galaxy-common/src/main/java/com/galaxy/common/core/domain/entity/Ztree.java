package com.galaxy.common.core.domain.entity;

import java.io.Serializable;

/**
 * <p>Ztree树结构实体类</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/20 16:54
 */
public class Ztree implements Serializable {
    private static final long serialVersionUID = -2180668742126857847L;

    /** 节点ID */
    private Long id;

    /** 节点父ID */
    private Long pId;

    /** 节点名称 */
    private String name;

    /** 节点标题 */
    private String title;

    /** 是否勾选 */
    private boolean checked = false;

    /** 是否展开 */
    private boolean open = false;

    /** 是否能勾选 */
    private boolean nocheck = false;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getpId()
    {
        return pId;
    }

    public void setpId(Long pId)
    {
        this.pId = pId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public boolean isChecked()
    {
        return checked;
    }

    public void setChecked(boolean checked)
    {
        this.checked = checked;
    }

    public boolean isOpen()
    {
        return open;
    }

    public void setOpen(boolean open)
    {
        this.open = open;
    }

    public boolean isNocheck()
    {
        return nocheck;
    }

    public void setNocheck(boolean nocheck)
    {
        this.nocheck = nocheck;
    }

    @Override
    public String toString() {
        return "Ztree{" +
                "id=" + id +
                ", pId=" + pId +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", checked=" + checked +
                ", open=" + open +
                ", nocheck=" + nocheck +
                '}';
    }
}
