package com.ycnet.dbank.domain.enums;

/**
 * 发布渠道
 * User: guozp
 * Date: 14-5-5
 * Time: 上午12:28
 */
public enum ChannelType implements NameableEnum{
    SITE{
        @Override
        public String getName() {
            return "前台";
        }
    },IM{
        @Override
        public String getName() {
            return "内管";
        }
    };
}
