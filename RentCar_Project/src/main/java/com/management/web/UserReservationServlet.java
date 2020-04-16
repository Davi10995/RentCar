package com.management.web;

import com.management.dao.PrenotazioneDao;
import com.management.model.Prenotazione;

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
import java.util.List;

@WebServlet("/userReservation")
public class UserReservationServlet  extends HttpServlet {

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
            HttpSession session = request.getSession();
            int idUser = (int)session.getAttribute("userId");
            List<Prenotazione> list = prenDao.getReservationByUserId(idUser);
            request.setAttribute("listPrenotazioni", list);
            dispatcher = request.getRequestDispatcher("/userReservation.jsp");
            dispatcher.forward(request, response);

        } catch (ServletException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}
