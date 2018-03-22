package com.project.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.GestioneUtenteDAO;

/**
 * Servlet implementation class RegistraUtente
 */
public class ModificaUtenteBusiness extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaUtenteBusiness() {
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

        String denominazione = request.getParameter("denominazionemodbusiness");
        String nome = request.getParameter("nomemodbusiness");
        String cognome = request.getParameter("cognomemodbusiness");
        String email = request.getParameter("emailmodbusiness");

        String telefono = request.getParameter("telefonomodbusiness");
        String citta = request.getParameter("cittamodbusiness");
        int id=Integer.parseInt(request.getParameter("idmodbusiness"));


        //  System.out.println("Sto per fare l'inserimento dell'utente di nome: "+ nome +" idazienda: "+idAzienda);

        if(GestioneUtenteDAO.updateUtenteBusinessOfficina(denominazione,nome, cognome, email,  telefono,citta,id))response.sendRedirect("home_officina.jsp");


    }

}
