package com.litao.test;

import com.litao.Dao.IAccountDao;
import com.litao.Dao.IRoleDao;
import com.litao.Domain.Account;
import com.litao.Domain.AccountUser;
import com.litao.Domain.Role;
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
public class IRoleDao_test {
    private SqlSession sqlSession;
    private InputStream inputStream;
    private IRoleDao roleDao;

    @Before
    public void before() {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        inputStream = Resources.class.getResourceAsStream("/sqlMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        sqlSession = sqlSessionFactory.openSession(true);
        roleDao = sqlSession.getMapper(IRoleDao.class);
    }

    /*查询所有*/
    @Test
    public void test01() {
        List<Role> accounts = roleDao.findAll();
        for (Role account : accounts) {
            System.out.println("----------一个角色的信息------------");
            System.out.println(account);
            System.out.println(account.getUsers());
        }
    }






    @After
    public void after() throws IOException {
        inputStream.close();
        sqlSession.close();
    }

}
