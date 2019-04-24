package com.ycnet.dbank.dto.create;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.ycnet.dbank.domain.enums.ChannelType;
import com.ycnet.dbank.dto.common.NoticeDtoBase;

/**
  * 公告创建dto
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
public class NoticeCreateForm extends NoticeDtoBase {

	/**渠道类型*/
    private ChannelType channelType = ChannelType.SITE;
    
    /**标题*/
    private String title;
    /**发布时间*/
    private Date publishDate = new Date();
    /**公告内容，html lob*/
    private String content;
    /**作者*/
    private String author;
    
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	
    public ChannelType getChannelType() {
        return channelType;
    }

    public void setChannelType(ChannelType channelType) {
        this.channelType = channelType;
    }
}
