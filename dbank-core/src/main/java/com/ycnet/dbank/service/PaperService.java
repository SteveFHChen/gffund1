package com.ycnet.dbank.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.PaperCondition;
import com.ycnet.dbank.dto.create.PaperCreateForm;
import com.ycnet.dbank.dto.details.PaperDetails;
import com.ycnet.dbank.dto.update.PaperUpdateForm;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
public interface PaperService {

	DomainCreated create(PaperCreateForm form);

	PaperDetails update(Long id, PaperUpdateForm form);

	void delete(Long id);

	PaperDetails getDetails(Long id);

	Page<PaperDetails> query(PaperCondition condition, Pageable page);
	
}
