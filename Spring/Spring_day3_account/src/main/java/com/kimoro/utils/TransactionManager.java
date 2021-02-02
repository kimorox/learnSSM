package com.kimoro.utils;

import java.sql.SQLException;

/**
 * @ClassName TransactionManager
 * @Description TODO
 * @Author kimoro
 * @Date 2021/1/26 10:10
 * 和事务管理相关的工具类，它包含了开启事务、提交事务、回滚事务和释放连接
 **/
public class TransactionManager {
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public void beginTransaction() {
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void commit() {
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void rollback() {
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void release() {
        try {
            connectionUtils.getThreadConnection().close();
            connectionUtils.removeConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
