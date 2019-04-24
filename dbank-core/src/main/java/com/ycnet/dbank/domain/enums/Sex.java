package com.ycnet.dbank.domain.enums;

/**
 * 性别类型
 * User: guozp
 * Date: 14-3-11
 * Time: 上午12:15
 */
public enum Sex implements NameableEnum {
	
	MALE{
        public String getName() {
            return "男";
        }
    },
	FEMALE{
        public String getName() {
            return "女";
        }
    },
	UNKNOWN{
        public String getName() {
            return "未知";
        }
    };
}
