package com.ycnet.dbank.domain.enums;

/**
 * 内管用户状态
 * User: guozp
 * Date: 14-5-14
 * Time: 下午2:05
 */
public enum AdminState implements NameableEnum {
    ACTIVE{
        @Override
        public String getName() {
            return "激活";
        }
    },
    FREEZING{
        @Override
        public String getName() {
            return "临时冻结";
        }
    },
    PERMAFROST{
        @Override
        public String getName() {
            return "永久冻结";
        }
    };
}
