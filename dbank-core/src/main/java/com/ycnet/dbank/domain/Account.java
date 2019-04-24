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
 * 个人签约账户(一期不做)
 * 一个渠道用户=》对应E账通一个虚账户=》对应核心一个电子账户
 * 一个虚账户只能绑定一张他行卡。如果已经存在了，则需把钱提现到原卡上，然后解绑，
 * 广发信用卡客户直接用（卡号、CVV2、客户姓名、身份证号、手机号）实名验证，开通E账通，然后才能签约他行卡
 * 他行卡直接用（姓名、身份证号、卡号、手机号） 实名认证，开通E账通，然后才能签约他行卡
 * 95508 - 》E账通 -》核心
 * User: guozp
 * Date: 14-4-20
 * Time: 下午8:45
 */
@Entity
public class Account extends DomainImpl {

    private static final long serialVersionUID = -1668274773540260173L;
    /**签约银行卡所属银行类型：本行、他行*/
    @Enumerated(EnumType.STRING)
    private BankType bankType = BankType.REST;
    /**签约卡的类型:借记卡*/
    @Enumerated(EnumType.STRING)
    private CardType cardType = CardType.DEBIT;
    /**卡号*/
    @NotNull
    private String cardNo;
    /**开户行号，对应行名去字典表Option中取值*/
    private String openBankNo;
    /**所属客户*/
    @ManyToOne
    private Person person;

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }


    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public BankType getBankType() {
        return bankType;
    }

    public void setBankType(BankType bankType) {
        this.bankType = bankType;
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
