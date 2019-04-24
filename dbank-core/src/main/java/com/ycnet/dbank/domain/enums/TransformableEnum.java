package com.ycnet.dbank.domain.enums;

/**
 * 用于系统交互时，需要做转换的枚举
 * User: guozp
 * Date: 14-4-20
 * Time: 下午11:49
 */
public interface TransformableEnum {
    /**返回枚举值*/
    public String getTransformValue();
}
