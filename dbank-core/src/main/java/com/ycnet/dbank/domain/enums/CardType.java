package com.ycnet.dbank.domain.enums;

/**
 * 卡类型
 * User: guozp
 * Date: 14-4-20
 * Time: 下午8:57
 */
public enum CardType implements NameableEnum {
    CREDIT{
        @Override
        public String getName() {
            return "信用卡";
        }
    },
    DEBIT{
        @Override
        public String getName() {
            return "借记卡";
        }
    };
}
