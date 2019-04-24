package com.ycnet.dbank.domain;

import com.ycnet.dbank.domain.enums.AdminState;
import com.ycnet.mirage.domain.MirageUser;
import com.ycnet.mirage.domain.annotation.UniqueConstrain;
import com.ycnet.mirage.domain.annotation.UniqueConstrains;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

/**
 * 内管用户
 * User: guozp
 * Date: 14-3-11
 * Time: 上午12:15
 */
@Entity
@UniqueConstrains(constrains={@UniqueConstrain(fields = "username", alias = "用户名")})
@NamedQuery(name = "Admin.loadUserByUsername", query = "select a from Admin a where a.username = ?1")
public class Admin extends MirageUser {

	private static final long serialVersionUID = -9177715646016330800L;

    /** 用户名，登录用(spring security)*/
    @NotBlank
    private String username;
    /** 密码*/
    @NotBlank
    private String password;
    /** 昵称，展示用*/
    @Column(length = 20)
    private String nickname;
    /** 内管系统统一客户号**/
    private String customerNo;
    /** 所属角色*/
    @ManyToOne(fetch = FetchType.LAZY)
    private AdminRole adminRole;
    /**所属机构*/
    @ManyToOne(fetch = FetchType.LAZY)
    private Branch branch;
    /**内管用户编号*/
    @Column(nullable = false, unique = true)
    private String code;
    /**用户状态*/
    @Enumerated(EnumType.STRING)
    private AdminState state = AdminState.ACTIVE;
    /**描述*/
    private String description;

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

    public AdminRole getAdminRole() {
        return adminRole;
    }

    public void setAdminRole(AdminRole adminRole) {
        this.adminRole = adminRole;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public AdminState getState() {
        return state;
    }

    public void setState(AdminState state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
