package com.ycnet.dbank.service.impl;

import org.apache.commons.collections.Transformer;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.dbank.domain.AdminRole;
import com.ycnet.dbank.dto.condition.AdminRoleCondition;
import com.ycnet.dbank.dto.create.AdminRoleCreateForm;
import com.ycnet.dbank.dto.details.AdminRoleDetails;
import com.ycnet.dbank.dto.update.AdminRoleUpdateForm;
import com.ycnet.dbank.repository.AdminRoleRepository;
import com.ycnet.dbank.repository.spec.AdminRoleSpec;
import com.ycnet.dbank.service.AdminRoleService;
import com.ycnet.mirage.context.MirageService;
import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.mirage.utils.MirageUtils;

/**
  *
  * @author shine  
  * Date: 2014/04/22 10:20:47
  */
@MirageService
public class AdminRoleServiceImpl implements AdminRoleService {
	
	@Autowired
	private AdminRoleRepository adminRoleRepository;

	@Override
	public DomainCreated create(AdminRoleCreateForm form) {
		AdminRole role = MirageUtils.fromDto(form, AdminRole.class);
		role.setCode(RandomStringUtils.randomNumeric(8));//TODO:临时，需改为DB2 sequence
		role = adminRoleRepository.save(role);
		return new DomainCreated(role.getId());
	}

	@Override
	public AdminRoleDetails update(Long id, AdminRoleUpdateForm form) {
		AdminRole role = adminRoleRepository.findOne(id);
		role.setName(form.getName());
		role.setDesc(form.getDesc());
		role.setRoleType(form.getRoleType());
		return MirageUtils.toDto(AdminRoleDetails.class, role);
	}

	@Override
	public void delete(Long id) {
		adminRoleRepository.delete(id);
	}

	@Override
	public AdminRoleDetails getDetails(Long id) {
		AdminRole role = adminRoleRepository.findOne(id);
		return MirageUtils.toDto(AdminRoleDetails.class,role);
	}

	@Override
	public Page<AdminRoleDetails> query(AdminRoleCondition condition, Pageable page) {
		Page<AdminRole> roles = adminRoleRepository.findAll(new AdminRoleSpec(condition), page);
		
		return MirageUtils.toDto(roles, new Transformer() {

			@Override
			public Object transform(Object input) {
				AdminRole role = (AdminRole) input;
				AdminRoleDetails dto = MirageUtils.toDto(AdminRoleDetails.class, role);
				dto.setRoleType(role.getRoleType().getName());
				return dto;
			}
			
		});
	}
	
}