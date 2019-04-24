package com.ycnet.dbank.dto.condition;

/**
  *
 *  订单查询条件
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
public class OrderCondition {
    /**
     * 投资周期
     * -1:不限制，所有情况
     * 30:30
     * 90:90
     * 180:180
     * 365:365
     * 0:>365 大于365的情况
     */
    private Integer period;
    /**
     * 收益排名
     * -1:不限制，所有情况
     * 30:30
     * 90:90
     * 180:180
     * 365:365
     * 0:>365 大于365的情况
     */
    private Integer rank;

    /**
     * 姓名
     */
    private String name;
    
    private String orderNo;
    private String phone;
    private String startDate;
    private String endDate;
    

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
    
    
}
