<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<%@ page import="com.project.model.*"%>
		<%@ page import="utility.*"%>
		<%@ page import="java.util.ArrayList"%>
		<%@ page import="java.util.List"%>
		<%@ page import="com.project.dao.*"%>
		<%@ page import="com.project.automotive.dto.*"%>
		<%@ page import="com.project.dao.AlertsDAO"%>

<%
Utente u = (Utente)session.getAttribute("Utente");
    
    if(u != null ){
    	switch(u.getRuolo()){

    	case 0:
    		response.sendRedirect("utente_home.jsp");
    	break;
    	case 2:
    	System.out.println("dentro if "+u.getRuolo());
    		response.sendRedirect("home_admin.jsp");
    		break;
    	case 3:
    		//INFINITE LOOP, FAME DA LOOP
    		//TO DO
    	case 4:
    		response.sendRedirect("home_cliente-business_admin.jsp");
    		break;

    	}
    }else{
    response.sendRedirect("index.jsp");
	
    }
if(u != null ){
 if(u.getRuolo()==1){
	 String name = u.getNome();
Azienda a = DaoUtility.getDatiAzienda(u);


List<Utente> listaUtentiPrivati = DaoUtility.getListaClientiAzienda(a.id);

List<Azienda> listaClientiBusiness = DaoUtility.getListaClientiBusiness(a.id);

List<Auto> listaAutoOfficina = CarDAO.getListAutoAzienda(a.id);

AlertsDAO adao = new AlertsDAO();
ArrayList<GuastoDTO> guasti = adao.getAlertsGuastiGarageAdmin(u);
List<Dispositivo> dispositivi = DispositivoDAO.getOfficinaDevice(a.id);
boolean nol;
List<RichiestaPreventivo> richieste = RichiestaPreventivoDAO.getAllRichiestePreventivoUtente(a.id);
%>
<html lang="en" >
	<!-- begin::Head -->
	<head>
		<meta charset="utf-8" />
		<title>
			<%=a.getDenominazione()%>
		</title>
		<meta name="description" content="Latest updates and statistic charts">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<!--begin::Web font -->
		<script src="https://ajax.googleapis.com/ajax/libs/webfont/1.6.16/webfont.js"></script>
		<script>
          WebFont.load({
            google: {"families":["Poppins:300,400,500,600,700","Roboto:300,400,500,600,700"]},
            active: function() {
                sessionStorage.fonts = true;
            }
          });
		</script>
		<!--end::Web font -->
        <!--begin::Base Styles -->  
        <!--begin::Page Vendors -->
		<link href="assets/vendors/custom/fullcalendar/fullcalendar.bundle.css" rel="stylesheet" type="text/css" />
		<!--end::Page Vendors -->
		<link href="assets/vendors/base/vendors.bundle.css" rel="stylesheet" type="text/css" />
		<link href="assets/demo/demo2/base/style.bundle.css" rel="stylesheet" type="text/css" />
		<!--end::Base Styles -->
		<link rel="shortcut icon" href="assets/demo/demo2/media/img/logo/favicon.ico" />
		<style>.ali{color:#575962 !important;}.fah3{font-size:24px;padding-right:10px;}.transparentli{color: transparent !important;}.fa{cursor:pointer;}.fa-ul li{display:inline;margin-left:10px;}.btn-add:hover{color: #474343 !important;background-color: #f4f5f8 !important;}.btn-add{margin-top: 10px;color: #474343 !important;float:right;background-color: #f4f5f8;margin-right: 20px;border: none;padding: 12px;}.savebutton{margin-left: auto;    margin-right: auto;}.btn-box{       border: none;margin-top: 20px;    width: 200px;    color: white !important;}.logo{max-width:150px;}.m-widget24 .m-widget24__item .m-widget24__stats{margin-top:-2.43rem !important;}.m-widget24 .m-widget24__item .m-widget24__title{margin-top:1.23rem !important;}</style>
	</head>
	<!-- end::Head -->
    <!-- end::Body -->
	<body class="m-page--wide m-header--fixed m-header--fixed-mobile m-footer--push m-aside--offcanvas-default"  >

		<!-- begin:: Page -->
		<div class="m-grid m-grid--hor m-grid--root m-page">
			<%@ include file = "header.jsp" %>
		<!-- begin::Body -->
			<div class="m-grid__item m-grid__item--fluid  m-grid m-grid--ver-desktop m-grid--desktop 	m-container m-container--responsive m-container--xxl m-page__container m-body">
				<div class="m-grid__item m-grid__item--fluid m-wrapper">
					<!-- BEGIN: Subheader -->
					<div class="m-subheader ">
						<div class="d-flex align-items-center">
							<div class="mr-auto">
								<h3 class="m-subheader__title ">
									Dashboard - Officina <%=a.getDenominazione()%>
								</h3>
							</div>
						
						</div>
					</div>
					<!-- END: Subheader -->
					<div class="m-content">
						<!--begin:: Widgets/Stats-->
						<div class="m-portlet ">
							<div class="m-portlet__body  m-portlet__body--no-padding">
								<div class="row m-row--no-padding m-row--col-separator-xl">
									<div class="col-md-12 col-lg-6 col-xl-3">
										<!--begin::Total Profit-->
										<div class="m-widget24">
											<div class="m-widget24__item">
												<h4 class="m-widget24__title">
													GUASTI
												</h4>
												<br>
												<span class="m-widget24__desc">
													Rilevati dai dispositivi
												</span>
												<span class="m-widget24__stats m--font-brand">
													<%=guasti.size()%>
												</span>
												<div class="m--space-10"></div>
											<p style="text-align:center;" class="smooth-scroll"><a  href="#tableguasti" style="background-color:#716aca !important" class="btn btn-info btn-box">Visualizza</a></p>
											</div>
										</div>
										<!--end::Total Profit-->
									</div>
									<div class="col-md-12 col-lg-6 col-xl-3">
										<!--begin::New Feedbacks-->
										<div class="m-widget24">
											<div class="m-widget24__item">
												<h4 class="m-widget24__title" >
													SCADENZE
												</h4>
												<br>
												<span class="m-widget24__desc">
													Manutenzione
												</span>
												<span class="m-widget24__stats m--font-info">
													37
												</span>
												<div class="m--space-10"></div>
											
													<p style="text-align:center;"><a  style="background-color:#36a3f7  !important" class="btn btn-info btn-box" >Visualizza</a></p>
											</div>
										</div>
										<!--end::New Feedbacks-->
									</div>
									<div class="col-md-12 col-lg-6 col-xl-3">
										<!--begin::New Orders-->
										<div class="m-widget24">
											<div class="m-widget24__item">
												<h4 class="m-widget24__title">
													APPUNTAMENTI
												</h4>
												<br>
												<span class="m-widget24__desc">
													Richiesti
												</span>
												<span class="m-widget24__stats m--font-danger">
													23
												</span>
												<div class="m--space-10"></div>
											<p style="text-align:center;"><a  style="background-color:#f4516c   !important" class="btn btn-info btn-box"  >Visualizza</a></p>
											</div>
										</div>
										<!--end::New Orders-->
									</div>
									<div class="col-md-12 col-lg-6 col-xl-3">
										<!--begin::New Users-->
										<div class="m-widget24">
											<div class="m-widget24__item">
												<h4 class="m-widget24__title">
													PREVENTIVI
												</h4>
												<br>
												<span class="m-widget24__desc">
													Richiesti
												</span>
												<span class="m-widget24__stats m--font-success">
												<%=richieste.size()%>
												</span>
												<div class="m--space-10"></div>
											<p style="text-align:center;"><a href="#richiestepreventivi" style="background-color:#34bfa3   !important" class="btn btn-info btn-box"  >Visualizza</a></p>
											</div>
										</div>
										<!--end::New Users-->
									</div>
								</div>
							</div>
						</div>
						<!--end:: Widgets/Stats--> 


<!--Begin::Section-->
						<div class="row">
							<div class="col-xl-12">
								<div class="m-portlet m-portlet--mobile ">
									<div class="m-portlet__head">
										<div class="m-portlet__head-caption">
											<div class="m-portlet__head-title">
												<h3 class="m-portlet__head-text">
												<i class="fa fa-user fah3"  ></i>
													Clienti Privati
												</h3>
												<div id=test></div>
											</div>
										</div>
									<button class="btn btn-info btn-add" type="button" data-toggle="modal" data-target="#modaladduser">Aggiungi Nuovo</button>
									</div>
									<div class="m-portlet__body">
										<!--begin: Datatable -->
									<!--	<div class="m_datatable" id="m_datatable_latest_orders"></div>-->
									<div class="table-responsive">
									<table class="table table-striped">
									<thead>
									<tr>
									<th>ID</th>
									<th>Nome</th>
									<th>Cognome</th>
									<th>Email</th>
									<th>Telefono</th>
									<th>Data Registrazione</th>
									<th style="width:150px;"></th>
									
									</tr>
									</thead>
									<tbody>
									
									
									
									
												<% if(listaUtentiPrivati.size() != 0){
										for(int i = 0; i<listaUtentiPrivati.size(); i++){
											%>
												<tr>
													<td><%=listaUtentiPrivati.get(i).getID()%></td>
													<td><%=listaUtentiPrivati.get(i).getNome()%></td>
													<td><%=listaUtentiPrivati.get(i).getCognome()%></td>
													<td><%=listaUtentiPrivati.get(i).getEmail()%></td>
													<td><%=listaUtentiPrivati.get(i).getTelefono()%></td>
													<td><%=listaUtentiPrivati.get(i).getDataRegistrazione()%></td>
													<td><ul class="fa-ul">
  <li class="fa-li"><a class="ali" href="list_auto_utente.jsp?idutente=<%=listaUtentiPrivati.get(i).getID()%>&nome=<%=listaUtentiPrivati.get(i).getNome()%>&cognome=<%=listaUtentiPrivati.get(i).getCognome()%>" target="_blank"><i class="fa fa-car"  title="Visualizza lista auto"></i></a></li>
  <li class="fa-li"><i class="fa fa-pencil modcliente" title="Modifica cliente" data-id="<%=listaUtentiPrivati.get(i).getID()%>" data-nome="<%=listaUtentiPrivati.get(i).getNome()%>" data-cognome="<%=listaUtentiPrivati.get(i).getCognome()%>" data-email="<%=listaUtentiPrivati.get(i).getEmail()%>" data-telefono="<%=listaUtentiPrivati.get(i).getTelefono()%>"></i></li> 
  <li class="fa-li"><i class="fa fa-remove remcliente"  title="Rimuovi cliente" data-id="<%=listaUtentiPrivati.get(i).getID()%>" data-nome="<%=listaUtentiPrivati.get(i).getNome()%>" data-cognome="<%=listaUtentiPrivati.get(i).getCognome()%>"></i></li>
</ul></td>
												</tr>
												<%
										}
									}
									
									%>
									
									</tbody>
									</table>
									</div>
										<!--end: Datatable -->
									</div>
								</div>
							</div>
						
						</div>
						<!--End::Section-->   
						<!--Begin::Section-->
						<div class="row">
							<div class="col-xl-12">
								<div class="m-portlet m-portlet--mobile ">
									<div class="m-portlet__head">
										<div class="m-portlet__head-caption">
											<div class="m-portlet__head-title">
												<h3 class="m-portlet__head-text">
												<i class="fa fa-briefcase fah3"  ></i>
													Clienti Business
												</h3>
											</div>
										</div>
									<button class="btn btn-info btn-add" type="button" data-toggle="modal" data-target="#modaladduserbusiness">Aggiungi Nuovo</button>
									</div>
									<div class="m-portlet__body">
										<!--begin: Datatable -->
									<!--	<div class="m_datatable" id="m_datatable_latest_orders"></div>-->
									<div class="table-responsive">
									<table class="table table-striped">
									<thead>
									<tr>
									<th>ID</th>
									<th>Denominazione</th>
									<th>Nome Referente</th>
									<th>Cognome Referente</th>
									<th>Email</th>
									<th>Telefono</th>
									<th>Citt&agrave;</th>
									<th>Data Registrazione</th>
									<th style="width:150px;"></th>
									
									</tr>
									</thead>
									<tbody>
									
									
									
									<% if(listaClientiBusiness.size() != 0){
										for(int i = 0; i<listaClientiBusiness.size(); i++){
											%>
												<tr>
													<td><%=listaClientiBusiness.get(i).id%></td>
													<td><%=listaClientiBusiness.get(i).getDenominazione()%></td>
													<td><%=listaClientiBusiness.get(i).getNomeReferente()%></td>
													<td><%=listaClientiBusiness.get(i).getCognomeReferente()%></td>
													<td><%=listaClientiBusiness.get(i).getEmail()%></td>
													<td><%=listaClientiBusiness.get(i).getTelefono()%></td>
													<td><%=listaClientiBusiness.get(i).getCitta()%></td>
													<td><%=listaClientiBusiness.get(i).getDataInserimento()%></td>
													<td><ul class="fa-ul">
  <li class="fa-li"><a class="ali" href="list_auto_business.jsp?idutente=<%=listaClientiBusiness.get(i).id%>" target="_blank"><i class="fa fa-car"  title="Visualizza lista auto"></i></a></li>
  <li class="fa-li"><i class="fa fa-pencil modbusiness" title="Modifica cliente" data-id="<%=listaClientiBusiness.get(i).id%>" data-nome="<%=listaClientiBusiness.get(i).getNomeReferente()%>" data-cognome="<%=listaClientiBusiness.get(i).getCognomeReferente()%>" data-email="<%=listaClientiBusiness.get(i).getEmail()%>" data-telefono="<%=listaClientiBusiness.get(i).getTelefono()%>" data-citta="<%=listaClientiBusiness.get(i).getCitta()%>" data-denominazione="<%=listaClientiBusiness.get(i).getDenominazione()%>"></i></li> 
  <li class="fa-li"><i class="fa fa-remove"  title="Rimuovi cliente"></i></li>
</ul></td>
												</tr>
												<%
										}
									}
									
									%>
									
									
									
									
									
									</tbody>
									</table>
									</div>
										<!--end: Datatable -->
									</div>
								</div>
							</div>
						
						</div>
						<!--End::Section-->
<!--Begin::Section-->
						<div class="row">
							<div class="col-xl-12">
								<div class="m-portlet m-portlet--mobile ">
									<div class="m-portlet__head">
										<div class="m-portlet__head-caption">
											<div class="m-portlet__head-title">
												<h3 class="m-portlet__head-text">
												<i class="fa fa-car fah3"  ></i>	Auto <%=a.getDenominazione()%>
												</h3>
											</div>
										</div>
									<button class="btn btn-info btn-add" type="button" data-toggle="modal" data-target="#modaladdauto">Aggiungi Nuova</button>
									</div>
									<div class="m-portlet__body">
										<!--begin: Datatable -->
									<!--	<div class="m_datatable" id="m_datatable_latest_orders"></div>-->
									<div class="table-responsive">
									<table class="table table-striped">
									<thead>
									<tr>
									<th>ID</th>
									<th>Marca</th>
									<th>Modello</th>
									<th>Targa</th>
									<th>Telaio</th>
									<th>Da Noleggio</th>
									<th>Stato</th>
									<th></th>
									</tr>
									</thead>
									<tbody>
									
									
									
									
									
									
												<% if(listaAutoOfficina.size() != 0){
													
													NoleggioDTO clienteBusiness = null;
													NoleggioDTO clientePrivato = null;
													
										for(int i = 0; i<listaAutoOfficina.size(); i++){
					
											
											%>
												<tr>
													<td><%=listaAutoOfficina.get(i).getID()%></td>
													<td><%=listaAutoOfficina.get(i).getMarca()%></td>
													<td><%=listaAutoOfficina.get(i).getModello()%></td>
													<td><%=listaAutoOfficina.get(i).getTarga()%></td>
													<td><%=listaAutoOfficina.get(i).getNumeroTelaio()%></td>
												<td><% if(listaAutoOfficina.get(i).getDaNoleggio()==0) out.println("Non da noleggio"); else out.println("Da Noleggio");%></td>
												
												
												<%clienteBusiness = DaoUtility.noleggioAutoClienteBusiness(listaAutoOfficina.get(i).getID());
												clientePrivato = DaoUtility.noleggioAutoClientePrivato(listaAutoOfficina.get(i).getID());
											 nol=false;
												if((clienteBusiness != null) || (clientePrivato != null)){
													if(clienteBusiness != null){if(clienteBusiness.KmMaxNoleggio != 0){  nol=true; %><td>In noleggio</td><% }}
													else if(clientePrivato.KmMaxNoleggio != 0){ nol=true; %><td>In noleggio</td><%}
													else {%><td>Auto Privata</td><%}
													}else {%><td>Non in noleggio</td><% }
				
												%>
												<td><ul class="fa-ul"> <li class="fa-li"><a class="ali  <% if(nol){ %> "  href="dettagli_utente.jsp?idauto=<%=listaAutoOfficina.get(i).getID()%>"<% }else { %> transparentli" style="cursor:none !important;" <% } %>  target="_blank"><i class="fa fa-user" title="Visualizza Utente associato"></i></a></li>
												<li class="fa-li"><i class="fa fa-calendar"  title="Visualizza scadenze auto"></i></li>
												  <li class="fa-li"><i class="fa fa-pencil" title="Modifica auto"></i></li> 
												  <li class="fa-li"><i class="fa fa-remove"  title="Rimuovi auto"></i></li>
												</ul></td>
												</tr>
												<%
										}
												}
									%>
									
									
									
									
									</tbody>
									</table>
									</div>
										<!--end: Datatable -->
									</div>
								</div>
							</div>
						
						</div>
						<!--End::Section-->   
						

<!--Begin::Section-->
						<div class="row" id="tableguasti">
							<div class="col-xl-12">
								<div class="m-portlet m-portlet--mobile ">
									<div class="m-portlet__head">
										<div class="m-portlet__head-caption">
											<div class="m-portlet__head-title">
												<h3 class="m-portlet__head-text">
												<i class="fa fa-wrench fah3"  ></i>
													Guasti
												</h3>
											</div>
										</div>
									
									</div>
									<div class="m-portlet__body">
										<!--begin: Datatable -->
									<!--	<div class="m_datatable" id="m_datatable_latest_orders"></div>-->
									<div class="table-responsive">
									<table class="table table-striped">
									<thead>
									<tr>
									<th>ID</th>
									<th>Codice</th>
									<th>Data</th>
									<th>Dettagli</th>
									<th>Dispositivo</th>
									<th>Marca</th>
									<th>Modello</th>
									<th>Targa</th>
									<th>Telaio</th>
									<th></th>
						
									
									</tr>
									</thead>
									<tbody>
									
											<% if(guasti.size() != 0){
										for(int i = 0; i<guasti.size(); i++){
											%>
												<tr>
													<td><%=guasti.get(i).getId()%></td>
													<td><%=guasti.get(i).getCodice()%></td>
													<td><%=guasti.get(i).getData()%></td>
													<td><%=guasti.get(i).getDescrizione()%></td>
													<td><%=guasti.get(i).getIdDispositivo()%></td>
													<td><%=guasti.get(i).getMarcaAuto()%></td>
													<td><%=guasti.get(i).getModelloAuto()%></td>
													<td><%=guasti.get(i).getNumeroTarga()%></td>
													<td><%=guasti.get(i).getNumeroTelaio()%></td>
													<td><ul class="fa-ul">
  <li class="fa-li"><i class="fa fa-bar-chart"  title="Visualizza dati telemetria"></i></li>
  <li class="fa-li"><i class="fa fa-user" title="Visualizza dati cliente"></i></li> 

</ul></td>
												</tr>
												<%
										}
									}
									
									%>
									
									
									
									</tbody>
									</table>
									</div>
										<!--end: Datatable -->
									</div>
								</div>
							</div>
						
						</div>
						<!--End::Section-->   
						
	
<!--Begin::Section-->
						<div class="row" id="tabledispositivi">
							<div class="col-xl-12">
								<div class="m-portlet m-portlet--mobile ">
									<div class="m-portlet__head">
										<div class="m-portlet__head-caption">
											<div class="m-portlet__head-title">
												<h3 class="m-portlet__head-text">
												<i class="fa fa-microchip fah3"  ></i>
													DISPOSITIVI
												</h3>
											</div>
										</div>
									
									</div>
									<div class="m-portlet__body">
										<!--begin: Datatable -->
									<!--	<div class="m_datatable" id="m_datatable_latest_orders"></div>-->
									<div class="table-responsive">
									<table class="table table-striped">
									<thead>
									<tr>
									<th>ID</th>
									<th>Codice</th>
									<th>ID Auto</th>
									<th>Data Installazione</th>
							
									<th></th>
						
									
									</tr>
									</thead>
									<tbody>
									
											<% if(dispositivi.size() != 0){
										for(int i = 0; i<dispositivi.size(); i++){
											%>
												<tr>
													<td><%=dispositivi.get(i).getId()%></td>
													<td><%=dispositivi.get(i).getCodice()%></td>
													<td><%if(dispositivi.get(i).getIdAuto()==0)out.println("Nessun auto");else out.println(dispositivi.get(i).getIdAuto());%></td>
													<td><% if(dispositivi.get(i).getDataInstallazione()==null)out.println("Non installato");
													else out.println(dispositivi.get(i).getDataInstallazione());%></td>
													
													
													<td><ul class="fa-ul">
  <li class="fa-li"><a class="ali" href="list_guasti_dispositivo.jsp?id=<%=dispositivi.get(i).getId()%>" target="_blank"><i class="fa fa-wrench"  title="Visualizza guasti dispositivo"></i></a></li>

</ul></td>
												</tr>
												<%
										}
									}
									
									%>
									
									
									
									</tbody>
									</table>
									</div>
										<!--end: Datatable -->
									</div>
								</div>
							</div>
						
						</div>
						<!--End::Section-->   
						
						<!--Begin::Section-->
						<div class="row" id="richiestepreventivi">
							<div class="col-xl-12">
								<div class="m-portlet m-portlet--mobile ">
									<div class="m-portlet__head">
										<div class="m-portlet__head-caption">
											<div class="m-portlet__head-title">
												<h3 class="m-portlet__head-text">
													<i class="fa fa-file-o fah3"  ></i>
													Richieste Preventivo
												</h3>
												<div id=test></div>
											</div>
										</div>
									
									</div>
									<div class="m-portlet__body">
										<!--begin: Datatable -->
									<!--	<div class="m_datatable" id="m_datatable_latest_orders"></div>-->
									<div class="table-responsive">
									<table class="table table-striped">
									<thead>
									<tr>
									<th>ID</th>
									<th>Descrizione</th>
									<th>ID Auto</th>
									<th>ID Utente</th>
									<th style="width:150px;"></th>
									
									</tr>
									</thead>
									<tbody>
									
									
									
									
												<% if(richieste.size() != 0){
										for(int i = 0; i<richieste.size(); i++){
											%>
												<tr>
														<td><%=richieste.get(i).getId()%></td>
												<td><%=richieste.get(i).getDescrizione()%></td>
												<td><%=richieste.get(i).getIdAuto()%></td>
												<td><%=richieste.get(i).getIdUtente()%></td>
												<td></td>
												</tr>
												<%
										}
									}
									
									%>
									
									</tbody>
									</table>
									</div>
										<!--end: Datatable -->
									</div>
								</div>
							</div>
						
						</div>
						<!--End::Section-->  
					</div>
				</div>
				<!--
			</div>
			-->
		</div>
		<!-- end::Body -->
<%@ include file = "footer.jsp" %>
	</div>
	<!-- end:: Page -->
    	 
<!-- begin::modal windows -->
<!-- begin::modal add  cliente business -->
<div class="modal" tabindex="-1" role="dialog" id="modaladduserbusiness">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Aggiungi Cliente Business</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <form action="" method="POST">
  <div class="form-group">
    <label for="nomeclientebusiness">Denominazione</label>
    <input type="text" class="form-control" id="nomeclientebusiness" aria-describedby="nomeclientebusiness" placeholder="Denominazione Cliente Business..." name="nomeclientebusiness" required>
   
  </div>
  <div class="form-group">
    <label for="nomereferentebusiness">Nome referente</label>
    <input type="text" class="form-control" id="nomereferentebusiness" placeholder="Nome referente business..." name="nomerefebusiness">
  </div>
  <div class="form-group">
    <label for="cognomereferentebusiness">Cognome referente</label>
    <input type="text" class="form-control" id="cognomereferentebusiness" placeholder="Cognome referente business..." name="cognomerefbusiness">
  </div>
    <div class="form-group">
    <label for="emailbusiness">Email</label>
    <input type="email" class="form-control" id="emailbusiness" placeholder="Email..." name="emailbusiness">
  </div>
    <div class="form-group">
    <label for="telefonobusiness">Telefono</label>
    <input type="text" class="form-control" id="telefonobusiness" placeholder="Telefono..." name="telefonobusiness">
  </div>
   <div class="form-group">
    <label for="cittabusiness">Citt&agrave;</label>
    <input type="text" class="form-control" id="cittabusiness" placeholder="Citt&agrave;..." name="cittabusiness">
  </div>
  

      </div>
      <div class="modal-footer " style="text-align:center;" >
       <button type="submit" class="btn btn-primary savebutton">Salva</button>
	   </form>
      </div>
    </div>
  </div>
</div>
<!-- end::modal add cliente business -->
<!-- begin::modal add cliente -->
<div class="modal" tabindex="-1" role="dialog" id="modaladduser">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Aggiungi Cliente</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <form action="RegistraUtente" method="POST">
<div class="form-group">
							<label for="nomecliente">Nome</label> <input type="text"
								class="form-control" id="nome"
								aria-describedby="nome" placeholder="Nome..." name="nome"
								required>

						</div>
						<div class="form-group">
							<label for="cognomecliente">Cognome</label> <input type="text"
								class="form-control" id="cognomecliente"
								placeholder="Cognome..." name="cognomecliente">
						</div>
						<div class="form-group">
							<label for="emailcliente">Email</label> <input type="email"
								class="form-control" id="emailcliente" placeholder="Email..."
								name="emailcliente" required>
						</div>
						<div class="form-group">
							<label for="pwdcliente">Password</label> <input type="text"
								class="form-control" id="pwdcliente" placeholder="Password..."
								name="pwdcliente" required>
						</div>
						
							<input type="hidden"
								class="form-control" id="idazienda" value="<%=u.getIdAzienda()%>"
								name="idazienda">
						<input type="hidden"
								class="form-control" id="ruolocliente" value="0"
								name="ruolocliente">
								<input type="hidden"
								class="form-control" id="idaziendaprivata" value="0"
								name="idaziendaprivata">
								
						<div class="form-group">
							<label for="telefonocliente">Telefono</label> <input type="text"
								class="form-control" id="telefonocliente"
								placeholder="Telefono..." name="telefonocliente">
						</div>
  

      </div>
      <div class="modal-footer " style="text-align:center;" >
       <button type="submit" class="btn btn-primary savebutton">Salva</button>
	     
</form>
      </div>
    </div>
  </div>
</div>
<!-- end::modal add cliente -->
<!-- begin::modal add auto azienda-->
<div class="modal" tabindex="-1" role="dialog" id="modaladdauto">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Aggiungi Auto Dell'Officina</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <form action="AddAutoAzienda" method="POST">
  <div class="form-group">
    <label for="marca">Marca</label>
    <input type="text" class="form-control" id="marca" aria-describedby="marca" placeholder="Marca..." name="marca" >
   
  </div>
  <div class="form-group">
    <label for="modello">Modello</label>
    <input type="text" class="form-control" id="modello" placeholder="modello..." name="modello">
  </div>
  <div class="form-group">
    <label for="targa">Targa</label>
    <input type="text" class="form-control" id="targa" placeholder="targa..." name="targa">
  </div>
    <div class="form-group">
    <label for="telaio">Telaio</label>
    <input type="text" class="form-control" id="telaio" placeholder="Telaio..." name="telaio">
  </div>
    <div class="form-group">
    <label for="Da Noleggio">Da noleggio</label>
	<select class="form-control" name="danoleggio" id="danoleggio">
	<option selected disabled> Selezionare se da noleggio</option>
	<option value="0">No</option>
	<option value="1">S&igrave;</option>
	</select>
   
  </div>
  
  <input value="<%=a.id%>" type="hidden" name="idazienda">

      </div>
      <div class="modal-footer " style="text-align:center;" >
       <button type="submit" class="btn btn-primary savebutton">Salva</button>
	   </form>
      </div>
    </div>
  </div>
</div>
<!-- end::modal add auto azienda-->
<!-- begin::modal modifica cliente privato-->
<div class="modal" tabindex="-1" role="dialog" id="modalmodcliente">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Modifica cliente privato <span id=modcliente></span></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <form action="ModificaUtente" method="POST">
 
  <div class="form-group">
    <label for="nomemod">Nome</label>
    <input type="text" class="form-control" id="nomemod" placeholder="Nome..." name="nomemod">
  </div>
  <div class="form-group">
    <label for="cognomemod">Cognome</label>
    <input type="text" class="form-control" id="cognomemod" placeholder="Cognome..." name="cognomemod">
  </div>
    <div class="form-group">
    <label for="emailmod">Email</label>
    <input type="email" class="form-control" id="emailmod" placeholder="Email..." name="emailmod">
  </div>
    <div class="form-group">
    <label for="telefonomod">Telefono</label>
    <input type="text" class="form-control" id="telefonomod" placeholder="Telefono..." name="telefonomod">
  </div>
 
  <input type="hidden" id="idmod" name="idmod">
  

      </div>
      <div class="modal-footer " style="text-align:center;" >
       <button type="submit" class="btn btn-primary savebutton">Salva</button>
	   </form>
      </div>
    </div>
  </div>
</div>
<!-- end::modal modifica cliente -->
<!-- begin::modal modifica cliente business-->
<div class="modal" tabindex="-1" role="dialog" id="modalmodbusiness">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Modifica cliente business <span id=modbusiness></span></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <form action="ModificaUtenteBusiness" method="POST">
 <div class="form-group">
    <label for="denominazionemodbusiness">Nome</label>
    <input type="text" class="form-control" id="denominazionemodbusiness" placeholder="Denominazione..." name="denominazionemodbusiness">
  </div>
  <div class="form-group">
    <label for="nomemodbusiness">Nome</label>
    <input type="text" class="form-control" id="nomemodbusiness" placeholder="Nome..." name="nomemodbusiness">
  </div>
  <div class="form-group">
    <label for="cognomemodbusiness">Cognome</label>
    <input type="text" class="form-control" id="cognomemodbusiness" placeholder="Cognome..." name="cognomemodbusiness">
  </div>
    <div class="form-group">
    <label for="emailmodbusiness">Email</label>
    <input type="email" class="form-control" id="emailmodbusiness" placeholder="Email..." name="emailmodbusiness">
  </div>
    <div class="form-group">
    <label for="telefonomodbusiness">Telefono</label>
    <input type="text" class="form-control" id="telefonomodbusiness" placeholder="Telefono..." name="telefonomodbusiness">
  </div>
 <div class="form-group">
    <label for="cittamodbusiness">Citt&agrave;</label>
    <input type="text" class="form-control" id="cittamodbusiness" placeholder="Citt&agrave;..." name="cittamodbusiness">
  </div>
  <input type="hidden" id="idmodbusiness" name="idmodbusiness">
  

      </div>
      <div class="modal-footer " style="text-align:center;" >
       <button type="submit" class="btn btn-primary savebutton">Salva</button>
	   </form>
      </div>
    </div>
  </div>
</div>
<!-- end::modal modifica cliente business -->
<!-- begin::modal conferma rimuovi cliente privato -->
<div class="modal" tabindex="-1" role="dialog" id="modalconfermarimuoviprivato">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Rimozione cliente<span id="titleconfermarimuoviprivato"></span></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <form action="RimuoviCliente" method="POST">
  <p>Confermi di voler rimuovere questo cliente?</p>
  <input type="hidden" id="idrimuoviclienteprivato" name="idrimuoviclienteprivato">

      </div>
      <div class="modal-footer " style="text-align:center;" >
       <button type="submit" class="btn btn-primary savebutton">Conferma</button>
	   <button type="button" class="btn btn-default" data-dismiss="modal">Annulla</button>
	   </form>
      </div>
    </div>
  </div>
</div>
<!-- end::modal conferma rimuovi cliente privato -->
<!-- end::modal windows -->
	    <!-- begin::Scroll Top -->
	<div class="m-scroll-top m-scroll-top--skin-top" data-toggle="m-scroll-top" data-scroll-offset="500" data-scroll-speed="300">
		<i class="la la-arrow-up"></i>
	</div>
	<!-- end::Scroll Top -->		
    	<!--begin::Base Scripts -->
	<script src="assets/vendors/base/vendors.bundle.js" type="text/javascript"></script>
	<script src="assets/demo/demo2/base/scripts.bundle.js" type="text/javascript"></script>
	<!--end::Base Scripts -->   
        <!--begin::Page Vendors -->
	<script src="assets/vendors/custom/fullcalendar/fullcalendar.bundle.js" type="text/javascript"></script>
	<!--end::Page Vendors -->  
        <!--begin::Page Snippets -->
	<script src="assets/app/js/dashboard.js" type="text/javascript"></script>
	<!--end::Page Snippets -->
	<script>
	
	$('.modcliente').on('click',function(){
	var nome=$(this).data("nome");
	var cognome=$(this).data("cognome");
	var telefono = $(this).data("telefono");
	var email = $(this).data("email");
	var id=$(this).data("id");
	$('#modcliente').html(nome+ " " +cognome);
	$('#nomemod').val(nome);
	$('#cognomemod').val(cognome);
	$('#telefonomod').val(telefono);
	$('#emailmod').val(email);
	$('#idmod').val(id);
	$('#modalmodcliente').modal("show");
	});
		$('.modbusiness').on('click',function(){
			var denominazione=$(this).data("denominazione");
			var citta = $(this).data("citta");
	var nome=$(this).data("nome");
	var cognome=$(this).data("cognome");
	var telefono = $(this).data("telefono");
	var email = $(this).data("email");
	var id=$(this).data("id");
	$('#modbusiness').html(nome+ " " +cognome);
	$('#nomemodbusiness').val(nome);
	$('#denominazionemodbusiness').val(denominazione);
	$('#cittamodbusiness').val(citta);
	$('#cognomemodbusiness').val(cognome);
	$('#telefonomodbusiness').val(telefono);
	$('#emailmodbusiness').val(email);
	$('#idmodbusiness').val(id);
	$('#modalmodbusiness').modal("show");
	});
	
	$('.remcliente').on('click',function(){
			
	var nome=$(this).data("nome");
	var cognome=$(this).data("cognome");

	var id=$(this).data("id");
	$('#titleconfermarimuoviprivato').html(nome+ " " +cognome);
	$('#idrimuoviclienteprivato').val(id);
	$('#modalconfermarimuoviprivato').modal("show");
	});

	
	</script>
	<% } 
}%>
</body>
<!-- end::Body -->
</html>
