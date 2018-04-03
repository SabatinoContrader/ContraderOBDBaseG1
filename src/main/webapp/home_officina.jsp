<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>

 
<!DOCTYPE html>
<html lang="en" >
	<!-- begin::Head -->
	<head>
		<meta charset="utf-8" />
		<title>
		
		
			Home Officina
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
		#uloption{list-style: none;padding-left:0px;}.btn-left{background-color:#4c4e50 !important;}.btn-left-active{background-color:#ea202e !important}.showguasti,.btn-add:hover{color: #474343 !important;background-color: #f4f5f8 !important;}.showguasti,.btn-add{margin-top: 10px;color: #474343 !important;float:right;background-color: #f4f5f8;margin-right: 20px;border: none;padding: 12px;} #datitel{padding-top: 20px;border: 1px solid black;min-height: 200px;padding-left: 10px;}.btnfooter{    margin-left: auto;    margin-right: auto;}.fa-ul > li{display:inline !important;}
		#rightscadenzetable,#rightappuntamentitable,#rightguastitable,#rightpreventivitable,#rightutentitable{display:none;}.m-body{margin-top:-100px;}</style>
	</head>
	<!-- end::Head -->
    <!-- end::Body -->
	<body class="m-page--wide m-header--fixed m-header--fixed-mobile m-footer--push m-aside--offcanvas-default"  >
	<c:if test ="${sessionScope.sessionModel==null}" >
		<c:redirect url="/"/>
		 </c:if>
	<c:if test ="${sessionScope.sessionModel!=null}" >
		
		<c:choose>
 <c:when test = "${sessionScope.sessionModel.utente.getRuolo()==0}">
       <c:redirect url="/utente_home.jsp"/>
      </c:when>
	   
		   <c:otherwise>
              
         </c:otherwise>
      </c:choose>
		
		
		 </c:if>

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
													${sessionScope.sessionModel.guasti}
												</span>
												<div class="m--space-10"></div>
											<p style="text-align:center;" class="smooth-scroll"><a   style="background-color:#716aca !important" class="btn btn-info btn-box visualizzaguasti">Visualizza</a></p>
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
												
													${sessionScope.sessionModel.autoScadenze.size() + sessionScope.sessionModel.kmScadenza.size()} 
												</span>
												<div class="m--space-10"></div>
												<p style="text-align:center;" class="smooth-scroll"><a   style="background-color:#36a3f7   !important" class="btn btn-info btn-box visualizzascadenze">Visualizza</a></p>
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
												${sessionScope.preventivi.size()}
												</span>
												<div class="m--space-10"></div>
												<p style="text-align:center;" class="smooth-scroll"><a  style="background-color:#f4516c  !important" class="btn btn-info btn-box visualizzapreventivi">Visualizza</a></p>
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
													${sessionScope.appuntamenti.size()}
												</span>
												<div class="m--space-10"></div>
												<p style="text-align:center;" class="smooth-scroll"><a  style="background-color:#34bfa3    !important" class="btn btn-info btn-box visualizzaappuntamenti">Visualizza</a></p>
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
						<li>
						
						<p style="text-align:center;" class="smooth-scroll"><a class="btn btn-info btn-box btn-left btnshow" data-n="utenti">Utenti</a></p>
						</li>
						<li><p style="text-align:center;" class="smooth-scroll"><a   id="buttonguasti" class="btn btn-info btn-box btn-left btnshow" data-n="guasti">Guasti</a></p></li>
						<li><p style="text-align:center;" class="smooth-scroll"><a   id="buttonappuntamenti" class="btn btn-info btn-box btn-left btnshow" data-n="appuntamenti">Appuntamenti</a></p></li>
						<li><p style="text-align:center;" class="smooth-scroll"><a   id="buttonpreventivi" class="btn btn-info btn-box btn-left btnshow" data-n="preventivi">Preventivi</a></p></li>
						<li><p style="text-align:center;" class="smooth-scroll"><a   id="buttonscadenze" class="btn btn-info btn-box btn-left btnshow" data-n="scadenze">Scadenze</a></p></li>
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
													AUTO 
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
									 <c:forEach items="${sessionScope.sessionModel.autoOfficina}" var="auto">
<tr>
												<td>${auto.getId()}</td>
									 <td>${auto.getMarca()}</td>
									 <td>${auto.getModello()}</td>
									 <td>${auto.getTarga()}</td>
									 <td>${auto.getNumeroTelaio()}</td>
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
							
							
							<div class="col-xs-12 col-sm-12 col-md-9 col-lg-9" id="rightutentitable">
								<div class="m-portlet m-portlet--mobile ">
									<div class="m-portlet__head">
										<div class="m-portlet__head-caption">
											<div class="m-portlet__head-title">
												<h3 class="m-portlet__head-text">
												<i class="fa fa-person fah3"  ></i>
													Clienti
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
									<th>Nome</th>
									<th>Cognome</th>
									<th>Email</th>
									<th>Telefono</th>
									<th>Data Registrazione</th>
									<th></th>
									</tr>
									</thead>
									<tbody>
								 <c:forEach items="${listaUtenti}" var="utenti">
								 <c:if test="${utenti.getRuolo()==0}" >
<tr  >			
			<td>${utenti.getId()}</td>
			<td>${utenti.getNome()}</td>
		<td>${utenti.getCognome()}</td>
		<td>${utenti.getEmail()}</td>
		<td>${utenti.getTelefono()}</td>
			<td>${utenti.getDataRegistrazione()}</td>
									
									 <td>
									 <ul class="fa-ul">
  <li class="fa-li"><a class="ali" href="listaautoutente?id=${utenti.getId()}" ><i class="fa fa-info-circle"  title="Visualizza auto cliente"></i></a></li>
  <li class="fa-li"><a class="ali associaauto" data.id="=${utenti.getId()}" ><i class="fa fa-car"  title="Associa auto a cliente"></i></a></li>


</ul></td>
									 </tr>
									 </c:if>
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
									
									 <c:forEach items="${sessionScope.sessionModel.AlertsGuastiOfficina}" var="guasto">
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
        <li class="fa-li"><a class="ali setrisolto" data-id="${guasto.getId()}" ><i class="fa fa-exclamation-triangle"  title="Guasto da risolvere"></i></a></li>
      </c:when>
	  
	   <c:otherwise>
            <li class="fa-li"><a class="ali" ><i class="fa fa-check"  title="Guasto Risolto"></i></a></li>
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
									<th>Dettagli</th>
									<th>Stato</th>
									<th>Risposta</th>
									<th></th>
									</tr>
									</thead>
									<tbody>
										 <c:forEach items="${sessionScope.appuntamenti}" var="app">
<tr  >			
<td>${app.getId()}</td>
			<td>${app.getData()}  ${app.getOra()}</td>
			<td>${app.getDettagli()}</td>
			
			 <td>
			
					<c:choose>
 <c:when test = "${app.getStato()==0}">
    In Attesa 
      </c:when>
	   <c:when test = "${app.getStato()==1}">
     Confermato
      </c:when>
		   <c:otherwise>
    Non confermato
         </c:otherwise>
      </c:choose>
		</td>
			<td>${app.getRisposta()}</td>
									<td><ul class="fa-ul">
  <li class="fa-li"><a class="ali rispondiappuntamento" data-id="${app.getId()}"><i class="fa fa-file-o"  title="Rispondi alla richiesta di appuntamento"></i></a></li>
  
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
									<th>Targa</th>
									<th>Data</th>
									<th>Dettagli</th>
									<th>Risposta</th>
									<th>Costo</th>
									<th></th>
									</tr>
									</thead>
									<tbody>
								 <c:forEach items="${sessionScope.preventivi}" var="prev">
<tr  >			
			<td>${prev.getId()}</td>
			<td>${prev.getAuto().getMarca()} ${prev.getAuto().getModello()}</td>
		<td>${prev.getAuto().getTarga()}</td>
			<td>${prev.getData()}</td>
									 <td>${prev.getDettagli()}</td>
									  <td>${prev.getRisposta()}</td> 
									  <td>${prev.getCosto()}&euro;</td>
									 <td><ul class="fa-ul">
  <li class="fa-li"><a class="ali rispondipreventivo"  data-marca="${prev.getAuto().getMarca()}"  data-modello="${prev.getAuto().getTarga()}" data-id="${prev.getId()}" target="_blank"><i class="fa fa-file-o"  title="Rispondi alla richiesta di preventivo"></i></a></li>

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
									<th>Auto</th>
									<th>Scadenze</th>
									<th></th>
									</tr>
									</thead>
									<tbody>
									 <c:forEach items="${sessionScope.sessionModel.autoScadenze}" var="scadenze">
<tr  >			
			<td>${scadenze.getAuto().getMarca()} ${scadenze.getAuto().getModello()}</td>
			<td>
			<c:forEach items="${scadenze.cosaStaPerScadere()}" var="tiposcad">
			${tiposcad}<br>
			 </c:forEach>
		</td>

									 <td></td>
									 </tr>
									 </c:forEach>
							 <c:forEach items="${sessionScope.sessionModel.kmScadenza}" var="kmscad">
<tr  >			
			<td>${kmscad.getAuto().getMarca()} ${kmscad.getAuto().getModello()}</td>
			<td>Km Noleggio
			
			
		</td>

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
<div class="modal" tabindex="-1" role="dialog" id="modalrispondipreventivo">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Rispondi al preventivo per <span id="autorichiesta"></span></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <form action="/rispondipreventivo" method="POST">
<div class="form-group">

  <label for="costoprev">Costo:</label>
  <input class="form-control"  id="costoprev" name="costoprev" type="number" required>
</div>
						
						<div class="form-group">
  <label for="dettagli">Risposta:</label>
  <textarea class="form-control" rows="5" id="dettagli" name="dettagli" required></textarea>
</div>
						
							<input type="hidden"
								class="form-control" id="email" value="${sessionScope.sessionModel.utente.getEmail()}"
								name="email">
							
						<input type="hidden"
								class="form-control" id="idprev" 
								name="idprev">
								
  

      </div>
      <div class="modal-footer " style="text-align:center;" >
       <button type="submit" class="btn btn-primary savebutton">Invia Preventivo</button>
	     
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
        <h5 class="modal-title">Rispondi appuntamento</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <form action="rispondiappuntamento" method="POST">
	
						<div class="form-group">
  <label for="stato">Rispondi:</label>
  <select name="selectapp" id="selectapp" required class="form-control">
  <option value="1" selected>Accetta appuntamento</option>
  <option value="2">Rifiuta appuntamento</option>
  </select>
  
</div>

						<div class="form-group">
  <label for="dettagliapp">Informazioni aggiuntive:</label>
  <textarea class="form-control" rows="5" id="dettagliapp" name="dettagliapp"></textarea>
</div>
						
							<input type="hidden"
								class="form-control" id="emailapp" value="${sessionScope.sessionModel.utente.getEmail()}"
								name="emailapp">
							
						<input type="hidden"
								class="form-control" id="idapp" 
								name="idapp">
								
  

      </div>
      <div class="modal-footer " style="text-align:center;" >
       <button type="submit" class="btn btn-primary savebutton btnfooter">Invia Risposta</button>
	     
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
<!-- begin::modal SET RISOLTO GUASTO-->
<div class="modal" tabindex="-1" role="dialog" id="modalsetrisoltoguasto">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Risolvi guasto? </h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
  <form action="setrisoltoguasto" method="POST">

			
						
							
						<input type="hidden"
								class="form-control" id="idguasto" 
								name="idguasto">
								
  

      </div>
      <div class="modal-footer " style="text-align:center;" >
      <button type="submit" class="btn btn-primary savebutton btnfooter">Conferma</button>
	     <button type="button" data-dismiss="modal" class="btn btn-primary savebutton btnfooter">Annulla</button>
</form>
      </div>
    </div>
  </div>
</div>

<!-- end::modal SET RISOLTO GUASTO-->
<!-- begin::modal SET RISOLTO GUASTO-->
<div class="modal" tabindex="-1" role="dialog" id="modalassocia">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Noleggio</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
  <form action="associaauto" method="POST">
	<div class="form-group">
  <label for="selauto">Seleziona Auto:</label>
  <select name="selauto" id="selauto" required class="form-control">
   <c:forEach items="${sessionScope.sessionModel.autoOfficina}" var="auto">
   <option value="${auto.getId()}" selected>${auto.getMarca()} ${auto.getModello()} - ${auto.getTarga()}</option>
   
									 </c:forEach>
  
  </select>
  
</div>
		
						
							
						<input type="hidden"
								class="form-control" id="idguasto" 
								name="idguasto">
								
  

      </div>
      <div class="modal-footer " style="text-align:center;" >
      <button type="submit" class="btn btn-primary savebutton btnfooter">Conferma</button>
	     <button type="button" data-dismiss="modal" class="btn btn-primary savebutton btnfooter">Annulla</button>
</form>
      </div>
    </div>
  </div>
</div>

<!-- end::modal SET RISOLTO GUASTO-->
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
	$('.setrisolto').on('click',function(){
		var id = $(this).data("id");
		$('#idguasto').val(id);
		$('#modalsetrisoltoguasto').modal("show");
	});
	
	$('.rispondipreventivo').on('click',function(){
	var marca = $(this).data("marca");
	var modello = $(this).data("modello");
	var id=$(this).data("id");
	
	$('#autorichiesta').html(marca+ " " +modello);
	$('#idprev').val(id);

	$('#modalrispondipreventivo').modal("show");
		
		
		
	});
	$('.rispondiappuntamento').on('click',function(){
	var id=$(this).data("id");
	$('#idapp').val(id);
	$('#modalappuntamenti').modal("show");
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
			$('#rightutentitable').hide();
			$('#rightautotable').show(1000);
		}else if(tipo=='utenti'){
			$('#rightguastitable').hide();
			$('#rightpreventivitable').hide();
			$('#rightappuntamentitable').hide();
			$('#rightscadenzetable').hide();
			$('#rightautotable').hide();
			$('#rightutentitable').show(1000);
		}else 	if(tipo=='guasti'){
			$('#rightautotable').hide();
			$('#rightpreventivitable').hide();
			$('#rightappuntamentitable').hide();
			$('#rightscadenzetable').hide();
			$('#rightutentitable').hide();
			$('#rightguastitable').show(1000);
		}else 	if(tipo=='appuntamenti'){
			$('#rightguastitable').hide();
			$('#rightpreventivitable').hide();
			$('#rightautotable').hide();
			$('#rightscadenzetable').hide();
			$('#rightutentitable').hide();
			$('#rightappuntamentitable').show(1000);
		}else 	if(tipo=='preventivi'){
			$('#rightguastitable').hide();
			$('#rightautotable').hide();
			$('#rightappuntamentitable').hide();
			$('#rightscadenzetable').hide();
			$('#rightutentitable').hide();
			$('#rightpreventivitable').show(1000);
		}else 	if(tipo=='scadenze'){
			$('#rightguastitable').hide();
			$('#rightautotable').hide();
			$('#rightappuntamentitable').hide();
			$('#rightpreventivitable').hide();
			$('#rightutentitable').hide();
			$('#rightscadenzetable').show(1000);
		}
		
		
	});
	$('.visualizzaguasti').on('click',function(){
		$( ".btnshow" ).each(function( index ) {
			$(this).removeClass("btn-left-active");
			$(this).addClass("btn-left");
		});
		$('#buttonguasti').addClass("btn-left-active");
	$('#rightautotable').hide();
			$('#rightpreventivitable').hide();
			$('#rightappuntamentitable').hide();
			$('#rightscadenzetable').hide();
			$('#rightutentitable').hide();
			$('#rightguastitable').show(1000);
			
	});
	
	$('.visualizzascadenze').on('click',function(){
		$( ".btnshow" ).each(function( index ) {
			$(this).removeClass("btn-left-active");
			$(this).addClass("btn-left");
		});
		$('#buttonscadenze').addClass("btn-left-active");
	$('#rightguastitable').hide();
			$('#rightautotable').hide();
			$('#rightappuntamentitable').hide();
			$('#rightpreventivitable').hide();
			$('#rightutentitable').hide();
			$('#rightscadenzetable').show(1000);
			
	});
	
	$('.visualizzapreventivi').on('click',function(){
		$( ".btnshow" ).each(function( index ) {
			$(this).removeClass("btn-left-active");
			$(this).addClass("btn-left");
		});
		$('#buttonpreventivi').addClass("btn-left-active");
		$('#rightguastitable').hide();
			$('#rightautotable').hide();
			$('#rightappuntamentitable').hide();
			$('#rightscadenzetable').hide();
			$('#rightutentitable').hide();
			$('#rightpreventivitable').show(1000);
			
	});
	
	$('.visualizzaappuntamenti').on('click',function(){
		$( ".btnshow" ).each(function( index ) {
			$(this).removeClass("btn-left-active");
			$(this).addClass("btn-left");
		});
		$('#buttonappuntamenti').addClass("btn-left-active");
			$('#rightguastitable').hide();
			$('#rightpreventivitable').hide();
			$('#rightautotable').hide();
			$('#rightscadenzetable').hide();
			$('#rightutentitable').hide();
			$('#rightappuntamentitable').show(1000);
			
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
	
	$('.associaauto').on('click',function(){
		var id = $(this).data("id");
		$('#idasscliente').val(id);
		
		$('#modalassocia').modal("show");
		
	});
	</script>

</body>
<!-- end::Body -->
</html>
