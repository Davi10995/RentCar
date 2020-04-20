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
            editVehicle(request,response);
            RequestDispatcher dispatcher = null;
            dispatcher = request.getRequestDispatcher("/success.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }


    private void editVehicle(HttpServletRequest request, HttpServletResponse response)
            throws ParseException, ServletException, IOException {
        RequestDispatcher dispatcher = null;

        if(request.getParameter("prenotabile").equals("true")) {
            String targa = request.getParameter("targa");
            String modello = request.getParameter("modello");
            String casa = request.getParameter("casa");
            String anno = request.getParameter("anno");
            Veicolo veicolo = new Veicolo(targa, modello, casa, anno);
            veicolo.id = Integer.parseInt(request.getParameter("id"));
            if(validate(veicolo)){
                veicoloDao.updateVehicle(veicolo);
            }else {
                dispatcher = request.getRequestDispatcher("/errorVehicle.jsp");
                dispatcher.forward(request,response);
            }

        }
        else{
            dispatcher = request.getRequestDispatcher("/vehicleReservedError.jsp");
            dispatcher.forward(request, response);
        }
    }

    private boolean validate(Veicolo u){
        if(u.targa.equals("") || u.modello.equals("") || u.casaCostrutt.equals("") || u.annoImm.equals("")){
            return false;
        }else {
            Veicolo veicolo = veicoloDao.getVeicoloById(u.id);
            if (veicoloDao.getVeicoloByTarga(u.targa) != null && !veicolo.targa.equals(u.targa))
                return false;
            return true;
        }


    }
}