package com.ycnet.dbank.dto.condition;

import com.ycnet.dbank.dto.common.AdminRoleDtoBase;


/**
  *
  * @author shine  
  * Date: 2014/04/22 10:20:47
  */
public class AdminRoleCondition extends AdminRoleDtoBase{
	/**
     * 角色编号
     */
    private String code;
    
    public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
