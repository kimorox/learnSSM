package com.kimoro.service.impl;

import com.kimoro.service.IAccountService;

/**
 * @ClassName AccountServiceImpl
 * @Description TODO
 * @Author kimoro
 * @Date 2021/1/23 16:43
 * 账户的业务层实现类
 **/
public class AccountServiceImpl implements IAccountService {
    public AccountServiceImpl() {
        System.out.println("对象创建了");
    }

    public void saveAccount() {
        System.out.println("----------accountService中的saveAccount执行了----------");
    }

    public void init(){
        System.out.println("初始化了");
    }

    public void destroy(){
        System.out.println("销毁了");
    }
}
