package com.ycnet.dbank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.mirage.context.MirageService;
import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.VerifyCodeCondition;
import com.ycnet.dbank.dto.create.VerifyCodeCreateForm;
import com.ycnet.dbank.dto.details.VerifyCodeDetails;
import com.ycnet.dbank.dto.update.VerifyCodeUpdateForm;
import com.ycnet.dbank.repository.VerifyCodeRepository;
import com.ycnet.dbank.service.VerifyCodeService;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
@MirageService
public class VerifyCodeServiceImpl implements VerifyCodeService {
	
	@Autowired
	private VerifyCodeRepository verifyCodeRepository;

	@Override
	public DomainCreated create(VerifyCodeCreateForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VerifyCodeDetails update(Long id, VerifyCodeUpdateForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public VerifyCodeDetails getDetails(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<VerifyCodeDetails> query(VerifyCodeCondition condition, Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}
	
}