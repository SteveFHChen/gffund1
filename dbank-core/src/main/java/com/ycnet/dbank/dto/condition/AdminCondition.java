package com.ycnet.dbank.dto.condition;

/**
  * 内管用户查询条件
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
public class AdminCondition {

    private String code;
    private String name;
    private String status;
    private Long roleId;
    private Long branchId;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }
}
