package com.kimoro.dao.impl;

import com.kimoro.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * @ClassName AccountDaoImpl
 * @Description TODO
 * @Author kimoro
 * @Date 2021/1/23 16:50
 * 账户的持久层实现
 **/
@Repository(value = "accountDao")
public class AccountDaoImpl implements IAccountDao {
    public void saveAccount() {
        System.out.println("保存了账户");
    }
}
