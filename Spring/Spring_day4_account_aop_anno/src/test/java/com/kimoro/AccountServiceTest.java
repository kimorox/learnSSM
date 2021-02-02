package com.kimoro;

import com.kimoro.domain.Account;
import com.kimoro.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @ClassName AccountServiceTest
 * @Description TODO
 * @Author kimoro
 * @Date 2021/1/25 11:22
 * 使用junit单元测试配置
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {
    @Autowired
    private IAccountService as;

    @Test
    public void testTransfer() {
        as.transfer("aaa", "bbb", 100f);
    }


}
