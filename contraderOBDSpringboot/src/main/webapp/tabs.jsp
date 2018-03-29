<c:choose>
    <c:when test="${user.ruolo == 1 }">
        <div class="col-lg-3 col-md-6">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-3">
                            <i class="fa fa-wrench fa-5x"></i>
                        </div>
                        <div class="col-xs-9 text-right">
                            <div class="huge">
                                ${countOfficinaAll}
                            </div>
                            <div>Officine</div>
                        </div>
                    </div>
                </div>
                <a href="javascript:{}" onclick="document.getElementById('listAll').submit(); return false;">
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
                                ${countAziendeAll}
                            </div>
                            <div>Aziende</div>
                        </div>
                    </div>
                </div>
                <a href="javascript:{}" onclick="document.getElementById('listAllAzienda').submit(); return false;">
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
                                ${countAutoAll}
                            </div>
                            <div>Auto</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:when>
    <c:when test="${user.ruolo == 2 }">
        <div class="col-lg-3 col-md-6">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-3">
                            <i class="fa fa-list-alt fa-5x"></i>
                        </div>
                        <div class="col-xs-9 text-right">
                            <div class="huge">1</div>
                            <div>Preventivi</div>
                        </div>
                    </div>
                </div>
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
                            <div class="huge">2</div>
                            <div>Appuntamenti</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:when>
    <c:when test="${user.ruolo == 3 }">
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
    <c:when test="${user.ruolo == 4 }">
        <div class="row">
            <div class="col-lg-9">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <h2>Nessuna auto noleggiata</h2>
                    </div>
                </div>
            </div>
        </div>
    </c:when>
</c:choose>