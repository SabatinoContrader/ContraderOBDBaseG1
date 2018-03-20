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
<%String name = (String)session.getAttribute("Name");
 int ruolo = (Integer)session.getAttribute("Ruolo");
%>
Benvetuto in Contrader <%=name%> <br>
<div>
Il tuo ruolo è : <%=ruolo%>
</div>


  
</body>
</html>
