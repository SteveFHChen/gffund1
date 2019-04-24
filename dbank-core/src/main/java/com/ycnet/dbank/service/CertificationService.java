package com.ycnet.dbank.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.CertificationCondition;
import com.ycnet.dbank.dto.create.CertificationCreateForm;
import com.ycnet.dbank.dto.details.CertificationDetails;
import com.ycnet.dbank.dto.update.CertificationUpdateForm;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
public interface CertificationService {

	DomainCreated create(CertificationCreateForm form);

	CertificationDetails update(Long id, CertificationUpdateForm form);

	void delete(Long id);

	CertificationDetails getDetails(Long id);

	Page<CertificationDetails> query(CertificationCondition condition, Pageable page);
	
}
