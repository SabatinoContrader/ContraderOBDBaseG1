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
            <%@ page import="com.virtualpairprogrammers.domain.Driver"%>
                <% List<Driver> listaDriver = (List<Driver>) session.getAttribute("listaDriver"); %>

</head>

<body>

    <div id="wrapper">

        <%@ include file = "header.jsp" %>

            <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Driver</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
                <div class="row">
                    <div class="col-lg-9">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <i class="fa fa-user fa-fw"></i> Elenco driver
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th>Cognome</th>
                                                <th>Nome</th>
                                                <th>Codice fiscale</th>
                                                <th>Email</th>
                                                <th>Cellulare</th>
                                                <th>Residenza</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <% if (listaDriver.isEmpty()) { %>
                                                <tr>
                                                    <td colspan="6" align="center">Nessun driver registrato</td>
                                                </tr>
                                                <% } else { for (int i = 0; i < listaDriver.size(); i++) { %>
                                                    <tr>
                                                        <td>
                                                            <%= listaDriver.get(i).getCognome() %>
                                                        </td>
                                                        <td>
                                                            <%= listaDriver.get(i).getNome() %>
                                                        </td>
                                                        <td>
                                                            <%= listaDriver.get(i).getCf() %>
                                                        </td>
                                                        <td>
                                                            <%= listaDriver.get(i).getEmail() %>
                                                        </td>
                                                        <td>
                                                            <%= listaDriver.get(i).getCellulare() %>
                                                        </td>
                                                        <td>
                                                            <%= listaDriver.get(i).getResidenza() %>
                                                        </td>
                                                    </tr>
                                                    <% } }%>
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