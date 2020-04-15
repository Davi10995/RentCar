package com.management.web;

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

@WebServlet("/editVehicleForm")
public class VehicleEditFormServlet extends HttpServlet {

    private VeicoloDao veicoloDao;

    public void init(){
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
            showEditForm(request, response);
            dispatcher = request.getRequestDispatcher("/vehicleEdit.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        Veicolo vehicle = veicoloDao.getVeicoloById(id);
        request.setAttribute("veicolo", vehicle);

    }
}
