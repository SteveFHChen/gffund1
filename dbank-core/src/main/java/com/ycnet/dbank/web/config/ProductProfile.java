package com.ycnet.dbank.web.config;

import com.ycnet.mirage.config.env.JndiEnvironment;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * 生产环境的配置JNDI配置
 * User: guozp
 * Date: 14-3-17
 * Time: 下午1:52
 */
@Configuration
@Profile("product")
@PropertySource(value = "classpath:/application-product.properties")
public class ProductProfile extends JndiEnvironment {

}
