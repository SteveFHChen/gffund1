package com.ycnet.dbank.dto.create;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.ycnet.dbank.domain.enums.RoleType;
import com.ycnet.dbank.dto.common.AdminRoleDtoBase;

/**
  *
  * @author shine  
  * Date: 2014/04/22 10:20:47
  */
public class AdminRoleCreateForm extends AdminRoleDtoBase{
	/**角色类型*/
    @Enumerated(EnumType.STRING)
    private RoleType roleType = RoleType.ZH;

	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}
    
}
