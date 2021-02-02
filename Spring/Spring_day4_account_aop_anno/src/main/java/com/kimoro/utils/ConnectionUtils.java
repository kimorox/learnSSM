package com.kimoro.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @ClassName ConnectionUtils
 * @Description TODO
 * @Author kimoro
 * @Date 2021/1/26 9:58
 * 连接工具类,它用于从数据源中获取一个连接，并且实现和线程的绑定
 **/
@Component("connectionUtils")
public class ConnectionUtils {
    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    @Autowired
    private DataSource dataSource;

    public Connection getThreadConnection() {
        try {
            //1.先从ThreadLocal上获取
            Connection connection = tl.get();
            //2.判断当前线程上是否有连接
            if (connection == null) {
                //3.从数据源中获取一个连接，并且存入ThreadLocal中
                connection = dataSource.getConnection();
                tl.set(connection);
            }
            //4.返回当前线程上的连接
            return connection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 把连接和线程解绑
     */
    public void removeConnection(){
        tl.remove();
    }
}
