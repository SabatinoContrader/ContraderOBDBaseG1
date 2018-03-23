<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!-- 
Template Name: Metronic - Responsive Admin Dashboard Template build with Twitter Bootstrap 4
Author: KeenThemes
Website: http://www.keenthemes.com/
Contact: support@keenthemes.com
Follow: www.twitter.com/keenthemes
Dribbble: www.dribbble.com/keenthemes
Like: www.facebook.com/keenthemes
Purchase: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes
Renew Support: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes
License: You must have a valid license purchased only from themeforest(the above link) in order to legally use the theme for your project.
-->
<html lang="en">
<!-- begin::Head -->
<head>
<meta charset="utf-8" />
<title>Admin HOME</title>
<meta name="description" content="Latest updates and statistic charts">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!--begin::Web font -->
<script
	src="https://ajax.googleapis.com/ajax/libs/webfont/1.6.16/webfont.js"></script>
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
<link href="assets/vendors/custom/fullcalendar/fullcalendar.bundle.css"
	rel="stylesheet" type="text/css" />
<!--end::Page Vendors -->
<link href="assets/vendors/base/vendors.bundle.css" rel="stylesheet"
	type="text/css" />
<link href="assets/demo/demo2/base/style.bundle.css" rel="stylesheet"
	type="text/css" />
<!--end::Base Styles -->
<!-- <link rel="shortcut icon" href="assets/demo/demo2/media/img/logo/favicon.ico" /> -->
<style>
.savebutton {
	margin-left: auto;
	margin-right: auto;
}

.btn-box {
	margin-top: 20px;
	width: 200px;
}

.logo {
	max-width: 150px;
}

.m-widget24 .m-widget24__item .m-widget24__stats {
	margin-top: -2.43rem !important;
}

.m-widget24 .m-widget24__item .m-widget24__title {
	margin-top: 1.23rem !important;
}
.fah3{font-size:24px;padding-right:10px;}
</style>
</head>
<!-- end::Head -->
<!-- end::Body -->
<body
	class="m-page--wide m-header--fixed m-header--fixed-mobile m-footer--push m-aside--offcanvas-default">


	<%@ page import="com.project.model.*"%>
	<%@ page import="com.project.automotive.dto.*"%>
	<%@ page import="utility.*"%>
	<%@ page import="java.util.List"%>
	<%@ page import="java.util.ArrayList"%>
	<%@ page import="com.project.dao.DispositivoDAO"%>
	<%@ page import="com.project.dao.CarDAO"%>
	<%@ page import="com.project.dao.AlertsDAO"%>
	
	<%
Utente u = (Utente)session.getAttribute("Utente");
if(u != null ){
	switch(u.getRuolo()){
	case 0:
		response.sendRedirect("utente_home.jsp");
		break;
	case 1:
		response.sendRedirect("home_officina.jsp");
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

String name = u.getNome();

List<Azienda> officine = DaoUtility.getListaOfficine();
List<Utente> utenti = DaoUtility.getListaUtenti();
List<Dispositivo> dispositivi = DispositivoDAO.getAllSystemDevice();
List<Auto> auto = CarDAO.getListAllAuto();
AlertsDAO adao = new AlertsDAO();
ArrayList<GuastoDTO> guasti = adao.getAlertsGuastiSystemAdministrator();
%>



	<!-- begin:: Page -->
	<div class="m-grid m-grid--hor m-grid--root m-page">
	<%@ include file = "header.jsp" %>
		<!-- begin::Body -->
		<div
			class="m-grid__item m-grid__item--fluid  m-grid m-grid--ver-desktop m-grid--desktop 	m-container m-container--responsive m-container--xxl m-page__container m-body">
			<div class="m-grid__item m-grid__item--fluid m-wrapper">
				<!-- BEGIN: Subheader -->
				<div class="m-subheader ">
					<div class="d-flex align-items-center">
						<div class="mr-auto">
							<h3 class="m-subheader__title ">Dashboard - Amministratore Sistema</h3>
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
											<h4 class="m-widget24__title">Officine</h4>
											<br> <span class="m-widget24__desc"> Tutte le
												officine del network </span> <span
												class="m-widget24__stats m--font-brand"> <%=officine.size() %>
											</span>
											<div class="m--space-10"></div>
											<p style="text-align: center;">
												<button data-toggle="modal" data-target="#modaladdofficina"
													style="background-color: #716aca !important"
													class="btn btn-info btn-box" type="button">Aggiungi
													Officina</button>
											</p>
										</div>
									</div>
									<!--end::Total Profit-->
								</div>
								<div class="col-md-12 col-lg-6 col-xl-3">
									<!--begin::New Feedbacks-->
									<div class="m-widget24">
										<div class="m-widget24__item">
											<h4 class="m-widget24__title">Utenti</h4>
											<br> <span class="m-widget24__desc"> Tutti i
												clienti delle officine </span> <span
												class="m-widget24__stats m--font-info"> <%=utenti.size() %>
											</span>
											<div class="m--space-10"></div>

											<p style="text-align: center;">
												<button data-toggle="modal" data-target="#modaladduser"
													style="background-color: #36a3f7 !important"
													class="btn btn-info btn-box" type="button">Aggiungi	Utente</button>

											</p>
										</div>
									</div>
									<!--end::New Feedbacks-->
								</div>
								<div class="col-md-12 col-lg-6 col-xl-3">
									<!--begin::New Orders-->
									<div class="m-widget24">
										<div class="m-widget24__item">
											<h4 class="m-widget24__title">New Orders</h4>
											<br> <span class="m-widget24__desc"> Fresh Order
												Amount </span> <span class="m-widget24__stats m--font-danger">
												567 </span>
											<div class="m--space-10"></div>
											<div class="progress m-progress--sm">
												<div class="progress-bar m--bg-danger" role="progressbar"
													style="width: 69%;" aria-valuenow="50" aria-valuemin="0"
													aria-valuemax="100"></div>
											</div>
											<span class="m-widget24__change"> Change </span> <span
												class="m-widget24__number"> 69% </span>
										</div>
									</div>
									<!--end::New Orders-->
								</div>
								<div class="col-md-12 col-lg-6 col-xl-3">
									<!--begin::New Users-->
									<div class="m-widget24">
										<div class="m-widget24__item">
											<h4 class="m-widget24__title">New Users</h4>
											<br> <span class="m-widget24__desc"> Joined New
												User </span> <span class="m-widget24__stats m--font-success">
												276 </span>
											<div class="m--space-10"></div>
											<div class="progress m-progress--sm">
												<div class="progress-bar m--bg-success" role="progressbar"
													style="width: 90%;" aria-valuenow="50" aria-valuemin="0"
													aria-valuemax="100"></div>
											</div>
											<span class="m-widget24__change"> Change </span> <span
												class="m-widget24__number"> 90% </span>
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
							<!--begin::Portlet-->
							<!--		<div class="m-portlet " id="m_portlet">
									<div class="m-portlet__head">
										<div class="m-portlet__head-caption">
											<div class="m-portlet__head-title">
												<span class="m-portlet__head-icon">
													<i class="flaticon-map-location"></i>
												</span>
												<h3 class="m-portlet__head-text">
													Calendar
												</h3>
											</div>
										</div>
										<div class="m-portlet__head-tools">
											<ul class="m-portlet__nav">
												<li class="m-portlet__nav-item">
													<a href="#" class="btn btn-accent m-btn m-btn--custom m-btn--icon m-btn--pill m-btn--air">
														<span>
															<i class="la la-plus"></i>
															<span>
																Add Event
															</span>
														</span>
													</a>
												</li>
											</ul>
										</div>
									</div>
									<div class="m-portlet__body">
										<div id="m_calendar"></div>
									</div>
								</div>
								<!--end::Portlet-->
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
											<h3 class="m-portlet__head-text"><i class="fa fa-wrench fah3"  ></i>OFFICINE</h3>
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
													<th>Denominazione</th>
													<th>Nome Referente</th>
													<th>Cognome Referente</th>
													<th>Email</th>
													<th>Telefono</th>
													<th>Citt&agrave;</th>
												</tr>
											</thead>
											<tbody>



												<% if(officine.size() != 0){
										for(int i = 0; i<officine.size(); i++){
											%>
												<tr>
													<td><%=officine.get(i).id%></td>
													<td><%=officine.get(i).getDenominazione()%></td>
													<td><%=officine.get(i).getNomeReferente()%></td>
													<td><%=officine.get(i).getCognomeReferente()%></td>
													<td><%=officine.get(i).getEmail()%></td>
													<td><%=officine.get(i).getTelefono()%></td>
													<td><%=officine.get(i).getCitta()%></td>
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
											<h3 class="m-portlet__head-text"><i class="fa fa-user fah3"  ></i>UTENTI</h3>
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
													<th>Nome</th>
													<th>Cognome</th>
													<th>Email</th>
													<th>Telefono</th>
													<th>ID Azienda</th>
												</tr>
											</thead>
											<tbody>


												<% if(utenti.size() != 0){
										for(int i = 0; i<utenti.size(); i++){
											%>
												<tr>
													<td><%=utenti.get(i).getID()%></td>
													<td><%=utenti.get(i).getNome()%></td>
													<td><%=utenti.get(i).getCognome()%></td>
													<td><%=utenti.get(i).getEmail()%></td>
													<td><%=utenti.get(i).getTelefono()%></td>
													<td><%=utenti.get(i).getIdAzienda()%></td>
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
					
						<!--Begin::Section TABLE DEVICE-->
					<div class="row">
						<div class="col-xl-12">
							<div class="m-portlet m-portlet--mobile ">
								<div class="m-portlet__head">
									<div class="m-portlet__head-caption">
										<div class="m-portlet__head-title">
											<h3 class="m-portlet__head-text">	<i class="fa fa-microchip fah3"  ></i>DISPOSITIVI</h3>
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
													<th>ID Azienda</th>
													
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
													<td><%=dispositivi.get(i).getIdAzienda()%></td>
													
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
					<!--End::Section TABLE DEVICE-->
					
					
					<!--Begin::Section TABLE AUTO-->
					<div class="row">
						<div class="col-xl-12">
							<div class="m-portlet m-portlet--mobile ">
								<div class="m-portlet__head">
									<div class="m-portlet__head-caption">
										<div class="m-portlet__head-title">
											<h3 class="m-portlet__head-text">	<i class="fa fa-car fah3"  ></i>AUTO</h3>
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
													<th>Marca</th>
													<th>Modello</th>
													<th>Targa</th>
													<th>Telaio</th>
													<th></th>
												</tr>
											</thead>
											<tbody>



												<% if(auto.size() != 0){
										for(int i = 0; i<auto.size(); i++){
											%>
												<tr>
													<td><%=auto.get(i).getID()%></td>
													<td><%=auto.get(i).getMarca()%></td>
													<td><%=auto.get(i).getModello()%></td>
													<td><%=auto.get(i).getTarga()%></td>
													<td><%=auto.get(i).getNumeroTelaio()%></td>
													<td><ul class="fa-ul">
  <li class="fa-li"><i class="fa fa-calendar"  title="Visualizza Scadenze Tecnico Amministrative" data-id="<%=auto.get(i).getID()%>"></i></li>
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
					<!--End::Section TABLE AUTO-->
					
						<!--Begin::Section TABLE GUASTI-->
					<div class="row">
						<div class="col-xl-12">
							<div class="m-portlet m-portlet--mobile ">
								<div class="m-portlet__head">
									<div class="m-portlet__head-caption">
										<div class="m-portlet__head-title">
											<h3 class="m-portlet__head-text">	<i class="fa fa-wrench fah3"  ></i>GUASTI</h3>
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
													<th>Descrizione</th>
													<th>ID Dispositivo</th>
													<th>Marca</th>
													<th>Modello</th>
													<th>Targa</th>
													<th>Telaio</th>
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
												<!--	<td><ul class="fa-ul">
  <li class="fa-li"><i class="fa fa-calendar"  title="Visualizza Scadenze Tecnico Amministrative" data-id="<%=auto.get(i).getID()%>"></i></li>
</ul></td>-->
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
					<!--End::Section TABLE GUASTI-->
					
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
	<!-- begin::modal add officina -->
	<div class="modal" tabindex="-1" role="dialog" id="modaladdofficina">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Aggiungi Officina</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="" method="POST">
						<div class="form-group">
							<label for="nomeofficina">Denominazione</label> <input
								type="text" class="form-control" id="nomeofficina"
								aria-describedby="nomeofficina"
								placeholder="Denominazione Officina..." name="nome" required>

						</div>
						<div class="form-group">
							<label for="nomereferente">Nome referente</label> <input
								type="text" class="form-control" id="nomereferente"
								placeholder="Nome referente..." name="nomeref">
						</div>
						<div class="form-group">
							<label for="cognomereferente">Cognome referente</label> <input
								type="text" class="form-control" id="cognomereferente"
								placeholder="Cognome referente..." name="cognomeref">
						</div>
						<div class="form-group">
							<label for="emailofficina">Email</label> <input type="email"
								class="form-control" id="emailofficina" placeholder="Email..."
								name="emailofficina">
						</div>
						<div class="form-group">
							<label for="telefonoofficina">Telefono</label> <input type="text"
								class="form-control" id="telefonoofficina"
								placeholder="Telefono..." name="telefonoofficina">
						</div>
						<div class="form-group">
							<label for="cittaofficina">Citt&agrave;</label> <input
								type="text" class="form-control" id="cittaofficina"
								placeholder="Citt&agrave;..." name="cittaofficina">
						</div>
				</div>
				<div class="modal-footer " style="text-align: center;">
					<button type="submit" class="btn btn-primary savebutton">Salva</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- end::modal add officina -->
	<!-- begin::modal add cliente -->
	<div class="modal" tabindex="-1" role="dialog" id="modaladduser">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Aggiungi Utente</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="RegistraUtente" method="POST">
						<div class="form-group">
							<label for="nomecliente">Nome</label> <input type="text"
								class="form-control" id="nomecliente"
								aria-describedby="nomecliente" placeholder="Nome..." name="nome"
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
						<div class="form-group">
							<label for="idazienda">ID Officina</label> <input type="number"
								class="form-control" id="idazienda" placeholder="ID Azienda..."
								name="idazienda">
						</div>
						<div class="form-group">
							<label for="telefonocliente">Telefono</label> <input type="text"
								class="form-control" id="telefonocliente"
								placeholder="Telefono..." name="telefonocliente">
						</div>
						<div class="form-group">
							<label for="ruolo">Tipologia Utente</label> <select required
								class="form-control" id="ruolocliente" name="ruolocliente">
								<option disabled selected>Selezione la Tipologia di Utente</option>
								<option value = "0">Cliente Privato</option>
								<option value = "1">Officina</option>
								<option value = "4">Cliente Business</option>
								<option value = "3">Dipendete di Cliente Business</option>
								</select>
						</div>
						<div class="form-group">
							<label for="idaziendaprivata">Id Cliente Business (In caso di Dipendente)</label> <input type="text"
								class="form-control" id="idaziendaprivata"
								placeholder="Id Cliente Business" name="idaziendaprivata">
						</div>
						<div class="modal-footer " style="text-align: center;">
							<button type="submit" class="btn btn-primary savebutton"
								name="RegistraUtente">Salva</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- end::modal add cliente -->
	<!-- end::modal windows -->
	<!-- begin::Scroll Top -->
	<div class="m-scroll-top m-scroll-top--skin-top"
		data-toggle="m-scroll-top" data-scroll-offset="500"
		data-scroll-speed="300">
		<i class="la la-arrow-up"></i>
	</div>
	<!-- end::Scroll Top -->
	<!--begin::Base Scripts -->
	<script src="assets/vendors/base/vendors.bundle.js"
		type="text/javascript"></script>
	<script src="assets/demo/demo2/base/scripts.bundle.js"
		type="text/javascript"></script>
	<!--end::Base Scripts -->
	<!--begin::Page Vendors -->
	<script src="assets/vendors/custom/fullcalendar/fullcalendar.bundle.js"
		type="text/javascript"></script>
	<!--end::Page Vendors -->
	<!--begin::Page Snippets -->
	<script src="assets/app/js/dashboard.js" type="text/javascript"></script>
	<!--end::Page Snippets -->

</body>
<!-- end::Body -->
</html>
