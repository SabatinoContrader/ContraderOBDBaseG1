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
<%  session.removeAttribute("view");
    session.setAttribute("mode", "add");
    session.setAttribute("method", "callAction");
    session.setAttribute("servlet", "Officina");
    String role = (String) session.getAttribute("role"); %>

<div style="width:400px; position:relative; top:100px; left:50%; margin-left:-200px;">
    <form action="MainDispatcherServlet" method="post">
        <fieldset>
            <legend>Aggiungi officina, <% out.print(role); %></legend>
            <table>
                <tr>
                    <td>Nome</td>
                    <td><input type="text" name="nome"></td>
                </tr>
                <tr>
                    <td>Indirizzo</td>
                    <td><input type="text" name="indirizzo"></td>
                </tr>
                <tr>
                    <td>Città</td>
                    <td><input type="text" name="citta"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Aggiungi" name="bott"></td>
                </tr>
            </table>
        </fieldset>
    </form>
    <form action="MainDispatcherServlet" method="post">
        <input type="submit" value="Logout" name="bott">
    </form>
</body>
</html>
