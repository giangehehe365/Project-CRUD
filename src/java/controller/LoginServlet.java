/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import model.User;
import service.UserService;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String remember = request.getParameter("rememberMe");

        System.out.println("Servlet: Received login request with name='" + name + "', password='" + password + "', remember=" + remember);

        UserService userService = new UserService();
        try {
            User user = userService.checkLogin(name, password);

            if (user != null) {
                System.out.println("Servlet: User logged in successfully: " + user.getName());

                HttpSession session = request.getSession();
                session.setAttribute("user", user);

                if ("yes".equals(remember)) {
                    String encodedName = URLEncoder.encode(name, "UTF-8");
                    Cookie cookie = new Cookie("name", encodedName);
                    cookie.setMaxAge(7 * 24 * 60 * 60); 
                    cookie.setPath("/");
                    response.addCookie(cookie);
                } else {
                    Cookie cookie = new Cookie("name", "");
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }

                response.sendRedirect(request.getContextPath() + "/users");
            } else {
                System.out.println("Servlet: Login failed - wrong name or password.");
                request.setAttribute("errorMessage", "Sai tên đăng nhập hoặc mật khẩu!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            System.out.println("Servlet: Exception during login: " + e.getMessage());
            e.printStackTrace();
            request.setAttribute("errorMessage", "Lỗi hệ thống khi đăng nhập: " + e.getMessage());
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}

