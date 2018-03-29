package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.domain.Auto;
import com.virtualpairprogrammers.domain.AutoConErrore;
import com.virtualpairprogrammers.domain.Dati_dispositivo;
import com.virtualpairprogrammers.services.AutoService;
import com.virtualpairprogrammers.services.DatiService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AutoServlet extends HttpServlet {

    private AutoService autoService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String mode = (String) session.getAttribute("mode");
        String username = (String) session.getAttribute("username");

        switch (mode) {
            case "addAuto": {
                int Cod_Dispositivo = (Integer.parseInt(request.getParameter("cod_disp")));
                String Targa = request.getParameter("targa");
                int Telaio = (Integer.parseInt(request.getParameter("telaio")));
                String casa_Costruttrice = request.getParameter("casa_cost");
                String Modello = request.getParameter("modello");
                String Alimentazione = request.getParameter("alimentazione");
                String Tipologia = request.getParameter("tipologia");
                String Cambio = request.getParameter("cambio");
                String Proprietario = request.getParameter("proprietario");
                String Revisione = request.getParameter("revisione");
                String Tagliando_Data = request.getParameter("tagliando_data");
                int Tagliando_Km = (Integer.parseInt(request.getParameter("tagliando_km")));
                int id_officina = (Integer.parseInt(session.getAttribute("id").toString()));
                System.out.println(id_officina);
                autoService = new AutoService();
                Auto auto = new Auto(Cod_Dispositivo, Targa, Telaio, casa_Costruttrice, Modello, Alimentazione, Tipologia, Cambio, Proprietario, Revisione, Tagliando_Data, Tagliando_Km, null, id_officina);
                if (!autoService.InsertAuto(auto)) {
                    session.setAttribute("status", "success");
                } else {
                    session.setAttribute("status", "error");
                }
                session.setAttribute("view", "officinaAddAuto.jsp");
                MainDispatcherServlet.getInstance(request).callView(request, response);
            }
            break;
            case "addAutoDriver": {
                autoService = new AutoService();
                int cod_Dispositivo = Integer.parseInt(request.getParameter("id_auto"));
                int id_driver = Integer.parseInt(request.getParameter("id_driver"));
                if (!autoService.AssegnaAutoDriver(cod_Dispositivo, id_driver)) {
                    session.setAttribute("status", "success");
                } else {
                    session.setAttribute("status", "error");
                }
                session.setAttribute("view", "aziendaNoleggio.jsp");
                MainDispatcherServlet.getInstance(request).callView(request, response);
            }
            break;
            case "updateAuto": {
                int Cod_Dispositivo = (Integer.parseInt(request.getParameter("cod_disp")));
                String Targa = request.getParameter("targa");
                int Telaio = (Integer.parseInt(request.getParameter("telaio")));
                String casa_Costruttrice = request.getParameter("casa_cost");
                String Modello = request.getParameter("modello");
                String Alimentazione = request.getParameter("alimentazione");
                String Tipologia = request.getParameter("tipologia");
                String Cambio = request.getParameter("cambio");
                String Proprietario = request.getParameter("proprietario");
                String Revisione = request.getParameter("revisione");
                String Tagliando_Data = request.getParameter("tagliando_data");
                int Tagliando_Km = (Integer.parseInt(request.getParameter("tagliando_km")));
                int id_officina = (Integer.parseInt(session.getAttribute("id").toString()));
                autoService = new AutoService();
                Auto auto = new Auto(Cod_Dispositivo, Targa, Telaio, casa_Costruttrice, Modello, Alimentazione, Tipologia, Cambio, Proprietario, Revisione, Tagliando_Data, Tagliando_Km, null, id_officina);
                autoService.updateAuto(auto);
                session.setAttribute("status", "Auto Modificata");
                session.setAttribute("view", "home.jsp");
                MainDispatcherServlet.getInstance(request).callView(request, response);
            }
            break;
            case "resetAuto": {
                int cod_Dispositivo = (Integer.parseInt(request.getParameter("cod_Dispositivo")));
                autoService = new AutoService();
                if (!autoService.resetAuto(cod_Dispositivo)) {
                    session.setAttribute("status", "success");
                } else {
                    session.setAttribute("status", "error");
                }
                session.setAttribute("view", "officinaResetAuto.jsp");
                MainDispatcherServlet.getInstance(request).callView(request, response);

            }
            break;

            case "listaAutoDriver": {
                List<Auto> lista;
                int id_driver = Integer.parseInt(session.getAttribute("id").toString());
                autoService = new AutoService();
                lista = autoService.listaAutoDriver(id_driver);
                session.setAttribute("listaAuto", lista);
                session.setAttribute("view", "home.jsp");
                MainDispatcherServlet.getInstance(request).callView(request, response);
            }
            break;

            case "findAuto": {
                Auto auto;
                DatiService datiService;
                int cod_dispositivo = Integer.parseInt(session.getAttribute("cod_dispositivo").toString());
                autoService = new AutoService();
                auto = autoService.findAuto(cod_dispositivo);
                List<Dati_dispositivo> lista;
                datiService = new DatiService();
                lista = datiService.listaAllDatiDispositivo(cod_dispositivo);
                session.setAttribute("auto", auto);
                session.setAttribute("lista", lista);
                session.setAttribute("view", "findAuto.jsp");
                MainDispatcherServlet.getInstance(request).callView(request, response);
            }
            break;

            case "terminaAssegnazioneAutoDriver": {
                String proprietario = (String) session.getAttribute("username");
                int cod_dispositivo = Integer.parseInt(request.getParameter("cod_dispositivo"));
                if (!AutoService.getService().terminaAssegnazioneAutoDriver(cod_dispositivo, proprietario)) {
                    session.setAttribute("status", "success");
                } else {
                    session.setAttribute("status", "error");
                }
                session.setAttribute("view", "aziendaTerminaNoleggio.jsp");
                MainDispatcherServlet.getInstance(request).callView(request, response);
            }
            break;

            case "listaAutoAzienda": {
                List<Auto> listaAutoAzienda;
                String proprietario = (String) session.getAttribute("username");
                autoService = new AutoService();
                listaAutoAzienda = autoService.listaAutoAzienda(proprietario);
                session.setAttribute("listaAutoAzienda", listaAutoAzienda);
                session.setAttribute("view", "viewListAuto.jsp");
                MainDispatcherServlet.getInstance(request).callView(request, response);
            }
            break;

            case "autoConErrori": {
                DatiService datiService = new DatiService();
                List<AutoConErrore> autoConErrori = datiService.listaAutoErrori(username);
                session.setAttribute("autoConErrori", autoConErrori);
                session.setAttribute("view", "viewAutoConErrori.jsp");
                MainDispatcherServlet.getInstance(request).callView(request, response);
            }
            break;
        }
    }
}



