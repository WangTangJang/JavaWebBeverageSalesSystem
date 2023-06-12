package com.dessert.service.impl;

import com.dessert.dao.impl.UserDAOImpl;
import com.dessert.model.User;
import com.dessert.service.UserServiceDAO;

public class UserServiceDAOImpl implements UserServiceDAO {
    UserDAOImpl userDAO = new UserDAOImpl();
    User user =new User();
    @Override
    public int register(User user) throws Exception {
        int i;
        i= userDAO.register(user);
        return i;
    }

    @Override
    public User login(String loginName, String password) throws Exception {
        user = userDAO.login(loginName,password);
        return user;
    }
}
