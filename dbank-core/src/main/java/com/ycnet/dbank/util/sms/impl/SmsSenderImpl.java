package com.ycnet.dbank.util.sms.impl;

import com.ycnet.dbank.util.sms.SmsSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 短信接口标准实现
 * User: guozp
 * Date: 14-4-20
 * Time: 下午7:09
 */
@Component
public class SmsSenderImpl implements SmsSender {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void send(String phone, String message) {
        logger.info("message send to " + phone + " success!");
    }
}
