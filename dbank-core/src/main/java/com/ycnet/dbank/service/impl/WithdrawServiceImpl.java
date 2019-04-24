package com.ycnet.dbank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.mirage.context.MirageService;
import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.WithdrawCondition;
import com.ycnet.dbank.dto.create.WithdrawCreateForm;
import com.ycnet.dbank.dto.details.WithdrawDetails;
import com.ycnet.dbank.dto.update.WithdrawUpdateForm;
import com.ycnet.dbank.repository.WithdrawRepository;
import com.ycnet.dbank.service.WithdrawService;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
@MirageService
public class WithdrawServiceImpl implements WithdrawService {
	
	@Autowired
	private WithdrawRepository withdrawRepository;

	@Override
	public DomainCreated create(WithdrawCreateForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WithdrawDetails update(Long id, WithdrawUpdateForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public WithdrawDetails getDetails(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<WithdrawDetails> query(WithdrawCondition condition, Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}
	
}