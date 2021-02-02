package com.kimoro.ui;

import com.kimoro.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName Client
 * @Description TODO
 * @Author kimoro
 * @Date 2021/1/23 16:45
 * 模拟一个表现层，用于调用业务层
 **/
public class Client {
    /**
     * 获取spring的Ioc核心容器，根据id获取对象
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
//IAccountService as = new AccountServiceImpl();
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取Bean对象
//        IAccountService as = (IAccountService) applicationContext.getBean("accountService");
//        as.saveAccount();
//        IAccountService as = (IAccountService) applicationContext.getBean("accountService2");
//        as.saveAccount();
        IAccountService as = (IAccountService) applicationContext.getBean("accountService3");
        as.saveAccount();

    }
}
