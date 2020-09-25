package com.litao.test;

import com.litao.Dao.IUserDao;
import com.litao.Domain.Account;
import com.litao.Domain.QueryVO;
import com.litao.Domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description   mybatis的CRUD方法测试
 * @Author Taozi
 * @Date 2020/8/26 22:29
 */
public class IUserDao_test {

     private IUserDao mapper;
     private InputStream inputStream;
     private SqlSession sqlSession;
    @Before
    public void before(){
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        inputStream= Resources.class.getResourceAsStream("/SqlMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        sqlSession = sqlSessionFactory.openSession(true);  //设置默认事务提交
        mapper= sqlSession.getMapper(IUserDao.class);
    }
    @Test
    public void test01() throws IOException {

        List<User> users = mapper.selectAll();
        for (User user : users) {
            System.out.println(user);
        }


    }

    /**
     * @Description: 查询所有用户及账户信息
     * @param:  []
     * @return: void
     * @author: Taozi
     * @date: 2020/8/26 23:31
     */
    @Test
    public void test02() throws IOException {

        List<User> users = mapper.selectAll();
        for (User user : users) {
            System.out.println("==========每个user信息============");
            System.out.println(user);
            System.out.println(user.getAccountList());

        }


    }

    /**
     * @Description: 插入用户
     * @param:  []
     * @return: void
     * @author: Taozi
     * @date: 2020/8/26 23:31
     */
    @Test
    public void test03(){

        User user=new User();
        user.setSex("男");
        user.setUsername("高志文");
        user.setAddress("北京");
        user.setBirthday(new Date());
        System.out.println("保存之前："+user);
        mapper.addOne(user);
        System.out.println("保存之后："+user);

    }

    /**
     * @Description: 更新用户
     * @param:  []
     * @return: void
     * @author: Taozi
     * @date: 2020/8/26 23:45
     */
    @Test
    public void test04(){
        User user=new User(51, "二毛", new Date(), "女", "大同");
        mapper.updateOne(user);
    }
    /**
     * @Description: 删除用户
     * @param:  []
     * @return: void
     * @author: Taozi
     * @date: 2020/8/26 23:45
     */
    @Test
    public void test05(){
      //  User user=new User(51, "二毛", new Date(), "女", "大同");
        mapper.deleteOne(41);
    }
    /**
     * @Description: 查询一个用户
     * @param:  []
     * @return: void
     * @author: Taozi
     * @date: 2020/8/26 23:45
     */
    @Test
    public void test06(){
        //  User user=new User(51, "二毛", new Date(), "女", "大同");
        User user = mapper.findById(48);
        System.out.println(user);
    }
    /**
     * @Description: 通过名字模糊查询一个用户
     * @param:  []
     * @return: void
     * @author: Taozi
     * @date: 2020/8/26 23:45
     */
    @Test
    public void test07(){
        //  User user=new User(51, "二毛", new Date(), "女", "大同");
        List<User> users = mapper.findByName("%王%");
//        List<User> users = mapper.findByName("王");
        for (User user : users) {
            System.out.println(user);
        }
    }


    /**
     * @Description: 查询总记录数
     * @param:  []
     * @return: void
     * @author: Taozi
     * @date: 2020/8/26 23:45
     */
    @Test
    public void test08(){
        //  User user=new User(51, "二毛", new Date(), "女", "大同");
        int i = mapper.countAll();
        System.out.println(i);
    }

/**
 * @Description: 使用queryVO作为查询条件
 * @param:  []
 * @return: void
 * @author: Taozi
 * @date: 2020/8/27 18:07
 */
@Test
    public void tets09(){
        QueryVO vo=new QueryVO();
        User user=new User();
        user.setUsername("%王%");
        vo.setUser(user);
        List<User> userByVO = mapper.findUserByVO(vo);
        for (User user1 : userByVO) {
            System.out.println(user1);
        }
    }
@Test
public void test10(){
    User user = new User();
    user.setUsername("小二王");
    user.setSex("女");
    List<User> users = mapper.findUserByCondition(user);
    for (User user1 : users) {
        System.out.println(user1);
    }
}

    @Test
    public void test11(){
        List<Integer> idlist=new ArrayList<>();
        idlist.add(49);
        idlist.add(50);
        QueryVO vo = new QueryVO();
        vo.setList(idlist);
        List<User> users = mapper.findUserInIds(vo);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }

/**
 * 多表
 * */

@Test
public void test12(){

}






    @After
    public void close() throws IOException {
        //        提交事务
     //   sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }

}
