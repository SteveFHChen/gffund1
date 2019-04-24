package com.ycnet.dbank.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * 开发环境的配置
 * User: guozp
 * Date: 14-3-11
 * Time: 上午12:15
 */
@Configuration
@Profile("develop")
@PropertySource(value = "classpath:/application-develop.properties")
public class DevelopProfile {

}
