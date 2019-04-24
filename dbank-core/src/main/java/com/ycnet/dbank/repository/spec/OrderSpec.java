package com.ycnet.dbank.repository.spec;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.persistence.criteria.Path;

import org.joda.time.format.DateTimeFormat;

import com.ycnet.dbank.domain.Order;
import com.ycnet.dbank.dto.condition.OrderCondition;
import com.ycnet.mirage.repository.spec.support.QueryWraper;

/**
 * 订单查询specification
 * User: guozp
 * Date: 14-4-22
 * Time: 下午5:47
 */
public class OrderSpec extends BaseSpec<Order,OrderCondition> {
    /**
     * @param condition 查询条件
     */
	private OrderCondition condition;
	
    public OrderSpec(OrderCondition condition) {
        super(condition);
        this.condition = condition;
    }

    @Override
    protected void addCondition(QueryWraper<Order> queryWrapper) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    	addEqualsCondition(queryWrapper, "orderNo", "orderNo");
    	
    	Path<Order> path = queryWrapper.getRoot().get("createTime");
    	Date startDate = DateTimeFormat.forPattern("yyyy-mm-dd").parseDateTime(this.condition.getStartDate()).toDate();
    	Date endDate = DateTimeFormat.forPattern("yyyy-mm-dd").parseDateTime(this.condition.getEndDate()).toDate();
    	this.addGreaterThanOrEqualToCondition(queryWrapper, path, startDate);
    	this.addLessThanOrEqualToCondition(queryWrapper, path, endDate);
    	
    	this.addEqualsCondition(queryWrapper, "phone", "person.phone");
    }
}
