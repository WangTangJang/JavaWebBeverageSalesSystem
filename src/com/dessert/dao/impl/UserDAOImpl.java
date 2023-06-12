package com.dessert.dao.impl;

import com.dessert.dao.BaseDAO;
import com.dessert.dao.UserDAO;
import com.dessert.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class UserDAOImpl implements UserDAO {

    BaseDAO baseDAO=new BaseDAO();
    @Override
    public int register(User user) throws Exception {
        int result = -1;
        String sql = "INSERT INTO user(username, password, email) VALUES (?, ?, ?)";
        Object[] params = {user.getUsername(), user.getPassword(), user.getEmail()};
        result = baseDAO.executeUpdate(sql, params);
        return result;
    }
    @Override
    public User login(String loginName, String password) throws Exception {
        User user = null;
        Connection connection = baseDAO.getConnection();
        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, loginName);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
        }
        baseDAO.closeConnection(resultSet, preparedStatement, connection);
        return user;
    }
}
