<%--
  Created by IntelliJ IDEA.
  User: Contrader18006
  Date: 23/05/2018
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%String nome =((String) session.getAttribute("nome"));
    String cognome =((String) session.getAttribute("cognome"));
    String ruolo =((String) session.getAttribute("ruolo"));
    Integer id = ((Integer) session.getAttribute("id"));%>
    <title>Piattaforma di Recruitment</title>
</head>
<body>
<h1>Benvenuto nel sito</h1>
<h2>Menu Candidato</h2>
<h3><%= nome %></h3>
<form action="CandidatoServlet" method="post">
<input type="submit" value="Lista annunci" name="richiesta">
</form>
<form action="LogoutServlet" method="post">
<input type="submit" value="Logout" name="richiesta">
</form>
</body>
</html>