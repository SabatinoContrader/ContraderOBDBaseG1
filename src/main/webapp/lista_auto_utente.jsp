<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>

 
<!DOCTYPE html>
<html lang="en" >
	<!-- begin::Head -->
	<head>
		<meta charset="utf-8" />
		<title>
		
		
			Lista Auto Cliente
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
		#rightscadenzetable,#rightappuntamentitable,#rightguastitable,#rightpreventivitable,#rightutentitable{display:none;}.m-body{margin-top:-30px;}.fa-ul>li>a>i{    padding-left: 15px;}</style>
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
						

						<!--begin:: section content-->
						<div class="row">
						
						
						<!--begin:: section RIGHT SIDEBAR-->
												<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" id="rightautotable">
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
									 <c:forEach items="${listaNoleggio}" var="auto">
<tr>
												<td>${auto.getAuto().getId()}</td>
									 <td>${auto.getAuto().getMarca()}</td>
									 <td>${auto.getAuto().getModello()}</td>
									 <td>${auto.getAuto().getTarga()}</td>
									 <td>${auto.getAuto().getNumeroTelaio()}</td>
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

	</script>

</body>
<!-- end::Body -->
</html>
