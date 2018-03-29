package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.domain.Login;
import com.virtualpairprogrammers.domain.Officina;
import com.virtualpairprogrammers.services.LoginService;
import com.virtualpairprogrammers.services.OfficinaService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OfficinaServlet extends HttpServlet {
    private OfficinaService officinaService;
    private LoginService loginService;


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String mode = (String) session.getAttribute("mode");
        String nome = request.getParameter("nome");
        String indirizzo = request.getParameter("indirizzo");
        String citta = request.getParameter("citta");
        Officina officina;

        switch (mode) {
            case "add": {
                officinaService = new OfficinaService();
                officina = new Officina(nome, indirizzo, citta);
                int id = officinaService.addOfficina(officina);


                String access = "O_0" + id;
                loginService = new LoginService();
                if (!loginService.InsertLogin(new Login(access, access, 2, id)))
                    session.setAttribute("status", "success");
                else
                    session.setAttribute("status", "error");

                session.setAttribute("view", "addOfficina.jsp");
                MainDispatcherServlet.getInstance(request).callView(request, response);
            }
            break;

            case "listAll": {
                List<Officina> lista;
                officinaService = new OfficinaService();
                lista = officinaService.listOfficina();
                session.setAttribute("lista", lista);
                session.setAttribute("view", "viewListOfficina.jsp");
                MainDispatcherServlet.getInstance(request).callView(request, response);
            }
            break;

            case "listCitta": {
                List<Officina> lista;
                officinaService = new OfficinaService();
                lista = officinaService.listOfficina(citta);
                session.setAttribute("lista", lista);
                session.setAttribute("view", "viewListOfficina.jsp");
                MainDispatcherServlet.getInstance(request).callView(request, response);
            }
            break;
        }
    }
}



