package com.ycnet.dbank.domain;

import com.ycnet.dbank.domain.enums.ChannelType;
import com.ycnet.dbank.domain.enums.NoticeStatus;
import com.ycnet.mirage.domain.DomainImpl;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 公告
 * User: guozp
 * Date: 14-4-20
 * Time: 下午11:54
 */
@Entity
public class Notice extends DomainImpl {

    private static final long serialVersionUID = -5492422570590720091L;
    /**标题*/
    @NotNull
    private String title;
    /**发布时间*/
    @Temporal(TemporalType.DATE)
    private Date publishDate = new Date();
    /**公告内容，html lob*/
    @Lob
    private String content;
    /**渠道类型*/
    @Enumerated(EnumType.STRING)
    private ChannelType channelType = ChannelType.SITE;
    /**作者*/
    private String author;
    /**截止有效期*/
    @Temporal(TemporalType.DATE)
    private Date endDate = new Date();
    /**发布状态<已发布、已过期>*/ 
    @Enumerated(EnumType.STRING)
    private NoticeStatus status = NoticeStatus.PUBLISHED ;
    
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public NoticeStatus getStatus() {
		return status;
	}
	public void setStatus(NoticeStatus status) {
		this.status = status;
	}
	public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ChannelType getChannelType() {
        return channelType;
    }

    public void setChannelType(ChannelType channelType) {
        this.channelType = channelType;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
