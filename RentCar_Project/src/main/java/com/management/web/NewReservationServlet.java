package com.management.web;


import com.management.dao.PrenotazioneDao;
import com.management.dao.UserDao;
import com.management.dao.VeicoloDao;
import com.management.model.Prenotazione;
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
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/newReservation")

public class NewReservationServlet extends HttpServlet {
    private PrenotazioneDao prenDao;

    public void init() {
        prenDao = new PrenotazioneDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            RequestDispatcher dispatcher = null;
            insertReservation(request,response);
            dispatcher = request.getRequestDispatcher("/success.jsp");
            dispatcher.forward(request, response);

        } catch (ServletException e) {
            e.printStackTrace();
            throw new ServletException(e);

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    private void insertReservation(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ParseException {

        VeicoloDao veicolodao = new VeicoloDao();
        HttpSession session = request.getSession();
        int vehicleId = Integer.parseInt(request.getParameter("id"));
        int userId = (int) session.getAttribute("userId");
        Veicolo veicolo = veicolodao.getVeicoloById(vehicleId);
        veicolo.prenotabile = false;
        String[] dataInizio = request.getParameterValues("dataInizio");
        SimpleDateFormat availDate = new SimpleDateFormat("yyyy-MM-dd");
        Date inizio = availDate.parse(dataInizio[0]);
        String[] dataFine = request.getParameterValues("dataFine");
        SimpleDateFormat availDate2 = new SimpleDateFormat("yyyy-MM-dd");
        Date fine = availDate2.parse(dataFine[0]);

        Prenotazione prenotazione = new Prenotazione(userId, vehicleId, inizio, fine);
        prenDao.saveReservation(prenotazione);
        veicolodao.updateVehicle(veicolo);
        }


}
