<%--
  Created by IntelliJ IDEA.
  User: Contrar18002
  Date: 19/03/2018
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%@ page import = "com.project.model.*" %>


<%

Utente u = (Utente)session.getAttribute("Utente");

String name = u.getNome();
int ruolo = u.getRuolo() ;
 
%>
Benvetuto in Contrader <%=name%> <br>
<div>
Il tuo ruolo è : <%=ruolo%> <br> <br>



<% 
	
switch(u.getRuolo()){
case 1:
	//Officina
	%>
	<>
	<input type="submit" value="VISUALIZZA AUTO CON GUASTI" name="bott"> <br> <br>
	<input type="submit" value="VISUALIZZA LISTA UTENTI" name="bott"> <br> <br>
	<input type="submit" value="VISUALIZZA LISTA AUTO DELL'AZIENDA" name="bott"> <br> <br>
	<input type="submit" value="VISUALIZZA TUTTI I DISPOSITIVI" name="bott"> <br> <br>
	<input type="submit" value="VISUALIZZA AUTO CON REVISIONE IN SCADENZA" name="bott"> <br> <br>
	<input type="submit" value="AGGIUNGI NUOVA AUTO DELL'AZIENDA" name="bott"> <br> <br>
	<input type="submit" value="TORNA INDIETRO" name="bott"> <br> <br>
	
	<%
	break;
case 0: 
	//Cliente
	%>
	<input type="submit" value="VISUALIZZA LISTA AUTO" name="bott"> <br> <br>
	<input type="submit" value="VISUALIZZA SCADENZA REVISIONE" name="bott"> <br> <br>
	<input type="submit" value="TORNA INDIETRO" name="bott"> <br> <br>
	
	<%
	break;
case 2:
	//Admin
	%>
	<input type="submit" value="REGISTRA UTENTE" name="bott"> <br> <br>
	<input type="submit" value="REGISTRA AZIENDA" name="bott"> <br> <br>
	<input type="submit" value="TORNA INDIETRO" name="bott"> <br> <br>
	
	<%
	break;
}


%>>





</div>


  
</body>
</html>
