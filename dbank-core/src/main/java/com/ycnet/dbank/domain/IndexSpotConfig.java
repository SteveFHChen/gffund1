package com.ycnet.dbank.domain;

import com.ycnet.dbank.domain.enums.HrefType;
import com.ycnet.dbank.domain.enums.SpotType;
import com.ycnet.mirage.domain.DomainImpl;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * 首页配置
 * User: guozp
 * Date: 14-4-22
 * Time: 上午10:28
 */
@Entity
public class IndexSpotConfig extends DomainImpl {

    private static final long serialVersionUID = -5068497849609398130L;

    /**区域类型*/
    @Enumerated(EnumType.STRING)
    private SpotType spotType;
    /**区域内容，图片则为图片在文件服务器上的url,其他则为文字内容*/
    private String content;
    /**顺序*/
    private Integer order;
    /**链接*/
    private String url;
    /**链接类型*/
    private HrefType hrefType;

    public SpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HrefType getHrefType() {
        return hrefType;
    }

    public void setHrefType(HrefType hrefType) {
        this.hrefType = hrefType;
    }
}
