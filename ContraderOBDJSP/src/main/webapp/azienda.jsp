<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List"%>
<%@ page import="com.virtualpairprogrammers.domain.Auto"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.virtualpairprogrammers.services.AutoService" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

   

    <script>
    function myFunction() {
        var x = document.getElementById("myDIV");
        if (x.style.display === "none") {
            x.style.display = "block";
        } else {
            x.style.display = "none";
        }
    }
    </script>
</head>
<body background="sfondo.jpg">
<%
    session.setAttribute("method", "callAction");
    session.setAttribute("servlet","Auto");
    session.setAttribute("role","reg");
    session.getAttribute("username");
    String username =(String) session.getAttribute("username");
    AutoService autoService = new AutoService();
    List<Auto> auto = autoService.listaAutoAzienda(username);
    String role = (String) session.getAttribute("role");
    String aziendaFa = (String) session.getAttribute("aziendaFa");
%>
<div class="topnav">
  <a class="active" href="#home">Home Azienda</a>
  <a href="#news" onclick="myFunction()">Add Driver</a>
  <a href="#contact">Contact</a>
  <a href="#about">About</a>
</div>

<br>

<div id="myDIV" class="myDIV" align="center">
 <br>
  <h4>Assegnazione di Driver ad Auto. Inserire i dati del Driver e dell'auto</h4>

    <form action="MainDispatcherServlet" method="post">
       <table>
           <tr>
               <td>Nome Driver:</td> <td><input type="text" name="id_driver" id="id_driver"></td>
           </tr>
            <tr>
              <td>Id Auto:</td> <td><input type="text" name="id_auto" id="id_auto"></td>
           </tr>
            <tr>
                 <td><td><input type="submit" value="AssegnaDriver" name="bott"></td>
            </tr>
       </table>
   </form>
</div>
</div>

<%

		if(!auto.isEmpty()){
			%><table>
			<%for(Auto au: auto){%>
				<tr>
				   <td> <% out.print(au.getTarga()); %></td>
				   <td> <% out.print(au.getCasa_Costruttrice()) ;%></td>
				   <td> <% out.print( au.getModello()) ;%></td>
				   <td> <% out.print(au.getTagliando_Data()) ;%></td>
				   <td> <% out.print(au.getRevisione()) ;%></td>
				   <td> <% out.print(au.getDriver()) ;%></td>
				   <td> <% out.print(au.getTagliando_Km()) ;%></td>
				   <td> <% out.print(au.getTelaio()) ;%></td>
				   <td> <% out.print(au.getTipologia()) ;%></td>
				</tr>
				
			<%}%>
	</table>
<%}%>


<form>


<input type="submit" value="button"/>

</form>

</body>
</html>