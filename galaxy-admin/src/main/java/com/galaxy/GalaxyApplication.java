package com.galaxy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * <p>TODO</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2021/10/13 22:13
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//@MapperScan("com.galaxy.system.mapper")
//@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class GalaxyApplication {
    public static void main(String[] args) {
        SpringApplication.run(GalaxyApplication.class,args);
        System.out.println("(♥◠‿◠)ﾉﾞ  galaxy启动成功   ლ(´ڡ`ლ)ﾞ  \n" );
    }
}
