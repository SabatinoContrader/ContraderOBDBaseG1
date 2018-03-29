<div class="navbar-default sidebar" role="navigation">
    <div class="sidebar-nav navbar-collapse">
        <ul class="nav" id="side-menu">
            <li>
                <a href="/contraderOBDSpringBoot/home">
                    <i class="fa fa-home fa-fw"></i> Dashboard</a>
            </li>
            <c:choose>
                <c:when test="${sessionScope.model.user.ruolo == 1 }">
                    <li>
                        <a href="#">
                            <i class="fa fa-wrench fa-fw"></i> Officina
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="/contraderOBDSpringBoot/viewListOfficina">
                                    Visualizza tutte
                                </a>
                            </li>
                            <li>
                                <a href="#"> Cerca per citt&aacute;
                                    <span class="fa arrow"></span>
                                </a>
                                <ul class="nav nav-third-level">
                                    <li>
                                        <a>
                                            <form action="/contraderOBDSpringBoot/viewListOfficina" method="post">
                                                <fieldset>
                                                    <input type="text" size="12" name="citta">
                                                    <button type="submit" class="btn btn-primary btn-xs">
                                                        Cerca
                                                    </button>
                                                </fieldset>
                                            </form>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-briefcase fa-fw"></i> Azienda
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="/contraderOBDSpringBoot/viewListAzienda">
                                    Visualizza tutte
                                </a>
                            </li>
                            <li>
                                <a href="#"> Cerca per citt&aacute;
                                    <span class="fa arrow"></span>
                                </a>
                                <ul class="nav nav-third-level">
                                    <li>
                                        <a>
                                            <form action="/contraderOBDSpringBoot/viewListAzienda" method="post">
                                                <fieldset>
                                                    <input type="text" size="12" name="citta">
                                                    <button type="submit" class="btn btn-primary btn-xs">
                                                        Cerca
                                                    </button>
                                                </fieldset>
                                            </form>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                </c:when>
                <c:when test="${sessionScope.model.user.ruolo == 2 }">
                    <li>
                        <a href="#">
                            <i class="fa fa-briefcase fa-fw"></i> Azienda
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="#formAddAzienda" data-toggle="modal">
                                    Aggiungi
                                </a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-automobile fa-fw"></i> Auto
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="#formAddAuto" data-toggle="modal">
                                    Aggiungi
                                </a>
                            </li>
                            <li>
                                <a href="#"> Cerca
                                    <span class="fa arrow"></span>
                                </a>
                                <ul class="nav nav-third-level">
                                    <li>
                                        <a>
                                            <form action="findAuto" method="post">
                                                <fieldset>
                                                    <input type="text" size="12" name="codDispositivo">
                                                    <button type="submit" class="btn btn-primary btn-xs">
                                                        Cerca
                                                    </button>
                                                </fieldset>
                                            </form>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="#"> Reset dispositivo
                                    <span class="fa arrow"></span>
                                </a>
                                <ul class="nav nav-third-level">
                                    <li>
                                        <a>
                                            <form action="/contraderOBDSpringBoot/resetAuto" method="post">
                                                <fieldset>
                                                    <input type="text" size="12" name="codDispositivo">
                                                    <button type="submit" class="btn btn-primary btn-xs" data-toggle="tooltip" data-placement="right" title="Verr&aacute; cancellata l'auto associata al dispositivo e tutti i dati ad essa riferiti">
                                                        Reset
                                                    </button>
                                                </fieldset>
                                            </form>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-user fa-fw"></i> Driver
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                                <li>
                                    <a href="#formAddDriver" data-toggle="modal">
                                        Aggiungi
                                    </a>
                                </li>
                            </ul>
                        <!-- /.nav-second-level -->
                    </li>
                </c:when>
                <c:when test="${sessionScope.model.user.ruolo == 3 }">
                    <li>
                        <a href="#">
                            <i class="fa fa-automobile fa-fw"></i> Auto
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="aziendaNoleggio.jsp">Noleggia</a>
                            </li>
                            <li>
                                <a href="aziendaTerminaNoleggio.jsp">Termina noleggio</a>
                            </li>
                            <li>
                                <a href="javascript:{}" onclick="document.getElementById('listAllAutoAzienda').submit(); return false;">
                                    Visualizza tutte
                                </a>
                                <form action="MainDispatcherServlet" method="post" id="listAllAutoAzienda">
                                    <fieldset>
                                        <input type="hidden" value="Auto:listaAutoAzienda" name="button" class="btn btn-primary">
                                    </fieldset>
                                </form>
                            </li>
                            <li>
                                <a href="javascript:{}" onclick="document.getElementById('listAllAutoConErrori').submit(); return false;">
                                    Visualizza auto con errori
                                </a>
                                <form action="MainDispatcherServlet" method="post" id="listAllAutoConErrori">
                                    <fieldset>
                                        <input type="hidden" value="Auto:autoConErrori" name="button" class="btn btn-primary">
                                    </fieldset>
                                </form>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-user fa-fw"></i> Driver
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="addDriver.jsp">Aggiungi</a>
                            </li>
                            <li>
                                <a href="javascript:{}" onclick="document.getElementById('listAllDriver').submit(); return false;">
                                    Visualizza tutti
                                </a>
                                <form action="MainDispatcherServlet" method="post" id="listAllDriver">
                                    <fieldset>
                                        <input type="hidden" value="Driver:listaDriver" name="button" class="btn btn-primary">
                                    </fieldset>
                                </form>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                </c:when>
                <c:when test="${sessionScope.model.user.ruolo == 4 }">

                </c:when>
            </c:choose>
        </ul>
    </div>
    <!-- /.sidebar-collapse -->
</div>