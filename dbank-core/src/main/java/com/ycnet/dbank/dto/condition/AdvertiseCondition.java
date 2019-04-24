package com.ycnet.dbank.dto.condition;

import com.ycnet.dbank.domain.enums.AdState;

public class AdvertiseCondition {
	/**广告ID*/
	private Long adId;
	/**广告位ID*/
	private Long adColumnId;
	/**广告名称*/
	private String name;
	/**广告状态*/
	private AdState status;
	
	public Long getAdId() {
		return adId;
	}
	public void setAdId(Long adId) {
		this.adId = adId;
	}
	public Long getAdColumnId() {
		return adColumnId;
	}
	public void setAdColumnId(Long adColumnId) {
		this.adColumnId = adColumnId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AdState getStatus() {
		return status;
	}
	public void setStatus(AdState status) {
		this.status = status;
	}
	
}
