package com.management.web;

import com.management.dao.VeicoloDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/deleteVehicle")
public class DeleteVehicleServlet extends HttpServlet {

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
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        veicoloDao.deleteVehicle(id);
    }
}