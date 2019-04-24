package com.ycnet.dbank.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;

import com.ycnet.dbank.domain.enums.RoleType;
import com.ycnet.mirage.domain.DomainImpl;

/**
 * 内管角色
 * User: guozp
 * Date: 14-3-12
 * Time: 上午11:49
 */
@Entity
public class AdminRole extends DomainImpl {

    private static final long serialVersionUID = -6265573474634459395L;

    /**
     * 角色名称
     */
    @NotBlank
    private String name;
    /**
     * 角色编号
     */
    private String code;
    /**
     * 角色描述
     */
    private String desc;
    
    /**角色类型*/
    @Enumerated(EnumType.STRING)
    private RoleType roleType = RoleType.ZH;
    /**
     * 角色管理的菜单
     */
    @OneToMany(fetch= FetchType.LAZY, cascade= CascadeType.REMOVE, mappedBy="role")
    private List<RoleMenu> menus = new ArrayList<RoleMenu>();
    /**
     * 属于该角色的用户列表
     */
    @OneToMany(fetch=FetchType.LAZY, mappedBy="adminRole")
    private List<Admin> admin = new ArrayList<Admin>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}

	public List<RoleMenu> getMenus() {
        return menus;
    }

    public void setMenus(List<RoleMenu> menus) {
        this.menus = menus;
    }

	public List<Admin> getAdmin() {
		return admin;
	}

	public void setAdmin(List<Admin> admin) {
		this.admin = admin;
	}
}
