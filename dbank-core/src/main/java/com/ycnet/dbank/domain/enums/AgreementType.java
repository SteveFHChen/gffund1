package com.ycnet.dbank.domain.enums;

/**
 * 协议书类型
 * User: guozp
 * Date: 14-4-21
 * Time: 上午12:21
 */
public enum AgreementType implements NameableEnum{
    E{
        @Override
        public String getName() {
            return "电子协议书";
        }
    },
    R{
        @Override
        public String getName() {
            return "风险揭示书";
        }
    };

}
