package com.ycnet.dbank.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.AgreementCondition;
import com.ycnet.dbank.dto.create.AgreementCreateForm;
import com.ycnet.dbank.dto.details.AgreementDetails;
import com.ycnet.dbank.dto.update.AgreementUpdateForm;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
public interface AgreementService {

	DomainCreated create(AgreementCreateForm form);

	AgreementDetails update(Long id, AgreementUpdateForm form);

	void delete(Long id);

	AgreementDetails getDetails(Long id);

	Page<AgreementDetails> query(AgreementCondition condition, Pageable page);
	
}
