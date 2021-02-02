package com.kimoro.test;

import com.kimoro.dao.IAccountDao;
import com.kimoro.dao.IUserDao;
import com.kimoro.domain.Account;
import com.kimoro.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName MybatisTest
 * @Description TODO
 * @Author kimoro
 * @Date 2021/1/19 14:47
 * 测试mybatis的crud操作
 **/
public class MybatisTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IAccountDao accountDao;


    @Before//用于在测试方法执行之前执行
    public void init() throws Exception {
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession();
        //4.获取dao的代理对象
        accountDao = sqlSession.getMapper(IAccountDao.class);
    }

    @After//用于在测试方法执行之后执行
    public void destory() throws Exception {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    /**
     * 测试查询操作
     */
    @Test
    public void testFindAll() {
        //5.执行查询所有方法
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println("------------------");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

}
