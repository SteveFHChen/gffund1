package com.ycnet.dbank.dto.condition;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ArrayUtils;


/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
public class ProductCondition {

	/**投资期限(天)*/
	private String period;
    private String minPeriod = null;
    private String maxPeriod = null;
    /**预期年化收益率(%)排行，取前rows条记录*/
    private int rows;
    /**风险等级*/
    private String riskLevel;
    /**保本：默认不保本*/
    private String breakevenState;
    /**销售状态*/
    private String saleState;
    
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getMinPeriod() {
		if(StringUtils.isNotBlank(period)) {
			String[] strs = StringUtils.split("-");
			if(ArrayUtils.isNotEmpty(strs) && strs.length>0) {
				return strs[0];
			}
		}
		return minPeriod;
	}
	public String getMaxPeriod() {
		if(StringUtils.isNotBlank(period)) {
			String[] strs = StringUtils.split("-");
			if(ArrayUtils.isNotEmpty(strs) && strs.length==2) {
				return strs[1];
			}
		}
		return maxPeriod;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public String getRiskLevel() {
		return riskLevel;
	}
	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}
	public String getBreakevenState() {
		return breakevenState;
	}
	public void setBreakevenState(String breakevenState) {
		this.breakevenState = breakevenState;
	}
	public String getSaleState() {
		return saleState;
	}
	public void setSaleState(String saleState) {
		this.saleState = saleState;
	}
    
    
}
