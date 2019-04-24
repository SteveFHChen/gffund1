package com.ycnet.dbank.domain;

import com.ycnet.mirage.domain.DomainImpl;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * 内管角色-菜单多对多关系
 * User: guozp
 * Date: 14-4-17
 * Time: 下午6:13
 */
@Entity
public class RoleMenu extends DomainImpl {

    private static final long serialVersionUID = -6331047653977111621L;
    /**菜单*/
    @ManyToOne
    private AdminMenu menu;
    /**内管角色*/
    @ManyToOne
    private AdminRole role;
    /**表示对该菜单是否可复核授权*/
    private boolean isHasAuth = false;

    public AdminMenu getMenu() {
        return menu;
    }

    public void setMenu(AdminMenu menu) {
        this.menu = menu;
    }

    public AdminRole getRole() {
        return role;
    }

    public void setRole(AdminRole role) {
        this.role = role;
    }

	public boolean isHasAuth() {
		return isHasAuth;
	}

	public void setHasAuth(boolean isHasAuth) {
		this.isHasAuth = isHasAuth;
	}

}
