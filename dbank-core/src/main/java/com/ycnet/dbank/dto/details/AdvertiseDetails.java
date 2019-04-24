package com.ycnet.dbank.dto.details;

import java.util.Date;

public class AdvertiseDetails {
	/**广告位ID*/
	private String adColumnName;
	private Long adId;
	/**广告名称*/
	private String name;
	/**广告标题*/
	private String title;
	/**广告内容*/
	private String content;
	/**广告资源文件*/
	private String source;
	/**链接地址*/
	private String linked;
	/**广告状态*/
	private String status;
	/**开放时间*/
	private Date openTime;
	/**关闭时间*/
	private Date closeTime;
	/**播放顺序*/
	private int orderNo;

	public Long getAdId() {
		return adId;
	}

	public void setAdId(Long adId) {
		this.adId = adId;
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

	public Date getOpenTime() {
		return openTime;
	}

	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}

	public Date getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getAdColumnName() {
		return adColumnName;
	}

	public void setAdColumnName(String adColumnName) {
		this.adColumnName = adColumnName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
