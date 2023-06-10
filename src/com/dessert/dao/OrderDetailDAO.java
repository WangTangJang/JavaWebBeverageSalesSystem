package com.dessert.dao;

public interface OrderDetailDAO {

    /**
     * 添加订单明细
     *
     * @param orderId
     * @param productId
     * @param number
     * @param cost
     * @return
     * @throws Exception
     */
    public int addOrderDetail(int orderId, int productId, int number, float cost) throws Exception;

}
