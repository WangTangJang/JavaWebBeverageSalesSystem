package com.beverage.dao.impl;

import com.beverage.dao.BaseDAO;
import com.beverage.dao.ProductDAO;
import com.beverage.model.Product;
import com.beverage.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品数据访问层实现类
 *
 * @author Administrator
 */
public class ProductDAOImpl implements ProductDAO {
    public static void main(String[] args) throws Exception {
        ProductDAOImpl productDAO = new ProductDAOImpl();
        Product product = new Product();
        product.setId(5);
        product.setName("可乐");
        product.setDescription("xxx");
        product.setCategoryLevel1Id(11);
        product.setStock(100);
        product.setIsDelete(12);
        product.setFileName("xxxx");
        product.setCategoryLevel2Id(3);
        product.setCategoryLevel3Id(10);
        product.setPrice(100);
//        productDAO.addProduct(product);
//        productDAO.delProduct(6);
//        productDAO.modifyProduct(product);

//        product=productDAO.findProductById(5);
//        System.out.println(product.toString());
//        List<Product> list=productDAO.findAll();
//
//        for(Product ep:list)
//        {
//            System.out.println(ep.getName()+"\n");
//        }
    }
    BaseDAO bd = new BaseDAO();
    @Override
    public int addProduct(Product ep) throws Exception {
        int r = -1;

        String sql = "insert into product(name,description,price,stock,categoryLevel1Id,categoryLevel2Id,categoryLevel3Id,fileName,isDelete) values(?,?,?,?,?,?,?,?,?)";
        Object[] param = {ep.getName(), ep.getDescription(), ep.getPrice(), ep.getStock(), ep.getCategoryLevel1Id(), ep.getCategoryLevel2Id(), ep.getCategoryLevel3Id(), ep.getFileName(), ep.getIsDelete()};
        r = bd.executeUpdate(sql, param);
        return r;
    }
    @Override
    public int modifyProduct(Product ep) throws Exception {
        int r = -1;

        String sql = "update  product set name=?,description=?,price=?,stock=?,categoryLevel1Id=?,categoryLevel2Id=?,categoryLevel3Id=?,fileName=?,isDelete=? where id=?";
        Object[] param = {ep.getName(), ep.getDescription(), ep.getPrice(), ep.getStock(), ep.getCategoryLevel1Id(), ep.getCategoryLevel2Id(), ep.getCategoryLevel3Id(), ep.getFileName(), ep.getIsDelete(), ep.getId()};

        r = bd.executeUpdate(sql, param);

        return r;
    }

    @Override
    public int delProduct(int id) throws Exception {
        int r = -1;

        try {

            String sql = "delete from  product where id=?";


            Object param[] = {id};


            r = bd.executeUpdate(sql, param);

        } catch (Exception e) {
            throw e;
        }
        return r;
    }


    @Override
    public List<Product> findAll() throws Exception {
        List<Product> list = new ArrayList<Product>();

        try {
            Connection conn = bd.getConnection();
            String sql = "select * from product";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product ep = new Product();
                ep.setCategoryLevel1Id(rs.getInt("categoryLevel1Id"));
                ep.setCategoryLevel2Id(rs.getInt("categoryLevel2Id"));
                ep.setCategoryLevel3Id(rs.getInt("categoryLevel3Id"));
                ep.setDescription(rs.getString("description"));
                ep.setFileName(rs.getString("fileName"));
                ep.setId(rs.getInt("id"));
                ep.setIsDelete(rs.getInt("isDelete"));
                ep.setName(rs.getString("name"));
                ep.setPrice(rs.getFloat("price"));
                ep.setStock(rs.getInt("stock"));
                list.add(ep);
            }
            bd.closeConnection(rs, ps, conn);

        } catch (Exception e) {
            throw e;
        }
        return list;
    }


    @Override
    public Product findProductById(int id) throws Exception {
        Product ep = null;
        try {
            Connection conn = bd.getConnection();
            String sql = "select * from product where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ep = new Product();
                ep.setCategoryLevel1Id(rs.getInt("categoryLevel1Id"));
                ep.setCategoryLevel2Id(rs.getInt("categoryLevel2Id"));
                ep.setCategoryLevel3Id(rs.getInt("categoryLevel3Id"));
                ep.setDescription(rs.getString("description"));
                ep.setFileName(rs.getString("fileName"));
                ep.setId(rs.getInt("id"));
                ep.setIsDelete(rs.getInt("isDelete"));
                ep.setName(rs.getString("name"));
                ep.setPrice(rs.getFloat("price"));
                ep.setStock(rs.getInt("stock"));

            }
            bd.closeConnection(rs, ps, conn);

        } catch (Exception e) {
            throw e;
        }
        return ep;
    }

    @Override
    public List<Product> findProductByCategory(int secondCategory) throws Exception {
        List<Product> list = new ArrayList<Product>();

        try {
            Connection conn = bd.getConnection();
            String sql = "select * from product where categoryLevel2Id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, secondCategory);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product ep = new Product();
                ep.setCategoryLevel1Id(rs.getInt("categoryLevel1Id"));
                ep.setCategoryLevel2Id(rs.getInt("categoryLevel2Id"));
                ep.setCategoryLevel3Id(rs.getInt("categoryLevel3Id"));
                ep.setDescription(rs.getString("description"));
                ep.setFileName(rs.getString("fileName"));
                ep.setId(rs.getInt("id"));
                ep.setIsDelete(rs.getInt("isDelete"));
                ep.setName(rs.getString("name"));
                ep.setPrice(rs.getFloat("price"));
                ep.setStock(rs.getInt("stock"));
                list.add(ep);
            }
            bd.closeConnection(rs, ps, conn);

        } catch (Exception e) {
            throw e;
        }
        return list;
    }

}
