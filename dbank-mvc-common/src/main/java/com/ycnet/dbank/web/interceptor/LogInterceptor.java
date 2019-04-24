package com.ycnet.dbank.web.interceptor;

import com.ycnet.dbank.web.security.SecurityContextUtil;
import com.ycnet.mirage.context.MirageException;
import com.ycnet.mirage.web.interceptor.MirageInterceptor;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 拦截所有(/**)所有请求,具体见DbankWebMvcConfig
 * User: guozp
 * Date: 14-3-11
 * Time: 上午12:15
 */
public class LogInterceptor extends MirageInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("startTime", DateTime.now().getMillis());
		return super.preHandle(request,response,handler);
	}

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        final String SEPARATOR = "|";

        long executeTime = DateTime.now().getMillis() - (Long)request.getAttribute("startTime");
        UserDetails curUser = SecurityContextUtil.getCurrentUser();
        String clientIp = getClientIp(request);
        String userAgent = request.getHeader("user-agent");
        String requestURI = request.getRequestURI();

        StringBuffer content = new StringBuffer();
        content.append(DateTime.now().toString("yyyy-MM-dd HH:mm:ss,SSS")).append(SEPARATOR);
        content.append(userAgent).append(SEPARATOR);
        content.append(clientIp).append(SEPARATOR);
        content.append(requestURI).append(SEPARATOR);
        if(curUser == null){
            content.append("<anonymous>").append(SEPARATOR);
        }else{
            content.append("<").append(curUser.getUsername()).append(">").append(SEPARATOR);
        }
        content.append("NA").append(SEPARATOR);
        if(ex == null){
            content.append("OK").append(SEPARATOR);
        }else{
            if(ex instanceof MirageException){
                content.append(((MirageException) ex).getCode()).append(SEPARATOR);
            }else{
                content.append(ex.getMessage()).append(SEPARATOR);
            }

            if(logger.isDebugEnabled()){
                content.append(printStackTraceToString(ex)).append(SEPARATOR);
            }
        }

        content.append(executeTime).append(SEPARATOR);

        logger.info(content.toString());

    }

    private String getClientIp(HttpServletRequest request){
        String headerIp = request.getHeader("X-Real-IP");
        String clientIp = StringUtils.isNotBlank(headerIp) ?headerIp : request.getRemoteAddr();
        return clientIp;
    }

    private String printStackTraceToString(Exception ex){
        String exceptionStack = null;
        if(ex != null){
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            try {
                ex.printStackTrace(printWriter);
                exceptionStack = stringWriter.toString();
            } finally {
                try {
                    if(stringWriter != null){
                        printWriter.close();
                    }
                    if(printWriter != null){
                        stringWriter.close();
                    }
                } catch (Exception e) {
                    logger.info("log error:" + e.getMessage());
                }
            }
        }
        return exceptionStack;
    }


	
}
