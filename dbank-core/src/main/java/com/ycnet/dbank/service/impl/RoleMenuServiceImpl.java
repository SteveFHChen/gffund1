package com.ycnet.dbank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.mirage.context.MirageService;
import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.RoleMenuCondition;
import com.ycnet.dbank.dto.create.RoleMenuCreateForm;
import com.ycnet.dbank.dto.details.RoleMenuDetails;
import com.ycnet.dbank.dto.update.RoleMenuUpdateForm;
import com.ycnet.dbank.repository.RoleMenuRepository;
import com.ycnet.dbank.service.RoleMenuService;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
@MirageService
public class RoleMenuServiceImpl implements RoleMenuService {
	
	@Autowired
	private RoleMenuRepository roleMenuRepository;

	@Override
	public DomainCreated create(RoleMenuCreateForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoleMenuDetails update(Long id, RoleMenuUpdateForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RoleMenuDetails getDetails(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<RoleMenuDetails> query(RoleMenuCondition condition, Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}
	
}