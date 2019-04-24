package com.ycnet.dbank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.mirage.context.MirageService;
import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.RechargeCondition;
import com.ycnet.dbank.dto.create.RechargeCreateForm;
import com.ycnet.dbank.dto.details.RechargeDetails;
import com.ycnet.dbank.dto.update.RechargeUpdateForm;
import com.ycnet.dbank.repository.RechargeRepository;
import com.ycnet.dbank.service.RechargeService;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
@MirageService
public class RechargeServiceImpl implements RechargeService {
	
	@Autowired
	private RechargeRepository rechargeRepository;

	@Override
	public DomainCreated create(RechargeCreateForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RechargeDetails update(Long id, RechargeUpdateForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RechargeDetails getDetails(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<RechargeDetails> query(RechargeCondition condition, Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}
	
}