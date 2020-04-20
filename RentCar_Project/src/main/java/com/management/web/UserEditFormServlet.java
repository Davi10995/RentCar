package com.management.web;

import com.management.dao.UserDao;
import com.management.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hibernate.type.descriptor.java.DateTypeDescriptor.DATE_FORMAT;


@WebServlet("/editForm")
public class UserEditFormServlet extends HttpServlet {
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
            RequestDispatcher dispatcher = null;
            showEditForm(request, response);
            dispatcher = request.getRequestDispatcher("/edit.jsp");
            dispatcher.forward(request, response);
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = userDao.getUserById(id);
        SimpleDateFormat  DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
        String data = DATE_FORMAT.format(existingUser.data);
        request.setAttribute("user", existingUser);
        request.setAttribute("data", data);

    }

}