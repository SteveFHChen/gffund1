package com.ycnet.dbank.repository.spec;

import java.lang.reflect.InvocationTargetException;

import com.ycnet.dbank.domain.Product;
import com.ycnet.dbank.dto.condition.ProductCondition;
import com.ycnet.mirage.repository.spec.support.QueryWraper;

public class ProductSpec extends BaseSpec<Product, ProductCondition> {

	public ProductSpec(ProductCondition condition) {
		super(condition);
	}

	protected void addCondition(QueryWraper<Product> queryWraper)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		addEqualsCondition(queryWraper,"riskLevel");
		addEqualsCondition(queryWraper, "breakevenState");
		//addBetweenCondition(queryWraper, queryWraper.getRoot(), minValue, maxValue)
	}

	
}
