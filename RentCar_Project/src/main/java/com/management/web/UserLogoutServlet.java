package com.management.web;
import com.management.dao.UserDao;
import com.management.model.User;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")

public class UserLogoutServlet extends  HttpServlet{
    private UserDao userDao;

    public void init() {
        userDao = new UserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        try {
            HttpSession session = request.getSession();
            session.invalidate();
            RequestDispatcher dispatcher = null;
            response.sendRedirect("index.jsp");


        } catch ( Exception ex) {
            throw new ServletException(ex);
        }
    }
}
