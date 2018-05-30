<%@ page import="com.virtualpairprogrammers.domain.Annunci" %>

<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<form action="GestoreServlet" method="post">
Saluti a tutti
    Titolo<input type="text"  name="titolo">
    Luogo<input type="text"  name="luogo">
    Categoria<input type="text" name="categoria">
    Contratto<input type="text"  name="contratto">
    <input type="submit" value="Inserisci Annuncio" name="richiesta">
    </form>
</body>
</html>