package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.services.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class HomeServlet extends HttpServlet
{
    private LoginService loginService;
    private String result="";

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String id = (String) session.getAttribute("id");
        String role = (String) session.getAttribute("role");
        loginService =LoginService.getService();

        if ((request != null)&&(role== null)&&(id==null))
        {

            String userName = request.getParameter("user");
            String password = request.getParameter("pwd");
            session.setAttribute("username", userName);

            result = this.loginService.login(userName, password);

            if (result != null)
            {
                String[] part = result.split(":");
                session.setAttribute("role", part[0]);
                session.setAttribute("id", part[1]);
                if(part[0].equals("driver"))
                    {
                        session.setAttribute("servlet", "Auto");
                        session.setAttribute("mode", "listaAutoDriver");
                        MainDispatcherServlet.getInstance(request).callAction(request, response);
                    }
                else
                    {
                        session.setAttribute("view", "home.jsp");
                        MainDispatcherServlet.getInstance(request).callView(request, response);
                    }
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
