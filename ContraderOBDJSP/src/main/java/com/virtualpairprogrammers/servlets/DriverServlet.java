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

public class DriverServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DriverService driverService;


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession(true);
        String mode = (String) session.getAttribute("mode");

        switch (mode) {
            
            case "VediListaDriver":
            	 session.setAttribute("view", "vediListaDriver.jsp");
            	 String username =(String) session.getAttribute("username");
            	 
                 List<Driver> driver = driverService.getService().getAllDriver();
                 session.setAttribute("driver", driver);
                 MainDispatcherServlet.getInstance(request).callView(request, response);
                 break;     
        }
    }

}
