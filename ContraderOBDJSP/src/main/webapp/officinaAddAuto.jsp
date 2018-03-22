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
    session.setAttribute("servlet","Auto");
    session.setAttribute("mode", "addAuto");
    String role = (String) session.getAttribute("role");
%>

    <div id="myDiv" class = "myDiv" align="center"> <h2> Inserisci Auto </h2>
        <form action="MainDispatcherServlet" method="post">
            <table>
                <tr>
                    <td> <b> Cod Dispositivo</b>: </td><td> <input type="text" name="cod_disp" align="center" > </td>
                </tr>
                <tr>
                    <td> <b> Targa</b>: </td><td><input type="text" name="targa" align="center"> </td>
                </tr>
                <tr>
                    <td> <b> Telaio</b>: </td><td> <input type="text" name="telaio" align="center"> </td>
                </tr>
                <tr>
                    <td> <b> Casa Costruttrice</b>: </td><td><input type="text" name="casa_cost" align="center"> </td>
                </tr>
                <tr>
                    <td> <b> Modello</b>: </td><td><input type="text" name="modello" align="center"> </td>
                </tr>
                <tr>
                    <td> <b> Alimentazione</b>: </td><td> <input type="text" name="alimentazione" align="center"> </td>
                </tr>
                <tr>
                    <td> <b> Tipologia</b>: </td><td><input type="text" name="tipologia" align="center"> </td>
                </tr>
                <tr>
                    <td> <b> Cambio (A/M)</b>: </td><td> <input type="text" name="cambio" align="center"> </td>
                </tr>
                <tr>
                    <td> <b> Proprietario</b>: </td><td><input type="text" name="proprietario" align="center"> </td>
                </tr>
                <tr>
                    <td> <b> Revisione</b>: </td><td> <input type="text" name="revisione" value = "2018-01-01"
                                                                                                      onfocus = "if (this.value==this.defaultValue)this.value=''" align="center">
                                                                                                       </td>
                </tr>
                <tr>
                    <td> <b> Tagliando (Data)</b>: </td><td><input type="text" name="tagliando_data" value = "2018-01-01"align="center"
                        onfocus = "if (this.value==this.defaultValue)this.value=''"> </td>
                </tr>
                <tr>
                    <td> <b> Tagliando (km)</b>: </td><td><input type="text" name="tagliando_km" align="center"> </td>
                </tr>
                <tr>
                    <td collspan="2"><input type="submit" value= "Inserisci" name="bott" align="center"> </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
