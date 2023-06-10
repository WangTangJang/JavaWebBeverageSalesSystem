package com.dessert.dao;

import com.dessert.model.User;

import java.util.List;

/**
 * 用户数据访问层接口
 */
public interface UserDAO {

    /**
     * 用户注册
     * @param user 用户对象，包含注册所需的用户信息
     * @return 返回注册结果，成功返回大于 0 的整数，失败返回小于等于 0 的整数
     * @throws Exception 注册过程中发生的异常
     */
    public int register(User user) throws Exception;

    /**
     * 用户登录
     * @param loginName 用户登录名
     * @param password 用户密码
     * @return 返回登录成功后的用户对象
     * @throws Exception 登录过程中发生的异常
     */
    public User login(String loginName, String password) throws Exception;
    public int delUser(int id) throws Exception;
    public List<User> findAll()throws Exception;
    public int modifyUser(User user) throws Exception;
    public User findUserById(int id) throws Exception;
}

