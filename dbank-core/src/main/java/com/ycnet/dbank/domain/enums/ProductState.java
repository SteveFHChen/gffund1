package com.ycnet.dbank.domain.enums;

/**
 * 产品状态
 * User: guozp
 * Date: 14-4-21
 * Time: 上午12:01
 */
public enum ProductState implements NameableEnum {
    INIT{
        @Override
        public String getName() {
            return "初始状态";  //从理财系统同步过来时的状态
        }
    },
    IN_WAREHOUSE{
        @Override
        public String getName() {
            return "仓库中";
        }
    },
    WAIT_OPEN{
        @Override
        public String getName() {
            return "尚未开放购买";
        }
    },
    WAIT_SALE{
        @Override
        public String getName() {
            return "即将销售";
        }
    },
    ON_SALE{
        @Override
        public String getName() {
            return "正在销售"; //开始挣钱
        }
    },
    OUT_SALE{
        @Override
        public String getName() {
            return "售罄";
        }
    },
    DOWN {
        @Override
        public String getName() {
            return "下架";
        }
    };
}
