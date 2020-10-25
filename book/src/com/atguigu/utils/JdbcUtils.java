package com.atguigu.utils;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();

    static {
        try {
            //创建属性配置类
            Properties properties = new Properties();

            //从src源码目录下读取jdbc.properties
            InputStream resourceAsStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");

            // 从流中加载键值对
            properties.load(resourceAsStream);

            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);

            // System.out.println(dataSource.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * 从数据库连接池中获取链接
     * @return 返回null 说明获取失败，有值就代表获取成功
     */
    public static Connection getConnection (){
        Connection connection = conns.get();
        if (connection == null) {
            try {
                //从数据库连接池中获取连接
                connection = dataSource.getConnection();
                //设置手动提交事务
                connection.setAutoCommit(false);
                //保存到ThreadLocal 中，共享
                conns.set(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    /**
     * 提交事务并关闭连接
     */
    public static void commitAndClose (){
        Connection conn = conns.get();

        if (conn != null){
            try {
                conn.commit();//提交事务
                conn.close();//关闭连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        conns.remove();
    }

    /**
     * 回滚事务并关闭连接
     */
    public static void rollbackAndClose (){
        Connection conn = conns.get();

        if (conn != null){
            try {
                conn.rollback();//回滚事务
                conn.close();//关闭连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        conns.remove();
    }
}
