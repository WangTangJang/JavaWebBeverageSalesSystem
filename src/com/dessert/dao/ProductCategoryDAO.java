package com.dessert.dao;



import com.dessert.model.ProductCategory;

import java.util.List;


public interface ProductCategoryDAO {

    /**
     * 根据父级ID查询分类信息
     * @param parentId
     * @return
     * @throws Exception
     */
    public List<ProductCategory> getCategroyByParnetId(int parentId)throws Exception;
    /**
     * 根据ID查询分类信息
     * @param id
     * @return
     * @throws Exception
     */
    public ProductCategory getCategroyById(int id)throws Exception;



}
