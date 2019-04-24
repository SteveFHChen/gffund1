package com.ycnet.dbank.web.config;

import ch.qos.logback.core.PropertyDefinerBase;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;

/**
 * 日志路径配置器
 * User: guozp
 * Date: 14-3-25
 * Time: 下午7:42
 */
public class LogHomeDefiner extends PropertyDefinerBase {

    private Logger logger = LoggerFactory.getLogger(LogHomeDefiner.class);

    @Value("${log.path}")
    private String logPath;

    @Override
    public String getPropertyValue() {
        String logHome = null;
        try {
            if(StringUtils.isBlank(logPath)){
                logHome = "dbank/log";
            }
            FileUtils.forceMkdir(new File(logHome));
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("logPath no execute command mkdir permission!");
            return logHome;
        }

        return logHome;
    }
}
