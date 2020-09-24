package com.litao.Domain;

import java.io.Serializable;
import java.util.List;

/**
 * @Description
 * @Author Taozi
 * @Date 2020/8/29 18:08
 */
public class Role implements Serializable {
    private int ID;
    private String ROLE_NAME;
    private String ROLE_DESC;

    /*配置多对多映射关系,一个角色可以赋予多个用户*/
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Role() {
    }

    @Override
    public String toString() {
        return "Role{" +
                "ID=" + ID +
                ", ROLE_NAME='" + ROLE_NAME + '\'' +
                ", ROLE_DESC='" + ROLE_DESC + '\'' +
                '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getROLE_NAME() {
        return ROLE_NAME;
    }

    public void setROLE_NAME(String ROLE_NAME) {
        this.ROLE_NAME = ROLE_NAME;
    }

    public String getROLE_DESC() {
        return ROLE_DESC;
    }

    public void setROLE_DESC(String ROLE_DESC) {
        this.ROLE_DESC = ROLE_DESC;
    }
}
