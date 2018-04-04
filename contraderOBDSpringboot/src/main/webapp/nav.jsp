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
                                                    <input type="text" size="12" name="findAuto">
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
                                <a href="javascript:{}" onclick="document.getElementById('listAllAutoAzienda').submit(); return false;">
                                    Visualizza
                                </a>
                                <form action="viewAutoAzienda" method="post" id="listAllAutoAzienda">
                                    <fieldset>
                                        <input type="hidden" value="${sessionScope.model.user.username}" name="proprietario" class="btn btn-primary">
                                    </fieldset>
                                </form>
                            </li>
                            <li>
                                <a href="#formNoleggio" data-toggle="modal">
                                    Noleggio
                                </a>
                            </li>
                            <li>
                                <a href="#formTerminaNoleggio" data-toggle="modal">
                                    Termina noleggio
                                </a>
                            </li>
                            <li>
                                <a href="javascript:{}" onclick="document.getElementById('listAllAutoConErrori').submit(); return false;">
                                    Visualizza auto con errori
                                </a>
                                <form action="viewAutoError" method="post" id="listAllAutoConErrori">
                                    <fieldset>
                                        <input type="hidden" value="${sessionScope.model.user.username}" name="proprietario" class="btn btn-primary">
                                    </fieldset>
                                </form>
                            </li>
                            <li>
                                <a href="/contraderOBDSpringBoot/preSetDisponibilita">Vedi Disponibilita Auto</a>
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
                                <a href="javascript:{}" onclick="document.getElementById('listAllDriverAzienda').submit(); return false;">
                                    Visualizza
                                </a>
                                <form action="viewDriverAzienda" method="post" id="listAllDriverAzienda">
                                    <fieldset>
                                        <input type="hidden" value="${sessionScope.model.user.id}" name="idAzienda" class="btn btn-primary">
                                    </fieldset>
                                </form>
                            </li>
                            <li>
                                <a href="#formAddDriver" data-toggle="modal">
                                    Aggiungi
                                </a>
                            </li>
                        </ul>
                        <!-- /.nav-second-level -->
                    </li>
                </c:when>
                <c:when test="${sessionScope.model.user.ruolo == 4 }">
                    <li>
                        <a href="#">
                            <i class="fa fa-calendar fa-fw"></i> Appuntamenti
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <form action="/contraderOBDSpringBoot/viewAppuntamentiDriver" method="POST" id="viewAppuntamentiDriver">
                                    <input type="hidden" name="idDriver" value="${sessionScope.model.user.id}" />
                                </form>
                                <a href="javascript:{}" onclick="document.getElementById('viewAppuntamentiDriver').submit(); return false;">
                                    Visualizza
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-euro fa-fw"></i> Preventivi
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <form action="/contraderOBDSpringBoot/viewPreventiviDriver" method="POST" id="viewPreventiviDriver">
                                    <input type="hidden" name="idDriver" value="${sessionScope.model.user.id}" />
                                </form>
                                <a href="javascript:{}" onclick="document.getElementById('viewPreventiviDriver').submit(); return false;">
                                    Visualizza
                                </a>
                            </li>
                        </ul>
                    </li>
                </c:when>
            </c:choose>
        </ul>
    </div>
    <!-- /.sidebar-collapse -->
</div>