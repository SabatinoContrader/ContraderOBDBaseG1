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
 int idDispositivo = Integer.parseInt(request.getParameter("id"));

Azienda a = DaoUtility.getDatiAzienda(u);
AlertsDAO aDAO = new AlertsDAO();
ArrayList<GuastoDTO> listaguasti = aDAO.getListaGuastiDispositivo(idDispositivo,u.getIdAzienda());


%>
<html lang="en" >
	<!-- begin::Head -->
	<head>
		<meta charset="utf-8" />
		<title>
			<%=a.getDenominazione()%> - Lista Guasti Dispositivo <%=idDispositivo%>
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
		<style>.ali{color:#575962 !important;}.fah3{font-size:24px;padding-right:10px;}.transparentli{color: transparent;}.fa{cursor:pointer;}.fa-ul li{display:inline;margin-left:10px;}.btn-add:hover{color: #474343 !important;background-color: #f4f5f8 !important;}.btn-add{margin-top: 10px;color: #474343 !important;float:right;background-color: #f4f5f8;margin-right: 20px;border: none;padding: 12px;}.savebutton{margin-left: auto;    margin-right: auto;}.btn-box{       border: none;margin-top: 20px;    width: 200px;    color: white !important;}.logo{max-width:150px;}.m-widget24 .m-widget24__item .m-widget24__stats{margin-top:-2.43rem !important;}.m-widget24 .m-widget24__item .m-widget24__title{margin-top:1.23rem !important;}</style>
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
									Lista Guasti Dispositivo <%=idDispositivo%>
								</h3>
							</div>

						</div>
					</div>
					<!-- END: Subheader -->
					<div class="m-content">
						

<!--Begin::Section-->
						<div class="row">
							<div class="col-xl-12">
								<div class="m-portlet m-portlet--mobile ">
									<div class="m-portlet__head">
										<div class="m-portlet__head-caption">
											<div class="m-portlet__head-title">
												<h3 class="m-portlet__head-text">
												<i class="fa fa-car fah3"  ></i>	Guasti Dispositivo <%=idDispositivo%>
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
									<th>Data</th>
									<th>Codice</th>
									<th>Descrizione</th>
									<th>Marca</th>
									<th>Modello</th>
									<th>Targa</th>
									<th>Telaio</th>
									<th></th>
									</tr>
									</thead>
									<tbody>






												<% if(listaguasti.size() != 0){

													
													

										for(int i = 0; i<listaguasti.size(); i++){


											%>
												<tr>
													<td><%=listaguasti.get(i).getId()%></td>
													<td><%=listaguasti.get(i).getData()%></td>
													<td><%=listaguasti.get(i).getCodice()%></td>
													<td><%=listaguasti.get(i).getDescrizione()%></td>
													<td><%=listaguasti.get(i).getMarcaAuto()%></td>
													<td><%=listaguasti.get(i).getModelloAuto()%></td>
													<td><%=listaguasti.get(i).getNumeroTarga()%></td>
													<td><%=listaguasti.get(i).getNumeroTelaio()%></td>


												
												<td><ul class="fa-ul">
												  <li class="fa-li"><i class="fa fa-check" title="Segna il guasto come risolto"></i></li>
												  <li class="fa-li"><i class="fa fa-info-circle"  title="Visualizza dati telemetria"></i></li>
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
		<!-- end::Body -->
<%@ include file = "footer.jsp" %>
	</div>
	<!-- end:: Page -->

<!-- begin::modal windows -->

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
}	%>
</body>
<!-- end::Body -->
</html>
