package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.domain.Driver;
import com.virtualpairprogrammers.services.DriverService;

public class DriverServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private DriverService driverService;


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String mode = (String) session.getAttribute("mode");
        String role = (String) session.getAttribute("role");
        Integer id_azienda = Integer.parseInt(session.getAttribute("id").toString());

        switch (mode) {

            case "listaDriver":
                driverService = new DriverService();
                List<Driver> listaDriver = driverService.getAllDriver(id_azienda);
                session.setAttribute("listaDriver", listaDriver);
                session.setAttribute("view", "viewListDriver.jsp");
                MainDispatcherServlet.getInstance(request).callView(request, response);
                break;

            case "addDriver":
                int id_driver = Integer.parseInt(request.getParameter("id_driver"));
                String nome = request.getParameter("nome");
                String cognome = request.getParameter("cognome");
                String cf = request.getParameter("cf");
                String email = request.getParameter("email");
                String cellulare = request.getParameter("cellulare");
                String residenza = request.getParameter("residenza");
                if (role.equals("officina")) id_azienda = null;
                Driver driver = new Driver(id_driver, nome, cognome, cf, email, cellulare, residenza, id_azienda);
                driverService = new DriverService();
                if (!driverService.insertDriver(driver)) {
                    session.setAttribute("status", "success");
                } else {
                    session.setAttribute("status", "error");
                }
                session.setAttribute("view", "addDriver.jsp");
                MainDispatcherServlet.getInstance(request).callView(request, response);
                break;

        }
    }

}
