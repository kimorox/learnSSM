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
     * ApplicationContext的三个常用实现类
     *      ClassPathXmlApplicationContext：它可以加载类路径下的配置文件，要求配置文件必须在类路径下。不在的话，加载不了（更常用）
     *      FileSystemXmlApplicationContext：它可以加载磁盘任意路径下的配置文件（必须有访问权限）
     *      AnnotationConfigApplicationContext：它是用于读取注解创建容器
     * 核心容器的两个接口引发的问题：
     * ApplicationContext： （单例对象适用,实际开发中，更多使用此接口）
     *      它在构建核心容器时，创建对象采取的策略是采用立即加载的方式，也就是说，只要一读取完配置文件就马上创建配置文件中配置的对象。
     * BeanFactory：  （多例对象适用）
     *      它在构建核心容器时，创建对象采取的策略是延迟加载的方式，也就是说，什么时候根据id获取对象，什么时候才真正创建对象
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
//IAccountService as = new AccountServiceImpl();
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取Bean对象
        IAccountService as = (IAccountService) applicationContext.getBean("accountService");
        IAccountDao adao = applicationContext.getBean("accountDao", IAccountDao.class);
        System.out.println(as);
        System.out.println(adao);
//        as.saveAccount();
    }
}
