package com.ycnet.dbank.service.impl;

import com.ycnet.dbank.domain.Admin;
import com.ycnet.dbank.dto.condition.AdminCondition;
import com.ycnet.dbank.dto.details.AdminDetails;
import com.ycnet.dbank.repository.AdminRepository;
import com.ycnet.dbank.repository.spec.AdminSpec;
import com.ycnet.dbank.service.AdminService;
import com.ycnet.mirage.context.MirageService;
import org.apache.commons.collections.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static com.ycnet.mirage.utils.MirageUtils.toDto;

/**
  * 内管用户服务
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
@MirageService
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public AdminDetails getDetails(Long id) {
        Admin admin = adminRepository.findOne(id);
        AdminDetails detail = toDto(AdminDetails.class, admin);
        detail.setRoleId(admin.getAdminRole().getId());
		return detail;
	}

	@Override
	public Page<AdminDetails> query(AdminCondition condition, Pageable page) {
        Page<Admin> admins = adminRepository.findAll(new AdminSpec(condition), page);
        return toDto(admins, new Transformer() {

            public Object transform(Object input) {
                Admin admin =  (Admin) input;
                AdminDetails details = toDto(AdminDetails.class,admin);
                details.setAdminId(admin.getId());
                details.setRoleName(admin.getAdminRole().getName());
                return details;
            }
        });
	}
	
}