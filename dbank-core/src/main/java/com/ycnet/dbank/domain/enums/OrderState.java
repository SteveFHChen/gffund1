package com.ycnet.dbank.domain.enums;

/**
 * 购买理财订单状态
 * User: guozp
 * Date: 14-4-20
 * Time: 下午10:23
 */
public enum OrderState implements NameableEnum {
    UNPAID{
        @Override
        public String getName() {
            return "等待付款";
        }
    },
    PAID{
        @Override
        public String getName() {
            return "已付款";
        }
    },
    REFUND{
        @Override
        public String getName() {
            return "退款";
        }
    },
    VALUED{
        @Override
        public String getName() {
            return "开始起息";
        }
    },
    SETTLED{
        @Override
        public String getName() {
            return "已结息";
        }
    },
    CANCEL{
        @Override
        public String getName() {
            return "已取消";
        }
    };


}
