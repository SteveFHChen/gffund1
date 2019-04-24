package com.ycnet.dbank.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.WithdrawCondition;
import com.ycnet.dbank.dto.create.WithdrawCreateForm;
import com.ycnet.dbank.dto.details.WithdrawDetails;
import com.ycnet.dbank.dto.update.WithdrawUpdateForm;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
public interface WithdrawService {

	DomainCreated create(WithdrawCreateForm form);

	WithdrawDetails update(Long id, WithdrawUpdateForm form);

	void delete(Long id);

	WithdrawDetails getDetails(Long id);

	Page<WithdrawDetails> query(WithdrawCondition condition, Pageable page);
	
}
