<%--
  Created by IntelliJ IDEA.
  User: Contrar18002
  Date: 19/03/2018
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Scanner"%>
<%@ page import="com.virtualpairprogrammers.domain.Auto"%>
<%@ page import="com.virtualpairprogrammers.domain.Dati_dispositivo"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%  session.removeAttribute("view");
    String role = (String) session.getAttribute("role");
    int cod_dispositivo= Integer.parseInt(session.getAttribute("cod_dispositivo").toString());
    Auto auto = (Auto) session.getAttribute("auto");
    List<Dati_dispositivo> listaDatiAuto = (List<Dati_dispositivo>) session.getAttribute("lista");
%>

<div style="width:400px; position:relative; top:100px; left:50%; margin-left:-200px;">
    <form action="MainDispatcherServlet" method="post">
        <fieldset>
            <legend><% out.print(auto.getCasa_Costruttrice() + " " + auto.getModello()); %></legend>
            <table>
                <tr><td>Codice dispositivo: <%= auto.getCod_Dispositivo() %></td></tr>
                <tr><td>Targa: <%= auto.getTarga() %></td></tr>
                <tr><td>Num. telaio: <%= auto.getTelaio() %></td></tr>
                <tr><td>Modello: <%= auto.getCasa_Costruttrice() %></td></tr>
                <tr><td>Alimentazione: <%= auto.getAlimentazione() %></td></tr>
                <tr><td>Cambio: <%= auto.getCambio() %></td></tr>
                <tr><td>Ultima revisione: <%= auto.getRevisione() %></td></tr>
                <tr><td>Ultimo tagliando: <%= auto.getTagliando_Data() %> effettuato a <%= auto.getTagliando_Km() %> km</td></tr>
                <tr><td>Dati del dispositivo:</td></tr>
            </table>
            <br>
            <table style="width:100%">
                <tr><td>Data</td><td>Km</td><td>Livello Olio</td><td>Errore</td></tr>
                <% if(listaDatiAuto.size() == 0) { %><tr><td>Nessun dato presente per quest'auto</td></tr>
                <% } else { for(int i = 0; i < listaDatiAuto.size(); i++) { Dati_dispositivo dato = listaDatiAuto.get(i); %>
                <tr><td><%= dato.getData() %></td><td><%= dato.getKm() %></td><td><%= dato.getLivello_olio() %></td><td><%= dato.getCodice_Errore() %></td></tr>
                <% } } %>
            </table>
        </fieldset>
    </form>
    <form action="MainDispatcherServlet" method="post">
        <input type="submit" value="Logout" name="bott">
    </form>
</body>
</html>
