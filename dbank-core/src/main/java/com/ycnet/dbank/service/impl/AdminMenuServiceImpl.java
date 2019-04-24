package com.ycnet.dbank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.mirage.context.MirageService;
import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.AdminMenuCondition;
import com.ycnet.dbank.dto.create.AdminMenuCreateForm;
import com.ycnet.dbank.dto.details.AdminMenuDetails;
import com.ycnet.dbank.dto.update.AdminMenuUpdateForm;
import com.ycnet.dbank.repository.AdminMenuRepository;
import com.ycnet.dbank.service.AdminMenuService;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
@MirageService
public class AdminMenuServiceImpl implements AdminMenuService {
	
	@Autowired
	private AdminMenuRepository adminMenuRepository;

	@Override
	public DomainCreated create(AdminMenuCreateForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminMenuDetails update(Long id, AdminMenuUpdateForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AdminMenuDetails getDetails(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<AdminMenuDetails> query(AdminMenuCondition condition, Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}
	
}