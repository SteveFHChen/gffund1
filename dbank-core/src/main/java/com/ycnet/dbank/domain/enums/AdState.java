package com.ycnet.dbank.domain.enums;

/**
 * 广告栏状态
 * User: zhanghuan
 * Date: 14-5-09
 * Time: 下午8:51
 */
public enum AdState implements NameableEnum {
    OPEN {
        @Override
        public String getName() {
            return "开放中";
        }
    },
    CLOSE{
        @Override
        public String getName() {
            return "关闭";
        }
    };
}
