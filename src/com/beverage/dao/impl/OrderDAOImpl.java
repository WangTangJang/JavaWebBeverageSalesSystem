package com.beverage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.beverage.dao.BaseDAO;
import com.beverage.dao.OrderDAO;
import com.beverage.model.Order;

public class OrderDAOImpl implements OrderDAO {

    BaseDAO bd = new BaseDAO();

    /**
     * 插入订单
     * @param order 订单实体
     * @return 插入结果
     * @throws Exception 如果插入订单时发生异常
     */
    @Override
    public int addOrder(Order order) throws Exception {
        int r;
        String sql = "insert into orders(id,userId,loginName,userAddress,createTime,cost,serialNumber)values(?,?,?,?,?,?,?)";
        Object[] param = {order.getId(), order.getUserId(), order.getLoginName(), order.getUserAddress(), new Date(), order.getCost(),
                order.getSerialNumber() };
        r = bd.executeUpdate(sql, param);
        return r;
    }
    public Order findOrderById(int id) throws Exception {
        Order order = new Order();
        Connection conn = bd.getConnection();
        String sql = "select * from orders where id=?";
        sql = "select * from product where id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1, id);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            order.setId(resultSet.getInt("id"));
            order.setUserId(resultSet.getInt("userId"));
            order.setLoginName(resultSet.getString("loginName"));
            order.setUserAddress(resultSet.getString("userAddress"));
            order.setCreateTime(resultSet.getDate("createTime"));
            order.setCost(resultSet.getFloat("cost"));
            order.setSerialNumber(resultSet.getString("serialNumber"));
        }
        bd.closeConnection(resultSet, ps, conn);
        return order;
    }
    @Override
    public int modifyOrder(Order order) throws Exception {
        int r = -1;
        try {
            String sql = "update   orders set cost=? where id=?";
            Object[] param = { order.getCost(), order.getId() };
            r = bd.executeUpdate(sql, param);
        } catch (Exception e) {
            throw e;
        }
        return r;
    }
    @Override
    public List<Order> findAll() throws Exception {

        List<Order> list = new ArrayList<Order>();

        try {
            Connection conn = bd.getConnection();
            String sql = "select * from orders order by id desc";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setUserId(resultSet.getInt("userId"));
                order.setLoginName(resultSet.getString("loginName"));
                order.setUserAddress(resultSet.getString("userAddress"));
                order.setCreateTime(resultSet.getDate("createTime"));
                order.setCost(resultSet.getFloat("cost"));
                order.setSerialNumber(resultSet.getString("serialNumber"));
                list.add(order);
            }
            bd.closeConnection(resultSet, ps, conn);
        } catch (Exception e) {
            throw e;
        }
        return list;
    }
    public int delOrder(int id) throws Exception{
        int r = -1;
        try {
            String sql = "delete from  orders where id=?";
            Object param[] = {id};
            r = bd.executeUpdate(sql, param);
        } catch (Exception e) {
            throw e;
        }
        return r;
    }

}
