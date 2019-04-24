package com.ycnet.dbank.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.PersonCondition;
import com.ycnet.dbank.dto.create.PersonCreateForm;
import com.ycnet.dbank.dto.details.PersonDetails;
import com.ycnet.dbank.dto.update.PersonUpdateForm;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
public interface PersonService {

	DomainCreated create(PersonCreateForm form);

	PersonDetails update(Long id, PersonUpdateForm form);

	void delete(Long id);

	PersonDetails getDetails(Long id);
	
	String modPassword(Long id, PersonUpdateForm form);

	Page<PersonDetails> query(PersonCondition condition, Pageable page);
	
}
