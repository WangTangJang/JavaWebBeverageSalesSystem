package com.dessert.dao.impl;


import com.dessert.dao.BaseDAO;
import com.dessert.dao.OrderDetailDAO;

public class OrderDetailDAOImpl implements OrderDetailDAO {

    BaseDAO bd = new BaseDAO();

    @Override
    public int addOrderDetail(int orderId, int productId, int number, float cost) throws Exception {
        int r = -1;
        try {
            String sql = "insert into orderDetail(orderId,productId,quantity,cost) values(?,?,?,?)";

            Object param[] = { orderId, productId, number, cost };

            r = bd.executeUpdate(sql, param);

        } catch (Exception e) {
            throw e;
        }
        return r;

    }

}
