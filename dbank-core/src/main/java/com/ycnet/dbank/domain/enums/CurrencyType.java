package com.ycnet.dbank.domain.enums;

/**
 * 币种类型
 * User: guozp
 * Date: 14-4-20
 * Time: 下午6:19
 */
public enum CurrencyType implements NameableEnum {
    RMB{
        @Override
        public String getName() {
            return "人民币";
        }

    },
    USD{
        @Override
        public String getName() {
            return "美元";
        }
    };
}
