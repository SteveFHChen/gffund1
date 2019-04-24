package com.ycnet.dbank.web.config;

import com.ycnet.dbank.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 内管的security config 配置文档
 * User: guozp
 * Date: 14-3-25
 * Time: 上午10:31
 */
@Configuration
public class IMSecurityConfig extends DbankSecurityConfig {

    @Autowired
    private AdminRepository adminRepository;

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return adminRepository;
    }

    @Override
    public String getLoginPage() {
        return "/manage/login";
    }

    @Override
    public String getLogoutUrl() {
        return "/manage/logout";
    }

    @Override
    public String getLogoutSuccessUrl() {
        return "/manage/logout/success";
    }

    @Override
    public String getLoginProcessingUrl() {
        return "/manage/authentication";
    }

}
