package com.ycnet.dbank.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.LogCondition;
import com.ycnet.dbank.dto.create.LogCreateForm;
import com.ycnet.dbank.dto.details.LogDetails;
import com.ycnet.dbank.dto.update.LogUpdateForm;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
public interface LogService {

	DomainCreated create(LogCreateForm form);

	LogDetails update(Long id, LogUpdateForm form);

	void delete(Long id);

	LogDetails getDetails(Long id);

	Page<LogDetails> query(LogCondition condition, Pageable page);
	
}
