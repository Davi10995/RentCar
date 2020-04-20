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

@WebServlet("/newUser")
public class newUserServlet extends HttpServlet {
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
            inserUser(request,response);
            dispatcher = request.getRequestDispatcher("/success.jsp");
            dispatcher.forward(request, response);
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }


    private void inserUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ParseException, ServletException {
        RequestDispatcher dispatcher = null;
        String cf = request.getParameter("cf");
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String password = request.getParameter("password");
        String tipo = "Customer";
        String[] availableDate = request.getParameterValues("data");
        SimpleDateFormat availDate = new SimpleDateFormat("yyyy-MM-dd");
        Date data = availDate.parse(availableDate[0]);

        User user = new User(cf, nome, cognome, password, tipo, data);
        if(validate(user)){
            userDao.saveUser(user);
        }else {
            dispatcher = request.getRequestDispatcher("/errorUser.jsp");
            dispatcher.forward(request,response);
        }
    }

    private boolean validate(User u){
        if(u.cf.equals("") || u.nome.equals("") || u.cognome.equals("") || u.password.equals("")){
            return false;
        }else {
            if(userDao.getUserByDB(u.cf) != null)
                return false;
            return true;
        }


    }
}