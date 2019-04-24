package com.ycnet.dbank.web.config;

import com.ycnet.dbank.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * spring security配置文档
 * User: guozp
 * Date: 14-3-11
 * Time: 上午12:15
 */
@Configuration
public class SiteSecurityConfig extends DbankSecurityConfig {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		return personRepository;
	}

    @Override
    public String getLoginPage() {
        return "/service/login";
    }

    @Override
    public String getLogoutUrl() {
        return "/service/logout";
    }

    @Override
    public String getLogoutSuccessUrl() {
        return "/service/logout/success";
    }

    @Override
    public String getLoginProcessingUrl() {
        return "/service/authentication";
    }
}
