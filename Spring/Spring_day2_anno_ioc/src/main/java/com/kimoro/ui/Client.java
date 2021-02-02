package com.kimoro.ui;

import com.kimoro.dao.IAccountDao;
import com.kimoro.service.IAccountService;
import com.kimoro.service.impl.AccountServiceImpl;
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
     *
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
//IAccountService as = new AccountServiceImpl();
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取Bean对象
        IAccountService as = (IAccountService) applicationContext.getBean("accountService");
//        IAccountService as2 = (IAccountService) applicationContext.getBean("accountService");
//        System.out.println(as);

//        IAccountDao adao = applicationContext.getBean("accountDao", IAccountDao.class);
//        System.out.println(adao);
//        System.out.println(as==as2);
        as.saveAccount();
        applicationContext.close();
    }
}
