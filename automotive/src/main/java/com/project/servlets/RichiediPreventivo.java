package com.project.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.GestioneUtenteDAO;
import com.project.dao.RichiestaPreventivoDAO;

/**
 * Servlet implementation class RegistraUtente
 */
public class RichiediPreventivo extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RichiediPreventivo() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idutente = Integer.parseInt(request.getParameter("idutente"));
        int idazienda = Integer.parseInt(request.getParameter("idazienda"));
        int idauto = Integer.parseInt(request.getParameter("idauto"));

        String descrizione = request.getParameter("descrizione");
       if(RichiestaPreventivoDAO.inviaRichiesta(descrizione,idutente,idazienda,idauto))response.sendRedirect("utente_home.jsp");

    }
}
