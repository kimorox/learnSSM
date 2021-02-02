package com.kimoro.jdbctemplate;

import com.kimoro.dao.IAccountDao;
import com.kimoro.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @ClassName JdbcTemplateDemo1
 * @Description TODO
 * @Author kimoro
 * @Date 2021/1/27 9:50
 **/
public class JdbcTemplateDemo4 {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        IAccountDao accountDao = ac.getBean("accountDao", IAccountDao.class);
        Account account = accountDao.findAccountById(1);
        System.out.println(account);
        account.setMoney(20000f);
        accountDao.updateAccount(account);
    }
}
