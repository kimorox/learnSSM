package com.kimoro.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @ClassName JdbcTemplateDemo1
 * @Description TODO
 * @Author kimoro
 * @Date 2021/1/27 9:50
 **/
public class JdbcTemplateDemo2 {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        JdbcTemplate jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        //3.执行操作
        jt.execute("insert  into account(name,money)values('ddd',2000)");
//        //准备数据源：spring内置数据源
//        DriverManagerDataSource ds = new DriverManagerDataSource();
//        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        ds.setUrl("jdbc:mysql://localhost:3306/learnspring?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT&nullCatalogMeansCurrent=true");
//        ds.setUsername("root");
//        ds.setPassword("root");
//        //1.创建jdbcTemplate对象
//        JdbcTemplate jt = new JdbcTemplate();
//        //给jt设置数据源
//        jt.setDataSource(ds);
//        //2.执行操作
//        jt.execute("insert  into account(name,money)values('ccc',1000)");
    }
}