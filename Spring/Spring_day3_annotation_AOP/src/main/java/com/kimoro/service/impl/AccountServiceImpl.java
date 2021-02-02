package com.kimoro.service.impl;

import com.kimoro.service.IAccountService;
import org.springframework.stereotype.Service;

/**
 * @ClassName AccountService
 * @Description TODO
 * @Author kimoro
 * @Date 2021/1/26 16:14
 **/
@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    public void saveAccount() {
        System.out.println("执行了保存");
    }

    public void updateAccount(int i) {
        System.out.println("执行了更新" + i);
    }

    public int deleteAccount() {
        System.out.println("执行了删除");
        return 0;
    }
}
