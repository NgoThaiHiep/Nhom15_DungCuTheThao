/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iuh.se.fit.dao;

import java.io.InputStream;
import java.util.List;

import iuh.se.fit.entity.User;

public interface UserDao {

    public void insert(User user, InputStream avatar);

    public void update(User user,InputStream avatar);

    public void delete(long userId);

    public User findById(long userId);

    public List<User> findAll(int pageIndex, int pageSize);

    public User findByEmailOrPhoneAndPassword(String email, String password, boolean verity);

    public User loadUserByUsername(String email);

    public User findByEmail(String email);

    int count();
}
