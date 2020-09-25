package com.litao.Domain;

import java.io.Serializable;

/**
 * @Description
 * @Author Taozi
 * @Date 2020/8/29 11:55
 */
public class Account implements Serializable {
    private int ID;
    private int UID;
    private double MONEY;

    /*从表实体应该包含主表实体对象的引用*/
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Account{" +
                "ID=" + ID +
                ", UID=" + UID +
                ", MONEY=" + MONEY +
                '}';
    }

    public Account() {
    }

    public Account(int ID, int UID, double MONEY) {
        this.ID = ID;
        this.UID = UID;
        this.MONEY = MONEY;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public double getMONEY() {
        return MONEY;
    }

    public void setMONEY(double MONEY) {
        this.MONEY = MONEY;
    }
}
