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
    session.setAttribute("mode", "terminaAssegnazioneAutoDriver");
    session.setAttribute("method", "callAction");
    session.setAttribute("servlet", "Auto");
    String role = (String) session.getAttribute("role");
    String username =(String) session.getAttribute("username");
    System.out.println("username "+username);
    AutoService autoService =  AutoService.getService();
  %>

<div style="width:400px; position:relative; top:100px; left:50%; margin-left:-200px;">
   Ciao mondo dei belli
</di>
    
    <div>
<!--      <form action="AutoServlet" method="post"> -->
<!--         <fieldset> -->
<!--             <legend>Termina assagnazione auto ad azienda></legend> -->
            
<!--              <label>Id Auto: </label> <input type="text" id="id_auto" name="id_auto"><br> -->
<!--              <input type="submit" value="Invio" name="invio"> -->
      
<!--          </fieldset> -->
<!--       </form> -->
    </div>
    
    <div>
     <form action="MainDispatcherServlet" method="post">
        <fieldset>
            <legend>Termina assagnazione auto ad azienda></legend>
           
             <label>Id Auto: </label> <input type="text" id="id_auto" name="id_auto"><br>
             <input type="submit" value="Termina Assegnazione Auto" name="bott">
         </fieldset>
      </form>
    </div>
   
    
</body>
</html>
