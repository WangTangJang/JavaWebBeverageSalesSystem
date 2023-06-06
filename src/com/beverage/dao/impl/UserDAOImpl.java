package com.beverage.dao.impl;

import com.beverage.dao.BaseDAO;
import com.beverage.dao.UserDAO;
import com.beverage.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAOImpl implements UserDAO {
//    public static void main(String[] args) throws Exception {
//        UserDAOImpl userDAO = new UserDAOImpl();
//        User user = new User();
//        user = userDAO.login("user1","password1");
//        System.out.println(user.getAddress());
//    }
    BaseDAO baseDAO=new BaseDAO();
    @Override
    public int register(User user) throws Exception {
        int result = -1;
        try {
            String sql = "INSERT INTO user(username, password, email, fullName, address, phoneNumber, type, active) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            Object[] params = {user.getUsername(), user.getPassword(), user.getEmail(), user.getFullName(), user.getAddress(), user.getPhoneNumber(), user.getType(), user.isActive()};
            result = baseDAO.executeUpdate(sql, params);
        } catch (Exception e) {
            throw e;
        }
        return result;
    }

    @Override
    public User login(String loginName, String password) throws Exception {
        User user = null;
        try {
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
                user.setFullName(resultSet.getString("fullName"));
                user.setAddress(resultSet.getString("address"));
                user.setPhoneNumber(resultSet.getString("phoneNumber"));
                user.setType(resultSet.getString("type"));
                user.setActive(resultSet.getBoolean("active"));
            }
            baseDAO.closeConnection(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            throw e;
        }
        return user;
    }
}
