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
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/newVeicolo")
public class NewVeicoloServlet extends HttpServlet {
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
            RequestDispatcher dispatcher = null;
            inserUser(request,response);
            dispatcher = request.getRequestDispatcher("/success.jsp");
            dispatcher.forward(request, response);
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }


    private void inserUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ParseException {
        String targa = request.getParameter("targa");
        String modello = request.getParameter("modello");
        String casa = request.getParameter("casa");
        String anno = request.getParameter("anno");
        Veicolo veicolo = new Veicolo(targa, modello, casa, anno);
        veicolo.prenotabile = true;
        veicoloDao.saveVeicolo(veicolo);
    }
}