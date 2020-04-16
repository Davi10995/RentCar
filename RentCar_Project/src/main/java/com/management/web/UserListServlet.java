package com.management.web;

import com.management.dao.UserDao;
import com.management.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class UserListServlet extends HttpServlet {

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
            List<User> userList = userDao.getAllUser();
            request.setAttribute("listUser", userList);
            RequestDispatcher dispatcher = null;
//            if(session.getAttribute("tipo").equals("SuperUser")) {
                dispatcher = request.getRequestDispatcher("/listSuperUser.jsp");
//            }
//            else{
//                dispatcher = request.getRequestDispatcher("/listCustomer.jsp");
//            }
            dispatcher.forward(request, response);
        } catch ( Exception ex) {
            throw new ServletException(ex);
        }
    }
}
