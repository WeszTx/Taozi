package com.litao.Domain;

import java.util.List;

/**
 * @Description
 * @Author Taozi
 * @Date 2020/8/27 18:02
 */
public class QueryVO {
    private User user;
    private List<Integer> idlist;

    public List<Integer> getList() {
        return idlist;
    }

    public void setList(List<Integer> list) {
        this.idlist = list;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
