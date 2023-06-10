package com.dessert.servlet;
import com.dessert.dao.impl.ShoppingDAOImpl;
import com.dessert.model.Product;
import com.dessert.model.Shopping;
import com.dessert.model.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ShoppingServlet")
public class ShoppingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        doPost(request, response);
    }

    ShoppingDAOImpl shoppingDAO = new ShoppingDAOImpl();
    /**
     * 加入购物车
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void addShopping(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        User users = (User) request.getSession().getAttribute("USERS");

        if (users == null) {
            out.print("<script>alert('您还没有登录');location.href='dynamicPage/Login.jsp';</script>");
        } else {
            /**
             * 商品ID
             */
            String productId = request.getParameter("productId");

            int number = 1;

            Shopping shopping = new Shopping();
            shopping.setProductid(Integer.parseInt(productId));
            shopping.setUserid(users.getId());
            shopping.setNumber(1);
            try {
                int r = shoppingDAO.addShopping(shopping);
                if (r > 0) {
                    out.print(
                            "<script>alert('添加购物车成功');location.href='ShoppingServlet?op=showShopping';</script>");
                } else {
                    out.print("<script>alert('添加购物车失败');location.href='IndexServlet';</script>");
                }
            } catch (Exception e) {
                out.print("<script>alert('添加购物车失败');location.href='IndexServlet';</script>");
                e.printStackTrace();
            }
        }
    }

    protected void showShopping(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        User users = (User) request.getSession().getAttribute("USERS");

        if (users == null) {
            out.print("<script>alert('您还没有登录');location.href='dynamicPage/Login.jsp';</script>");
        } else {

            try {
                List list = shoppingDAO.getShoppingByUserId(users.getId());

                request.setAttribute("list", list);

                request.getRequestDispatcher("/dynamicPage/Shopping.jsp").forward(request, response);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    protected void delShopping(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        User users = (User) request.getSession().getAttribute("USERS");
        String productId = request.getParameter("id");
        Product product = new Product();
        product.setId(Integer.parseInt(productId));
        if (users == null) {
            out.print("<script>alert('您还没有登录');location.href='/dynamicPage/Shopping.jsp';</script>");
        } else {

            try {
                int r = shoppingDAO.delShopping(product.getId());

                if (r > 0) {
                    out.print("<script>alert('删除成功');location.href='ShoppingServlet?op=showShopping';</script>");
                } else {
                    out.print("<script>alert('删除失败');location.href='ShoppingServlet?op=showShopping';</script>");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String op = request.getParameter("op");
        switch (op) {
            case "addShopping":
                addShopping(request, response);
                break;
            case "showShopping":
                showShopping(request, response);
                break;
            case "delShopping":
                delShopping(request, response);
                break;
        }

    }

}
