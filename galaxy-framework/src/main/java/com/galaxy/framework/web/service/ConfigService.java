package com.galaxy.framework.web.service;

import com.galaxy.system.service.ISysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>html调用 thymeleaf 实现参数管理</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/15 16:22
 */
@Service("config")
public class ConfigService {
    @Autowired
    private ISysConfigService configService;

    /**
     * 根据键名查询参数配置信息
     *
     * @param configKey 参数键名
     * @return 参数键值
     */
    public String getKey(String  configKey){
        return configService.selectConfigByKey(configKey);
    }
}
