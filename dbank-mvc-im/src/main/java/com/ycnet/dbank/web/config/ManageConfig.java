package com.ycnet.dbank.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 内管系统的contextConfigLocation
 * User: guozp
 * Date: 14-3-18
 * Time: 上午10:10
 */
@Configuration
@ComponentScan(basePackages = "com.ycnet.dbank.web.controller")
public class ManageConfig extends DbankWebMvcConfig {

}
