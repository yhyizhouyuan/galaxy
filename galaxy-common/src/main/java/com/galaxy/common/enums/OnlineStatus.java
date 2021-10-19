package com.galaxy.common.enums;

/**
 * <p>TODO</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/16 20:51
 */
public enum  OnlineStatus {
    /** 用户状态 */
    on_line("在线"), off_line("离线");

    private final String info;

    private OnlineStatus(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
