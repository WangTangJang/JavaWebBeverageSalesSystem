package com.dessert.dao;


import com.dessert.model.Order;

import java.util.List;

public interface OrderDAO {

    /**
     * 添加订单
     *
     * @param order
     * @return
     * @throws Exception
     */
    public int addOrder(Order order) throws Exception;
    /**
     * 修改订单
     *
     * @param order
     * @return
     * @throws Exception
     */
    public int modifyOrder(Order order) throws Exception;
    public List<Order> findAll() throws Exception;
    public Order findOrderById(int id) throws Exception;
    public int delOrder(int id) throws Exception;
}
