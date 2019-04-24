package com.ycnet.dbank.domain.enums;

import org.apache.commons.lang.ArrayUtils;

import java.util.Map;

/**
 * 理财产品风险等级
 * User: guozp
 * Date: 14-4-20
 * Time: 下午6:38
 */
public enum RiskLevel implements JsonableEnum {
    PR1{
        @Override
        public String getName() {
            return "谨慎型";
        }
    },
    PR2{
        @Override
        public String getName() {
            return "稳健型";
        }
    },
    PR3{
        @Override
        public String getName() {
            return "平衡型";
        }
    },
    PR4{
        @Override
        public String getName() {
            return "进取型";
        }
    },
    PR5{
        @Override
        public String getName() {
            return "激进型";
        }
    },
    UNKNOWN{
        @Override
        public String getName() {
            return "未知";
        }
    };

    @SuppressWarnings("unchecked")
	@Override
    public Map<String, Object> toJsonObj() {
        return ArrayUtils.toMap(new Object[][]{{"name", getName()}, {"value", toString()}});
    }

    public static void main(String[] args) {
        System.out.println(RiskLevel.PR1.toJsonObj());
    }
}
