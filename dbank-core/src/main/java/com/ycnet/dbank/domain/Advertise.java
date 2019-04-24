package com.ycnet.dbank.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import com.ycnet.dbank.domain.enums.AdState;
import com.ycnet.mirage.domain.DomainImpl;
/**
 * 广告管理 
 * User: chenfh 
 * Date: 14-5-8 
 * Time: 上午12:19
 */
@Entity
public class Advertise extends DomainImpl {
	private static final long serialVersionUID = -5924023702569284723L;
	/**广告位ID*/
	@ManyToOne
	private AdvertiseColumn adColumn;
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
	@Enumerated(EnumType.STRING)
	private AdState status = AdState.CLOSE;
	/**开放时间*/
	private Date openTime;
	/**关闭时间*/
	private Date closeTime;
	/**播放顺序*/
	private int orderNo;

	public AdvertiseColumn getAdColumn() {
		return adColumn;
	}

	public void setAdColumn(AdvertiseColumn adColumn) {
		this.adColumn = adColumn;
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
}
