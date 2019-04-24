package com.ycnet.dbank.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.AccountCondition;
import com.ycnet.dbank.dto.create.AccountCreateForm;
import com.ycnet.dbank.dto.details.AccountDetails;
import com.ycnet.dbank.dto.update.AccountUpdateForm;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
public interface AccountService {

	DomainCreated create(AccountCreateForm form);

	AccountDetails update(Long id, AccountUpdateForm form);

	void delete(Long id);

	AccountDetails getDetails(Long id);

	Page<AccountDetails> query(AccountCondition condition, Pageable page);
	
}
