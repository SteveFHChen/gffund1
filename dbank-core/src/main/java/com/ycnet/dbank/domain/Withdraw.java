package com.ycnet.dbank.domain;

import com.ycnet.dbank.domain.enums.WithdrawState;
import com.ycnet.mirage.domain.DomainImpl;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 提现流水表
 * User: guozp
 * Date: 14-4-21
 * Time: 上午11:01
 */
@Entity
public class Withdraw extends DomainImpl {
    private static final long serialVersionUID = -4167455958649872661L;

    /**流水号*/
    @NotNull
    private String flowNo;
    /**提现流水状态*/
    @Enumerated(EnumType.STRING)
    private WithdrawState state;
    /**用户*/
    @ManyToOne
    private Person person;
    /**手续费*/
    private BigDecimal fee;

    public String getFlowNo() {
        return flowNo;
    }

    public void setFlowNo(String flowNo) {
        this.flowNo = flowNo;
    }

    public WithdrawState getState() {
        return state;
    }

    public void setState(WithdrawState state) {
        this.state = state;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }
}
