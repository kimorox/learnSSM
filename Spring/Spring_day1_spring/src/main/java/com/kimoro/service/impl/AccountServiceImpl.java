package com.kimoro.service.impl;

import com.kimoro.dao.IAccountDao;
import com.kimoro.dao.impl.AccountDaoImpl;
import com.kimoro.service.IAccountService;

/**
 * @ClassName AccountServiceImpl
 * @Description TODO
 * @Author kimoro
 * @Date 2021/1/23 16:43
 * 账户的业务层实现类
 **/
public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao = new AccountDaoImpl();

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
