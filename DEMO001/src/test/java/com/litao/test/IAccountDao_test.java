package com.litao.test;

import com.litao.Dao.IAccountDao;
import com.litao.Domain.Account;
import com.litao.Domain.AccountUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Description
 * @Author Taozi
 * @Date 2020/8/29 12:06
 */
public class IAccountDao_test {
    private SqlSession sqlSession;
    private InputStream inputStream;
    private IAccountDao accountDao;

    @Before
    public void before() {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        inputStream = Resources.class.getResourceAsStream("/sqlMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        sqlSession = sqlSessionFactory.openSession(true);
        accountDao = sqlSession.getMapper(IAccountDao.class);
    }

    /*查询所有*/
    @Test
    public void test01() {
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println("------------每个account--------------");
            System.out.println(account);
            System.out.println(account.getUser().toString());
        }
    }

    /*延迟查询所有*/
    @Test
    public void test03() {
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println("------------每个account--------------");
            System.out.println(account);
            System.out.println(account.getUser().toString());
        }
    }

    /*查詢所有账户并且带有用户名和地址信息*/
    @Test
    public void test02(){
        List<AccountUser> list = accountDao.findAccount();
        for (AccountUser accountUser : list) {
            System.out.println(accountUser);
        }
    }



    @After
    public void after() throws IOException {
        inputStream.close();
        sqlSession.close();
    }

}
