package com.ycnet.dbank.repository.spec;

import java.lang.reflect.InvocationTargetException;

import com.ycnet.dbank.domain.Faq;
import com.ycnet.dbank.dto.condition.FaqCondition;
import com.ycnet.mirage.repository.spec.support.QueryWraper;

public class FaqSpec extends BaseSpec<Faq, FaqCondition> {

	public FaqSpec(FaqCondition condition) {
		super(condition);
	}

	/**
	 * FAQ查询条件拼接
	 * 
	 */
	@Override
	protected void addCondition(QueryWraper<Faq> queryWraper)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		
		addEqualsCondition(queryWraper,"faqCategoryId","category.id");
		addLikeCondition(queryWraper, "question");
			
		}

}
