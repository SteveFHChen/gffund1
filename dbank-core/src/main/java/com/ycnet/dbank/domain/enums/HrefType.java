package com.ycnet.dbank.domain.enums;

/**
 * 链接类型（系统内部，还是对接外部）
 * User: guozp
 * Date: 14-4-22
 * Time: 下午1:07
 */
public enum HrefType implements NameableEnum {
    INNER{
        @Override
        public String getName() {
            return "内部链接";
        }
    },OUTER{
        @Override
        public String getName() {
            return "外部链接";
        }
    };
}
