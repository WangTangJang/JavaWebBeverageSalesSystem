package com.dessert.service.impl;
import com.dessert.dao.BaseDAO;
import com.dessert.dao.DessertDAO;
import com.dessert.dao.impl.DessertDAOImpl;
import com.dessert.model.Dessert;
import com.dessert.model.DessertPage;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 *
 * @author Administrator
 */
public class DessertServiceDAOImpl implements DessertDAO {
    public static void main(String[] args) throws Exception {
    }
    BaseDAO baseDAO = new BaseDAO();
    Dessert dessert = new Dessert();
    DessertDAOImpl dessertDAO = new DessertDAOImpl();
    @Override
    public int addDessert(Dessert dessert) throws Exception {
        int r = -1;
        r=dessertDAO.addDessert(dessert);
        return r;
    }
    @Override
    public int modifyDessert(Dessert dessert) throws Exception {
        int r = -1;
        r=dessertDAO.modifyDessert(dessert);
        return r;
    }
    @Override
    public int delDessert(int id) throws Exception {
        int r = -1;
        r=dessertDAO.delDessert(id);
        return r;
    }
    @Override
    public List<Dessert> findAll() throws Exception {
        List<Dessert> list = new ArrayList<Dessert>();
        list = dessertDAO.findAll();
        return list;
    }
    @Override
    public Dessert findDessertById(int id) throws Exception {
        dessert  = dessertDAO.findDessertById(id);
        return dessert;
    }

    @Override
    public DessertPage findDessertsByPage(String where,int pageNum, int pageSize) throws Exception {
        return dessertDAO.findDessertsByPage(where,pageNum,pageSize);
    }
}
