package com.beverage.dao.impl;

import com.beverage.dao.BaseDAO;
import com.beverage.dao.ProductDAO;
import com.beverage.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品数据访问层实现类
 *
 * @author Administrator
 */
public class ProductDAOImpl implements ProductDAO {
    BaseDAO bd = new BaseDAO();

    @Override
    public int addProduct(Product ep) throws Exception {
        int r;
        String sql = "insert into product(name,description,price,stock,categoryLevel1Id,categoryLevel2Id,categoryLevel3Id,fileName,isDelete) values(?,?,?,?,?,?,?,?,?)";
        Object[] param = {ep.getName(), ep.getDescription(), ep.getPrice(), ep.getStock(), ep.getCategoryLevel1Id(), ep.getCategoryLevel2Id(), ep.getCategoryLevel3Id(), ep.getFileName(), ep.getIsDelete()};
        r = bd.executeUpdate(sql, param);
        return r;
    }

    @Override
    public int modifyProduct(Product product) throws Exception {
        int r;
        String sql = "update  product set name=?,description=?,price=?,stock=?,categoryLevel1Id=?,categoryLevel2Id=?,categoryLevel3Id=?,fileName=?,isDelete=? where id=?";
        Object[] param = {product.getName(), product.getDescription(), product.getPrice(), product.getStock(), product.getCategoryLevel1Id(), product.getCategoryLevel2Id(), product.getCategoryLevel3Id(), product.getFileName(), product.getIsDelete(), product.getId()};
        r = bd.executeUpdate(sql, param);
        return r;
    }

    @Override
    public int delProduct(int id) throws Exception {
        int r;
        String sql = "delete from  product where id=?";
        Object[] param = {id};
        r = bd.executeUpdate(sql, param);
        return r;
    }

    @Override
    public List<Product> findAll() throws Exception {
        List<Product> list = new ArrayList<>();
        Connection conn = bd.getConnection();
        String sql = "select * from product";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Product ep = new Product();
            createProductFromResultSet(ep, rs);
            list.add(ep);
        }
        bd.closeConnection(rs, ps, conn);
        return list;
    }

    @Override
    public Product findProductById(int id) throws Exception {
        Product product = null;
        Connection conn = bd.getConnection();
        String sql = "select * from product where id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            product = new Product();
            createProductFromResultSet(product, rs);
        }
        bd.closeConnection(rs, ps, conn);

        return product;
    }

    @Override
    public List<Product> findProductByPage(String where, int page, int pageSize) throws Exception {
        List<Product> list = new ArrayList<>();
        Connection connection = bd.getConnection();
        String sql = "select * from product where 1=1 "+where +" limit ?,?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, (page - 1) * pageSize);
        ps.setInt(2, pageSize);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Product product = new Product();
            createProductFromResultSet(product, rs);
            list.add(product);
        }
        String sql1 = "select count(*) count from product where 1=1 "+where +"";
        PreparedStatement ps1 = connection.prepareStatement(sql1);
        ResultSet rs1 = ps1.executeQuery();
        while (rs1.next()) {
            if (list.size() != 0) {
                list.get(0).setCount(rs1.getInt("count"));
            }
        }
        bd.closeConnection(rs, ps, connection);
        return list;
    }

    private void createProductFromResultSet(Product product, ResultSet rs) throws SQLException {
        product.setCategoryLevel1Id(rs.getInt("categoryLevel1Id"));
        product.setCategoryLevel2Id(rs.getInt("categoryLevel2Id"));
        product.setCategoryLevel3Id(rs.getInt("categoryLevel3Id"));
        product.setDescription(rs.getString("description"));
        product.setFileName(rs.getString("fileName"));
        product.setId(rs.getInt("id"));
        product.setIsDelete(rs.getInt("isDelete"));
        product.setName(rs.getString("name"));
        product.setPrice(rs.getFloat("price"));
        product.setStock(rs.getInt("stock"));
    }
}
