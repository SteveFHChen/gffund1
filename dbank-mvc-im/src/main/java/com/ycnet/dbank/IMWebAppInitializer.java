package com.ycnet.dbank;

import com.ycnet.Application;
import com.ycnet.dbank.web.config.ManageConfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * 外置容器,web配置(同web.xml)
 * User: guozp
 * Date: 14-3-11
 * Time: 上午12:15
 */
public class IMWebAppInitializer extends WebAppAdapter {

	@Override
	protected Class<?> getApplicationClass() {
		return Application.class;
	}

    @Override
    public void onStartup(ServletContext ctx) throws ServletException {
        super.onStartup(ctx);
        addServlet(ctx, "manage", ManageConfig.class.getName());
    }

}
