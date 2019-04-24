package com.ycnet.dbank.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.OptionCondition;
import com.ycnet.dbank.dto.create.OptionCreateForm;
import com.ycnet.dbank.dto.details.OptionDetails;
import com.ycnet.dbank.dto.update.OptionUpdateForm;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
public interface OptionService {

	DomainCreated create(OptionCreateForm form);

	OptionDetails update(Long id, OptionUpdateForm form);

	void delete(Long id);

	OptionDetails getDetails(Long id);

	Page<OptionDetails> query(OptionCondition condition, Pageable page);
	
}
