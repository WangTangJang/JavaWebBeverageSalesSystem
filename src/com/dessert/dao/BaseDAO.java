package com.dessert.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 数据库连接工具类
 */
public class BaseDAO {

    /**
     * 获取数据库连接
     * @return 数据库连接对象
     * @throws Exception 连接异常
     */
    public Connection getConnection() throws Exception {
        Connection conn;
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        Class.forName(JDBC_DRIVER);
        String DB_URL = "jdbc:mysql://localhost:3306/beverage?useUnicode=true&characterEncoding=utf-8";
        String DB_USER = "root";
        String DB_PASSWORD = "20020525";
        conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        return conn;
    }

    /**
     * 关闭数据库连接和相关资源
     * @param rs 结果集对象
     * @param ps 预编译语句对象
     * @param conn 数据库连接对象
     * @throws Exception 关闭异常
     */
    public void closeConnection(ResultSet rs, PreparedStatement ps, Connection conn) throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    /**
     * 通用的增、删、改方法
     * @param sql  SQL语句
     * @param params 参数数组
     * @return 执行结果
     * @throws Exception 执行异常
     */
    public int executeUpdate(String sql, Object[] params) throws Exception {
        int result = -1;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            if (params != null && params.length > 0) {
                conn = getConnection();
                ps = conn.prepareStatement(sql);
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
                result = ps.executeUpdate();
            }
        } finally {
            closeConnection(null, ps, conn);
        }
        return result;
    }
}
