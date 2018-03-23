package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.domain.Auto;
import com.virtualpairprogrammers.domain.Dati_dispositivo;
import com.virtualpairprogrammers.services.AutoService;
import com.virtualpairprogrammers.services.DatiService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class DatiServlet extends HttpServlet {

    private DatiService datiService;
    private AutoService autoService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession(true);
        String mode = (String) session.getAttribute("mode");

        switch (mode) {
            case "getError": {
                System.out.println("Sei nella servlet dati");
                List<Dati_dispositivo> lista;
                Auto auto;
                int cod_dispositivo= Integer.parseInt(session.getAttribute("cod_dispositivo").toString());
                autoService = new AutoService();
                auto = autoService.findAuto(cod_dispositivo);
                datiService = new DatiService();
                lista = datiService.listaAllDatiDispositivo(cod_dispositivo);
                session.setAttribute("auto", auto);
                session.setAttribute("lista", lista);
                session.setAttribute("view", "viewNotificheDriver.jsp");
                MainDispatcherServlet.getInstance(request).callView(request, response);
            }
            break;



        }
    }
}



