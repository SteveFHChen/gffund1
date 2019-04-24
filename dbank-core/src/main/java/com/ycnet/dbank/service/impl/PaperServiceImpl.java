package com.ycnet.dbank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.mirage.context.MirageService;
import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.PaperCondition;
import com.ycnet.dbank.dto.create.PaperCreateForm;
import com.ycnet.dbank.dto.details.PaperDetails;
import com.ycnet.dbank.dto.update.PaperUpdateForm;
import com.ycnet.dbank.repository.PaperRepository;
import com.ycnet.dbank.service.PaperService;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
@MirageService
public class PaperServiceImpl implements PaperService {
	
	@Autowired
	private PaperRepository paperRepository;

	@Override
	public DomainCreated create(PaperCreateForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaperDetails update(Long id, PaperUpdateForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PaperDetails getDetails(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<PaperDetails> query(PaperCondition condition, Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}
	
}