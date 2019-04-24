package com.ycnet.dbank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.mirage.context.MirageService;
import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.CertificationCondition;
import com.ycnet.dbank.dto.create.CertificationCreateForm;
import com.ycnet.dbank.dto.details.CertificationDetails;
import com.ycnet.dbank.dto.update.CertificationUpdateForm;
import com.ycnet.dbank.repository.CertificationRepository;
import com.ycnet.dbank.service.CertificationService;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
@MirageService
public class CertificationServiceImpl implements CertificationService {
	
	@Autowired
	private CertificationRepository certificationRepository;

	@Override
	public DomainCreated create(CertificationCreateForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CertificationDetails update(Long id, CertificationUpdateForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CertificationDetails getDetails(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<CertificationDetails> query(CertificationCondition condition, Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}
	
}