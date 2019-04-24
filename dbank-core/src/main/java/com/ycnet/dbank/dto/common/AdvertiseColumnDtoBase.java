package com.ycnet.dbank.dto.common;


/**
 * 广告栏管理 
 * User: zhanghuan 
 * Date: 14-5-12 Time: 上午12:19
 */

public class AdvertiseColumnDtoBase{

	/** 广告栏ID */
	private Long id;
	/** 广告栏名称 */
	private String name;
	/** 广告栏状态 */
	private String state;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
