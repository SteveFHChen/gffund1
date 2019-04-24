package com.ycnet.dbank.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * 单元测试环境的配置
 * User: guozp
 * Date: 14-3-17
 * Time: 下午1:50
 */
@Configuration
@Profile("junit")
@PropertySource(value = "classpath:/application-junit.properties")
public class JunitProfile {

}
