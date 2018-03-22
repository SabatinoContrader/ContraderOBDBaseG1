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
                    <td>Menu officina</td>
                </tr>
                <tr>
                    <td><a href="officinaAddAuto.jsp">Aggiungi auto</a></td>
                </tr>

            </table>
            <% } else if( role.equals("azienda")) { %>
            <table>
                <tr>
                    <td>Menu azienda</td>
                </tr>
                <tr>
                    <td><a href="aziendaAddDriverAuto.jsp">Associa un'auto ad un driver</a></td>
                </tr>

            </table>
            <% } else if( role.equals("driver")) { %>
            <table>
                <tr>
                    <td>Menu driver</td>
                </tr>
            </table>
            <% } %>
        </fieldset>
    </form>
    <form action="MainDispatcherServlet" method="post">
        <input type="submit" value="Logout" name="bott">
    </form>
</body>
</html>
