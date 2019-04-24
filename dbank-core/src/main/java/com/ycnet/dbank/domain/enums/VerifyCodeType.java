package com.ycnet.dbank.domain.enums;

import org.apache.commons.lang.RandomStringUtils;

/**
 * 验证码类型
 * User: guozp
 * Date: 14-4-20
 * Time: 下午7:13
 */
public enum VerifyCodeType implements NameableEnum {
    MSG{
        @Override
        public String getName() {
            return "短信验证码";
        }

        @Override
        String getContent() {
            return RandomStringUtils.randomNumeric(6);
        }
    },
    MAIL{
        @Override
        public String getName() {
            return "邮箱验证码";
        }

        @Override
        String getContent() {
            return RandomStringUtils.randomNumeric(10);
        }
    };

    //生成验证码的规则
    abstract String getContent();
}
