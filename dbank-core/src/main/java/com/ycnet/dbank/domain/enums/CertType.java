package com.ycnet.dbank.domain.enums;

/**
 * 证件类型
 * User: guozp
 * Date: 14-4-17
 * Time: 下午7:28
 */
public enum CertType implements NameableEnum {
    ID_CARD{
        @Override
        public String getName() {
            return "身份证";
        }
    },
    OFFICER{
        @Override
        public String getName() {
            return "军官证";
        }
    };



}
