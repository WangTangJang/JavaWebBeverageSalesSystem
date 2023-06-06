package com.beverage.servlet;

import com.beverage.dao.impl.NewsDAOImpl;
import com.beverage.dao.impl.ProductCategoryDAOImpl;
import com.beverage.dao.impl.ProductDAOImpl;
import com.beverage.model.News;
import com.beverage.model.Product;
import com.beverage.model.ProductCategory;

import java.io.IOException;
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

            /**
             * 查询新闻
             */
            List<News> listNews = newsDAO.findAll();

            request.setAttribute("listNews", listNews);

            /**
             * 查询产品
             */
            List<Product> listProduct = productDAO.findAll();

            request.setAttribute("listProduct", listProduct);

            /**
             * 分类信息
             */
            List<ProductCategory> listCategroy = productCategoryDAO.getCategroyByParnetId(0);

            request.getSession().setAttribute("listCategroy", listCategroy);

            request.getRequestDispatcher("dynamicPage/Index.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
