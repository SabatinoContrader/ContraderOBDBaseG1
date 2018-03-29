package com.virtualpairprogrammers.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String mode = session.getAttribute("mode").toString();

        switch (mode) {
            case "Login": {
                session.setAttribute("servlet", "Home");
                session.setAttribute("role", null);
                session.setAttribute("id", null);
                MainDispatcherServlet.getInstance(request).callAction(request, response);
            }
            break;
        }
    }
}



