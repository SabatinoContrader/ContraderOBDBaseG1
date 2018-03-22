
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
    session.setAttribute("mode", "addAutoDriver");
    String role = (String) session.getAttribute("role");
%>

<div class="topnav">
  <a class="active" href="#home">Home Azienda</a>
  <a href="#news" onclick="myFunction()">Add Driver</a>
  <a href="#contact">Contact</a>
  <a href="#about">About</a>
</div>

<br>

<div id="myDIV" class="myDIV" align="center">
 <br>
  <h4> Inserisci il codice dell'auto da rimuovere </h4>

    <form action="MainDispatcherServlet" method="post">
       <table>
           <tr>
               <td>Id Codice Dispositivo:</td> <td><input type="text" name="cod_dispositivo"></td>
           </tr>
            <tr>
                 <td><td><input type="submit" value="Reset" name="bott"></td>
            </tr>
       </table>
   </form>
</div>
</div>
</body>
</html>