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
                    <%@ include file = "message.jsp" %>
                        <div class="col-lg-9">
                            <div class="panel panel-default">
                                <c:if test="${findAuto != null}">
                                    <div class="panel-heading">
                                        <i class="fa fa-automobile fa-fw"></i>
                                        ${findAuto.casaCostruttrice} ${findAuto.modello}
                                        <button class="btn btn-circle pull-right" data-toggle="modal" data-target="#formEditAuto" style="margin-top:-5px;">
                                            <i class="fa fa-edit"></i>
                                        </button>
                                        <%@ include file = "modalEditAuto.jsp" %>
                                    </div>
                                    <!-- /.panel-heading -->
                                    <div class="panel-body">
                                        <div class="row">
                                            <div class="col-md-3">Codice dispositivo:</div>
                                            <div class="col-md-3">${findAuto.codDispositivo}</div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-3">Targa:</div>
                                            <div class="col-md-3">${findAuto.targa}</div>
                                            <div class="col-md-3">Num. telaio:</div>
                                            <div class="col-md-3">${findAuto.telaio}</div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-3">Casa costruttrice:</div>
                                            <div class="col-md-3">${findAuto.casaCostruttrice}</div>
                                            <div class="col-md-3">Modello:</div>
                                            <div class="col-md-3">${findAuto.modello}</div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-3">Alimentazione:</div>
                                            <div class="col-md-3">${findAuto.alimentazione}</div>
                                            <div class="col-md-3">Cambio:</div>
                                            <div class="col-md-3">
                                                <c:choose>
                                                    <c:when test="${findAuto.cambio == 'M'.charAt(0)}">
                                                        Manuale
                                                    </c:when>
                                                    <c:when test="${findAuto.cambio == 'A'.charAt(0)}">
                                                        Automatico
                                                    </c:when>
                                                </c:choose>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-3">Ultima revisione:</div>
                                            <div class="col-md-3">${findAuto.revisione}</div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-3">Ultimo tagliando:</div>
                                            <div class="col-md-9">${findAuto.tagliandoData} effettuato a ${findAuto.tagliandoKm} km </div>
                                        </div>
                                        <div class="table-responsive">
                                            <table class="table text-center">
                                                <title>
                                                    Dati del dispositivo
                                                </title>
                                                <thead>
                                                    <tr>
                                                        <th class="text-center">Data</th>
                                                        <th class="text-center">Km</th>
                                                        <th class="text-center">Livello olio</th>
                                                        <th class="text-center">Errore</th>
                                                        <th class="text-center">Stato</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    </tr>
                                                    <c:if test="${findAuto.datiEntitySet.isEmpty()}">
                                                        <tr>
                                                            <td colspan="5">Nessun dato presente per quest'auto</td>
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
                                                            <td>
                                                                <c:if test="${dato.codErrore != null}">
                                                                    <c:choose>
                                                                        <c:when test="${dato.stato == true}">
                                                                            <button type="button" class="btn btn-success btn-circle btn-sm">
                                                                                <i class="fa fa-check"></i>
                                                                            </button>
                                                                        </c:when>
                                                                        <c:when test="${dato.stato == false}">
                                                                            <form action="fixError" method="POST">
                                                                                <button type="button" class="btn btn-danger btn-circle btn-sm">
                                                                                    <i class="fa fa-times"></i>
                                                                                </button>
                                                                                <input type="hidden" name="n" value="${dato.n}">
                                                                                <input type="hidden" name="codDispositivo" value="${findAuto.codDispositivo}">
                                                                                <button type="submit" class="btn btn-circle btn-sm">
                                                                                    <i class="fa fa-wrench"></i>
                                                                                </button>
                                                                            </form>
                                                                        </c:when>
                                                                    </c:choose>
                                                                </c:if>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </c:if>
                                <c:if test="${findAuto == null}">
                                    <div class="panel-body">
                                        Nessuna auto registrata
                                    </div>
                                </c:if>
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