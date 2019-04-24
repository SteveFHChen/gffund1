package com.ycnet.dbank.dto.condition;


import com.ycnet.dbank.domain.enums.AdState;

/**
 * 
 * @author zhanghuan Date: 2014/05/12 10:20:47
 */
public class AdvertiseColumnCondition {

	/** 广告栏ID */
	private Long id;
	/** 广告栏名称 */
	private String name;
	/** 广告栏状态 */
	private AdState state;

	public AdvertiseColumnCondition()
	{
		
	}
	
	public AdvertiseColumnCondition(Long id, String name, AdState state)
	{
		this.id = id;
		this.name = name;
		this.state = state;
	}

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

	public AdState getState() {
		return state;
	}

	public void setState(AdState state) {
		this.state = state;
	}
}
