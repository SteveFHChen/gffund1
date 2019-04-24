package com.ycnet.dbank.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.RechargeCondition;
import com.ycnet.dbank.dto.create.RechargeCreateForm;
import com.ycnet.dbank.dto.details.RechargeDetails;
import com.ycnet.dbank.dto.update.RechargeUpdateForm;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
public interface RechargeService {

	DomainCreated create(RechargeCreateForm form);

	RechargeDetails update(Long id, RechargeUpdateForm form);

	void delete(Long id);

	RechargeDetails getDetails(Long id);

	Page<RechargeDetails> query(RechargeCondition condition, Pageable page);
	
}
