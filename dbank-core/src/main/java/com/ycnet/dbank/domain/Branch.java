package com.ycnet.dbank.domain;

import com.ycnet.mirage.domain.TreeImpl;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * 机构表
 * User: guozp
 * Date: 14-5-5
 * Time: 上午9:10
 */
@Entity
public class Branch extends TreeImpl<Branch> {

    private static final long serialVersionUID = 1941082137700140321L;
    /**机构号*/
    private String code;
    /**机构名称*/
    private String branchName;
    /**角色管理的菜单*/
    @OneToMany(fetch= FetchType.LAZY, cascade= CascadeType.REMOVE, mappedBy="branch")
    private List<Admin> admins = new ArrayList<Admin>();

    @Override
    public String getName() {
        return branchName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }
}
