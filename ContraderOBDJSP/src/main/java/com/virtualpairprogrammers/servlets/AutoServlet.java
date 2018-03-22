package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.domain.Auto;
import com.virtualpairprogrammers.services.AutoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AutoServlet extends HttpServlet {

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
            case "addAuto":
            {
                int Cod_Dispositivo = (Integer.parseInt(request.getParameter("cod_disp")));
                String Targa = request.getParameter("targa");
                int Telaio = (Integer.parseInt(request.getParameter("telaio")));
                String casa_Costruttrice = request.getParameter("casa_cost");
                String Modello = request.getParameter("modello");
                String Alimentazione = request.getParameter("alimentazione");
                String Tipologia = request.getParameter("tipologia");
                String Cambio = request.getParameter("cambio");
                int Proprietario = (Integer.parseInt(request.getParameter("proprietario")));
                String Revisione = request.getParameter("revisione");
                String Tagliando_Data = request.getParameter("tagliando_data");
                int Tagliando_Km = (Integer.parseInt(request.getParameter("tagliando_km")));
                autoService = new AutoService();
                Auto auto = new Auto(Cod_Dispositivo, Targa, Telaio, casa_Costruttrice, Modello, Alimentazione, Tipologia, Cambio, Proprietario, Revisione, Tagliando_Data, Tagliando_Km, null);
                autoService.InsertAuto(auto);
                session.setAttribute("status", "Auto inserita");
                session.setAttribute("view", "home.jsp");
                MainDispatcherServlet.getInstance(request).callView(request, response);
            }
            break;
            case "addAutoDriver":{
                autoService = new AutoService();
                int cod_Dispositivo = Integer.parseInt(request.getParameter("id_auto"));
                int id_driver = Integer.parseInt(request.getParameter("id_driver"));
                session.setAttribute("status", "Auto associato a driver");
                autoService.AssegnaAutoDriver(cod_Dispositivo, id_driver);
                MainDispatcherServlet.getInstance(request).callView(request, response);
            }
            break;
            case "updateAuto":
            {
                int Cod_Dispositivo = (Integer.parseInt(request.getParameter("cod_disp")));
                String Targa = request.getParameter("targa");
                int Telaio = (Integer.parseInt(request.getParameter("telaio")));
                String casa_Costruttrice = request.getParameter("casa_cost");
                String Modello = request.getParameter("modello");
                String Alimentazione = request.getParameter("alimentazione");
                String Tipologia = request.getParameter("tipologia");
                String Cambio = request.getParameter("cambio");
                int Proprietario = (Integer.parseInt(request.getParameter("proprietario")));
                String Revisione = request.getParameter("revisione");
                String Tagliando_Data = request.getParameter("tagliando_data");
                int Tagliando_Km = (Integer.parseInt(request.getParameter("tagliando_km")));
                autoService = new AutoService();
                Auto auto = new Auto(Cod_Dispositivo, Targa, Telaio, casa_Costruttrice, Modello, Alimentazione, Tipologia, Cambio, Proprietario, Revisione, Tagliando_Data, Tagliando_Km, null);
                autoService.updateAuto(auto);
                session.setAttribute("status", "Auto Modificata");
                session.setAttribute("view", "home.jsp");
                MainDispatcherServlet.getInstance(request).callView(request, response);
            }
            break;
            case "resetAuto": {
                int cod_Dispositivo = (Integer.parseInt(request.getParameter("cod_dispositivo")));
                autoService = new AutoService();
                autoService.resetAuto(cod_Dispositivo);
            }
            break;



        }
    }
}



