package com.beverage.test;

import com.beverage.dao.impl.ProductDAOImpl;
import com.beverage.model.Product;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductDAOImplTest {

    @org.junit.jupiter.api.Test
    void findProductByPage() throws Exception {
        ProductDAOImpl productDAO = new ProductDAOImpl();
        List<Product> list = productDAO.findProductByPage(1,10);
        list.forEach(System.out::println);
    }
}