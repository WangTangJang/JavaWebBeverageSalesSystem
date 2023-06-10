package com.dessert.dao.impl;

import com.dessert.dao.BaseDAO;
import com.dessert.dao.ProductCategoryDAO;
import com.dessert.model.ProductCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProductCategoryDAOImpl implements ProductCategoryDAO {
    public static void main(String[] args) throws Exception {
        ProductCategoryDAOImpl productCategoryDAO = new ProductCategoryDAOImpl();
        ProductCategory productCategory = new ProductCategory();
        productCategory=productCategoryDAO.getCategroyById(2);
        System.out.println(productCategory.getName());
    }
    BaseDAO bd = new BaseDAO();
    /**
     * 根据父级ID查询分类信息
     *
     * @param parentId
     * @return
     * @throws Exception
     */
    @Override
    public List<ProductCategory> getCategroyByParnetId(int parentId) throws Exception {
        List<ProductCategory> list = new ArrayList<ProductCategory>();
        try {
            Connection conn = bd.getConnection();
            String sql = "select * from productCategory where parentId=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, parentId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ProductCategory epc = new ProductCategory();
                epc.setId(rs.getInt("id"));
                epc.setName(rs.getString("name"));
                epc.setParentId(rs.getInt("parentId"));
                epc.setType(rs.getInt("type"));
                epc.setSecondCategroy(getCategroyByParnetId(epc.getId()));
                list.add(epc);
            }
            bd.closeConnection(rs, ps, conn);

        } catch (Exception e) {
            throw e;
        }
        return list;
    }

    /**
     * 根据ID查询分类信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public ProductCategory getCategroyById(int id) throws Exception {
        ProductCategory epc = null;
        try {
            Connection conn = bd.getConnection();
            String sql = "select * from productCategory where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                epc = new ProductCategory();
                epc.setId(rs.getInt("id"));
                epc.setName(rs.getString("name"));
                epc.setParentId(rs.getInt("parentId"));
                epc.setType(rs.getInt("type"));
            }
            bd.closeConnection(rs, ps, conn);

        } catch (Exception e) {
            throw e;
        }
        return epc;
    }

}
