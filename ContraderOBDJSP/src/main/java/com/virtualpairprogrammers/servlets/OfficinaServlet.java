package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.domain.Officina;
import com.virtualpairprogrammers.services.OfficinaService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OfficinaServlet extends HttpServlet
{
    private OfficinaService officinaService;


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession(true);
        String mode = (String) session.getAttribute("mode");
        String nome = request.getParameter("nome");
        String indirizzo = request.getParameter("indirizzo");
        String citta = request.getParameter("citta");
        String bott = request.getParameter("bott");
        Officina officina;

        switch (mode)
        {
            case "add":
            {
                officinaService = new OfficinaService();
                officina = new Officina(nome, indirizzo, citta);
                if(!officinaService.addOfficina(officina))
                {
                    session.setAttribute("status", "Officina inserita con successo");
                }
                else
                {
                    session.setAttribute("status", "Errore nell'inserimento");
                }
                session.setAttribute("view", "home.jsp");
                MainDispatcherServlet.getInstance(request).callView(request, response);
            }
                break;

            case "list":
            {
                List<Officina> lista = new ArrayList<>();

                if(bott.equals("Cerca per città"))
                {
                    officinaService = new OfficinaService();
                    lista = officinaService.listOfficina(citta);
                }
                else if(bott.equals("Visualizza tutte"))
                {
                    officinaService = new OfficinaService();
                    lista = officinaService.listOfficina();
                }

                System.out.print(lista.get(0).getNome());
                session.setAttribute("lista", lista);
                session.setAttribute("view", "viewListOfficina.jsp");
                MainDispatcherServlet.getInstance(request).callView(request, response);
            }
                break;
        }
    }
}



