package com.dessert.service;

import java.util.List;
import com.dessert.model.Dessert;
import com.dessert.model.DessertPage;

/**
 * 甜品数据访问层接口
 */
public interface DessertServiceDAO {

    /**
     * 添加甜品
     * @param dessert 甜品对象
     * @return 受影响的行数
     * @throws Exception 注册过程中发生的异常
     */
    public int addDessert(Dessert dessert) throws Exception;

    /**
     * 修改甜品
     * @param dessert 甜品对象
     * @return 受影响的行数
     * @throws Exception 注册过程中发生的异常
     */
    public int modifyDessert(Dessert dessert) throws Exception;

    /**
     * 删除甜品
     * @param id 甜品ID
     * @return 受影响的行数
     * @throws Exception 注册过程中发生的异常
     */
    public int delDessert(int id) throws Exception;

    /**
     * 查询所有的甜品
     * @return 甜品列表
     * @throws Exception 注册过程中发生的异常
     */
    public List<Dessert> findAll() throws Exception;

    /**
     * 根据ID查询甜品信息
     * @param id 甜品ID
     * @return 甜品对象
     * @throws Exception 注册过程中发生的异常
     */
    public Dessert findDessertById(int id) throws Exception;
    /**
     * 查询指定页数的甜品列表
     * @param pageNum 当前页数
     * @param pageSize 每页记录数
     * @return 甜品列表
     * @throws Exception 查询过程中发生的异常
     */
    public DessertPage findDessertsByPage(int pageNum, int pageSize) throws Exception;

}
