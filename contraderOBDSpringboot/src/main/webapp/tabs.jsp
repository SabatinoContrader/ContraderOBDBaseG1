<c:choose>
    <c:when test="${sessionScope.model.user.ruolo == 1 }">
        <div class="col-lg-3 col-md-6">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-3">
                            <i class="fa fa-wrench fa-5x"></i>
                        </div>
                        <div class="col-xs-9 text-right">
                            <div class="huge">
                                ${sessionScope.model.countOfficinaAll}
                            </div>
                            <div>Officine</div>
                        </div>
                    </div>
                </div>
                <a href="/contraderOBDSpringBoot/viewListOfficina">
                    <div class="panel-footer">
                        <span class="pull-left">Visualizza tutte</span>
                        <span class="pull-right">
                            <i class="fa fa-arrow-circle-right"></i>
                        </span>
                        <div class="clearfix"></div>
                    </div>
                </a>
            </div>
        </div>
        <div class="col-lg-3 col-md-6">
            <div class="panel panel-yellow">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-3">
                            <i class="fa fa-briefcase fa-5x"></i>
                        </div>
                        <div class="col-xs-9 text-right">
                            <div class="huge">
                                ${sessionScope.model.countAziendeAll}
                            </div>
                            <div>Aziende</div>
                        </div>
                    </div>
                </div>
                <a href="/contraderOBDSpringBoot/viewListAzienda">
                    <div class="panel-footer">
                        <span class="pull-left">Visualizza tutte</span>
                        <span class="pull-right">
                            <i class="fa fa-arrow-circle-right"></i>
                        </span>
                        <div class="clearfix"></div>
                    </div>
                </a>
                </a>
            </div>
        </div>
        <div class="col-lg-3 col-md-6">
            <div class="panel panel-green">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-3">
                            <i class="fa fa-automobile fa-5x"></i>
                        </div>
                        <div class="col-xs-9 text-right">
                            <div class="huge">
                                ${sessionScope.model.countAutoAll}
                            </div>
                            <div>Auto</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:when>
    <c:when test="${sessionScope.model.user.ruolo == 2 }">

        <%@ include file = "modalAddAuto.jsp" %>
            <%@ include file = "modalAddAzienda.jsp" %>
                <%@ include file = "modalAddDriver.jsp" %>

                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-list-alt fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">${sessionScope.model.countPreventivoOfficina}</div>
                                        <div>Preventivi</div>
                                    </div>
                                </div>
                            </div>
                            <form action="/contraderOBDSpringBoot/viewPreventiviOfficina" method="POST" id="viewPreventiviOfficina">
                                <input type="hidden" name="idOfficina" value="${sessionScope.model.user.id}" />
                            </form>
                            <a href="javascript:{}" onclick="document.getElementById('viewPreventiviOfficina').submit(); return false;">
                                <div class="panel-footer">
                                    <span class="pull-left">Visualizza</span>
                                    <span class="pull-right">
                                        <i class="fa fa-arrow-circle-right"></i>
                                    </span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-yellow">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-calendar fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">${sessionScope.model.countAppuntamentoOfficina}</div>
                                        <div>Appuntamenti</div>
                                    </div>
                                </div>
                            </div>
                            <form action="/contraderOBDSpringBoot/viewAppuntamentiOfficina" method="POST" id="viewAppuntamentiOfficina">
                                <input type="hidden" name="idOfficina" value="${sessionScope.model.user.id}" />
                            </form>
                            <a href="javascript:{}" onclick="document.getElementById('viewAppuntamentiOfficina').submit(); return false;">
                                <div class="panel-footer">
                                    <span class="pull-left">Visualizza</span>
                                    <span class="pull-right">
                                        <i class="fa fa-arrow-circle-right"></i>
                                    </span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
    </c:when>
    <c:when test="${sessionScope.model.user.ruolo == 3 }">
        <div class="col-lg-3 col-md-6">
            <div class="panel panel-green">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-3">
                            <i class="fa fa-automobile fa-5x"></i>
                        </div>
                        <div class="col-xs-9 text-right">
                            <div class="huge">
                                NaN
                            </div>
                            <div>Auto</div>
                        </div>
                    </div>
                </div>
                <a href="javascript:{}" onclick="document.getElementById('listAllAutoAzienda').submit(); return false;">
                    <div class="panel-footer">
                        <span class="pull-left">Visualizza tutte</span>
                        <span class="pull-right">
                            <i class="fa fa-arrow-circle-right"></i>
                        </span>
                        <div class="clearfix"></div>
                    </div>
                </a>
            </div>
        </div>
        <div class="col-lg-3 col-md-6">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-3">
                            <i class="fa fa-user fa-5x"></i>
                        </div>
                        <div class="col-xs-9 text-right">
                            <div class="huge">
                                NaN
                            </div>
                            <div>Driver</div>
                        </div>
                    </div>
                </div>
                <a href="javascript:{}" onclick="document.getElementById('listAllDriver').submit(); return false;">
                    <div class="panel-footer">
                        <span class="pull-left">Visualizza tutte</span>
                        <span class="pull-right">
                            <i class="fa fa-arrow-circle-right"></i>
                        </span>
                        <div class="clearfix"></div>
                    </div>
                </a>
            </div>
        </div>
        <div class="col-lg-3 col-md-6">
            <div class="panel panel-red">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-3">
                            <i class="fa fa-warning fa-5x"></i>
                        </div>
                        <div class="col-xs-9 text-right">
                            <div class="huge">
                                NaN
                            </div>
                            <div>Auto</div>
                        </div>
                    </div>
                </div>
                <a href="javascript:{}" onclick="document.getElementById('listAllAutoConErrori').submit(); return false;">
                    <div class="panel-footer">
                        <span class="pull-left">Visualizza</span>
                        <span class="pull-right">
                            <i class="fa fa-arrow-circle-right"></i>
                        </span>
                        <div class="clearfix"></div>
                    </div>
                </a>
            </div>
        </div>
    </c:when>
    <c:when test="${sessionScope.model.user.ruolo == 4 }">
        <div class="row">
            <c:choose>
                <c:when test="${sessionScope.model.driver.autoEntitySet.isEmpty() }">
                    <div class="col-lg-9">
                        <div class="panel-body">
                            <h2>Nessuna auto noleggiata</h2>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${sessionScope.model.driver.autoEntitySet}" var="auto">
                        <div class="col-lg-3 col-md-6">
                            <div class="panel panel-${model.color.get(auto.codDispositivo)}">
                                <div class="panel-heading">
                                    <div class="row">
                                        <div class="col-xs-3">
                                            <i class="fa fa-automobile fa-5x"></i>
                                        </div>
                                        <div class="col-xs-9 text-right">
                                            <div>${auto.casaCostruttrice} ${auto.modello}</div>
                                            <div class="big btn btn-default" style="margin-right: -5px; padding: 5px;">
                                                ${auto.targa}
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <form action="/contraderOBDSpringBoot/viewNotificheDriver" method="POST" id="viewAuto${auto.codDispositivo}">
                                    <input type="hidden" name="codDispositivo" value="${auto.codDispositivo}" />
                                </form>
                                <a href="javascript:{}" onclick="document.getElementById('viewAuto${auto.codDispositivo}').submit(); return false;">
                                    <div class="panel-footer">
                                        <span class="pull-left">Visualizza</span>
                                        <span class="pull-right">
                                            <i class="fa fa-arrow-circle-right"></i>
                                        </span>
                                        <div class="clearfix"></div>
                                    </div>
                                </a>
                            </div>
                        </div>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </div>
    </c:when>
</c:choose>