package com.ycnet.dbank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.mirage.context.MirageService;
import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.OptionCondition;
import com.ycnet.dbank.dto.create.OptionCreateForm;
import com.ycnet.dbank.dto.details.OptionDetails;
import com.ycnet.dbank.dto.update.OptionUpdateForm;
import com.ycnet.dbank.repository.OptionRepository;
import com.ycnet.dbank.service.OptionService;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
@MirageService
public class OptionServiceImpl implements OptionService {
	
	@Autowired
	private OptionRepository optionRepository;

	@Override
	public DomainCreated create(OptionCreateForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OptionDetails update(Long id, OptionUpdateForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OptionDetails getDetails(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<OptionDetails> query(OptionCondition condition, Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}
	
}