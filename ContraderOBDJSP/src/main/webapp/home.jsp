<%--
  Created by IntelliJ IDEA.
  User: Contrar18002
  Date: 19/03/2018
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List"%>
<%@ page import="com.virtualpairprogrammers.domain.Auto"%>
<html>
<head>
    <title>Title</title>
    <link href="styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<%  String role = (String) session.getAttribute("role");
    String id = (String) session.getAttribute("id");
    String status = (String) session.getAttribute("status"); %>

<div style="width:400px; position:relative; top:100px; left:50%; margin-left:-200px;">
    <form action="MainDispatcherServlet" method="post">
        <fieldset>
            <legend>Benvenuto in Contrader, <% out.print(role); %></legend>
            <% if( role.equals("owner")) { %>
            <table>
                <tr>
                    <td><a href="addOfficina.jsp">Aggiungi officina</a></td>
                </tr>
                <tr>
                    <td><a href="listOfficina.jsp">Lista officine</a></td>
                </tr>
            </table>
            <% } else if( role.equals("officina")) { %>
            <table>
                <tr>
                    <td><a href="officinaAddAuto.jsp">Aggiungi Auto</a></td>
                </tr>
                <tr>
                    <td><a href="officinaUpdateAuto.jsp">Modifica Auto</a></td>
                 <tr>
                    <td><a href="officinaAddAzienda.jsp">Aggiungi Azienda</a></td>
                 </tr>
                 <tr>
                    <td><a href="officinaResetAuto.jsp">Rimuovi Auto</a></td>
                </tr>
                </tr>
            </table>
            <% } else if( role.equals("azienda")) { %>
            <table>
                <tr>
                    <td><a href="aziendaAddDriverAuto.jsp">Associa un'auto ad un driver</a></td>
                </tr>

            </table>
            <% } else if( role.equals("driver")) { %>
            <table>
                <% List<Auto> lista = (List<Auto>) session.getAttribute("lista");
                if (lista.isEmpty()) { %>
                 <tr>
                    <td>Nessuna auto noleggiata</td>
                 </tr>
                <% } else { for (int i = 0; i < lista.size(); i++) { %>
                <tr>
                    <td>
                        <form action="MainDispatcherServlet" method="post">
                            <button class="btn-pulito" type="submit" value="<% out.print(lista.get(i).getCod_Dispositivo()); %>" name="cod_dispositivo">
                                <% out.print(lista.get(i).getCasa_Costruttrice() + " " + lista.get(i).getModello() + " targata " + lista.get(i).getTarga()); %>
                            </button>
                        </form>
                    </td>
                </tr>
                <% } }%>
            </table>
            <% } %>
        </fieldset>
    </form>
    <form action="MainDispatcherServlet" method="post">
        <input type="submit" value="Logout" name="bott">
    </form>
</body>
</html>
