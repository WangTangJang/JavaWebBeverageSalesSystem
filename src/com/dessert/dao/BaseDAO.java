package com.dessert.dao;

import org.apache.taglibs.standard.tag.common.sql.DataSourceUtil;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * 数据库连接工具类
 */
public class BaseDAO {

    private static String driver;
    private static String url;
    private static String user;
    private static String password;
    static {
        init();
    }

    private static void init(){
        Properties properties = new Properties();
        String configFile = "/com/dessert/util/database.properties";
        InputStream is = DataSourceUtil.class.getClassLoader().getResourceAsStream(configFile);
        try {
            properties.load(is);

        } catch (IOException e) {
            e.printStackTrace();
        }
        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        user = properties.getProperty("username");
        password = properties.getProperty("password");
    }

    /**
     * 获取数据库连接
     * @return 数据库连接对象
     * @throws Exception 连接异常
     */
    public Connection getConnection() throws Exception {
        Connection conn;
        Class.forName(driver);
        conn = DriverManager.getConnection(url, user, password);
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
