package com.galaxy.common.annotation;

import com.galaxy.common.enums.DataSourceType;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    /**
     * 切换数据源名称
     */
    public DataSourceType value() default DataSourceType.MASTER;
}
