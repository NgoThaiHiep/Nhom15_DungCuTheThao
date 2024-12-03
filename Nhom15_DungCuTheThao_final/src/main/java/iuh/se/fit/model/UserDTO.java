/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iuh.se.fit.model;

import java.util.Date;


public class UserDTO {

    private long userId;

    private String userName;
    
    private boolean sex;
    
    private boolean verify;
    
    private Date birthDay;
    
    private String phone;
    
    private String address;
    
    private String email;
    
    private String password;

    private String avatar;
    
    private RoleDTO roleDTO;

    public UserDTO() {
    }

    public UserDTO(long userId, String userName, boolean sex, boolean verify, Date birthDay, String phone, String address, String email, String password, String avatar, RoleDTO roleDTO) {
        this.userId = userId;
        this.userName = userName;
        this.sex = sex;
        this.verify = verify;
        this.birthDay = birthDay;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.roleDTO = roleDTO;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public boolean isVerify() {
        return verify;
    }

    public void setVerify(boolean verify) {
        this.verify = verify;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public RoleDTO getRoleDTO() {
        return roleDTO;
    }

    public void setRoleDTO(RoleDTO roleDTO) {
        this.roleDTO = roleDTO;
    }

    
}
