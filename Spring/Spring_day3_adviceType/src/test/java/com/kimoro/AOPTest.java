package com.kimoro;

import com.kimoro.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName AOPTest
 * @Description TODO
 * @Author kimoro
 * @Date 2021/1/26 16:42
 **/
public class AOPTest {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
        //3.执行方法
        as.saveAccount();
    }
}
