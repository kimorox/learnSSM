package com.kimoro.test;

import com.kimoro.dao.IUserDao;
import com.kimoro.domain.QueryVo;
import com.kimoro.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
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
        sqlSession = factory.openSession();
        //4.获取dao的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After//用于在测试方法执行之后执行
    public void destory() throws Exception {
        //不要忘了提交事务
        sqlSession.commit();
        //6.释放资源
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

    /**
     * 测试保存操作
     */
    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("mybatis_save");
        user.setAddress("广州市天河区");
        user.setSex("女");
        user.setBirthday(new Date());
        System.out.println("保存之前："+user);
        //5.执行保存方法
        userDao.saveUser(user);
        System.out.println("保存后："+user);
    }

    /**
     * 测试更新操作
     */
    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(44);
        user.setUsername("mybatis");
        user.setAddress("广州市天河区");
        user.setSex("男");
        user.setBirthday(new Date());
        //5.执行更新方法
        userDao.updateUser(user);
    }

    /**
     * 测试删除操作
     */
    @Test
    public void testDelete() {
        //5.执行删除方法
        userDao.deleteUser(44);
    }

    /**
     * 测试根据id查询操作
     */
    @Test
    public void testFindOne() {
        //5.执行查询一个方法
        User user = userDao.findById(42);
        System.out.println(user);
    }

    /**
     * 测试模糊查询操作
     */
    @Test
    public void testFindByName() {
        List<User> users = userDao.findByName("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试查询总记录条数
     */
    @Test
    public void testFindTotal() {
        //5.执行查询一个方法
        int count = userDao.findTotal();
        System.out.println(count);
    }

    /**
     * 测试使用QueryVo作为查询条件
     */
    @Test
    public void testFindByVo() {
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        vo.setUser(user);
        List<User> users = userDao.findUserByVo(vo);
        for (User u : users) {
            System.out.println(u);
        }
    }

}
