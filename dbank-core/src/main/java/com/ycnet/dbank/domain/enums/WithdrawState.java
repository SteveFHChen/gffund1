package com.ycnet.dbank.domain.enums;

/**
 * 提现状态
 * User: guozp
 * Date: 14-4-21
 * Time: 上午11:04
 */
public enum WithdrawState implements NameableEnum {
    SUCCESS{
        @Override
        public String getName() {
            return "成功";
        }
    },
    FAIL{
        @Override
        public String getName() {
            return "失败";
        }
    };
}
