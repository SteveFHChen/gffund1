package com.ycnet.dbank.dto.common;

/**
 * @author shine
 *
 */
public class AdminRoleDtoBase {
	/**
     * 角色名称
     */
    private String name;
    /**
     * 角色描述
     */
    private String desc;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
