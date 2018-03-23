<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.virtualpairprogrammers.domain.Driver"%>
<%@ page import="com.virtualpairprogrammers.dao.*"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.virtualpairprogrammers.services.Dati_DispositivoService" %>
<%@ page import="com.virtualpairprogrammers.services.DriverService" %>
<html>

<head>
    <title>Title</title>
</head>
<body>
<%  session.removeAttribute("view");
session.setAttribute("mode", "VediListaDriver");
    session.setAttribute("method", "callAction");
    session.setAttribute("servlet", "Auto");
    String role = (String) session.getAttribute("role");
    String username =(String) session.getAttribute("username");
    DriverService driverService = DriverService.getService();
    List<Driver> listaDriver =  driverService.getAllDriver();
    if(listaDriver==null)
    	 System.out.println("lista driver vuota");
    
 %>



    

<div>
  <%if(!listaDriver.isEmpty()){ 
	  for(Driver driver: listaDriver) {%>
    
    <table>
        <tr>
          <td>
              <%= driver.getNome() %>
          </td>
          <td>
               <%= driver.getCognome() %>
          </td>
           <td>
               <%= driver.getCf() %>
          </td>
           <td>
               <%= driver.getResidenza() %>
          </td>
        </tr>
    
    </table>
  <%}} %>
    </div>
   
    
</body>
</html>
