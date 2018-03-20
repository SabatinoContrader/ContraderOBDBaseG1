package com.vianelloProjectJsp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vianelloProjectJsp.model.Utente;
import com.vianelloProjectJsp.services.LoginService;


public class HomeServlet extends HttpServlet
{
    private LoginService loginService;
    private Utente utente;

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String firstName = (String) session.getAttribute("firstname");
        String role = (String) session.getAttribute("role");
        loginService =LoginService.getService();

        if ((request != null)&&(role== null)&&(firstName==null))
        {

            String userName = request.getParameter("user");
            String password = request.getParameter("pwd");

            utente = this.loginService.login(userName, password);

            if (utente != null)
            {
                
                session.setAttribute("Name", utente.getNome());
                session.setAttribute("Ruolo",utente.getRuolo());
                session.setAttribute("view", "home.jsp");
                MainDispatcherServlet.getInstance(request).callView(request, response);
            }

            else
                {
                    session.setAttribute("view", "index.jsp");
                    MainDispatcherServlet.getInstance(request).callView(request, response);
                }
        }
        else
            {
                session.setAttribute("view", "home.jsp");
                MainDispatcherServlet.getInstance(request).callView(request, response);
            }
    }


}
