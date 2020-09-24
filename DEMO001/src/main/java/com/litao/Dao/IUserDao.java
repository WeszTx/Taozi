package com.litao.Dao;

import com.litao.Domain.QueryVO;
import com.litao.Domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description
 * @Author Taozi
 * @Date 2020/8/26 22:31
 */
public interface IUserDao {

    /*查询所有用户及账户信息*/
//   @Select("select * from user")
    List<User> selectAll();

    void  addOne(User user);

    void updateOne(User user);

    void deleteOne(int id);

   User findById(int id);
   /*根据名称模糊查询*/
   List<User> findByName(String name);

   int countAll();

   /*根据queryVO中的查询条件查询用户*/
    List<User> findUserByVO(QueryVO queryVO);

    /*根据条件查询所有用户*/
    List<User> findUserByCondition(User user);

    /*根据传入的vo中的ID集合查询符合条件的所有user*/
    List<User> findUserInIds(QueryVO vo);

}
