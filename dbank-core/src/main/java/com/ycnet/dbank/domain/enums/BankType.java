package com.ycnet.dbank.domain.enums;

/**
 * 银行类型
 * User: guozp
 * Date: 14-4-20
 * Time: 下午8:51
 */
public enum BankType implements NameableEnum {
    SELF {
        @Override
        public String getName() {
            return "本行";
        }
    },
    REST{
        @Override
        public String getName() {
            return "他行";
        }
    };
}
