package com.ycnet.dbank.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.ycnet.dbank.domain.enums.OrderState;
import com.ycnet.mirage.domain.DomainImpl;

/**
 * 用户购买的产品订单，Person和Product的多对多关系
 * User: guozp
 * Date: 14-4-20
 * Time: 下午10:03
 */
@Entity
public class Order extends DomainImpl {

    private static final long serialVersionUID = -6618876746593981204L;
    /**订单号*/
    @NotNull
    @Column(unique = true,length = 20)
    private String orderNo;
    /**购买的理财产品*/
    @ManyToOne
    private Product product;
    /**购买者*/
    @ManyToOne
    private Person person;
    /**订单状态*/
    @Enumerated(EnumType.STRING)
    private OrderState state = OrderState.UNPAID;
    /**订单金额*/
    private BigDecimal amount;
    /**下单时间*/
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime = new Date();
    /**交易账号*/
    @NotBlank
    private String accountNo;
    /**交易摘要*/
    private String remark;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
    
}
