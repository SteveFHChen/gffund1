package com.ycnet.dbank.domain;

import com.ycnet.dbank.domain.enums.VerifyCodeType;
import com.ycnet.mirage.domain.DomainImpl;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 验证码
 * User: guozp
 * Date: 14-4-20
 * Time: 下午7:04
 */
@Entity
public class VerifyCode extends DomainImpl {

    private static final long serialVersionUID = 8960168966829046860L;

    /**发送目标：手机号、邮箱*/
    private String target;
    /**验证码内容*/
    private String content;
    /**验证码类型*/
    private VerifyCodeType type;
    /**过期时间*/
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date expires;
    /**是否已验证通过*/
    private boolean verified;

    /**
     * 是否过期
     * @return
     */
    @Transient
    public boolean isExpired(){
        return new Date().after(expires);
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public VerifyCodeType getType() {
        return type;
    }

    public void setType(VerifyCodeType type) {
        this.type = type;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }
}
