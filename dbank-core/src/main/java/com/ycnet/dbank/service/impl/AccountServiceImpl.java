package com.ycnet.dbank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.mirage.context.MirageService;
import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.AccountCondition;
import com.ycnet.dbank.dto.create.AccountCreateForm;
import com.ycnet.dbank.dto.details.AccountDetails;
import com.ycnet.dbank.dto.update.AccountUpdateForm;
import com.ycnet.dbank.repository.AccountRepository;
import com.ycnet.dbank.service.AccountService;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
@MirageService
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public DomainCreated create(AccountCreateForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountDetails update(Long id, AccountUpdateForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AccountDetails getDetails(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<AccountDetails> query(AccountCondition condition, Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}
	
}