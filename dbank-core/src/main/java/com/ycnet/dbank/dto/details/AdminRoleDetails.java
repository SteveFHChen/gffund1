package com.ycnet.dbank.dto.details;

import com.ycnet.dbank.dto.common.AdminRoleDtoBase;

/**
  *
  * @author shine  
  * Date: 2014/04/22 10:20:47
  */
public class AdminRoleDetails extends AdminRoleDtoBase{
	private Long id;
	/**
     * 角色编号
     */
    private String code;
    /**角色类型*/
    private String roleType ;

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	
    public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
