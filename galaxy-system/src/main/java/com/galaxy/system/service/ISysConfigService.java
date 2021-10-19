package com.galaxy.system.service;

/**
 * <p>TODO</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/15 10:07
 */
public interface ISysConfigService {
    public String selectConfigByKey(String configKey);

    /**
     * 加载参数缓存数据
     */
    public void loadingConfigCache();

    /**
     * 清空参数缓存数据
     */
    public void clearConfigCache();

    /**
     * 重置参数缓存数据
     */
    public void resetConfigCache();
}
