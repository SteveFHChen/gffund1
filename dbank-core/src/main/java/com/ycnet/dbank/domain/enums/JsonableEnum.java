package com.ycnet.dbank.domain.enums;

import java.util.Map;

/**
 * 用于返回Enum中多字段的情况，如value，name等
 * User: guozp
 * Date: 14-4-20
 * Time: 下午6:41
 */
public interface JsonableEnum extends NameableEnum {

    public Map<String, Object> toJsonObj();
}
