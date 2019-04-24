package com.ycnet.dbank.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.RoleMenuCondition;
import com.ycnet.dbank.dto.create.RoleMenuCreateForm;
import com.ycnet.dbank.dto.details.RoleMenuDetails;
import com.ycnet.dbank.dto.update.RoleMenuUpdateForm;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
public interface RoleMenuService {

	DomainCreated create(RoleMenuCreateForm form);

	RoleMenuDetails update(Long id, RoleMenuUpdateForm form);

	void delete(Long id);

	RoleMenuDetails getDetails(Long id);

	Page<RoleMenuDetails> query(RoleMenuCondition condition, Pageable page);
	
}
