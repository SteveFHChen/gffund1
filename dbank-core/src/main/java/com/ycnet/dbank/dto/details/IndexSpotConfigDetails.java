package com.ycnet.dbank.dto.details;

import com.ycnet.dbank.domain.enums.HrefType;
import com.ycnet.dbank.domain.enums.SpotType;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 13:17:09
  */
public class IndexSpotConfigDetails {

    /**区域类型*/
    private SpotType spotType;
    /**区域内容，图片则为图片在文件服务器上的url,其他则为文字内容*/
    private String content;
    /**顺序*/
    private Integer order;
    /**链接*/
    private String url;
    /**链接类型：内链或者外链*/
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
