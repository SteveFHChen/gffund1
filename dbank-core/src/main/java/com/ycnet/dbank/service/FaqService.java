package com.ycnet.dbank.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.FaqCondition;
import com.ycnet.dbank.dto.create.FaqCreateForm;
import com.ycnet.dbank.dto.details.FaqDetails;
import com.ycnet.dbank.dto.update.FaqUpdateForm;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
public interface FaqService {

	DomainCreated create(FaqCreateForm form);

	FaqDetails update(Long id, FaqUpdateForm form);

	void delete(Long id);

	FaqDetails getDetails(Long id);

	Page<FaqDetails> query(FaqCondition condition, Pageable page);
	
//	Page<FaqDetails> queryByCondition(FaqCondition condition, Pageable page);
	
}
