/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package iuh.se.fit.dao;

import java.util.List;

import iuh.se.fit.entity.Role;

public interface RoleDao {

    public List<Role> findAll();
}
