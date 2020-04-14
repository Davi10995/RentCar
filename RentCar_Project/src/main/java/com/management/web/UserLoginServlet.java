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
        if(userDao.Validate(username, password)) {
            HttpSession session = request.getSession();
            User user = userDao.getUserByDB(username);
            session.setAttribute("name", user.nome);
            session.setAttribute("tipo", user.tipo);
            //response.sendRedirect("/home.jsp");
            dispatcher = request.getRequestDispatcher("/home.jsp");
        }else{
            dispatcher = request.getRequestDispatcher("/index.jsp");
            //response.sendRedirect("/index.jsp");
        }
        dispatcher.forward(request, response);

        } catch ( Exception ex) {
            throw new ServletException(ex);
        }
    }

//    private void listUser(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException, ServletException {
//        //0) Add data
//            List <User> userList = userDao.getAllUser();
//            request.setAttribute("listUser", userList);
//            //1) get request dispatcher
//            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
//            //2) forward the request to jsp
//            dispatcher.forward(request, response);
//    }
//
//    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
//        dispatcher.forward(request, response);
//    }
//
//    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, ServletException, IOException {
//        String cf =request.getParameter("CF");
//        User existingUser = userDao.getUser(cf);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
//        request.setAttribute("user", existingUser);
//        dispatcher.forward(request, response);
//
//    }
//
//    private void insertUser(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException, ParseException {
//        String cf =request.getParameter("CF");
//        String nome = request.getParameter("Nome");
//        String cognome = request.getParameter("Cognome");
//        String password = request.getParameter("Password");
//        String tipo = request.getParameter("Tipo");
//        Date data = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("Data"));
//        User newUser = new User(cf,nome, cognome,password, tipo,data);
//        userDao.saveUser(newUser);
//        response.sendRedirect("list");
//    }
//
//    private void updateUser(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException, ParseException {
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String country = request.getParameter("country");
//        Date data = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("Data"));
//        User user = new User(name, email, country,data);
//        userDao.updateUser(user);
//        response.sendRedirect("list");
//    }
//
//    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException {
//        String cf = request.getParameter("CF");
//        userDao.deleteUser(cf);
//        response.sendRedirect("list");
//    }
//
//    private void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
//        dispatcher.forward(request, response);
//    }
}