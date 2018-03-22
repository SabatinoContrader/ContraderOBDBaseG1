<!DOCTYPE html>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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
      background-color: #c0c0c0;
      color: white;
      align:center;
    }

    .myDIV{
    background-color: silver;
    position:relative;
    width: 800px;
    height: 400px;
    top: 50px;
    left:50%;
    margin-left: -400px;
    align:center;
    }
    </style>

    <script>
    function myFunction() {
        var x = document.getElementById("myDIV");
        if (x.style.display === "none") {
            x.style.display = "block";
        } else {
            x.style.display = "none";
        }
    }
    </script>
</head>
<body background="sfondo.jpg">
<%
    session.setAttribute("method", "callAction");
    session.setAttribute("servlet","Auto");
    session.setAttribute("mode", "updateAuto");
    String role = (String) session.getAttribute("role");
%>

<div class="topnav">
  <a class="active" href="#home">Home Azienda</a>
  <a href="#news" onclick="myFunction()">Add Driver</a>
  <a href="#contact">Contact</a>
  <a href="#about">About</a>
</div>

<br>

 <div id="myDiv" class = "myDiv" align="center"> <h2> Modifica Auto </h2>
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
                    <td collspan="2"><input type="submit" value= "Modifica" name="bott" align="center"> </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>