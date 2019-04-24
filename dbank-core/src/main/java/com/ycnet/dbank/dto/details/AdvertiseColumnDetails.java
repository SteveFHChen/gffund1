package com.ycnet.dbank.dto.details;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.ycnet.dbank.domain.enums.AdState;

/**
  *
  * @author zhanghuan  
  * Date: 2014/05/12 10:20:47
  */
public class AdvertiseColumnDetails {

	/** 广告栏名称 */
	private String name;
	/** 广告栏描述 */
	private String desc;
	/** 广告栏状态 */
	@Enumerated(EnumType.STRING)
	private AdState state;
	/** 广告栏轮询时间 */
	private int polling;
	
	public String getDesc() {
		return desc;
	}
	public String getName() {
		return name;
	}
	public int getPolling() {
		return polling;
	}
	public AdState getState() {
		return state;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPolling(int polling) {
		this.polling = polling;
	}
	public void setState(AdState state) {
		this.state = state;
	}
}
