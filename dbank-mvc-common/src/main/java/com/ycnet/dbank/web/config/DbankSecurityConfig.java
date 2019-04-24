package com.ycnet.dbank.web.config;

import com.ycnet.mirage.config.support.SecuritySettings;
import com.ycnet.mirage.web.security.MirageSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;

/**
 * spring security配置文档 base
 * User: guozp
 * Date: 14-3-11
 * Time: 上午12:15
 */
public abstract class DbankSecurityConfig extends MirageSecurityConfig {

    @Autowired
    protected SecuritySettings securitySettings;

    /**
     * web页面拦截配置
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        web.ignoring()
                .antMatchers("/images/**")
                .antMatchers("/scripts/**")
                .antMatchers("/views/**")
                .antMatchers("/styles/**");
    }

    /**
     * http拦截
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        super.configure(http);

        http.authorizeRequests()
                .antMatchers(getLoginPage()).permitAll();

        http.logout()
                .logoutUrl(getLogoutUrl())
                .logoutSuccessUrl(getLogoutSuccessUrl());

        http.formLogin()
                .loginProcessingUrl(getLoginProcessingUrl());

        http.sessionManagement().disable();

        if (getMaximunSessions() != -1) {
            http.sessionManagement().maximumSessions(getMaximunSessions());
        }

        if (!securitySettings.getUseDefaultLoginForm()) {
            http.formLogin().loginPage(getLoginPage());
        }

    }

    public abstract String getLoginPage();         //登录页面
    public abstract String getLogoutUrl();         //登出url
    public abstract String getLogoutSuccessUrl();  //登出成功跳转url
    public abstract String getLoginProcessingUrl();//登录接口
}
