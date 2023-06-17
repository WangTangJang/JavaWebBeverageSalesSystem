package com.beverage.dao;

import java.util.List;

import com.beverage.model.Product;
import com.beverage.model.User;

/**
 * 商品数据访问层接口
 */
public interface ProductDAO {

    /**
     * 添加商品
     * @param product 商品对象
     * @return 受影响的行数
     * @throws Exception 注册过程中发生的异常
     */
    public int addProduct(Product product) throws Exception;

    /**
     * 修改商品
     * @param product 商品对象
     * @return 受影响的行数
     * @throws Exception 注册过程中发生的异常
     */
    public int modifyProduct(Product product) throws Exception;

    /**
     * 删除商品
     * @param id 商品ID
     * @return 受影响的行数
     * @throws Exception 注册过程中发生的异常
     */
    public int delProduct(int id) throws Exception;

    /**
     * 查询所有的商品
     * @return 商品列表
     * @throws Exception 注册过程中发生的异常
     */
    public List<Product> findAll() throws Exception;

    /**
     * 根据ID查询商品信息
     * @param id 商品ID
     * @return 商品对象
     * @throws Exception 注册过程中发生的异常
     */
    public Product findProductById(int id) throws Exception;

    /**
     *
     * @param where 查询语句
     * @param page 页
     * @param pageSize 页大小
     * @return 查询结果集
     * @throws Exception 查询过程中发生的异常
     */
    public List<Product> findProductByPage(String where, int page, int pageSize) throws Exception;
}
