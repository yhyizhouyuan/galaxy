package com.galaxy.framework.config;

import com.galaxy.common.config.GalaxyConfig;
import com.galaxy.common.constant.Constants;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>配置路径映射</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/19 8:15
 */
@Configuration
public class ResourcesConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(Constants.RESOURCE_PREFIX+"/**").addResourceLocations("file:"+ GalaxyConfig.getProfile()+"/");
    }
}
