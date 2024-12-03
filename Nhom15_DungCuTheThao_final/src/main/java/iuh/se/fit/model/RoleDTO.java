/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iuh.se.fit.model;

import java.util.List;


public class RoleDTO {

    private long roleId;

    private String roleName;

    private List<UserDTO> userDTOs;

    public RoleDTO() {
    }

    public RoleDTO(long roleId, String roleName, List<UserDTO> userDTOs) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.userDTOs = userDTOs;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<UserDTO> getUserDTOs() {
        return userDTOs;
    }

    public void setUserDTOs(List<UserDTO> userDTOs) {
        this.userDTOs = userDTOs;
    }

    
}
