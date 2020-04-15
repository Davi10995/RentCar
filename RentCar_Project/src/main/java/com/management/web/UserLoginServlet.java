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


/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
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

            String username = request.getParameter("username");
            String password = request.getParameter("password");
            RequestDispatcher dispatcher = null;
            if (userDao.Validate(username, password)) {
                HttpSession session = request.getSession();
                User user = userDao.getUserByDB(username);
                session.setAttribute("userId", user.id);
                session.setAttribute("name", user.nome);
                session.setAttribute("tipo", user.tipo);
                //response.sendRedirect("/home.jsp");
                dispatcher = request.getRequestDispatcher("/home.jsp");
            } else {
                dispatcher = request.getRequestDispatcher("/index.jsp");
                //response.sendRedirect("/index.jsp");
            }
            dispatcher.forward(request, response);

        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }
}