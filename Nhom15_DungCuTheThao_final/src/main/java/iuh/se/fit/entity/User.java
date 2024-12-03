/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iuh.se.fit.entity;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Type;


@Entity
@Table(name = "users")
public class User implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;
    
    @Column(name = "user_name")
    @Type(type="org.hibernate.type.StringNVarcharType")
    private String userName;
    
    @Column(name = "sex")
    private boolean sex;
    
    @Column(name = "verify")
    private boolean verify;
    
    @Column(name = "birth_day")
    private Date birthDay;
    
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "address")
    @Type(type="org.hibernate.type.StringNVarcharType")
    private String address;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "password")
    private String password;

    @Lob
    @Column(name = "avatar")
    private Blob avatar;
    
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public User() {
    }

    public User(long userId, String userName, boolean sex, boolean verify, Date birthDay, String phone, String address, String email, String password, Blob avatar, Role role) {
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
        this.role = role;
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

    public Blob getAvatar() {
        return avatar;
    }

    public void setAvatar(Blob avatar) {
        this.avatar = avatar;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    
}
