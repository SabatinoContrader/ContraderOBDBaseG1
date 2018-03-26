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
			Home Cliente
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
		<!-- <link rel="shortcut icon" href="assets/demo/demo2/media/img/logo/favicon.ico" /> -->
		<style>.logo{max-width:150px;}.m-widget24 .m-widget24__item .m-widget24__stats{margin-top:-2.43rem !important;}.m-widget24 .m-widget24__item .m-widget24__title{margin-top:1.23rem !important;}#autorichiesta{color:red;}
		.ali{color:#575962 !important;cursor:pointer;}.fah3{font-size:24px;padding-right:10px;}
		.btn-box{       border: none;margin-top: 20px;    width: 200px;    color: white !important;-webkit-appearance: button-bevel !important;}</style>
	</head>
	<!-- end::Head -->
    <!-- end::Body -->
	<body class="m-page--wide m-header--fixed m-header--fixed-mobile m-footer--push m-aside--offcanvas-default"  >

	<%@ page import = "com.project.model.*" %>
	<%@ page import = "java.util.ArrayList" %>
	<%@ page import = "java.util.List" %>
	<%@ page import = "com.project.dao.*" %>
	<%@ page import = "com.project.automotive.dto.*" %>

<%
Utente u = (Utente)session.getAttribute("Utente");
    if(u != null ){
    	switch(u.getRuolo()){

    	case 1:
    		response.sendRedirect("home_officina.jsp");
    	break;
    	case 2:
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
 if(u.getRuolo()==0){
String name = u.getNome();

AlertsDAO alerts = new AlertsDAO();

ArrayList<GuastoDTO> listaGuastiUtente = alerts.getUserAlertsGuastiDriver(u);
 List<RichiestaPreventivo> richieste = RichiestaPreventivoDAO.getAllRichiestePreventivoUtente(u.getID());
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
									Dashboard
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
													Guasti
												</h4>
												<br>
												<span class="m-widget24__desc">
													Rilevati dai dispositivi
												</span>
												<span class="m-widget24__stats m--font-brand">
													<%=listaGuastiUtente.size()%>
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
												<h4 class="m-widget24__title">
												Scadenze
												</h4>
												<br>
												
												<span class="m-widget24__stats m--font-info">
													7
												</span>
												<div class="m--space-10"></div>
												<p style="text-align:center;" class="smooth-scroll"><a   style="background-color:#36a3f7   !important" class="btn btn-info btn-box">Visualizza</a></p>
											</div>
										</div>
										<!--end::New Feedbacks-->
									</div>
									<div class="col-md-12 col-lg-6 col-xl-3">
										<!--begin::New Orders-->
										<div class="m-widget24">
											<div class="m-widget24__item">
												<h4 class="m-widget24__title">
													Richieste Preventivo
												</h4>
												<br>
												<span class="m-widget24__desc">
													Per riparazione auto
												</span>
												<span class="m-widget24__stats m--font-danger">
													<%=richieste.size()%>
												</span>
												<div class="m--space-10"></div>
												<p style="text-align:center;" class="smooth-scroll"><a  href="#tablerichiestepreventivo" style="background-color:#f4516c  !important" class="btn btn-info btn-box">Visualizza</a></p>
											</div>
										</div>
										<!--end::New Orders-->
									</div>
									<div class="col-md-12 col-lg-6 col-xl-3">
										<!--begin::New Users-->
										<div class="m-widget24">
											<div class="m-widget24__item">
												<h4 class="m-widget24__title">
													Appuntamenti
												</h4>
												<br>
												
												<span class="m-widget24__stats m--font-success">
													11
												</span>
												<div class="m--space-10"></div>
												<p style="text-align:center;" class="smooth-scroll"><a  style="background-color:#34bfa3    !important" class="btn btn-info btn-box">Visualizza</a></p>
											</div>
										</div>
										<!--end::New Users-->
									</div>
								</div>
							</div>
						</div>
						<!--end:: Widgets/Stats--> 

<!--begin:: section-->
						<div class="row">
							<div class="col-xl-12">
								<div class="m-portlet m-portlet--mobile ">
									<div class="m-portlet__head">
										<div class="m-portlet__head-caption">
											<div class="m-portlet__head-title">
												<h3 class="m-portlet__head-text">
												<i class="fa fa-car fah3"  ></i>
													AUTO UTENTE
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
									<th>Marca</th>
									<th>Modello</th>
									<th>Targa</th>
									<th>Telaio</th>
									<th></th>
									</tr>
									</thead>
									<tbody>
									<% if(u.getAuto().size() != 0){
										for(int i = 0; i<u.getAuto().size(); i++){
											%>
												<tr>
												<td><%=u.getAuto().get(i).getID()%></td>
												<td><%=u.getAuto().get(i).getMarca()%></td>
												<td><%=u.getAuto().get(i).getModello()%></td>
												<td><%=u.getAuto().get(i).getTarga()%></td>
												<td><%=u.getAuto().get(i).getNumeroTelaio()%></td>
													<td><ul class="fa-ul">
  <li class="fa-li"><a class="ali richiedipreventivo" data-marca="<%=u.getAuto().get(i).getMarca()%>"  data-modello="<%=u.getAuto().get(i).getModello()%>" data-id="<%=u.getAuto().get(i).getID()%>" target="_blank"><i class="fa fa-file-o"  title="Richiedi Preventivo per questa auto"></i></a></li>

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
						
<!--begin:: section-->
						<div class="row">
							<div class="col-xl-12">
								<div class="m-portlet m-portlet--mobile ">
									<div class="m-portlet__head">
										<div class="m-portlet__head-caption">
											<div class="m-portlet__head-title">
												<h3 class="m-portlet__head-text">
												<i class="fa fa-wrench fah3"  ></i>
													GUASTI 
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
									<th>Codice</th>
									<th>Data</th>		
									<th>Marca</th>
									<th>Modello</th>
									<th>Targa</th>
									<th>Telaio</th>
									<th></th>
									</tr>
									</thead>
									<tbody>
									<% if(listaGuastiUtente.size() != 0){
										for(int i = 0; i<listaGuastiUtente.size(); i++){
											%>
												<tr>										
												<td><%=listaGuastiUtente.get(i).getCodice()%></td>
												<td><%=listaGuastiUtente.get(i).getData()%></td>
												<td><%=listaGuastiUtente.get(i).getMarcaAuto()%></td>
												<td><%=listaGuastiUtente.get(i).getModelloAuto()%></td>
												<td><%=listaGuastiUtente.get(i).getNumeroTarga()%></td>
												<td><%=listaGuastiUtente.get(i).getNumeroTelaio()%></td>
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
							<!--begin:: section-->
						<div class="row" id="tablerichiestepreventivo">
							<div class="col-xl-12">
								<div class="m-portlet m-portlet--mobile ">
									<div class="m-portlet__head">
										<div class="m-portlet__head-caption">
											<div class="m-portlet__head-title">
												<h3 class="m-portlet__head-text">
												<i class="fa fa-file-o fah3"  ></i>
													Richieste Preventivo
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
									<th>Descrizione</th>
									<th>ID Auto</th>
									<th></th>
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
<!-- begin::modal richiedi preventivo -->
<div class="modal" tabindex="-1" role="dialog" id="modalrichiedipreventivo">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Richiedi preventivo per <span id="autorichiesta"></span></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <form action="RichiediPreventivo" method="POST">
<div class="form-group">
						<div class="form-group">
  <label for="descrizione">Descrizione Problema:</label>
  <textarea class="form-control" rows="5" id="descrizione" name="descrizione"></textarea>
</div>
						
							<input type="hidden"
								class="form-control" id="idutente" value="<%=u.getID()%>"
								name="idutente">
							<input type="hidden"
								class="form-control" id="idazienda" value="<%=u.getIdAzienda()%>"
								name="idazienda">
						<input type="hidden"
								class="form-control" id="idauto" 
								name="idauto">
								
  

      </div>
      <div class="modal-footer " style="text-align:center;" >
       <button type="submit" class="btn btn-primary savebutton">Invia Richiesta</button>
	     
</form>
      </div>
    </div>
  </div>
</div>
<!-- end::modal richiedi preventivo-->
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
	$('.richiedipreventivo').on('click',function(){
		var marca = $(this).data("marca");
	var modello = $(this).data("modello");
	var id=$(this).data("id");
	$('#autorichiesta').html(marca+ " " +modello);
	$('#idauto').val(id);
	$('#modalrichiedipreventivo').modal("show");
		
		
		
	});
	</script>
		<% } 
}%>
</body>
<!-- end::Body -->
</html>
