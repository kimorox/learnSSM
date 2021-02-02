package com.kimoro.jdbctemplate;

import com.kimoro.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @ClassName JdbcTemplateDemo1
 * @Description TODO
 * @Author kimoro
 * @Date 2021/1/27 9:50
 * jdbcTemplate的CRUD操作
 **/
public class JdbcTemplateDemo3 {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        JdbcTemplate jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        //3.执行操作
        //保存
//        jt.update("insert into account(name,money)values(?,?)", "eee", 3333);
        //更新
//        jt.update("update account set name=?,money=? where id=?", "test", 4567, 8);
        //删除
//        jt.update("delete from account where id=?",8);
        //查询所有
//        List<Account> accountList = jt.query("select * from account where money>?", new BeanPropertyRowMapper<Account>(Account.class), 1000f);
//        for (Account account : accountList) {
//            System.out.println(account);
//        }
        //查询一个
//        List<Account> accountList = jt.query("select * from account where id=?", new BeanPropertyRowMapper<Account>(Account.class), 1);
//        System.out.println(accountList.isEmpty() ? "没有返回值" : accountList.get(0));
        //查询返回一行一列（使用聚合函数，但是不加group by子句）
        Long count = jt.queryForObject("select count(*) from account where money>?", Long.class, 1000f);
        System.out.println(count);
    }
}
