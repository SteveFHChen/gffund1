package com.ycnet.dbank.repository.spec;

import java.lang.reflect.InvocationTargetException;

import com.ycnet.dbank.domain.Question;
import com.ycnet.dbank.dto.condition.QuestionCondition;
import com.ycnet.mirage.repository.spec.support.QueryWraper;

/**
 * 问题查询specification
 * User: guozp
 * Date: 14-4-22
 * Time: 下午5:47
 */
public class QuestionSpec extends BaseSpec<Question, QuestionCondition> {

	public QuestionSpec(QuestionCondition condition) {
		super(condition);
	}
	
	@Override
	protected void addCondition(QueryWraper<Question> queryWraper)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {

        addLikeCondition(queryWraper, "keyword", "title");

//        CriteriaBuilder cb = queryWraper.getCb();
//        Root<Question> root = queryWraper.getRoot();
//        Path<String> title = root.get("title");
//        Path<String> content = root.get("content");
//        List<Predicate> predicates = queryWraper.getPredicates();
//        String keyword = condition.getKeyword();
//        if(StringUtils.isNotBlank(keyword)){
//            predicates.add(
//                    cb.or(
//                            cb.like(title, "%" + keyword + "%"),
//                            cb.like(content, "%" + keyword + "%")
//                    )
//            );
//        }

	}

}
