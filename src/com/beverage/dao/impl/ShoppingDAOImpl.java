package com.beverage.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.beverage.dao.BaseDAO;
import com.beverage.dao.ShoppingDAO;
import com.beverage.model.Shopping;

/**
 * 购物车数据访问层实现类
 *
 * @author Administrator
 *
 */
public class ShoppingDAOImpl implements ShoppingDAO {

    BaseDAO bd = new BaseDAO();

    public static void main(String[] args) {

        try {
            System.out.println(new ShoppingDAOImpl().getShoppingByUserId(2));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * 加入购物车
     *
     * @param shopping
     * @return
     * @throws Exception
     */
    @Override
    public int addShopping(Shopping shopping) throws Exception {
        String sql = "insert into Shopping(productid,userid,number,createTime) values(?,?,?,?)";
        Object[] param = { shopping.getProductid(), shopping.getUserid(), shopping.getNumber(), new Date() };
        int r = bd.executeUpdate(sql, param);
        return r;
    }

    @Override
    /**
     * 根据用户ID查询购物车
     *
     * @param userId
     * @return
     * @throws Exception
     */
    public List<Shopping> getShoppingByUserId(int userId) throws Exception {

        List<Shopping> list = new ArrayList<Shopping>();

        try {
            Connection conn = bd.getConnection();

            String sql = " select a.shoppingid,a.productid,b.`name`,b.price,b.fileName,b.stock,a.number, a.userid,a.createTime,c.userName from shopping a,product b ,user c where a.productid=b.id and a.userid=c.id and a.userId=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Shopping shopping = new Shopping();
                shopping.setCreateTime(rs.getDate("createTime"));
                shopping.setName(rs.getString("name"));
                shopping.setNumber(rs.getInt("number"));
                shopping.setPrice(rs.getFloat("price"));
                shopping.setProductid(rs.getInt("productId"));
                shopping.setShoppingid(rs.getInt("shoppingid"));
                shopping.setStock(rs.getInt("stock"));
                shopping.setUserid(rs.getInt("userid"));
                shopping.setUserName(rs.getString("userName"));
                shopping.setFileName(rs.getString("fileName"));
                list.add(shopping);
            }
            bd.closeConnection(rs, ps, conn);
        } catch (Exception e) {
            throw e;
        }
        return list;
    }
    @Override
    public int delShopping( int productId) throws Exception {
        String sql = "delete from shopping where  shoppingid=?  ";
        Object[] param = { productId };
        int r = bd.executeUpdate(sql, param);
        return r;
    }
    @Override
    public int delShoppingBy2Id(int userId ,int productId) throws Exception {
        String sql = "delete from shopping where  userId=?  and productId =?";
        Object[] param = {userId, productId };
        int r = bd.executeUpdate(sql, param);
        return r;
    }
}