package com.ycnet.dbank;

import com.ycnet.mirage.context.MirageWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

/**
 * web配置
 * Created with IntelliJ IDEA.
 * User: guozp
 * Date: 14-3-11
 * Time: 上午12:15
 * To change this template use File | Settings | File Templates.
 */
public abstract class WebAppAdapter extends MirageWebApplication {

    @Bean
    public DispatcherServlet dispatcherServlet(){
        return new DispatcherServlet();
    }

    protected void addServlet(ServletContext ctx, String name, String configClass) {
        addServlet(ctx,name,configClass,1);
    }

    protected void addServlet(ServletContext ctx, String name, String configClass, int order) {
        DispatcherServlet loanServlet = dispatcherServlet();
        loanServlet.setContextClass(AnnotationConfigWebApplicationContext.class);
        loanServlet.setContextConfigLocation(configClass);
        ServletRegistration.Dynamic loan = ctx.addServlet(name, loanServlet);
        loan.setLoadOnStartup(order);
        loan.addMapping("/"+name+"/*");
    }

}
