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
public class RegistraUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistraUtente() {
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
		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognomecliente");
		String email = request.getParameter("emailcliente");
		String password = request.getParameter("pwdcliente");
		int ruolo = Integer.parseInt(request.getParameter("ruolocliente"));
		int idAziendaPrivata = 0;
		if(request.getParameter("idaziendaprivata") != null && !request.getParameter("idaziendaprivata").equals("")) idAziendaPrivata = Integer.parseInt(request.getParameter("idaziendaprivata"));
		int idAzienda = 0;
		if(request.getParameter("idazienda") != null && !request.getParameter("idazienda").equals("")) idAzienda = Integer.parseInt(request.getParameter("idazienda"));
		String telefono = request.getParameter("telefonocliente");
		System.out.println("Sto per fare l'inserimento dell'utente di nome: "+ nome +" idazienda: "+idAzienda+" idaziendaprivata: "+idAziendaPrivata);
		if(GestioneUtenteDAO.signUp(nome, cognome, email, password, ruolo, telefono, idAzienda, idAziendaPrivata)) response.sendRedirect("home_admin.jsp");
	}
}
