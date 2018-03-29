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
            <%@ page import="java.util.Scanner"%>
                <%@ page import="com.virtualpairprogrammers.domain.Auto"%>
                    <%@ page import="com.virtualpairprogrammers.domain.Dati_dispositivo"%>
                        <% Auto auto = (Auto) session.getAttribute("auto");
                    List<Dati_dispositivo> listaDatiAuto = (List<Dati_dispositivo>) session.getAttribute("listaDati"); %>
</head>

<body>

    <div id="wrapper">

        <%@ include file = "header.jsp" %>

            <div id="page-wrapper">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Notifiche</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <i class="fa fa-automobile fa-fw"></i>
                                <%= auto.getCasa_Costruttrice() + " " + auto.getModello() %>
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <%  for(int i = 0; i < listaDatiAuto.size(); i++)
                                {
                                    Dati_dispositivo dato = listaDatiAuto.get(i);
                                    if(dato.getCodice_Errore() != null)
                                    { %>
                                    <div class="alert alert-danger">
                                        <h3>ALERT! Errore:
                                            <%= dato.getCodice_Errore() + " ricevuto in data " + dato.getData() %>
                                        </h3>
                                    </div>
                                    <%       }
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

                                    if (data - revisione > 365 + 365 / 12 * 11) { %>
                                            <div class="alert alert-warning">
                                                <h3>La revisione scadrà tra meno di 1 mese</h3>
                                            </div>
                                            <%       }
                                    else if (((data - tagliando) > 365 + 365 / 12 * 11) || km > 14500) { %>
                                                <div class="alert alert-warning">
                                                    <h3>Il tagliando è in scadenza</h3>
                                                </div>
                                                <%       }
                                    else
                                    { %>
                                                    <div class="alert alert-success">
                                                        <h3>Nessuna prossima scadenza</h3>
                                                    </div>
                                                    <%      }
                                }
                                else
                                { %>
                                                        <div class="alert alert-primary">
                                                            <h2>Nessun dato rilevato</h2>
                                                        </div>
                                                        <%    }   %>
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