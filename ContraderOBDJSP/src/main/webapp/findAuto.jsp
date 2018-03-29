<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="vendor/img/favicon.ico">

    <title>Contrader | OBD project</title>

    <!-- Bootstrap Core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="vendor/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <%@ page import="java.util.List"%>
            <%@ page import="java.util.List"%>
                <%@ page import="java.util.Scanner"%>
                    <%@ page import="com.virtualpairprogrammers.domain.Auto"%>
                        <%@ page import="com.virtualpairprogrammers.domain.Dati_dispositivo"%>
                            <% int cod_dispositivo= Integer.parseInt(session.getAttribute("cod_dispositivo").toString());
                    Auto auto = (Auto) session.getAttribute("auto");
                    List<Dati_dispositivo> listaDatiAuto = (List<Dati_dispositivo>) session.getAttribute("lista"); %>

</head>

<body>

    <div id="wrapper">

        <%@ include file = "header.jsp" %>

            <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Officine</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
                <div class="row">
                    <div class="col-lg-9">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <i class="fa fa-automobile fa-fw"></i>
                                <%= auto.getCasa_Costruttrice() + " " + auto.getModello() %>
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                Codice dispositivo:
                                <%= auto.getCod_Dispositivo() %>
                                    <br> Targa:
                                    <%= auto.getTarga() %>
                                        <br> Num. telaio:
                                        <%= auto.getTelaio() %>
                                            <br> Casa costruttrice:
                                            <%= auto.getCasa_Costruttrice() %>
                                                <br> Modello:
                                                <%= auto.getModello() %>
                                                    <br> Alimentazione:
                                                    <%= auto.getAlimentazione() %>
                                                        <br> Cambio:
                                                        <% if(auto.getCambio().equals("M")) out.print("Manuale");
                                                            else if(auto.getCambio().equals("A")) out.print("Automatico"); %>
                                                            <br> Ultima revisione:
                                                            <%= auto.getRevisione() %>
                                                                <br> Ultimo tagliando:
                                                                <%= auto.getTagliando_Data() %> effettuato a
                                                                    <%= auto.getTagliando_Km() %> km
                                                                        <br>

                                                                        <div class="table-responsive">
                                                                            <table class="table">
                                                                                <title>
                                                                                    Dati del dispositivo
                                                                                </title>
                                                                                <thead>
                                                                                    <tr>
                                                                                        <th>Data</th>
                                                                                        <th>Km</th>
                                                                                        <th>Livello olio</th>
                                                                                        <th>Errore</th>
                                                                                    </tr>
                                                                                </thead>
                                                                                <tbody>
                                                                                    </tr>
                                                                                    <% if(listaDatiAuto.size() == 0) { %>
                                                                                        <tr>
                                                                                            <td colspan="4">Nessun dato presente per quest'auto</td>
                                                                                        </tr>
                                                                                        <% } else { for(int i = 0; i < listaDatiAuto.size(); i++) { Dati_dispositivo dato = listaDatiAuto.get(i); %>
                                                                                            <tr>
                                                                                                <td>
                                                                                                    <%= dato.getData() %>
                                                                                                </td>
                                                                                                <td>
                                                                                                    <%= dato.getKm() %>
                                                                                                </td>
                                                                                                <td>
                                                                                                    <%= dato.getLivello_olio() %>
                                                                                                </td>
                                                                                                <td>
                                                                                                    <%= dato.getCodice_Errore() %>
                                                                                                </td>
                                                                                            </tr>
                                                                                            <% } } %>
                                                                                </tbody>
                                                                            </table>
                                                                        </div>
                            </div>
                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                    </div>
                    <%@ include file = "tabs.jsp" %>
                </div>
                <!-- /.row -->
            </div>
            <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="vendor/raphael/raphael.min.js"></script>
    <script src="vendor/morrisjs/morris.min.js"></script>
    <script src="data/morris-data.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="dist/js/sb-admin-2.js"></script>

</body>

</html>