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
                                ${findAuto.casaCostruttrice} ${findAuto.modello}
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                Codice dispositivo: ${findAuto.codDispositivo}
                                <br> Targa: ${findAuto.targa}
                                <br> Num. telaio: ${findAuto.telaio}
                                <br> Casa costruttrice: ${findAuto.casaCostruttrice}
                                <br> Modello: ${findAuto.modello}
                                <br> Alimentazione: ${findAuto.alimentazione}
                                <br> Cambio:
                                <c:choose>
                                    <c:when test="${findAuto.cambio == M}">
                                        Manuale
                                    </c:when>
                                    <c:when test="${findAuto.cambio == A}">
                                        Automatico
                                    </c:when>
                                </c:choose>
                                <br> Ultima revisione: ${findAuto.revisione}
                                <br> Ultimo tagliando: ${findAuto.tagliandoData} effettuato a ${findAuto.tagliandoKm} km
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
                                            <c:if test="${findAuto.datiEntitySet.isEmpty()}">
                                                <tr>
                                                    <td colspan="4" align="center">Nessun dato presente per quest'auto</td>
                                                </tr>
                                            </c:if>
                                            <c:forEach items="${findAuto.datiEntitySet}" var="dato">
                                                <tr>
                                                    <td>
                                                        ${dato.data}
                                                    </td>
                                                    <td>
                                                        ${dato.km}
                                                    </td>
                                                    <td>
                                                        ${dato.livelloOlio}
                                                    </td>
                                                    <td>
                                                        ${dato.codErrore}
                                                    </td>
                                                </tr>
                                            </c:forEach>
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