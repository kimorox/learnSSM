package com.kimoro.dao.impl;

import com.kimoro.dao.IUserDao;
import com.kimoro.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @ClassName UserDaoImpl
 * @Description TODO
 * @Author kimoro
 * @Date 2021/1/19 16:54
 **/
public class UserDaoImpl implements IUserDao {
    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }


    public List<User> findAll() {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用SqlSession中的方法，实现查询列表
        List<User> users = session.selectList("com.kimoro.dao.IUserDao.findAll");//参数就是能获取配置信息的key
        //3.释放资源
        session.close();
        return users;
    }

    public void saveUser(User user) {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用方法实现保存
        session.insert("com.kimoro.dao.IUserDao.saveUser", user);
        //3.提交事务
        session.commit();
        //4.释放资源
        session.close();
    }

    public void updateUser(User user) {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用方法实现更新
        session.update("com.kimoro.dao.IUserDao.updateUser", user);
        //3.提交事务
        session.commit();
        //4.释放资源
        session.close();
    }

    public void deleteUser(Integer userId) {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用方法实现删除
        session.delete("com.kimoro.dao.IUserDao.deleteUser", userId);
        //3.提交事务
        session.commit();
        //4.释放资源
        session.close();
    }

    public User findById(Integer userId) {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用SqlSession中的方法，实现查询一个
        User users = session.selectOne("com.kimoro.dao.IUserDao.findById", userId);
        //3.释放资源
        session.close();
        return users;
    }

    public List<User> findByName(String username) {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用SqlSession中的方法，实现查询列表
        List<User> users = session.selectList("com.kimoro.dao.IUserDao.findByName",username);
        //3.释放资源
        session.close();
        return users;
    }

    public int findTotal() {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用SqlSession中的方法，实现查询列表
        Integer count = session.selectOne("com.kimoro.dao.IUserDao.findTotal");
        //3.释放资源
        session.close();
        return count;
    }
}
