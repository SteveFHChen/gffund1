package com.ycnet.dbank.util.sms;

/**
 * 短信接口
 * User: guozp
 * Date: 14-4-20
 * Time: 下午7:07
 */
public interface SmsSender {
    /**
     * 发送短信
     * @param phone     手机号
     * @param message   发送内容
     */
    public void send(String phone, String message);

}
