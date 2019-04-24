package com.ycnet.dbank.domain;

import com.ycnet.dbank.domain.enums.CertType;
import com.ycnet.dbank.domain.enums.RiskLevel;
import com.ycnet.dbank.domain.enums.Sex;
import com.ycnet.mirage.domain.MirageUser;
import com.ycnet.mirage.domain.annotation.UniqueConstrain;
import com.ycnet.mirage.domain.annotation.UniqueConstrains;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

/**
 * 个人用户
 * User: guozp
 * Date: 14-3-11
 * Time: 上午12:15
 */
@Entity
@UniqueConstrains(constrains = {
		@UniqueConstrain(fields = "phone", alias = "电话"),
		@UniqueConstrain(fields = "email", alias = "Email"),
        @UniqueConstrain(fields = "username", alias = "用户名")
})
@NamedQuery(name = "Person.loadUserByUsername", query = "select p from Person p where p.username = ?1")
public class Person extends MirageUser {

	private static final long serialVersionUID = 2583167331667662506L;

    /** 用户名，固定字段，登录用(给spring security用)*/
    @NotBlank
    private String username;
    /** 登录密码*/
    @NotBlank
    private String password;
    /**用户真实姓名*/
    private String realName;
    /**昵称，展示用*/
    private String nickname;
    /**邮箱*/
	@Email
    private String email;
    /** 手机号*/
    @Pattern(regexp = "\\d{11}")
    private String phone;
    /**证件类型*/
    @Enumerated(EnumType.STRING)
    private CertType certType;
    /** 证件号*/
    private String certNo;
    /** 性别*/
    @Enumerated(EnumType.STRING)
    private Sex sex = Sex.UNKNOWN;
    /**风险评估级别：记录最近一次的结果，没评估过则为UNKNOWN*/
    @Enumerated(EnumType.STRING)
    private RiskLevel level = RiskLevel.UNKNOWN;
    /**支付密码*/
    private String payPassword;
    /**统一客户号(E账通系统)**/
    private String customerNo;
    /**核心电子账号：一个用户只有一个*/
    private String account;
    /**虚账户(E账通系统)：一个渠道用户只有一个*/
    private String nominalAccount;
    /**是否广发信用卡用户*/
    private Boolean creditCustomer;
    /**是否首次登录*/
    private boolean modifyLoginPwd;

    /**账户列表*/
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "person")
    private List<Account> accounts = new ArrayList<Account>();
    /**实名认证列表*/
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "person")
    private List<Certification> certifications = new ArrayList<Certification>();
    /**订单列表*/
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "person")
    private List<Order> orders = new ArrayList<Order>();
    /**提现列表*/
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "person")
    private List<Withdraw> withdraws = new ArrayList<Withdraw>();
    /**充值列表*/
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "person")
    private List<Recharge> recharges = new ArrayList<Recharge>();
    /**
     * 是否已经实名认证
     * @return
     */
    @Transient
    public boolean isCertificated(){
        return StringUtils.isNotBlank(customerNo) || StringUtils.isNotBlank(account);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getNominalAccount() {
        return nominalAccount;
    }

    public void setNominalAccount(String nominalAccount) {
        this.nominalAccount = nominalAccount;
    }

    public Boolean getCreditCustomer() {
        return creditCustomer;
    }

    public void setCreditCustomer(Boolean creditCustomer) {
        this.creditCustomer = creditCustomer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public CertType getCertType() {
        return certType;
    }

    public void setCertType(CertType certType) {
        this.certType = certType;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public RiskLevel getLevel() {
        return level;
    }

    public void setLevel(RiskLevel level) {
        this.level = level;
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Certification> getCertifications() {
        return certifications;
    }

    public void setCertifications(List<Certification> certifications) {
        this.certifications = certifications;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Withdraw> getWithdraws() {
        return withdraws;
    }

    public void setWithdraws(List<Withdraw> withdraws) {
        this.withdraws = withdraws;
    }

    public List<Recharge> getRecharges() {
        return recharges;
    }

    public void setRecharges(List<Recharge> recharges) {
        this.recharges = recharges;
    }

    public boolean isModifyLoginPwd() {
        return modifyLoginPwd;
    }

    public void setModifyLoginPwd(boolean modifyLoginPwd) {
        this.modifyLoginPwd = modifyLoginPwd;
    }
}
