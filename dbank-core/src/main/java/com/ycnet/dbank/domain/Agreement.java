package com.ycnet.dbank.domain;

import com.ycnet.dbank.domain.enums.AgreementType;
import com.ycnet.mirage.domain.DomainImpl;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;

/**
 * 协议
 * User: guozp
 * Date: 14-4-21
 * Time: 上午12:21
 */
@Entity
public class Agreement extends DomainImpl {
    private static final long serialVersionUID = 8352028008579843182L;

    /**协议类型*/
    @Enumerated(EnumType.STRING)
    private AgreementType type;
    /**内容*/
    @Lob
    private String content;

    public AgreementType getType() {
        return type;
    }

    public void setType(AgreementType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
