package com.ycnet.dbank.repository.spec;

import java.util.Collection;

import javax.persistence.criteria.Path;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

import com.ycnet.mirage.repository.spec.MirageSimpleSpecification;
import com.ycnet.mirage.repository.spec.support.QueryWraper;

/**
 * specification基类
 * User: guozp
 * Date: 14-4-9
 * Time: 下午5:26
 */
public abstract class BaseSpec<T,C> extends MirageSimpleSpecification<T,C> {

    /**
     * @param condition 查询条件
     */
    public BaseSpec(C condition) {
        super(condition);
    }


    /**
     * 添加in条件
     *
     * @param queryWrapper
     * @param values
     */
    protected void addInCondition(QueryWraper<T> queryWrapper, String path, Object... values) {
        if (ArrayUtils.isNotEmpty(values)) {
            queryWrapper.addPredicate(queryWrapper.getRoot().get(path).in(values));
        }
    }

    /**
     * 添加in条件
     *
     * @param queryWrapper
     * @param values
     */
    protected void addInCondition(QueryWraper<T> queryWrapper, String path, Collection<?> values) {
        if (CollectionUtils.isNotEmpty(values)) {
            queryWrapper.addPredicate(queryWrapper.getRoot().get(path).in(values));
        }
    }

    /**
     * 添加in条件
     *
     * @param queryWrapper
     * @param expression
     * @param values
     */
    protected void addInCondition(QueryWraper<T> queryWrapper, Path<?> expression, Collection<?> values) {
        if (CollectionUtils.isNotEmpty(values)) {
            queryWrapper.addPredicate(expression.in(values));
        }
    }

    /**
     * 添加in条件
     *
     * @param queryWrapper
     * @param expression
     * @param values
     */
    protected void addInCondition(QueryWraper<T> queryWrapper, Path<?> expression, Object... values) {
        if(ArrayUtils.isNotEmpty(values)){
            queryWrapper.addPredicate(expression.in(values));
        }
    }



    /**
     * 添加between条件查询
     * @param queryWraper
     * @param experssion
     * @param minValue  范围下限
     * @param maxValue  范围上限
     */
    protected void addBetweenCondition(QueryWraper<T> queryWraper, Path experssion, Comparable minValue, Comparable maxValue) {
        if (minValue != null && maxValue != null) {
            queryWraper.addPredicate(queryWraper.getCb().between(experssion, minValue, maxValue));
        }
    }

    /**
     * 添加greaterThan条件查询
     * @param queryWraper
     * @param experssion
     * @param minValue
     */
    protected void addGreaterThanCondition(QueryWraper<T> queryWraper, Path experssion,  Comparable minValue) {
        if (minValue != null) {
            queryWraper.addPredicate(queryWraper.getCb().greaterThan(experssion, minValue));
        }
    }

    /**
     * 添加>=条件查询
     * @param queryWraper
     * @param experssion
     * @param minValue
     */
    protected void addGreaterThanOrEqualToCondition(QueryWraper<T> queryWraper, Path experssion,  Comparable minValue) {
        if (minValue != null) {
            queryWraper.addPredicate(queryWraper.getCb().greaterThanOrEqualTo(experssion, minValue));
        }
    }

    /**
     * 添加greaterThan条件查询
     * @param queryWraper
     * @param experssion
     * @param maxValue
     */
    protected void addLessThanCondition(QueryWraper<T> queryWraper, Path experssion,  Comparable maxValue) {
        if (maxValue != null) {
            queryWraper.addPredicate(queryWraper.getCb().lessThan(experssion, maxValue));
        }
    }

    /**
     * 添加<=条件查询
     * @param queryWraper
     * @param experssion
     * @param maxValue
     */
    protected void addLessThanOrEqualToCondition(QueryWraper<T> queryWraper, Path experssion,  Comparable maxValue) {
        if (maxValue != null) {
            queryWraper.addPredicate(queryWraper.getCb().lessThanOrEqualTo(experssion, maxValue));
        }
    }


}
