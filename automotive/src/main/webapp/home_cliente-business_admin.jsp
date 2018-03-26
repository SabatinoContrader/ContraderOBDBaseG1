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
<html lang="en" >
	<!-- begin::Head -->
	<head>
		<meta charset="utf-8" />
		<title>
			Admin Azienda
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
		<style>#modcliente{color:red;}.fah3{font-size:24px;padding-right:10px;}.transparentli{color: transparent;}.fa{cursor:pointer;}.fa-ul li{display:inline;margin-left:10px;}.btn-add:hover{color: #474343 !important;background-color: #f4f5f8 !important;}.btn-add{margin-top: 10px;color: #474343 !important;float:right;background-color: #f4f5f8;margin-right: 20px;border: none;padding: 12px;}.savebutton{margin-left: auto;    margin-right: auto;}.btn-box{       border: none;margin-top: 20px;    width: 200px;    color: white !important;}.logo{max-width:150px;}.m-widget24 .m-widget24__item .m-widget24__stats{margin-top:-2.43rem !important;}.m-widget24 .m-widget24__item .m-widget24__title{margin-top:1.23rem !important;}.logo{max-width:150px;}.m-widget24 .m-widget24__item .m-widget24__stats{margin-top:-2.43rem !important;}.m-widget24 .m-widget24__item .m-widget24__title{margin-top:1.23rem !important;}</style>
	</head>
	<!-- end::Head -->
    <!-- end::Body -->
	<body class="m-page--wide m-header--fixed m-header--fixed-mobile m-footer--push m-aside--offcanvas-default"  >

	<%@ page import = "com.project.model.*" %>
	<%@ page import = "java.util.List" %>
	<%@ page import = "com.project.dao.*" %>
	<%@ page import = "utility.*" %>
	
	
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
	case 2:
		response.sendRedirect("home_admin.jsp");
		break;
	case 3:
		//INFINITE LOOP, FAME DA LOOP
		//TO DO

	}
}else{
response.sendRedirect("index.jsp");

}

String name = u.getNome();

Azienda a = DaoUtility.getDatiAziendaPrivata(u.idAziendaPrivata);

List<Auto> listaAutoAziendaPrivata = DaoUtility.getAutoAziendaPrivata(u.idAziendaPrivata);

List<Utente> listaDipendenti = DaoUtility.getListaDipendendi(u.idAziendaPrivata);


%>
	
	
	
	
	
	
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
									Dashboard - <%=a.getDenominazione()%> Admin
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
													13
												</span>
												<div class="m--space-10"></div>
											<p style="text-align:center;" class="smooth-scroll"><a  style="background-color:#716aca !important" class="btn btn-info btn-box">Visualizza</a></p>
											</div>
										</div>
										<!--end::Total Profit-->
									</div>
									<div class="col-md-12 col-lg-6 col-xl-3">
										<!--begin::New Feedbacks-->
										<div class="m-widget24">
											<div class="m-widget24__item">
												<h4 class="m-widget24__title">
													SCADENZE
												</h4>
												<br>
												<span class="m-widget24__desc">
													Manutenzione
												</span>
												<span class="m-widget24__stats m--font-info">
													45
												</span>
												<div class="m--space-10"></div>
											
													<p style="text-align:center;"><a  style="background-color:#36a3f7  !important" class="btn btn-info btn-box">Visualizza</a></p>
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
													17
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
													34
												</span>
												<div class="m--space-10"></div>
											<p style="text-align:center;"><a  style="background-color:#34bfa3   !important" class="btn btn-info btn-box"  >Visualizza</a></p>
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
												<h3 class="m-portlet__head-text">
												<i class="fa fa-car fah3"  ></i>
													AUTO AZIENDALI
												</h3>
											</div>
										</div>
										<button class="btn btn-info btn-add" type="button" data-toggle="modal" data-target="#modaladdcar">Aggiungi Nuova </button>
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
									
									
									<% if(listaAutoAziendaPrivata.size() != 0){
										
										for(int i = 0; i<listaAutoAziendaPrivata.size(); i++){
											%>
												<tr>
												<td><%=listaAutoAziendaPrivata.get(i).getID()%></td>
												<td><%=listaAutoAziendaPrivata.get(i).getMarca()%></td>
												<td><%=listaAutoAziendaPrivata.get(i).getModello()%></td>
												<td><%=listaAutoAziendaPrivata.get(i).getTarga()%></td>
												<td><%=listaAutoAziendaPrivata.get(i).getNumeroTelaio()%></td>
												
												<td>
												<ul class="fa-ul">
												  <li class="fa-li"><i class="fa fa-calendar"  title="Visualizza Scadenze Tecnico Amministrative"></i></li>
												  <li class="fa-li"><i class="fa fa-tachometer"  title="Associa Auto A Dipendente"></i></li></ul></td>
																								
												
												
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
						
						
<!--Begin::Section TABLE DIPENDENTI-->
						<div class="row">
							<div class="col-xl-12">
								<div class="m-portlet m-portlet--mobile ">
									<div class="m-portlet__head">
										<div class="m-portlet__head-caption">
											<div class="m-portlet__head-title">
												<h3 class="m-portlet__head-text">
												<i class="fa fa-user fah3"  ></i>
													DIPENDENTI
												</h3>
											</div>
										</div>
									<button class="btn btn-info btn-add" type="button" data-toggle="modal" data-target="#modaladduser">Aggiungi Nuovo </button>
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
									<th></th>
									</tr>
									</thead>
									<tbody>
									
									
									
									
									
												<% if(listaDipendenti.size() != 0){
										for(int i = 0; i<listaDipendenti.size(); i++){
											%>
												<tr>
													<td><%=listaDipendenti.get(i).getID()%></td>
													<td><%=listaDipendenti.get(i).getNome()%></td>
													<td><%=listaDipendenti.get(i).getCognome()%></td>
													<td><%=listaDipendenti.get(i).getEmail()%></td>
													<td><%=listaDipendenti.get(i).getTelefono()%></td>
													<td>
									<ul class="fa-ul">
									 <li class="fa-li"><i class="fa fa-pencil"  title="Modifica Dipendente"></i></li>
  <li class="fa-li"><i class="fa fa-remove"  title="Rimuovi Dipendente"></i></li>
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
					</div>
				</div>
				<!--
			</div>
			-->
		</div>
		
<!-- begin::modal add dipendenti -->
<div class="modal" tabindex="-1" role="dialog" id="modaladduser">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Aggiungi Dipendente</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <form action="" method="POST">
  <div class="form-group">
    <label for="nomeuser">Nome</label>
    <input type="text" class="form-control" id="nomeuser" aria-describedby="nomeuser" placeholder="Nome dipendente..." name="nomeuser" required>
   
  </div>
  <div class="form-group">
    <label for="cognomeuser">Cognome</label>
    <input type="text" class="form-control" id="cognomeuser" placeholder="Cognome dipendente..." name="cognomeuser">
  </div>
  <div class="form-group">
    <label for="emailuser">Cognome referente</label>
    <input type="email" class="form-control" id="emailuser" placeholder="Email..." name="emailuser">
  </div>
    <div class="form-group">
    <label for="telefonouser">Telefono</label>
    <input type="text" class="form-control" id="telefonouser" placeholder="Telefono..." name="telefonouser">
  </div>
   
  
  

      </div>
      <div class="modal-footer " style="text-align:center;" >
       <button type="submit" class="btn btn-primary savebutton">Salva</button>
	   </form>
      </div>
    </div>
  </div>
</div>
<!-- end::modal add dipendente -->
<!-- begin::modal add  auto aziendali -->
<div class="modal" tabindex="-1" role="dialog" id="modaladdcar">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Aggiungi Auto Aziendale</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <form action="" method="POST">
  <div class="form-group">
    <label for="marca">Marca</label>
    <input type="text" class="form-control" id="marca" aria-describedby="marca" placeholder="Marca..." name="marca" required>
   
  </div>
  <div class="form-group">
    <label for="modello">Modello</label>
    <input type="text" class="form-control" id="modello" placeholder="Modello..." name="modello">
  </div>
  <div class="form-group">
    <label for="targa">Targa</label>
    <input type="text" class="form-control" id="targa" placeholder="Targa..." name="targa">
  </div>
    <div class="form-group">
    <label for="telaio">Telaio</label>
    <input type="text" class="form-control" id="telaio" placeholder="Telaio..." name="telaio">
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
		<!-- end::Body -->
<%@ include file = "footer.jsp" %>
	</div>
	<!-- end:: Page -->
    	       
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
	
</body>
<!-- end::Body -->
</html>
