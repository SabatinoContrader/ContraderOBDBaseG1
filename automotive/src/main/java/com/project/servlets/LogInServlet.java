package com.project.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.dao.GestioneUtenteDAO;
import com.project.model.Utente;


public class LogInServlet extends HttpServlet{


	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
	}
	
public void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("??????????????????????????'");
		
		 HttpSession session = request.getSession(true);
		 
	     Utente u = null; 
	     
	        if ((request != null))
	        {

	            String userName = request.getParameter("email");
	            String password = request.getParameter("pwd");

	            System.out.println(userName+password);
	            
	            u = GestioneUtenteDAO.logIn(userName, password);

	            if(u==null) {
	            	System.out.println("ERRORE DI LOG IN");
	            	try {
						response.sendRedirect("index.jsp");
					} catch (IOException e) {
						System.out.println("Caricameto pagina Index FALLITA!");
					}
	            } else
					try {
						session.setAttribute("Utente", u);
						response.sendRedirect("officina_home.jsp");
					} catch (IOException e) {
						System.out.println("Caricamento pagina Home FALLITA!");
					}
    
	        }
    }
}
