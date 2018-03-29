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
import java.util.List;

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
                String access = "A_0"+id;
                loginService = new LoginService();

                if (!loginService.InsertLogin(new Login(access, access, 3, id)) ) {
                    session.setAttribute("status", "success");
                } else {
                    session.setAttribute("status", "error");
                }
                session.setAttribute("view", "officinaAddAzienda.jsp");
                MainDispatcherServlet.getInstance(request).callView(request, response);
            }
            break;

            case "listAll": {
                List<Azienda> listaAzienda;
                aziendaService = new AziendaService();
                listaAzienda = aziendaService.listAzienda();
                session.setAttribute("listaAzienda", listaAzienda);
                session.setAttribute("view", "viewListAzienda.jsp");
                MainDispatcherServlet.getInstance(request).callView(request, response);
            }
            break;

        }

    }
}