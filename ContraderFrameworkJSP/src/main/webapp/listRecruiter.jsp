<%@ page import="com.virtualpairprogrammers.domain.Utente" %>

<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <% List<Utente> recruiters = (List<Utente>) session.getAttribute("listRecruiter");
        String ruolo = ((String) session.getAttribute("ruolo"));
    %>
</head>
<body>
<table>
    <tr>
        <th>
            Id
        </th>

        <th>
            Nome
        </th>
        <th>
            Cognome
        </th>
        <th>
            Indirizzo
        </th>
        <th>
            Codice Fiscale
        </th>
        <th>
            Telefono
        </th>
        <th>
            Email
        </th>
    </tr>

    <%for (Utente recruiter : recruiters) { %>
    <tr>

        <td>
            <%= recruiter.getId()%>
        </td>


        <td>
            <%= recruiter.getNome()%>
        </td>

        <td>
            <%= recruiter.getCognome()%>
        </td>

        <td>
            <%= recruiter.getIndirizzo()%>
        </td>

        <td>
            <%= recruiter.getCodice_fiscale()%>
        </td>

        <td>
            <%= recruiter.getTelefono()%>
        </td>

        <td>
            <%= recruiter.getEmail()%>
        </td>

    </tr>
    <% }%>
</table>
<a href="homeGestore.jsp">Home</a>
</body>
</html>