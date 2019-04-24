package com.ycnet.dbank.domain;

import com.ycnet.mirage.domain.TreeImpl;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * 内管菜单
 * User: guozp
 * Date: 14-3-12
 * Time: 上午11:46
 */
@Entity
public class AdminMenu extends TreeImpl<AdminMenu> {

    private static final long serialVersionUID = -8926809193812867074L;

    /**
	 * 菜单URL
	 */
    private String url;
    /**
     * icon图片名称
     */
    private String icon;
    /**
     * 菜单名称
     */
    private String menuName;
    
    /**
     * 是否需要授权
     */
    private boolean isAuth = true;
    /**
     * 拥有该菜单的角色
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "menu")
    private List<RoleMenu> roleMenu = new ArrayList<RoleMenu>();

    @Override
    public String getName() {
        return menuName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public List<RoleMenu> getRoleMenu() {
		return roleMenu;
	}

	public void setRoleMenu(List<RoleMenu> roleMenu) {
		this.roleMenu = roleMenu;
	}

	public boolean isAuth() {
		return isAuth;
	}

	public void setAuth(boolean isAuth) {
		this.isAuth = isAuth;
	}
}
