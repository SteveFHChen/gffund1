package com.ycnet.dbank.service.impl;

import org.apache.commons.collections.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.dbank.domain.Question;
import com.ycnet.dbank.dto.condition.QuestionCondition;
import com.ycnet.dbank.dto.create.QuestionCreateForm;
import com.ycnet.dbank.dto.details.QuestionDetails;
import com.ycnet.dbank.dto.update.QuestionUpdateForm;
import com.ycnet.dbank.repository.QuestionRepository;
import com.ycnet.dbank.repository.spec.QuestionSpec;
import com.ycnet.dbank.service.QuestionService;
import com.ycnet.mirage.context.MirageService;
import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.mirage.utils.MirageUtils;

@MirageService
public class QuestionServiceImp implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Override
	public Page<QuestionDetails> query(QuestionCondition condition,
			Pageable page) {
		Page<Question> rst = questionRepository.findAll(new QuestionSpec(condition), page);
		return MirageUtils.toDto(rst, new Transformer(){
			@Override
			public Object transform(Object input){
				QuestionDetails qd = MirageUtils.toDto(QuestionDetails.class, (Question)input);
				return qd;
			}
		});
	}

	@Override
	public QuestionDetails getDetails(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DomainCreated create(QuestionCreateForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuestionDetails update(Long id, QuestionUpdateForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
