package com.ycnet.dbank.dto.common;

import java.math.BigDecimal;
import java.util.Date;

import com.ycnet.dbank.domain.enums.CurrencyType;
import com.ycnet.dbank.domain.enums.RiskLevel;

public class ProductDtoBase {
	/**产品代码*/
    private String code;
    /**产品名称*/
    private String name;
    /**副标题*/
    private String title;
    /**币种*/
    private CurrencyType currencyType;
    /**投资期限(天)*/
    private Integer period;
    /**起点金额*/
    private BigDecimal beginMoney;
    /**预期年化收益率(%)*/
    private Double expectAnnualRate;
    /**风险等级*/
    private RiskLevel riskLevel;
    /**募集开始日期*/
    private Date raiseStartDate;
    /**起息日*/
    private Date valueDate;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public CurrencyType getCurrencyType() {
		return currencyType;
	}
	public void setCurrencyType(CurrencyType currencyType) {
		this.currencyType = currencyType;
	}
	public Integer getPeriod() {
		return period;
	}
	public void setPeriod(Integer period) {
		this.period = period;
	}
	public BigDecimal getBeginMoney() {
		return beginMoney;
	}
	public void setBeginMoney(BigDecimal beginMoney) {
		this.beginMoney = beginMoney;
	}
	public Double getExpectAnnualRate() {
		return expectAnnualRate;
	}
	public void setExpectAnnualRate(Double expectAnnualRate) {
		this.expectAnnualRate = expectAnnualRate;
	}
	public RiskLevel getRiskLevel() {
		return riskLevel;
	}
	public void setRiskLevel(RiskLevel riskLevel) {
		this.riskLevel = riskLevel;
	}
	public Date getRaiseStartDate() {
		return raiseStartDate;
	}
	public void setRaiseStartDate(Date raiseStartDate) {
		this.raiseStartDate = raiseStartDate;
	}
	public Date getValueDate() {
		return valueDate;
	}
	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}
}
