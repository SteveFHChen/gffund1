package com.ycnet.dbank.domain.enums;

/**
 * 角色类型
 * @author shine
 *
 */
public enum RoleType implements NameableEnum{
	ZH{
        @Override
        public String getName() {
            return "总行";
        }
    },FH{
        @Override
        public String getName() {
            return "分行";
        }
    },LH{
        @Override
        public String getName() {
            return "支行";
        }
    };

}
