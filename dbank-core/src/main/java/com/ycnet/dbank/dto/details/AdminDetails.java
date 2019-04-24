package com.ycnet.dbank.dto.details;

/**
  * 内管用户返回dto
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
public class AdminDetails {

    private Long adminId;
    private String name;
    private String username;
    private String roleName;
    private String password;
    private Long roleId;

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
