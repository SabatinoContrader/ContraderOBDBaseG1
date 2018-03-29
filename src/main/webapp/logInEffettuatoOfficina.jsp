<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8" language = "java"%>
<!DOCTYPE html>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body background="sfondo.jpg">



<div style="width:250px;position:relative;top:300px;left:730px;">
    <form action="get" method = "POST">
        <fieldset>
            <legend align="center">Log In Effettuato ${utente.getEmail()} Marca auto dell'Officina:</legend>
            	<table>
	            	<c:forEach items = "${autoOfficina}" var="Auto"> 
		            	
			                <tr>
			                	<td>${Auto.getMarca()}</td>
			                </tr>
		            	
	            	</c:forEach>
            	</table>
        </fieldset>
    </form>
</div>
</body>
</html>