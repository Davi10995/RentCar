package com.management.web;

import com.management.dao.VeicoloDao;
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

@WebServlet("/editVehicle")
public class EditVehicleServlet extends HttpServlet {

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
            deleteVehicle(request,response);
            RequestDispatcher dispatcher = null;
            dispatcher = request.getRequestDispatcher("/success.jsp");
            dispatcher.forward(request, response);
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }


    private void deleteVehicle(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ParseException {
        String targa =  request.getParameter("Targa");
        String modello = (String) request.getAttribute("Modello");
        String casa = (String) request.getAttribute("casaCostrutt");
        String anno = (String) request.getAttribute("annoImm");
        Veicolo veicolo = new Veicolo(targa, modello, casa, anno);
        veicolo.id = Integer.parseInt(request.getParameter("id"));
        veicoloDao.updateVehicle(veicolo);
    }
}