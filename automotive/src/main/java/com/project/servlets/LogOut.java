package com.project.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.dao.GestioneUtenteDAO;
import com.project.model.Utente;


public class LogOut extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) {


        HttpSession session = request.getSession(true);
        session.setAttribute("Utente", null);

        try {

            response.sendRedirect("index.jsp");
        } catch (IOException e) {
            System.out.println("LOGOUT FALLITO !" + e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {

}
}