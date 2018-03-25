<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<%@ page import="com.project.model.*"%>
		<%@ page import="utility.*"%>
		<%@ page import="java.util.ArrayList"%>
		<%@ page import="java.util.List"%>
		<%@ page import="com.project.dao.*"%>
		<%@ page import="com.project.automotive.dto.*"%>
		<%@ page import="com.project.dao.AlertsDAO"%>
		<%@ page import="com.project.dao.CarDAO"%>
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
 int idcar = Integer.parseInt(request.getParameter("idauto"));
Utente cliente = CarDAO.getUtenteFromAuto(idcar);
Azienda a = DaoUtility.getDatiAzienda(u);


if(cliente==null)System.out.println("E' NULLooooooo");

%>
<html lang="en" >
	<!-- begin::Head -->
	<head>
		<meta charset="utf-8" />
		<title>
			<%=a.getDenominazione()%> - Dettagli 
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
									Lista Auto <%=cliente.getNome()%> <%=cliente.getCognome()%>
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
												<i class="fa fa-car fah3"  ></i>	Auto <%=cliente.getNome()%> <%=cliente.getCognome()%>
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
									<th>Nome</th>
									<th>Cognome</th>
									<th>Email</th>
									<th>Telefono</th>
									<th>DataRegistrazione</th>
									<th></th>
									</tr>
									</thead>
									<tbody>






												
												<tr>
													<td><%=cliente.getID()%></td>
													<td><%=cliente.getNome()%></td>
													<td><%=cliente.getCognome()%></td>
													<td><%=cliente.getEmail()%></td>
													<td><%=cliente.getTelefono()%></td>
													<td><%=cliente.getDataRegistrazione()%></td>



												<td><ul class="fa-ul">
												<li class="fa-li"><i class="fa fa-calendar"  title="Visualizza scadenze auto"></i></li>
												  <li class="fa-li"><i class="fa fa-pencil" title="Modifica auto"></i></li>
												  <li class="fa-li"><i class="fa fa-remove"  title="Rimuovi auto"></i></li>
												</ul></td>
												</tr>
											


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
      <form action="" method="POST">
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
