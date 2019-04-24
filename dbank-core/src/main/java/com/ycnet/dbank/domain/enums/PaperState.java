package com.ycnet.dbank.domain.enums;

/**
 * 风险评估题目状态
 * User: guozp
 * Date: 14-4-20
 * Time: 下午10:57
 */
public enum PaperState implements NameableEnum {
    ACTIVE{
        @Override
        public String getName() {
            return "激活";
        }
    },
    INVALID{
        @Override
        public String getName() {
            return "无效";
        }
    };
}
