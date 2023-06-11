package com.dessert.dao.impl;
import com.dessert.dao.BaseDAO;
import com.dessert.dao.DessertDAO;
import com.dessert.model.Dessert;
import com.dessert.model.DessertPage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 * 甜品数据访问层实现类
 *
 * @author Administrator
 */
public class DessertDAOImpl implements DessertDAO {
    public static void main(String[] args) throws Exception {

    }
    BaseDAO baseDAO = new BaseDAO();
    Dessert dessert = new Dessert();
    @Override
    public int addDessert(Dessert dessert) throws Exception {
        int r = -1;
        String sql = "insert into DessertInfo(name,type,manufacturer,productionDate,productionAdd,price,stock) values(?,?,?,?,?,?,?)";
        Object[] param = {dessert.getName(), dessert.getType(), dessert.getManufacturer(), dessert.getProductionDate(), dessert.getProductionAdd(), dessert.getPrice(), dessert.getStock()};
        r = baseDAO.executeUpdate(sql, param);
        return r;
    }
    @Override
    public int modifyDessert(Dessert dessert) throws Exception {
        int r = -1;
        String sql = "update  DessertInfo set name=?,type=?,manufacturer=?,productionDate=?,productionAdd=?,price=?,stock=? where id=?";
        Object[] param = {dessert.getName(), dessert.getType(), dessert.getManufacturer(), dessert.getProductionDate(), dessert.getProductionAdd(), dessert.getPrice(), dessert.getStock(),dessert.getId()};
        r = baseDAO.executeUpdate(sql, param);
        return r;
    }
    @Override
    public int delDessert(int id) throws Exception {
        int r = -1;
        String sql = "delete from  DessertInfo where id=?";
        Object[] param = {id};
        r = baseDAO.executeUpdate(sql, param);
        return r;
    }
    @Override
    public List<Dessert> findAll() throws Exception {
        List<Dessert> list = new ArrayList<Dessert>();
        Connection conn = baseDAO.getConnection();
        String sql = "select * from Dessertinfo";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            dessert = new Dessert();
            dessert.setId(rs.getInt("id"));
            dessert.setName(rs.getString("name"));
            dessert.setType(rs.getString("type"));
            dessert.setManufacturer(rs.getString("manufacturer"));
            dessert.setProductionDate(rs.getDate("productionDate"));
            dessert.setProductionAdd(rs.getString("productionAdd"));
            dessert.setPrice(rs.getFloat("price"));
            dessert.setStock(rs.getInt("stock"));
            list.add(dessert);
        }
        baseDAO.closeConnection(rs, ps, conn);
        return list;
    }
    @Override
    public Dessert findDessertById(int id) throws Exception {
        Connection conn = baseDAO.getConnection();
        String sql = "select * from DessertInfo where id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            dessert.setId(rs.getInt("id"));
            dessert.setName(rs.getString("name"));
            dessert.setType(rs.getString("type"));
            dessert.setManufacturer(rs.getString("manufacturer"));
            dessert.setProductionDate(rs.getDate("productionDate"));
            dessert.setProductionAdd(rs.getString("productionAdd"));
            dessert.setPrice(rs.getFloat("price"));
            dessert.setStock(rs.getInt("stock"));
        }
        baseDAO.closeConnection(rs, ps, conn);
        return dessert;
    }
    @Override
    public DessertPage findDessertsByPage(String where,int pageNum, int pageSize) throws Exception {
        int offset = (pageNum - 1) * pageSize; // 计算偏移量
        Connection conn = baseDAO.getConnection();
        // 使用合适的查询语句从数据库中获取分页数据
        String sql = "SELECT * FROM dessertinfo where 1=1"+where+" LIMIT ?, ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, offset);
        statement.setInt(2, pageSize);
        ResultSet rs = statement.executeQuery();
        List<Dessert> dessertList = new ArrayList<>();
        while (rs.next()) {
            // 从结果集中提取数据并创建 Dessert 对象
            Dessert dessert = new Dessert();
            dessert.setId(rs.getInt("id"));
            dessert.setName(rs.getString("name"));
            dessert.setType(rs.getString("type"));
            dessert.setManufacturer(rs.getString("manufacturer"));
            dessert.setProductionDate(rs.getDate("productionDate"));
            dessert.setProductionAdd(rs.getString("productionAdd"));
            dessert.setPrice(rs.getFloat("price"));
            dessert.setStock(rs.getInt("stock"));
            dessertList.add(dessert);
        }
        sql = "SELECT COUNT(*) AS total FROM DessertInfo WHERE 1=1"+where+"";
        statement = conn.prepareStatement(sql);
        rs = statement.executeQuery();
        int totalRecords = 0;
        if (rs.next()) {
            totalRecords = rs.getInt("total");
        }
        DessertPage dessertPage = new DessertPage(dessertList,totalRecords);
        // 关闭资源，如 statement、resultSet 等
        conn.close();
        return dessertPage;
    }

}
