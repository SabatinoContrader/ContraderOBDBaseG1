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
        <!-- Modal -->
        <div class="modal fade" id="formAddAuto" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-body">
                        <form action="addAuto" method="post" role="form">
                            <div class="row">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label>Codice del dispositivo associato</label>
                                        <input type="text" name="codDispositivo" class="form-control">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label>Targa</label>
                                        <input type="text" name="targa" class="form-control">
                                    </div>
                                </div>
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label>Numero di telaio</label>
                                        <input type="text" name="telaio" class="form-control">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label>Casa costruttrice</label>
                                        <input type="text" name="casaCostruttrice" class="form-control">
                                    </div>
                                </div>
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label>Modello</label>
                                        <input type="text" name="modello" class="form-control">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label>Tipologia</label>
                                        <input type="text" name="tipologia" class="form-control">
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label>Alimentazione</label>
                                        <input type="text" name="alimentazione" class="form-control">
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label>Cambio</label>
                                        <select class="form-control" name="cambio">
                                            <option value="M">Manuale</option>
                                            <option value="A">Automatico</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label>Proprietario</label>
                                        <input type="text" name="proprietario" class="form-control">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label>Data ultima revisione</label>
                                        <input type="text" name="revisione" class="form-control" placeholder="GG/MM/AA">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label>Data ultimo tagliando</label>
                                        <input type="text" name="tagliandoData" class="form-control" placeholder="GG/MM/AA">
                                    </div>
                                </div>
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label>Chilometri all'ultimo tagliando</label>
                                        <input type="text" name="tagliandoKm" class="form-control">
                                    </div>
                                </div>
                            </div>
                            <input type="hidden" name="idOfficina" class="form-control" value="${sessionScope.model.user.id}">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Chiudi</button>
                            <button type="submit" class="btn btn-primary">
                                Aggiungi
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
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