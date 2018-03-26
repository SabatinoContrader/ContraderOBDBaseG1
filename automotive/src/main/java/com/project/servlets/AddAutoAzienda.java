package com.project.servlets;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.CarDAO;
import com.project.dao.GestioneUtenteDAO;

/**
 * Servlet implementation class RegistraUtente
 */
public class AddAutoAzienda extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAutoAzienda() {
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

        String marca = request.getParameter("marca");
        String modello = request.getParameter("modello");
        String targa = request.getParameter("targa");

        String telaio = request.getParameter("telaio");
        int danoleggio = Integer.parseInt(request.getParameter("danoleggio"));
        int id=Integer.parseInt(request.getParameter("idazienda"));
        Date oggi= new Date(System.currentTimeMillis());

        CarDAO.insertAutoAzienda(id,marca,modello,targa,telaio,0,0,oggi, oggi, oggi,  oggi,"0",danoleggio);
        response.sendRedirect("home_officina.jsp");


    }

}
