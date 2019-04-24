package com.ycnet.dbank.domain;

import com.ycnet.dbank.domain.enums.BankType;
import com.ycnet.dbank.domain.enums.CardType;
import com.ycnet.mirage.domain.DomainImpl;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * 实名认证记录
 * User: guozp
 * Date: 14-4-22
 * Time: 上午12:02
 */
@Entity
public class Certification extends DomainImpl {

    private static final long serialVersionUID = 1468969014866707238L;

    /**认证银行卡所属银行类型：本行、他行*/
    @Enumerated(EnumType.STRING)
    private BankType bankType = BankType.SELF;
    /**认证卡的类型:借记卡、信用卡*/
    @Enumerated(EnumType.STRING)
    private CardType cardType = CardType.CREDIT;
    /**卡号*/
    @NotNull
    private String cardNo;
    /**信用卡cvv2，当cardType为信用卡时，此项才有值*/
    private String cvv2;
    /**开户行号，对应行名去字典表Option中取值*/
    private String openBankNo;
    /**所属客户*/
    @ManyToOne
    private Person person;

    public BankType getBankType() {
        return bankType;
    }

    public void setBankType(BankType bankType) {
        this.bankType = bankType;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCvv2() {
        return cvv2;
    }

    public void setCvv2(String cvv2) {
        this.cvv2 = cvv2;
    }

    public String getOpenBankNo() {
        return openBankNo;
    }

    public void setOpenBankNo(String openBankNo) {
        this.openBankNo = openBankNo;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
