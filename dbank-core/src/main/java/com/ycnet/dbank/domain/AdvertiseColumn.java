package com.ycnet.dbank.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import com.ycnet.dbank.domain.enums.AdState;
import com.ycnet.mirage.domain.DomainImpl;

/**
 * 广告栏管理 
 * User: zhanghuan 
 * Date: 14-5-8 
 * Time: 上午12:19
 */
@Entity
public class AdvertiseColumn extends DomainImpl {

	private static final long serialVersionUID = -8409487325329629593L;
	/** 广告栏名称 */
	private String name;
	/** 广告栏描述 */
	private String desc;
	/** 广告栏状态 */
	@Enumerated(EnumType.STRING)
	private AdState state;
	/** 广告栏轮询时间 */
	private int polling;
 	/**广告列表*/
	@OneToMany(mappedBy = "adColumn")
	private List<Advertise> advertises = new ArrayList<Advertise>();

	public String getName() {
		return name;
	}

	public int getPolling() {
		return polling;
	}

	public AdState getState() {
		return state;
	}

	public String getDesc() {
		return desc;
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

	public List<Advertise> getAdvertises() {
		return advertises;
	}

	public void setAdvertises(List<Advertise> advertises) {
		this.advertises = advertises;
	}
	
	
}
