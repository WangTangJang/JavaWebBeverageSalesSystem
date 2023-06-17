package com.beverage.servlet;

import com.beverage.dao.impl.NewsDAOImpl;
import com.beverage.dao.impl.ProductCategoryDAOImpl;
import com.beverage.dao.impl.ProductDAOImpl;
import com.beverage.model.News;
import com.beverage.model.Product;
import com.beverage.model.ProductCategory;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 引入新闻业务逻辑层
     */
    NewsDAOImpl newsDAO = new NewsDAOImpl();

    /**
     * 引入产品业务逻辑层
     */
    ProductDAOImpl productDAO = new ProductDAOImpl();

    /**
     * 分类业务逻辑层
     */
    ProductCategoryDAOImpl productCategoryDAO = new ProductCategoryDAOImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            List<News> listNews = newsDAO.findAll();

            request.setAttribute("listNews", listNews);

            List<ProductCategory> listCategroy = productCategoryDAO.getCategroyByParnetId(0);
            request.getSession().setAttribute("listCategroy", listCategroy);

            ProductServlet productServlet = new ProductServlet();
            productServlet.findProductByPage(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
