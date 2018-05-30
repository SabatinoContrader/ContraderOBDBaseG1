<%@ page import="com.virtualpairprogrammers.domain.Utente" %>

<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<form action="CandidatoServlet" method="post">
    Username<input type="text"  name="username">
    Password<input type="text"  name="password">
    Nome<input type="text" name="nome">
    Cognome<input type="text"  name="cognome">
    Indirizzo<input type="text"  name="indirizzo">
    Codice_fiscale<input type="text"  name="codice_fiscale">
    Telefono<input type="text"  name="telefono">
    Email<input type="text"  name="email">
    <input type="submit" value="Registrati" name="richiesta">
    </form>
</body>
</html>

