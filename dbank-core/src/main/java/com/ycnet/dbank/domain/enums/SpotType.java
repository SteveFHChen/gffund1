package com.ycnet.dbank.domain.enums;

/**
 * 首页配置区域类型
 * User: guozp
 * Date: 14-4-22
 * Time: 下午12:58
 */
public enum SpotType implements NameableEnum {
    AD{
        @Override
        public String getName() {
            return "广告";
        }
    },
    HOT{
        @Override
        public String getName() {
            return "热销产品";
        }
    },
    LATEST{
        @Override
        public String getName() {
            return "最新产品"; //最新上市
        }
    };
}
