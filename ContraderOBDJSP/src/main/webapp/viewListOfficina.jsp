<%--
  Created by IntelliJ IDEA.
  User: Contrar18002
  Date: 19/03/2018
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List"%>
<%@ page import="com.virtualpairprogrammers.domain.Officina"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%  session.setAttribute("mode", "add");
    session.setAttribute("method", "callAction");
    session.setAttribute("servlet", "Officina");
    List<Officina> lista = (List<Officina>) session.getAttribute("lista");
    String role = (String) session.getAttribute("role"); %>

<div style="width:400px; position:relative; top:100px; left:50%; margin-left:-200px;">
    <form action="MainDispatcherServlet" method="post">
        <fieldset>
            <legend>Lista officine</legend>
            <table>
                <tr>
                    <td>Nome</td>
                    <td>Indirizzo</td>
                    <td>Citt&aacute;</td>
                </tr>
                <% if (lista.isEmpty()) { %>
                <tr>
                    <td>Nessuna officina</td>
                </tr>
                <% } else { for (int i = 0; i < lista.size(); i++) { %>
                <tr>
                    <td><% out.print(lista.get(i).getNome()); %></td>
                    <td><% out.print(lista.get(i).getIndirizzo()); %></td>
                    <td><% out.print(lista.get(i).getCitta()); %></td>
                </tr>
                <% } }%>
            </table>
        </fieldset>
    </form>
    <form action="MainDispatcherServlet" method="post">
            <input type="submit" value="Menu principale" name="bott">
        </form>
    <form action="MainDispatcherServlet" method="post">
        <input type="submit" value="Logout" name="bott">
    </form>
</body>
</html>
