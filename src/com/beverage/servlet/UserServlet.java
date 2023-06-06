package com.beverage.servlet;

import com.beverage.dao.impl.UserDAOImpl;
import com.beverage.model.User;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 *
 *
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    /**
     * 引用用户业务逻辑层
     */
    UserDAOImpl userDao = new UserDAOImpl();
    /**
     * 登录
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /**
         * 获取用户名和密码
         */
        String loginName = request.getParameter("username");

        String password = request.getParameter("password");

        /**
         * 调用用户业务逻辑层登录方法
         */
        try {
            User user = userDao.login(loginName, password);
            /**
             * 登录失败
             */
            if (user == null) {
                request.setAttribute("ERROR", "用户名或者密码错误");
                request.getRequestDispatcher("dynamicPage/Login.jsp").forward(request, response);
            } else {
                request.getSession().setAttribute("USERS", user);
                response.sendRedirect("IndexServlet");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 注册
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void register(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String fullName = request.getParameter("fullName");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setFullName(fullName);
        user.setAddress(address);
        user.setPhoneNumber(phoneNumber);
        try {
            int r = userDao.register(user);
            if (r > 0) {
                PrintWriter out = response.getWriter();
                out.println("<script>alert('注册成功');location.href='dynamicPage/Login.jsp';</script>");
                // response.sendRedirect("login.jsp");
            } else {
                request.setAttribute("ERROR", "注册 失败");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        doPost(request, response);
        response.sendRedirect("login.jsp");
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().invalidate();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        /**
         * 接收地址栏的op参数
         */
        String op = request.getParameter("op");
        switch (op) {
            case "login":
                login(request, response);
                break;
            case "register":
                register(request, response);
                break;
            case "logout":
                logout(request, response);
                break;
        }
    }
}
