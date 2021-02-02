package com.kimoro.dao;

import com.kimoro.domain.User;

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
    List<User> findAll();

    /**
     * 根据Id查询用户
     * @param userId
     * @return
     */
    User findById(Integer userId);

}
