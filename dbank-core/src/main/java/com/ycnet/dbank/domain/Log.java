package com.ycnet.dbank.domain;

import com.ycnet.mirage.domain.DomainImpl;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 操作日志
 * User: guozp
 * Date: 14-4-21
 * Time: 上午10:58
 */
@Entity
public class Log extends DomainImpl {

    private static final long serialVersionUID = -5210283072695194554L;
    /**操作员ID*/
    private Long operatorId;
    /**操作员名称*/
    private String operatorName;
    /**操作功能菜单名称：menu fullName*/
    private String menu;
    /**操作内容*/
    @Column(length = 1000)
    private String content;

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
