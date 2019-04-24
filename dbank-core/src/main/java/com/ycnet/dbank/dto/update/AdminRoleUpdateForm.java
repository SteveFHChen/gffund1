package com.ycnet.dbank.dto.update;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.ycnet.dbank.domain.enums.RoleType;
import com.ycnet.dbank.dto.common.AdminRoleDtoBase;

/**
  *
  * @author shine  
  * Date: 2014/04/22 10:20:47
  */
public class AdminRoleUpdateForm extends AdminRoleDtoBase{

	/**角色类型*/
    @Enumerated(EnumType.STRING)
    private RoleType roleType = RoleType.ZH;
    private String code;
    
    public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}
    
}
