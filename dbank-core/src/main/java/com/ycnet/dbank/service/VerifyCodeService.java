package com.ycnet.dbank.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.VerifyCodeCondition;
import com.ycnet.dbank.dto.create.VerifyCodeCreateForm;
import com.ycnet.dbank.dto.details.VerifyCodeDetails;
import com.ycnet.dbank.dto.update.VerifyCodeUpdateForm;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
public interface VerifyCodeService {

	DomainCreated create(VerifyCodeCreateForm form);

	VerifyCodeDetails update(Long id, VerifyCodeUpdateForm form);

	void delete(Long id);

	VerifyCodeDetails getDetails(Long id);

	Page<VerifyCodeDetails> query(VerifyCodeCondition condition, Pageable page);
	
}
