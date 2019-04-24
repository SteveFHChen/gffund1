package com.ycnet.dbank;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import com.ycnet.Application;
import com.ycnet.dbank.web.config.ServiceConfig;

/**
 * 外置容器,web配置(同web.xml)
 * Created with IntelliJ IDEA.
 * User: guozp
 * Date: 14-3-11
 * Time: 上午12:15
 * To change this template use File | Settings | File Templates.
 */
public class SiteWebAppInitializer extends WebAppAdapter {

    @Override
    protected Class<?> getApplicationClass() {
        return Application.class;
    }

    @Override
    public void onStartup(ServletContext ctx) throws ServletException {
        super.onStartup(ctx);
        addServlet(ctx, "service", ServiceConfig.class.getName());
    }


}
