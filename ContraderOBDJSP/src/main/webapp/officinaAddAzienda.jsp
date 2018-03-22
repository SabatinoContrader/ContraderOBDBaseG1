<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">

<style>
    body {
        margin: 0;
        font-family: Arial, Helvetica, sans-serif;
    }

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #4CAF50;
  color: white;
}
.myDiv {
background-color:#4CAF58;
width:400px;
position:absolute;
top:50%;
left:50%;
margin-left:-200px;

}
</style>
</head>

<body>
<%
    session.setAttribute("method", "callAction");
    session.setAttribute("servlet","Azienda");
    session.setAttribute("mode", "insertAzienda");
    String role = (String) session.getAttribute("role");
%>

    <div id="myDiv" class = "myDiv" align="center"> <h2> Inserisci Azienda </h2>
        <form action="MainDispatcherServlet" method="post">
            <table>
                <tr>
                    <td> <b> Nome </b>: </td><td> <input type="text" name="nome" align="center" > </td>
                </tr>
                <tr>
                    <td> <b> Città </b>: </td><td><input type="text" name="citta" align="center"> </td>
                </tr>
                <tr>
                    <td collspan="2"><input type="submit" value= "Inserisci" name="bott" align="center"> </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
