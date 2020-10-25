package com.atguigu.dao.impl;

import com.atguigu.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BaseDao {
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * 执行insert,update,delete 语句
     *
     * @param sql sql语句
     * @param args sql参数值
     * @return
     */
    public int update(String sql,Object ...args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection,sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     *执行只返回一个bean对象的select语句
     * @param type  返回的对象的具体类型
     * @param sql   sql语句
     * @param args  sql的参数值
     * @param <T>   查询返回的Java的具体类型
     * @return 返回null,说明查询失败 <br/> 有值则成功
     */
    public <T>T queryOne(Class<T> type, String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new BeanHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     *执行返回一个bean对象集合的select语句
     * @param type  返回的对象的具体类型
     * @param sql   sql语句
     * @param args  sql的参数值
     * @param <T>   查询返回的Java的具体类型
     * @return 返回null,说明查询失败 <br/> 有值则成功
     */
    public <T> List<T> queryList(Class<T> type, String sql, Object... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new BeanListHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     *执行只需要返回某列数据的select语句
     * @param sql   sql语句
     * @param args  sql的参数值
     * @return 返回null,说明查询失败 <br/> 有值则成功
     */
    public Object queryForSingleValue(String sql ,Object ... args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn,sql,new ScalarHandler(),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
