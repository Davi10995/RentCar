package com.management.web;

import com.management.dao.PrenotazioneDao;
import com.management.dao.UserDao;
import com.management.model.User;
import com.management.model.Prenotazione;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/reservationList")
public class ReservationListServlet extends HttpServlet{

    private PrenotazioneDao prenotazioneDao;

    public void init() {
        prenotazioneDao = new PrenotazioneDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            int id = Integer.parseInt(request.getParameter("id"));
            List<Prenotazione> prenotazioni = prenotazioneDao.getReservationByUserId(id);
            request.setAttribute("listPrenotazioni", prenotazioni);
            RequestDispatcher dispatcher = null;
            dispatcher = request.getRequestDispatcher("/reservationList.jsp");
            dispatcher.forward(request, response);
        } catch ( Exception ex) {
            throw new ServletException(ex);
        }
    }
}
