package com.ycnet.dbank.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.DictionaryCondition;
import com.ycnet.dbank.dto.create.DictionaryCreateForm;
import com.ycnet.dbank.dto.details.DictionaryDetails;
import com.ycnet.dbank.dto.update.DictionaryUpdateForm;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
public interface DictionaryService {

	DomainCreated create(DictionaryCreateForm form);

	DictionaryDetails update(Long id, DictionaryUpdateForm form);

	void delete(Long id);

	DictionaryDetails getDetails(Long id);

	Page<DictionaryDetails> query(DictionaryCondition condition, Pageable page);
	
}
