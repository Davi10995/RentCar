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
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/edit")
public class UserEditServlet extends HttpServlet {
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
            updateUser(request, response);
            dispatcher = request.getRequestDispatcher("/success.jsp");
            dispatcher.forward(request, response);
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }


    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws ParseException, ServletException, IOException {
        RequestDispatcher dispatcher=null;
        String cf = request.getParameter("cf");
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String password = request.getParameter("password");
        String tipo = request.getParameter("tipo");
        Date data = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data"));
        User user = new User(cf, nome, cognome,password, tipo, data);
        user.id = Integer.parseInt(request.getParameter("id"));
        if(validate(user)){
            userDao.updateUser(user);
        }else {
            dispatcher = request.getRequestDispatcher("/errorUser.jsp");
            dispatcher.forward(request,response);
        }
    }

    private boolean validate(User u) {
        if (u.cf.equals("") || u.nome.equals("") || u.cognome.equals("") || u.password.equals("")) {
            return false;
        } else {
            User user = userDao.getUserById(u.id);
            if (userDao.getUserByDB(u.cf) != null && !user.cf.equals(u.cf))
                return false;
            return true;
        }
    }

}