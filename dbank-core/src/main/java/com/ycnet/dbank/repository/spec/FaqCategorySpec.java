package com.ycnet.dbank.repository.spec;

import java.lang.reflect.InvocationTargetException;

import com.ycnet.dbank.domain.FaqCategory;
import com.ycnet.dbank.dto.condition.FaqCategoryCondition;
import com.ycnet.mirage.repository.spec.support.QueryWraper;

/**
 * @author shine
 *
 */
public class FaqCategorySpec  extends BaseSpec<FaqCategory, FaqCategoryCondition>{

	public FaqCategorySpec(FaqCategoryCondition condition) {
		super(condition);
	}

	@Override
	protected void addCondition(QueryWraper<FaqCategory> queryWraper)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		addLikeCondition(queryWraper, "categoryName");
	}

}
