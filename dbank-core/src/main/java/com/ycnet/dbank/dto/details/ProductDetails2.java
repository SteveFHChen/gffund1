package com.ycnet.dbank.dto.details;

import java.math.BigDecimal;
import java.util.Date;

import com.ycnet.dbank.dto.common.ProductDtoBase;

/**
 * 
 * @author shine
 * 理财产品详情页面dto
 */
public class ProductDetails2 extends ProductDtoBase {
	/**递增金额*/
    private BigDecimal increaseMoney;
    /**募集总额度*/
    private BigDecimal totalMoney;
    /**到期日*/
    private Date maturityDate;
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
	public Date getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}
    
}
