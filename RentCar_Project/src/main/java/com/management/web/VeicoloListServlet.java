package com.management.web;

import com.management.dao.UserDao;
import com.management.dao.VeicoloDao;
import com.management.model.User;
import com.management.model.Veicolo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/parcoAuto")
public class VeicoloListServlet extends HttpServlet {

    private VeicoloDao veicoloDao;

    public void init() {
        veicoloDao = new VeicoloDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Veicolo> veicoli = veicoloDao.getAllVeicoli();
            request.setAttribute("listVeicoli", veicoli);
            RequestDispatcher dispatcher = null;
            dispatcher = request.getRequestDispatcher("/parcoAuto.jsp");

            dispatcher.forward(request, response);
        } catch ( Exception ex) {
            throw new ServletException(ex);
        }
    }
}
