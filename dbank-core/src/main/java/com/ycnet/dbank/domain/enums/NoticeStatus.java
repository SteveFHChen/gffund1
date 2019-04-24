package com.ycnet.dbank.domain.enums;

/**
 * 发布渠道 
 * User: Chenxh
 * Date: 14-5-5
 * Time: 上午12:28
 */
public enum NoticeStatus implements NameableEnum{
	PUBLISHED{
        @Override
        public String getName() {
            return "已发布";
        }
    },OVERDUE{
        @Override
        public String getName() {
            return "已过期";
        }
    },CANCEL{
    	@Override
        public String getName() {
            return "已撤销";
        }
    };
}
