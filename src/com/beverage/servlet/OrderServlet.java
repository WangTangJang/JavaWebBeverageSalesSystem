package com.beverage.servlet;

import com.beverage.dao.impl.OrderDAOImpl;
import com.beverage.dao.impl.OrderDetailDAOImpl;
import com.beverage.dao.impl.ProductDAOImpl;
import com.beverage.dao.impl.ShoppingDAOImpl;
import com.beverage.model.Order;
import com.beverage.model.Product;
import com.beverage.model.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/orderServlet")
public class OrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    ShoppingDAOImpl shoppingDAO = new ShoppingDAOImpl();
    ProductDAOImpl productDAO = new ProductDAOImpl();
    OrderDAOImpl orderDAO = new OrderDAOImpl();
    OrderDetailDAOImpl orderDetailDAO = new OrderDetailDAOImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        doPost(request, response);
    }
    protected void findAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Order> list = orderDAO.findAll();
            request.setAttribute("list", list);
            request.getRequestDispatcher("dynamicPage/Mange/Orders.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void findUserById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        try {
            Order user = orderDAO.findOrderById(Integer.parseInt(id));
            request.setAttribute("user", user);
            request.getRequestDispatcher("/dynamicPage/Mange/OrderModify.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void modifyUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String userId = request.getParameter("userId");
        String loginName = request.getParameter("loginName");
        String userAddress = request.getParameter("userAddress");
        String createTime = request.getParameter("createTime");
        String cost = request.getParameter("cost");
        String serialNumber = request.getParameter("serialNumber");
        String id = request.getParameter("id");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = dateFormat.parse(request.getParameter("createTime"));

        Order order = new Order();
        order.setUserId(Integer.parseInt(userId));
        order.setLoginName(loginName);
        order.setUserAddress(userAddress);
        order.setCreateTime(time);
        order.setCost(Float.parseFloat(cost));
        order.setSerialNumber(serialNumber);
        order.setId(Integer.parseInt(id));
        try {
            int r = orderDAO.modifyOrder(order);
            if (r > 0) {
                out.print("<script>alert('修改成功');location.href='orderServlet?op=findAll';</script>");
            } else {
                out.print("<script>alert('修改失败');location.href='orderServlet?op=findAll';</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void delOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String idString = request.getParameter("id");
        try {
            int r = orderDAO.delOrder(Integer.parseInt(idString));
            if (r > 0) {
                out.print("<script>alert('删除成功');location.href='orderServlet?op=findAll';</script>");
            } else {
                out.print("<script>alert('删除失败');location.href='orderServlet?op=findAll';</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.print("<script>alert('删除失败');location.href='orderServlet?op=findAll';</script>");
        }
    }
    protected void goOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        User users = (User) request.getSession().getAttribute("USERS");
        try {

            String sizeString = request.getParameter("size");
            String total = request.getParameter("total");
            int size = Integer.parseInt(sizeString);
            String productStr = "";
            String number = "";
            String productId= request.getParameter("product_id_1");

            for (int i = 0; i < size; i++) {
                productStr += request.getParameter("product_id_" + i) + ",";
                number += request.getParameter("number_id_" + i) + ",";
            }
            String address = users.getAddress();
            int orderId = (int) (Math.random() * 100000);
            Order order = new Order();
            order.setId(orderId);
            order.setUserId(users.getId());
            order.setLoginName(users.getUsername());
            order.setUserAddress(address);
            order.setCost(Float.parseFloat(total));
            order.setSerialNumber(UUID.randomUUID().toString());
            try {
                /**
                 * 添加订单
                 */
                int r = orderDAO.addOrder(order);
                /**
                 * 添加订单明细
                 */
                String ps[] = productStr.split(",");
                String num[] = number.split(",");

                for (int i = 0; i < ps.length; i++) {
                    Product product = productDAO.findProductById(Integer.parseInt(ps[i]));
                    float cost = Integer.parseInt(num[i]) * product.getPrice();
                    orderDetailDAO.addOrderDetail(orderId, Integer.parseInt(ps[i]), Integer.parseInt(num[i]), cost);
                }
                /**
                 * 删除购物车记录
                 */
                for (int i = 0; i < ps.length; i++) {
                    shoppingDAO.delShoppingBy2Id(users.getId(), Integer.parseInt(ps[i]));
                }

                if (r > 0) {
                    out.print("<script>alert('下单成功');location.href='ShoppingServlet?op=showShopping';</script>");
                } else {
                    out.print("<script>alert('下单失败');location.href='ShoppingServlet?op=showShopping';</script>");
                }

            } catch (Exception e) {
                out.print("<script>alert('下单失败');location.href='ShoppingServlet?op=showShopping';</script>");
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String opString = request.getParameter("op");
        switch (opString) {
            case "goOrder":
                goOrder(request, response);
                break;
            case "findAll":
                findAll(request, response);
                break;
            case "findUserById":
                findUserById(request, response);
                break;
            case "delOrder":
                delOrder(request, response);
                break;
            case "modifyUser":
                try {
                    modifyUser(request, response);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }

    }
}


