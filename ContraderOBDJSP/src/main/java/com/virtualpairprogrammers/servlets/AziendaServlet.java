package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.domain.Azienda;
import com.virtualpairprogrammers.services.AziendaService;
import com.virtualpairprogrammers.services.LoginService;
import com.virtualpairprogrammers.domain.Login;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

public class AziendaServlet  extends HttpServlet {

    private AziendaService aziendaService;
    private LoginService loginService;
    private String role;
    private int id;


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String mode = (String) session.getAttribute("mode");

        switch (mode) {
            case "insertAzienda": {
                String nome = request.getParameter("nome");
                String citta = request.getParameter("citta");
                Azienda azienda;
                aziendaService = new AziendaService();
                azienda = new Azienda(nome, citta);
                int id=aziendaService.insertAzienda(azienda);
                /*if (!aziendaService.insertAzienda(azienda)) {
                    session.setAttribute("status", "Azienda inserita con successo");
                } else {
                    session.setAttribute("status", "Errore nell'inserimento");
                }*/
                session.setAttribute("view", "home.jsp");
                String access = "A_0"+id;
                loginService = new LoginService();
                loginService.InsertLogin(new Login(access, access, 3, id));
                MainDispatcherServlet.getInstance(request).callView(request, response);
            }
            break;

        }

    }
}