<%@ page import="com.virtualpairprogrammers.domain.Utente" %>

<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
 <% List<Utente> candidati = (List<Utente>) session.getAttribute("listCandidati");
    String ruolo =((String) session.getAttribute("ruolo"));%>
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
    <th>
    Valutazione
    </th>
    <th>
    Commenti
    </th>
</tr>


<%for (Utente candidato : candidati){ %>
<tr>

<td>
<%= candidato.getId()%>
</td>

<td>
<%= candidato.getNome()%>
</td>

<td>
<%= candidato.getCognome()%>
</td>

<td>
<%= candidato.getIndirizzo()%>
</td>

<td>
<%= candidato.getCodice_fiscale()%>
</td>

<td>
<%= candidato.getEmail()%>

</td>

<td>
<%= candidato.getTelefono()%>
</td>

<td>
<%= candidato.getValutazione()%>
</td>

<td>
<%= candidato.getCommenti()%>
</td>


</tr>
<% }%>
</table>
 <%if (ruolo.equals("gestore")){%>
                <a href="homeGestore.jsp">Home</a>
                <%} else if (ruolo.equals("recruiter")){%>
                <a href="homeRecruiter.jsp">Home</a>
  <%}%>
<%if (ruolo.equals("recruiter")){%>
  <a href="inserimentoValutazioneCommento.jsp">Commenta e valuta candidato</a>
 <%}%>
</body>
</html>