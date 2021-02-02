package com.kimoro.factory;

import com.kimoro.service.IAccountService;
import com.kimoro.service.impl.AccountServiceImpl;

/**
 * @ClassName InstanceFactory
 * @Description TODO
 * @Author kimoro
 * @Date 2021/1/24 11:30
 * 模拟一个工厂类（该类可能时存在于jar包中的，我们无法通过修改源码的方式来提供默认构造函数）
 **/
public class InstanceFactory {
    public IAccountService getAccountService() {
        return new AccountServiceImpl();
    }
}
