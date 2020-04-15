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

@WebServlet("/insertReservation")
public class ReservationInsertForm extends HttpServlet {

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
            showInsertForm(request,response);
            dispatcher = request.getRequestDispatcher("/newReservation.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showInsertForm(HttpServletRequest request, HttpServletResponse response){
        Veicolo veicolo = veicoloDao.getVeicoloById(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("veicolo",veicolo);
    }
}
