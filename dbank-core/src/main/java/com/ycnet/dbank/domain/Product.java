package com.ycnet.dbank.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;

import com.ycnet.dbank.domain.enums.CurrencyType;
import com.ycnet.dbank.domain.enums.ProductState;
import com.ycnet.dbank.domain.enums.RiskLevel;
import com.ycnet.mirage.domain.SortableImpl;

/**
 * 理财产品表
 * User: guozp
 * Date: 14-4-20
 * Time: 下午5:58
 */
@Entity
public class Product extends SortableImpl {
    private static final long serialVersionUID = 1781608208219605487L;
    /**产品代码*/
    private String code;
    /**产品名称*/
    @NotBlank
    private String name;
    /**副标题*/
    private String title;
    /**保本：默认不保本*/
    private boolean breakevenState = false;
    /**币种*/
    @Enumerated(EnumType.STRING)
    private CurrencyType currencyType = CurrencyType.RMB;
    /**投资期限(天)*/
    private Integer period;
    /**起点金额*/
    private BigDecimal beginMoney;
    /**递增金额*/
    private BigDecimal increaseMoney;
    /**募集总额度*/
    private BigDecimal totalMoney;
    /**预期年化收益率(%)*/
    private Double expectAnnualRate;
    /**风险等级*/
    @Enumerated(EnumType.STRING)
    private RiskLevel riskLevel = RiskLevel.UNKNOWN;
    /**募集开始日期*/
    @Temporal(TemporalType.DATE)
    private Date raiseStartDate;
    /**募集结束日期*/
    @Temporal(TemporalType.DATE)
    private Date raiseEndDate;
    /**起息日*/
    @Temporal(TemporalType.DATE)
    private Date valueDate;
    /**到期日*/
    @Temporal(TemporalType.DATE)
    private Date maturityDate;
    /**扣款日期*/
    @Temporal(TemporalType.DATE)
    private Date chargeDate;
    /**广告图片文件服务器上的地址*/
    private String adImage;
    /**详情图片文件服务器上的地址*/
    private String detailImage;
    /**产品状态:从理财系统同步过来的初始化状态，可以进行产品整理包装再上架*/
    private ProductState state = ProductState.INIT;
    /**上架时间*/
    private Date upDate;
    /**下架时间*/
    private Date downDate;
    /**产品系列*/
    private String series;

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

    public BigDecimal getIncreaseMoney() {
		return increaseMoney;
	}

	public void setIncreaseMoney(BigDecimal increaseMoney) {
		this.increaseMoney = increaseMoney;
	}

	public BigDecimal getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
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

    public Date getRaiseEndDate() {
        return raiseEndDate;
    }

    public void setRaiseEndDate(Date raiseEndDate) {
        this.raiseEndDate = raiseEndDate;
    }

    public Date getValueDate() {
        return valueDate;
    }

    public void setValueDate(Date valueDate) {
        this.valueDate = valueDate;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public Date getChargeDate() {
        return chargeDate;
    }

    public void setChargeDate(Date chargeDate) {
        this.chargeDate = chargeDate;
    }

    public String getAdImage() {
        return adImage;
    }

    public void setAdImage(String adImage) {
        this.adImage = adImage;
    }

    public String getDetailImage() {
        return detailImage;
    }

    public void setDetailImage(String detailImage) {
        this.detailImage = detailImage;
    }

    public ProductState getState() {
        return state;
    }

    public void setState(ProductState state) {
        this.state = state;
    }

    public Date getUpDate() {
        return upDate;
    }

    public void setUpDate(Date upDate) {
        this.upDate = upDate;
    }

    public Date getDownDate() {
        return downDate;
    }

    public void setDownDate(Date downDate) {
        this.downDate = downDate;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

	public boolean isBreakevenState() {
		return breakevenState;
	}

	public void setBreakevenState(boolean breakevenState) {
		this.breakevenState = breakevenState;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
    
}
