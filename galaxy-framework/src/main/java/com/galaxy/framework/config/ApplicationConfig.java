package com.galaxy.framework.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * <p>TODO</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/15 15:01
 */
@Configuration
@MapperScan("com.galaxy.**.mapper")
@EnableAspectJAutoProxy(exposeProxy = true)
public class ApplicationConfig {
}
