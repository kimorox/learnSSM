package com.kimoro.test;

import com.kimoro.dao.IUserDao;
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
    private IUserDao userDao;

    @Before//用于在测试方法执行之前执行
    public void init() throws Exception {
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession(true);
        //4.获取dao的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After//用于在测试方法执行之后执行
    public void destory() throws Exception {
        sqlSession.close();
        in.close();
    }

    /**
     * 测试查询操作
     */
    @Test
    public void testFindAll() {
        //5.执行查询所有方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setUsername("mybatis xxx");
        user.setAddress("广州市白云区");
        userDao.saveUser(user);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(52);
        user.setUsername("mybatis xxx");
        user.setAddress("广州市白云区");
        user.setBirthday(new Date());
        user.setSex("女");
        userDao.updateUser(user);
    }

    @Test
    public void testDelete() {
        userDao.deleteUser(52);
    }

    @Test
    public void testFindOne() {
        User user = userDao.findById(51);
        System.out.println(user);
    }

    @Test
    public void testFindByName() {
        List<User> users = userDao.findUserByName("%mybatis%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testTotalUser() {
        int count = userDao.findTotalUser();
        System.out.println(count);
    }
}
