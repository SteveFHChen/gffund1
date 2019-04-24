package com.ycnet.dbank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.mirage.context.MirageService;
import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.LogCondition;
import com.ycnet.dbank.dto.create.LogCreateForm;
import com.ycnet.dbank.dto.details.LogDetails;
import com.ycnet.dbank.dto.update.LogUpdateForm;
import com.ycnet.dbank.repository.LogRepository;
import com.ycnet.dbank.service.LogService;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
@MirageService
public class LogServiceImpl implements LogService {
	
	@Autowired
	private LogRepository logRepository;

	@Override
	public DomainCreated create(LogCreateForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LogDetails update(Long id, LogUpdateForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LogDetails getDetails(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<LogDetails> query(LogCondition condition, Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}
	
}