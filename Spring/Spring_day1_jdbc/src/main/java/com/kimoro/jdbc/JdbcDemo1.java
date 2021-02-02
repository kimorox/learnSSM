package com.kimoro.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @ClassName JdbcDemo1
 * @Description TODO
 * @Author kimoro
 * @Date 2021/1/23 14:52
 **/
public class JdbcDemo1 {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        //2.获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learnmybatis?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT&nullCatalogMeansCurrent=true", "root", "root");
        //3.获取操作数据库的预处理对象
        PreparedStatement preparedStatement = connection.prepareStatement("select * from account");
        //4.执行sql，得到结果集
        ResultSet resultSet = preparedStatement.executeQuery();
        //5.遍历结果集
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }
        //6.释放资源
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
