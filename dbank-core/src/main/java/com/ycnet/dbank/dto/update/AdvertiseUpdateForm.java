package com.ycnet.dbank.dto.update;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.hibernate.validator.constraints.NotBlank;

import com.ycnet.dbank.domain.enums.AdState;

public class AdvertiseUpdateForm {
	/**广告位ID*/
	@NotBlank
	private Long adColumnId;
	/**广告名称*/
	@NotBlank
	private String name;
	/**广告标题*/
	@NotBlank
	private String title;
	/**广告内容*/
	private String content;
	/**广告资源文件*/
	private String source;
	/**链接地址*/
	private String linked;
	/**广告状态*/
	@Enumerated(EnumType.STRING)
	private AdState status;
	/**开放时间*/
	private String openTime;
	/**关闭时间*/
	private String closeTime;
	/**播放顺序*/
	private int orderNo;

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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getLinked() {
		return linked;
	}
	public void setLinked(String linked) {
		this.linked = linked;
	}
	public AdState getStatus() {
		return status;
	}
	public void setStatus(AdState status) {
		this.status = status;
	}
	public String getOpenTime() {
		return openTime;
	}
	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}
	public String getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	
}
