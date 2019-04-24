package com.ycnet.dbank.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.AdminRoleCondition;
import com.ycnet.dbank.dto.create.AdminRoleCreateForm;
import com.ycnet.dbank.dto.details.AdminRoleDetails;
import com.ycnet.dbank.dto.update.AdminRoleUpdateForm;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
public interface AdminRoleService {

	DomainCreated create(AdminRoleCreateForm form);

	AdminRoleDetails update(Long id, AdminRoleUpdateForm form);

	void delete(Long id);

	AdminRoleDetails getDetails(Long id);

	Page<AdminRoleDetails> query(AdminRoleCondition condition, Pageable page);
	
}
