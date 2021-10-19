package com.galaxy.system.service.impl;

import com.galaxy.common.constant.Constants;
import com.galaxy.common.core.text.Convert;
import com.galaxy.common.utils.CacheUtils;
import com.galaxy.common.utils.StringUtils;
import com.galaxy.domain.SysConfig;
import com.galaxy.system.mapper.SysConfigMapper;
import com.galaxy.system.service.ISysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * <p>参数配置 服务层实现</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/15 10:33
 */
@Service
public class SysConfigServiceImpl implements ISysConfigService {

    @Autowired
    private SysConfigMapper configMapper;

    /**
     * 项目启动时，初始化参数到缓存
     */
    @PostConstruct
    public void init(){
        loadingConfigCache();
    }

    /**
     * 加载参数缓存数据
     */
    @Override
    public void loadingConfigCache() {
        List<SysConfig> configsList = configMapper.selectConfigList(new SysConfig());
        for (SysConfig config : configsList) {
            CacheUtils.put(getCacheName(),getCacheKey(config.getConfigKey()),config.getConfigValue());
        }

    }


    @Override
    public void clearConfigCache() {
        CacheUtils.removeAll(getCacheName());

    }

    @Override
    public void resetConfigCache() {
        clearConfigCache();
        loadingConfigCache();
    }

    /**
     * 根据键名查询参数配置信息
     *
     * @param configKey 参数key
     * @return 参数键值
     */
    @Override
    public String selectConfigByKey(String configKey) {
        String configVale = Convert.toStr(CacheUtils.get(getCacheName(), getCacheKey(configKey)));
        if (StringUtils.isNotEmpty(configVale)){
            return configVale;
        }
        SysConfig config = new SysConfig();
        config.setConfigKey(configKey);
        SysConfig retConfig = configMapper.selectConfig(config);
        if (StringUtils.isNotNull(retConfig)){
            CacheUtils.put(getCacheName(),getCacheKey(configKey),retConfig.getConfigValue());
            return retConfig.getConfigValue();
        }
        return StringUtils.EMPTY;
    }

    /**
     * 获取cache name
     *
     * @return 缓存名
     */
    private String getCacheName(){
        return Constants.SYS_CONFIG_CACHE;
    }

    /**
     * 设置cache key
     *
     * @param configKey 参数键
     * @return 缓存键key
     */
    private String getCacheKey(String configKey){
        return Constants.SYS_CONFIG_KEY+configKey;
    }

}
