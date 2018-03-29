<%@ page import="com.virtualpairprogrammers.services.CountService" %>
    <%@ page import="java.util.List"%>
        <%@ page import="com.virtualpairprogrammers.domain.Auto"%>
            <% CountService countService = new CountService(); %>
                <% if( role.equals("owner")) { %>
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-wrench fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">
                                            <%= countService.countOfficina() %>
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
                                            <%= countService.countAzienda() %>
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
                                            <%= countService.countAuto() %>
                                        </div>
                                        <div>Auto</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <% } else if( role.equals("officina")) { %>
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
                        <% } else if( role.equals("azienda")) { %>
                            <div class="col-lg-3 col-md-6">
                                <div class="panel panel-green">
                                    <div class="panel-heading">
                                        <div class="row">
                                            <div class="col-xs-3">
                                                <i class="fa fa-automobile fa-5x"></i>
                                            </div>
                                            <div class="col-xs-9 text-right">
                                                <div class="huge">
                                                    <%= countService.countMyAuto(username) %>
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
                                                    <%= countService.countMyDriver(Integer.parseInt(id)) %>
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
                            <% if (countService.countAziendaError(username) != 0) { %>
                            <div class="col-lg-3 col-md-6">
                                <div class="panel panel-red">
                                    <div class="panel-heading">
                                        <div class="row">
                                            <div class="col-xs-3">
                                                <i class="fa fa-warning fa-5x"></i>
                                            </div>
                                            <div class="col-xs-9 text-right">
                                                <div class="huge">
                                                    <%= countService.countAziendaError(username) %>
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
                            <% } %>
                            <% } else if( role.equals("driver")) { %>
                                <% List<Auto> listaAuto = (List<Auto>) session.getAttribute("listaAuto");
                                if (listaAuto.isEmpty()) { %>
                                    <div class="row">
                                        <div class="col-lg-9">
                                            <div class="panel panel-default">
                                                <div class="panel-body">
                                                    <h2>Nessuna auto noleggiata</h2>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <% } else { for (int i = 0; i < listaAuto.size(); i++) { %>


                                        <div class="col-lg-3 col-md-6">
                                            <div class="panel panel-primary">
                                                <div class="panel-heading">
                                                    <div class="row">
                                                        <div class="col-xs-3">
                                                            <i class="fa fa-automobile fa-5x"></i>
                                                        </div>
                                                        <div class="col-xs-9 text-right">
                                                            <div>
                                                                <%= listaAuto.get(i).getCasa_Costruttrice() %>
                                                            </div>
                                                            <div>
                                                                <%= listaAuto.get(i).getModello() %>
                                                            </div>
                                                            <div>
                                                                <%= listaAuto.get(i).getTarga() %>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <a href="javascript:{}" onclick="document.getElementById('viewAuto<%= i %>').submit(); return false;">
                                                    <form action="MainDispatcherServlet" method="post" id="viewAuto<%= i %>">
                                                        <fieldset>
                                                            <input type="hidden" value="<%= listaAuto.get(i).getCod_Dispositivo() %>" name="cod_dispositivo">
                                                            <input type="hidden" value="Dati:getError" name="button">
                                                        </fieldset>
                                                    </form>
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
                                        <% } }%>
                                            <% } %>