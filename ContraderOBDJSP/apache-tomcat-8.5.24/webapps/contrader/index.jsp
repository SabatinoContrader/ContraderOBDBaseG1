<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ContraderOBD</title>
</head>
<body>
<%
    session.setAttribute("method", "callAction");
    session.setAttribute("servlet",null);
%>
<div style="width:250px;position:relative;top:300px;left:730px;">
    <form action="MainDispatcherServlet" method="post">
        <fieldset>
            <legend align="center">Welcome project ContraderOBD</legend>
            <table>
                <tr>
                    <td>Username</td>
                    <td><input type="text" name="user"></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td>
                        <input type="password" name="pwd">
                    </td>
                <tr align="center">
                    <td colspan="2">
                        <input type="submit" value="Login" name="bott">
                    </td>
                </tr>
            </table>
        </fieldset>
    </form>
</div>
</body>
</html>