package com.beverage.dao;

import com.beverage.model.Shopping;

import java.util.List;


/**
 * 购物车数据访问层接口
 *
 * @author Administrator
 *
 */
public interface ShoppingDAO {
    /**
     * 根据用户ID和产品ID删除购物车记录

     * @param productId
     * @return
     * @throws Exception
     */
    public int delShopping( int productId) throws Exception;

    public int delShoppingBy2Id(int userId ,int productId) throws Exception;

    /**
     * 加入购物车
     *
     * @param shopping
     * @return
     * @throws Exception
     */
    public int addShopping(Shopping shopping) throws Exception;

    /**
     * 根据用户ID查询购物车
     *
     * @param userId
     * @return
     * @throws Exception
     */
    public List<Shopping> getShoppingByUserId(int userId) throws Exception;
}
