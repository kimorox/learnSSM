package com.kimoro.dao;

import com.kimoro.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 用户持久层接口
 */
public interface IUserDao {
    /**
     * 查询所有用户
     *
     * @return
     */
    @Select("select * from user")
    List<User> findAll();

    @Insert("insert into user(username,address,sex,birthday)values(#{username},#{address},#{sex},#{birthday}) ")
    void saveUser(User user);

    @Update("update user set username=#{username},address=#{address},sex=#{sex},birthday=#{birthday} where id=#{id}")
    void updateUser(User user);

    @Delete("delete from user where id=#{id}")
    void deleteUser(Integer userId);

    @Select("select * from user where id=#{id}")
    User findById(Integer userid);

    @Select("select * from user where username like #{username}")
    List<User> findUserByName(String username);

    @Select("select count(*) from user")
    int findTotalUser();
}
