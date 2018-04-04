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
                        <h1 class="page-header">Appuntamenti</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <i class="fa fa-calendar fa-fw"></i> Elenco appuntamenti
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <c:choose>
                                        <c:when test="${sessionScope.model.user.ruolo == 2}">
                                            <table class="table">
                                                <thead>
                                                    <tr>
                                                        <th>Auto</th>
                                                        <th>Contatto driver</th>
                                                        <th>Descrizione</th>
                                                        <th>Data</th>
                                                        <th>Conferma</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:choose>
                                                        <c:when test="${listaAppuntamenti.isEmpty()}">
                                                            <tr>
                                                                <td colspan="5" align="center">Nessun appuntamento</td>
                                                            </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <c:forEach items="${listaAppuntamenti}" var="appuntamento">
                                                                <tr>
                                                                    <td>
                                                                        <form action="findAuto" method="post">
                                                                            <fieldset>
                                                                                <input type="hidden" name="findAuto" value="${appuntamento.autoEntity.codDispositivo}">
                                                                                <button type="submit" class="btn btn-circle" data-toggle="tooltip" data-placement="top" title="${appuntamento.autoEntity.casaCostruttrice} ${appuntamento.autoEntity.modello}">
                                                                                    <i class="fa fa-automobile"></i>
                                                                                </button>
                                                                            </fieldset>
                                                                        </form>
                                                                    </td>
                                                                    <td>
                                                                        ${appuntamento.driverEntity.cellulare}
                                                                    </td>
                                                                    <td>
                                                                        ${appuntamento.descrizione}
                                                                    </td>
                                                                    <td>
                                                                        ${appuntamento.data}
                                                                    </td>
                                                                    <td>
                                                                        <c:if test="${appuntamento.stato == true}">
                                                                            Confermato
                                                                        </c:if>
                                                                        <c:if test="${appuntamento.stato == false}">
                                                                            Rifiutato
                                                                        </c:if>
                                                                        <c:if test="${appuntamento.stato == null}">
                                                                            <div class="col-md-3">
                                                                                <form action="confermaAppuntamento" method="POST">
                                                                                    <input type="hidden" name="idAppuntamento" value="${appuntamento.idAppuntamento}">
                                                                                    <input type="hidden" name="idOfficina" value="${sessionScope.model.user.id}">
                                                                                    <button type="submit" class="btn btn-circle btn-sm btn-success">
                                                                                        <i class="fa fa-check"></i>
                                                                                    </button>
                                                                                </form>
                                                                            </div>
                                                                            <div class="col-md-3">
                                                                                <form action="rifiutaAppuntamento" method="POST">
                                                                                    <input type="hidden" name="idAppuntamento" value="${appuntamento.idAppuntamento}">
                                                                                    <input type="hidden" name="idOfficina" value="${sessionScope.model.user.id}">
                                                                                    <button type="submit" class="btn btn-circle btn-sm btn-danger">
                                                                                        <i class="fa fa-times"></i>
                                                                                    </button>
                                                                                </form>
                                                                            </div>
                                                                        </c:if>
                                                                    </td>
                                                                </tr>
                                                            </c:forEach>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </tbody>
                                            </table>
                                        </c:when>
                                        <c:when test="${sessionScope.model.user.ruolo == 4}">
                                            <table class="table">
                                                <thead>
                                                    <tr>
                                                        <th>Auto</th>
                                                        <th>Contatto officina</th>
                                                        <th>Descrizione</th>
                                                        <th>Data</th>
                                                        <th>Conferma</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:choose>
                                                        <c:when test="${listaAppuntamenti.isEmpty()}">
                                                            <tr>
                                                                <td colspan="5" align="center">Nessun appuntamento</td>
                                                            </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <c:forEach items="${listaAppuntamenti}" var="appuntamento">
                                                                <tr>
                                                                    <td>
                                                                        <form action="/contraderOBDSpringBoot/viewNotificheDriver" method="POST">
                                                                            <fieldset>
                                                                                <input type="hidden" name="codDispositivo" value="${appuntamento.autoEntity.codDispositivo}">
                                                                                <button type="submit" class="btn btn-circle" data-toggle="tooltip" data-placement="top" title="${appuntamento.autoEntity.casaCostruttrice} ${appuntamento.autoEntity.modello}">
                                                                                    <i class="fa fa-automobile"></i>
                                                                                </button>
                                                                            </fieldset>
                                                                        </form>

                                                                    </td>
                                                                    <td>
                                                                        ${appuntamento.officinaEntity.nomeOfficina}
                                                                    </td>
                                                                    <td>
                                                                        ${appuntamento.descrizione}
                                                                    </td>
                                                                    <td>
                                                                        ${appuntamento.data}
                                                                    </td>
                                                                    <td>
                                                                        <c:if test="${appuntamento.stato == true}">
                                                                            Confermato
                                                                        </c:if>
                                                                        <c:if test="${appuntamento.stato == false}">
                                                                            Rifiutato
                                                                        </c:if>
                                                                        <c:if test="${appuntamento.stato == null}">
                                                                            In attesa di risposta
                                                                        </c:if>
                                                                    </td>
                                                                </tr>
                                                            </c:forEach>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </tbody>
                                            </table>
                                        </c:when>
                                    </c:choose>
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