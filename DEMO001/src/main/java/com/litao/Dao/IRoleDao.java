package com.litao.Dao;

import com.litao.Domain.Role;

import java.util.List;

/**
 * @Description
 * @Author Taozi
 * @Date 2020/8/29 18:43
 */
public interface IRoleDao {
    /*查询所有角色以及具有该角色的所有用户信息*/
    public List<Role> findAll();
}
