package com.kimoro.utils;

import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * @ClassName TransactionManager
 * @Description TODO
 * @Author kimoro
 * @Date 2021/1/26 10:10
 * 和事务管理相关的工具类，它包含了开启事务、提交事务、回滚事务和释放连接
 **/
@Component("transactionManager")
@Aspect
public class TransactionManager {
    @Autowired
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* com.kimoro.service.impl.*.*(..))")
    private void pt1() {
    }

    @Before("pt1()")
    public void beginTransaction() {
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @AfterReturning("pt1()")
    public void commit() {
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @AfterThrowing("pt1()")
    public void rollback() {
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @After("pt1()")
    public void release() {
        try {
            connectionUtils.getThreadConnection().close();
            connectionUtils.removeConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
