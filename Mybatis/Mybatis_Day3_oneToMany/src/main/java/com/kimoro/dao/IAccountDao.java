package com.kimoro.dao;

import com.kimoro.domain.Account;

import java.util.List;

public interface IAccountDao {
    /**
     * 查询所有账户
     * @return
     */
    List<Account> findAll();

    /**
     * 查询所有用户，并且带有用户名名称和地址信息
     * @return
     */
    List<Account> findAllAccount();
}
