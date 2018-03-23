<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.virtualpairprogrammers.domain.Auto"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.virtualpairprogrammers.services.Dati_DispositivoService" %>
<%@ page import="com.virtualpairprogrammers.services.AutoService" %>
<html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%  session.removeAttribute("view");
    session.setAttribute("mode", "list");
    session.setAttribute("method", "callAction");
    session.setAttribute("servlet", "Officina");
    String role = (String) session.getAttribute("role");
    String username =(String) session.getAttribute("username");
    System.out.println("username "+username);
    Dati_DispositivoService dati_DispositivoService = Dati_DispositivoService.getService();
    ResultSet resultSet =  dati_DispositivoService.listaAutoErrori(username); 
  %>

<div style="width:400px; position:relative; top:100px; left:50%; margin-left:-200px;">

</div>
    
    <%if(resultSet.isBeforeFirst()) %>
    <table>
        <%while(resultSet.next()){ %>
	      <tr> 
	          <td><% out.print(resultSet.getString("cod_dispositivo"));%></td>
	          <td><% out.print(resultSet.getString("targa"));%></td>
	          <td><% out.print(resultSet.getString("modello"));%></td>
	          <td><% out.print(resultSet.getString("km"));%></td>
	      </tr>
           <%} %>
    </table>
    <%  %>
    
    
</body>
</html>
