package com.ycnet.dbank.domain;

import com.ycnet.dbank.domain.enums.RechargeState;
import com.ycnet.mirage.domain.DomainImpl;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * 充值流水表
 * User: guozp
 * Date: 14-4-21
 * Time: 上午11:01
 */
@Entity
public class Recharge extends DomainImpl {
    private static final long serialVersionUID = -7872487092960439780L;

    /**流水号*/
    @NotNull
    private String flowNo;
    /**提现流水状态*/
    @Enumerated(EnumType.STRING)
    private RechargeState state;
    /**用户*/
    @ManyToOne
    private Person person;

    public String getFlowNo() {
        return flowNo;
    }

    public void setFlowNo(String flowNo) {
        this.flowNo = flowNo;
    }

    public RechargeState getState() {
        return state;
    }

    public void setState(RechargeState state) {
        this.state = state;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
