<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>

 
<!DOCTYPE html>
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
		<style>.logo{max-width:150px;}.m-widget24 .m-widget24__item .m-widget24__stats{margin-top:-2.43rem !important;}.m-widget24 .m-widget24__item .m-widget24__title{margin-top:1.23rem !important;}#autorichiesta,#autotelemetria{color:red;font-style:capitalize;}
		.ali{color:#575962 !important;cursor:pointer;}.fah3{font-size:24px;padding-right:10px;}
		.btn-box{       border: none;margin-top: 20px;    width: 150px;    color: white !important;-webkit-appearance: button-bevel !important;}
		#uloption{list-style: none;padding-left:0px;}.btn-left{background-color:#4c4e50 !important;}.btn-left-active{background-color:#ea202e !important}.showguasti,.btn-add:hover{color: #474343 !important;background-color: #f4f5f8 !important;}.showguasti,.btn-add{margin-top: 10px;color: #474343 !important;float:right;background-color: #f4f5f8;margin-right: 20px;border: none;padding: 12px;} #datitel{padding-top: 20px;border: 1px solid black;min-height: 200px;padding-left: 10px;}.btnfooter{    margin-left: auto;    margin-right: auto;}.fa-ul > li{display:inline !important;}</style>
	</head>
	<!-- end::Head -->
    <!-- end::Body -->
	<body class="m-page--wide m-header--fixed m-header--fixed-mobile m-footer--push m-aside--offcanvas-default"  >


	
	
	
		<!-- begin:: Page -->
		<div class="m-grid m-grid--hor m-grid--root m-page">
			<jsp:include page="header.jsp" />
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
													Non risolti rilevati dai dispositivi
												</span>
												<span class="m-widget24__stats m--font-brand">
													${guasti}
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
												<span class="m-widget24__desc">
													Tecnico-Amministrative
												</span>
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
												22
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
												<span class="m-widget24__desc">
													Richiesti
												</span>
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

						<!--begin:: section content-->
						<div class="row">
						
						<!--begin:: section LEFT SIDEBAR-->
						
							<div class="col-xs-12 col-sm-12 col-md-3 col-lg-3">
								<!--begin:: Widgets/New Users-->
								<div class="m-portlet m-portlet--full-height ">
								
									<div class="m-portlet__body">
										<div class="tab-content">
											<div class="tab-pane active" id="m_widget4_tab1_content">
												
						<ul id="uloption">
						<li>
						
						<p style="text-align:center;" class="smooth-scroll"><a class="btn btn-info btn-box btn-left-active btnshow" data-n="auto">Auto</a></p>
						</li>
						<li><p style="text-align:center;" class="smooth-scroll"><a   class="btn btn-info btn-box btn-left btnshow" data-n="guasti">Guasti</a></p></li>
						<li><p style="text-align:center;" class="smooth-scroll"><a   class="btn btn-info btn-box btn-left btnshow" data-n="appuntamenti">Appuntamenti</a></p></li>
						<li><p style="text-align:center;" class="smooth-scroll"><a   class="btn btn-info btn-box btn-left btnshow" data-n="preventivi">Preventivi</a></p></li>
						<li><p style="text-align:center;" class="smooth-scroll"><a   class="btn btn-info btn-box btn-left btnshow" data-n="scadenze">Scadenze</a></p></li>
						</ul>
												<!--end::Widget 14-->
											</div>
										</div>
									</div>
								</div>
								<!--end:: Widgets/New Users-->
							</div>
							<!--end:: section LEFT SIDEBAR-->
						<!--begin:: section RIGHT SIDEBAR-->
												<div class="col-xs-12 col-sm-12 col-md-9 col-lg-9" id="rightautotable">
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
									 <c:forEach items="${autoUtente}" var="auto">
<tr>
												<td>${auto.getAuto().getId()}</td>
									 <td>${auto.getAuto().getMarca()}</td>
									 <td>${auto.getAuto().getModello()}</td>
									 <td>${auto.getAuto().getTarga()}</td>
									 <td>${auto.getAuto().getNumeroTelaio()}</td>
									 <td><ul class="fa-ul">
  <li class="fa-li"><a class="ali richiedipreventivo" data-marca="${auto.getAuto().getMarca()}"  data-modello="${auto.getAuto().getTarga()}" data-id="${auto.getAuto().getId()}" target="_blank"><i class="fa fa-file-o"  title="Richiedi Preventivo per questa auto"></i></a></li>

</ul></td>
									 </tr>
									 </c:forEach>
								
									</tbody>
									</table>
									</div>
										<!--end: Datatable -->
									</div>
								</div>
							</div>
							<div class="col-xs-12 col-sm-12 col-md-9 col-lg-9" id="rightguastitable">
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
									<button class="btn btn-info showguasti" type="button" data-g="0">Visualizza Non Risolti</button>
									<button class="btn btn-info showguasti" type="button" data-g="1">Visualizza Risolti</button>
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
									
									 <c:forEach items="${AlertsGuasti}" var="guasto">
<tr 
<c:choose>
 <c:when test = "${fn:contains(guasto.getStatoRisoluzione(), 'Non Risolto')}">
        class=guastononrisolto 
      </c:when>
	  
		   <c:otherwise>
             class=guastorisolto 
         </c:otherwise>
      </c:choose>
	  >						<td>${guasto.getTipologiaGuasto().getCodice()}</td>
									 <td>${guasto.getData()}</td>
									 <td>${guasto.getDispositivo().getAuto().getMarca()}</td>
									 <td>${guasto.getDispositivo().getAuto().getModello()}</td>
									 <td>${guasto.getDispositivo().getAuto().getTarga()}</td>
									 <td>${guasto.getDispositivo().getAuto().getNumeroTelaio()}</td>
									 <td><ul class="fa-ul">
  <li class="fa-li"><a class="ali showtelemetria" data-telemetria="${guasto.getTelemetria().getDati()}" data-marca="${guasto.getDispositivo().getAuto().getMarca()}" data-modello="${guasto.getDispositivo().getAuto().getModello()}"><i class="fa fa-info-circle"  title="Visualizza dati telemetria"></i></a></li>
  <c:choose>
  <c:when test = "${fn:contains(guasto.getStatoRisoluzione(), 'Non Risolto')}">
        <li class="fa-li"><a class="ali" ><i class="fa fa-exclamation-triangle"  title="Guasto Risolto"></i></a></li>
      </c:when>
	  
	   <c:otherwise>
            <li class="fa-li"><a class="ali" ><i class="fa fa-check"  title="Guasto da risolvere"></i></a></li>
         </c:otherwise>
      </c:choose>

</ul></td>
									 </tr>
									 </c:forEach>
									 
									 
								
									</tbody>
									</table>
									</div>
										<!--end: Datatable -->
									</div>
								</div>
							</div>
							
								<div class="col-xs-12 col-sm-12 col-md-9 col-lg-9" id="rightappuntamentitable">
								<div class="m-portlet m-portlet--mobile ">
									<div class="m-portlet__head">
										<div class="m-portlet__head-caption">
											<div class="m-portlet__head-title">
												<h3 class="m-portlet__head-text">
												<i class="fa fa-calendar fah3"  ></i>
													Appuntamenti
												</h3>
											</div>
										</div>
									<button class="btn btn-info btn-add" type="button" data-toggle="modal" data-target="#modalappuntamenti">Richiedi</button>
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
								
									</tbody>
									</table>
									</div>
										<!--end: Datatable -->
									</div>
								</div>
							</div>
							
							
							<div class="col-xs-12 col-sm-12 col-md-9 col-lg-9" id="rightpreventivitable">
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
									<th>Auto</th>
									<th>Data</th>
									<th>Dettagli</th>
									<th></th>
									</tr>
									</thead>
									<tbody>
								 <c:forEach items="${preventivi}" var="prev">
<tr  >			
			<td>${prev.getId()}</td>
			<td>${prev.getAuto().getMarca()} ${prev.getAuto().getModello()}</td>
			<td>${prev.getData()}</td>
									 <td>${prev.getDettagli()}</td>
									 <td></td>
									 </tr>
									 </c:forEach>
									</tbody>
									</table>
									</div>
										<!--end: Datatable -->
									</div>
								</div>
							</div>
							
							
							<div class="col-xs-12 col-sm-12 col-md-9 col-lg-9" id="rightscadenzetable">
								<div class="m-portlet m-portlet--mobile ">
									<div class="m-portlet__head">
										<div class="m-portlet__head-caption">
											<div class="m-portlet__head-title">
												<h3 class="m-portlet__head-text">
												<i class="fa fa-info-circle fah3"  ></i>
													Scadenze
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
							
									</tbody>
									</table>
									</div>
										<!--end: Datatable -->
									</div>
								</div>
							</div>
						<!--end:: section RIGHT SIDEBAR-->
						
						</div>
						<!--end:: seciont content-->
						
 
						
  
					  
					</div>
				</div>
				<!--
			</div>
			-->
		</div>
		<!-- end::Body -->
<jsp:include page="footer.jsp" />
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
								class="form-control" id="idutente" value="${utente.getId()}"
								name="idutente">
							<input type="hidden"
								class="form-control" id="idazienda" value="${utente.getId()}"
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
</div>
<!-- end::modal richiedi preventivo-->
<!-- begin::modal richiedi appuntamento -->
<div class="modal" tabindex="-1" role="dialog" id="modalappuntamenti">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Richiedi appuntamento</h5>
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
								class="form-control" id="idutente" value="${utente.getId()}"
								name="idutente">
							<input type="hidden"
								class="form-control" id="idazienda" value="${utente.getId()}"
								name="idazienda">
						<input type="hidden"
								class="form-control" id="idauto" 
								name="idauto">
								
  

      </div>
      <div class="modal-footer " style="text-align:center;" >
       <button type="submit" class="btn btn-primary savebutton btnfooter">Invia Richiesta</button>
	     
</form>
      </div>
    </div>
  </div>
</div>
</div>
<!-- end::modal richiedi preventivo-->
<!-- begin::modal Dati Telemetria Guasto-->
<div class="modal" tabindex="-1" role="dialog" id="modaldatitelemetria">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Dati Telemetria </h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
   <div class="m-widget24">
											<div class="m-widget24__item">
											
												<h4 class="m-widget24__title" >
												Auto: <span id="autotelemetria"></span>
												</h4>
												<br>
												
											
												<div class="m--space-10"></div>
												<p  id="datitel"></p>
											</div>
										</div>
      </div>
      <div class="modal-footer " style="text-align:center;" >
       <button type="submit" class="btn btn-primary btnfooter" data-dismiss="modal" aria-label="close">Chiudi</button>
	     

      </div>
    </div>
  </div>
</div>

<!-- end::modal Dati Telemetria Guasto-->
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
	$('.btnshow').on('click',function(){
		var tipo = $(this).data("n");
		$( ".btnshow" ).each(function( index ) {
			$(this).removeClass("btn-left-active");
			$(this).addClass("btn-left");
		});
		$(this).addClass("btn-left-active");
		if(tipo=='auto'){
			$('#rightguastitable').hide();
			$('#rightpreventivitable').hide();
			$('#rightappuntamentitable').hide();
			$('#rightscadenzetable').hide();
			$('#rightautotable').show(1000);
		}else 	if(tipo=='guasti'){
			$('#rightautotable').hide();
			$('#rightpreventivitable').hide();
			$('#rightappuntamentitable').hide();
			$('#rightscadenzetable').hide();
			$('#rightguastitable').show(1000);
		}else 	if(tipo=='appuntamenti'){
			$('#rightguastitable').hide();
			$('#rightpreventivitable').hide();
			$('#rightautotable').hide();
			$('#rightscadenzetable').hide();
			$('#rightappuntamentitable').show(1000);
		}else 	if(tipo=='preventivi'){
			$('#rightguastitable').hide();
			$('#rightautotable').hide();
			$('#rightappuntamentitable').hide();
			$('#rightscadenzetable').hide();
			$('#rightpreventivitable').show(1000);
		}else 	if(tipo=='scadenze'){
			$('#rightguastitable').hide();
			$('#rightautotable').hide();
			$('#rightappuntamentitable').hide();
			$('#rightpreventivitable').hide();
			$('#rightscadenzetable').show(1000);
		}
		
		
	});
	
	$('.showtelemetria').on('click',function(){
		$('#datitel').html($(this).data("telemetria"));
		$('#autotelemetria').html($(this).data("marca") + " "+$(this).data("modello"));
		$('#modaldatitelemetria').modal("show");
	});
	
	$('.showguasti').on('click',function(){
		var g = $(this).data("g");
		if(g==0){
			$('.guastorisolto').hide();
			$('.guastononrisolto').show();
		}else if(g==1){
			$('.guastononrisolto').hide();
			$('.guastorisolto').show();
			
		}
	});
	</script>

</body>
<!-- end::Body -->
</html>
