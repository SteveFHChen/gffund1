package com.ycnet.dbank.web.config;

import com.ycnet.dbank.web.interceptor.LogInterceptor;
import com.ycnet.mirage.web.config.MirageWebMvcConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

/**
 * web mvc config
 * User: guozp
 * Date: 14-3-11
 * Time: 上午12:15
 */
@Configuration
@PropertySource("classpath:/config/application.properties")
public class DbankWebMvcConfig extends MirageWebMvcConfig {
    /**
     * 增加日志记录拦截器
     * @param registry
     */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/**");
    }

    /**
     * 注入CommonsMultipartResolver，用于解析MultipartFile，上传文件
     * @return
     */
    @Bean
    public CommonsMultipartResolver multipartResolver(){
        return new CommonsMultipartResolver();
    }

}
