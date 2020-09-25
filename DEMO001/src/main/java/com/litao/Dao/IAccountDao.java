package com.litao.Dao;

import com.litao.Domain.Account;
import com.litao.Domain.AccountUser;

import java.util.List;

/**
 * @Description
 * @Author Taozi
 * @Date 2020/8/29 12:00
 */
public interface IAccountDao {

    /*查詢所有账户以及所有用户信息*/
    public List<Account> findAll();

    /*查詢所有账户并且带有用户名和地址信息*/
    public List<AccountUser> findAccount();

}
