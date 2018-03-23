<%--
  Created by IntelliJ IDEA.
  User: Contrar18002
  Date: 19/03/2018
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Scanner"%>
<%@ page import="com.virtualpairprogrammers.domain.Auto"%>
<%@ page import="com.virtualpairprogrammers.domain.Dati_dispositivo"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%  session.removeAttribute("view");
    String role = (String) session.getAttribute("role");
    int cod_dispositivo= Integer.parseInt(session.getAttribute("cod_dispositivo").toString());
    Auto auto = (Auto) session.getAttribute("auto");
    List<Dati_dispositivo> listaDatiAuto = (List<Dati_dispositivo>) session.getAttribute("lista");
%>

<div style="width:400px; position:relative; top:100px; left:50%; margin-left:-200px;">
    <form action="MainDispatcherServlet" method="post">
        <fieldset>
            <legend>Notifiche per l'auto <% out.print(auto.getCasa_Costruttrice() + " " + auto.getModello()); %></legend>
            <%  int errore = 0;
                                for(int i = 0; i < listaDatiAuto.size(); i++)
                                {
                                    Dati_dispositivo dato = listaDatiAuto.get(i);
                                    if(dato.getCodice_Errore() != null)
                                    {
                                        errore = 1;
                                        out.println("ALERT! Errore: " + dato.getCodice_Errore() + " ricevuto in data " + dato.getData());
                                    }
                                }
                                if(errore == 0)
                                {
                                    out.println("Nessun errore rilevato su quest'auto <br>");
                                }

                                if(listaDatiAuto.size() != 0) {
                                    Dati_dispositivo dato = listaDatiAuto.get(listaDatiAuto.size() - 1);
                                    Scanner scanner = new Scanner(auto.getRevisione()).useDelimiter("/");
                                    int gg_revisione = scanner.nextInt();
                                    int mm_revisione = scanner.nextInt();
                                    int aa_revisione = scanner.nextInt();
                                    scanner = new Scanner(auto.getTagliando_Data()).useDelimiter("/");
                                    int gg_tagliando = scanner.nextInt();
                                    int mm_tagliando = scanner.nextInt();
                                    int aa_tagliando = scanner.nextInt();
                                    scanner = new Scanner(dato.getData()).useDelimiter("/");
                                    int gg_dato = scanner.nextInt();
                                    int mm_dato = scanner.nextInt();
                                    int aa_dato = scanner.nextInt();
                                    int revisione = gg_revisione + mm_revisione * 365 / 12 + aa_revisione * 365;
                                    int tagliando = gg_tagliando + mm_tagliando * 365 / 12 + aa_tagliando * 365;
                                    int data = gg_dato + mm_dato * 365 / 12 + aa_dato * 365;

                                    int km = dato.getKm() - auto.getTagliando_Km();

                                    if (data - revisione > 365 + 365 / 12 * 11) {
                                        out.println("La revisione scadrà tra meno di 1 mese!<br>");
                                    }
                                    else if (((data - tagliando) > 365 + 365 / 12 * 11) || km > 14500) {
                                        out.println("Il tagliando è in scadenza!<br>");
                                    }
                                    else
                                    {
                                        out.println("Nessuna prossima scadenza su quest'auto<br>");
                                    }
                                }
                                else
                                {
                                    out.println("Nessun dato rilevato per quest'auto<br>");
                                }   %>
        </fieldset>
    </form>
    <form action="MainDispatcherServlet" method="post">
        <input type="submit" value="Logout" name="bott">
    </form>
</body>
</html>
