package com.ycnet.dbank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.mirage.context.MirageService;
import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.AgreementCondition;
import com.ycnet.dbank.dto.create.AgreementCreateForm;
import com.ycnet.dbank.dto.details.AgreementDetails;
import com.ycnet.dbank.dto.update.AgreementUpdateForm;
import com.ycnet.dbank.repository.AgreementRepository;
import com.ycnet.dbank.service.AgreementService;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
@MirageService
public class AgreementServiceImpl implements AgreementService {
	
	@Autowired
	private AgreementRepository agreementRepository;

	@Override
	public DomainCreated create(AgreementCreateForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AgreementDetails update(Long id, AgreementUpdateForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AgreementDetails getDetails(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<AgreementDetails> query(AgreementCondition condition, Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}
	
}