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
    session.setAttribute("mode", "list");
    session.setAttribute("method", "callAction");
    session.setAttribute("servlet", "Auto");
    String role = (String) session.getAttribute("role"); %>

<div style="width:400px; position:relative; top:100px; left:50%; margin-left:-200px;">
    <form action="MainDispatcherServlet" method="post">
        <fieldset>
            <legend>Lista officine, <% out.print(role); %></legend>
            <table>
                <tr>
                    <td>Città</td>
                    <td><input type="text" name="citta"></td>
                    <td><input type="submit" value="Cerca per città" name="bott"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Visualizza tutte" name="bott"></td>
                </tr>
            </table>
        </fieldset>
    </form>
    <form action="MainDispatcherServlet" method="post">
        <input type="submit" value="Logout" name="bott">
    </form>
</body>
</html>
