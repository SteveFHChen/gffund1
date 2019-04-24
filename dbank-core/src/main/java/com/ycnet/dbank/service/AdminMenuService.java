package com.ycnet.dbank.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.AdminMenuCondition;
import com.ycnet.dbank.dto.create.AdminMenuCreateForm;
import com.ycnet.dbank.dto.details.AdminMenuDetails;
import com.ycnet.dbank.dto.update.AdminMenuUpdateForm;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
public interface AdminMenuService {

	DomainCreated create(AdminMenuCreateForm form);

	AdminMenuDetails update(Long id, AdminMenuUpdateForm form);

	void delete(Long id);

	AdminMenuDetails getDetails(Long id);

	Page<AdminMenuDetails> query(AdminMenuCondition condition, Pageable page);
	
}
