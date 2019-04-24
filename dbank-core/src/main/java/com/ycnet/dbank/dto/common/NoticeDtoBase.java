package com.ycnet.dbank.dto.common;

import java.util.Date;

/**
 * 公告的dto基类
 * User: guozp
 * Date: 14-5-5
 * Time: 上午1:12
 */
public class NoticeDtoBase {

    private String title; 
    private String author;
    private String content;
    private Date publishDate = new Date();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
}
