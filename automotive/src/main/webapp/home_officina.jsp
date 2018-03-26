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
		<title>
			Officina
		</title>
		<meta name="description" content="Latest updates and statistic charts">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<!--begin::Web font -->
		<script src="https://ajax.googleapis.com/ajax/libs/webfont/1.6.16/webfont.js"></script>
		<script>
			WebFont.load({
				google: { "families": ["Poppins:300,400,500,600,700", "Roboto:300,400,500,600,700"] },
				active: function () {
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
		<style>
			.ali {
				color: #575962 !important;
			}

			.fah3 {
				font-size: 24px;
				padding-right: 10px;
			}

			.transparentli {
				color: transparent;
			}

			.fa {
				cursor: pointer;
			}

			.fa-ul li {
				display: inline;
				margin-left: 10px;
			}

			.btn-add:hover {
				color: #474343 !important;
				background-color: #f4f5f8 !important;
			}

			.btn-add {
				margin-top: 10px;
				color: #474343 !important;
				float: right;
				background-color: #f4f5f8;
				margin-right: 20px;
				border: none;
				padding: 12px;
			}

			.savebutton {
				margin-left: auto;
				margin-right: auto;
			}

			.btn-box {
				border: none;
				margin-top: 20px;
				width: 200px;
				color: white !important;
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
		</style>
	</head>
	<!-- end::Head -->
	<!-- end::Body -->

	<body class="m-page--wide m-header--fixed m-header--fixed-mobile m-footer--push m-aside--offcanvas-default">

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
return;

}
String name = u.getNome();
if(u.getRuolo()==1){
Azienda a = DaoUtility.getDatiAzienda(u);


List<Utente> listaUtentiPrivati = DaoUtility.getListaClientiAzienda(a.id);

List<Azienda> listaClientiBusiness = DaoUtility.getListaClientiBusiness(a.id);

List<Auto> listaAutoOfficina = CarDAO.getListAutoAzienda(a.id);

AlertsDAO adao = new AlertsDAO();
ArrayList<GuastoDTO> guasti = adao.getAlertsGuastiGarageAdmin(u);

%>

										<!-- begin:: Page -->
										<div class="m-grid m-grid--hor m-grid--root m-page">
											<!-- begin::Header -->
											<header class="m-grid__item		m-header " data-minimize="minimize" data-minimize-offset="200" data-minimize-mobile-offset="200">
												<div class="m-header__top">
													<div class="m-container m-container--responsive m-container--xxl m-container--full-height m-page__container">
														<div class="m-stack m-stack--ver m-stack--desktop">
															<!-- begin::Brand -->
															<div class="m-stack__item m-brand">
																<div class="m-stack m-stack--ver m-stack--general m-stack--inline">
																	<div class="m-stack__item m-stack__item--middle m-brand__logo">
																		<a href="index.jsp" class="m-brand__logo-wrapper">
																			<img alt="" src="images/logo-contrader.png" / class="logo">
																		</a>
																	</div>
																	<div class="m-stack__item m-stack__item--middle m-brand__tools">

																		<!-- begin::Responsive Header Menu Toggler-->
																		<a id="m_aside_header_menu_mobile_toggle" href="javascript:;" class="m-brand__icon m-brand__toggler m--visible-tablet-and-mobile-inline-block">
																			<span></span>
																		</a>
																		<!-- end::Responsive Header Menu Toggler-->
																		<!-- begin::Topbar Toggler-->
																		<a id="m_aside_header_topbar_mobile_toggle" href="javascript:;" class="m-brand__icon m--visible-tablet-and-mobile-inline-block">
																			<i class="flaticon-more"></i>
																		</a>
																		<!--end::Topbar Toggler-->
																	</div>
																</div>
															</div>
															<!-- end::Brand -->
															<!-- begin::Topbar -->
															<div class="m-stack__item m-stack__item--fluid m-header-head" id="m_header_nav">
																<div id="m_header_topbar" class="m-topbar  m-stack m-stack--ver m-stack--general">
																	<div class="m-stack__item m-topbar__nav-wrapper">
																		<ul class="m-topbar__nav m-nav m-nav--inline">
																			<li class="m-nav__item m-topbar__user-profile m-topbar__user-profile--img  m-dropdown m-dropdown--medium m-dropdown--arrow m-dropdown--header-bg-fill m-dropdown--align-right m-dropdown--mobile-full-width m-dropdown--skin-light"
																			 data-dropdown-toggle="click">
																				<a href="#" class="m-nav__link m-dropdown__toggle">
																					<span class="m-topbar__userpic m--hide">
																						<img src="assets/app/media/img/users/user4.jpg" class="m--img-rounded m--marginless m--img-centered" alt="" />
																					</span>
																					<span class="m-topbar__welcome">
																						Benvenuto,&nbsp;
																					</span>
																					<span class="m-topbar__username">
																						<%=name%>
																					</span>
																				</a>
																				<div class="m-dropdown__wrapper">
																					<span class="m-dropdown__arrow m-dropdown__arrow--right m-dropdown__arrow--adjust"></span>
																					<div class="m-dropdown__inner">
																						<div class="m-dropdown__header m--align-center" style="background: url(assets/app/media/img/misc/user_profile_bg.jpg); background-size: cover;">
																							<div class="m-card-user m-card-user--skin-dark">
																								<div class="m-card-user__details">
																									<span class="m-card-user__name m--font-weight-500">
																										<%=name+" "+u.getCognome()%>
																									</span>
																									<a href="" class="m-card-user__email m--font-weight-300 m-link">
																										<%=u.getEmail()%>
																									</a>
																								</div>
																							</div>
																						</div>
																						<div class="m-dropdown__body">
																							<div class="m-dropdown__content">
																								<ul class="m-nav m-nav--skin-light">
																									<li class="m-nav__section m--hide">
																										<span class="m-nav__section-text">
																											Section
																										</span>
																									</li>
																									<li class="m-nav__item">
																										<a href="profile.html" class="m-nav__link">
																											<i class="m-nav__link-icon flaticon-profile-1"></i>
																											<span class="m-nav__link-title">
																												<span class="m-nav__link-wrap">
																													<span class="m-nav__link-text">
																														My Profile
																													</span>
																													<span class="m-nav__link-badge">
																														<span class="m-badge m-badge--success">
																															2
																														</span>
																													</span>
																												</span>
																											</span>
																										</a>
																									</li>
																									<li class="m-nav__item">
																										<a href="profile.html" class="m-nav__link">
																											<i class="m-nav__link-icon flaticon-share"></i>
																											<span class="m-nav__link-text">
																												Activity
																											</span>
																										</a>
																									</li>
																									<li class="m-nav__item">
																										<a href="profile.html" class="m-nav__link">
																											<i class="m-nav__link-icon flaticon-chat-1"></i>
																											<span class="m-nav__link-text">
																												Messages
																											</span>
																										</a>
																									</li>
																									<li class="m-nav__separator m-nav__separator--fit"></li>
																									<li class="m-nav__item">
																										<a href="profile.html" class="m-nav__link">
																											<i class="m-nav__link-icon flaticon-info"></i>
																											<span class="m-nav__link-text">
																												FAQ
																											</span>
																										</a>
																									</li>
																									<li class="m-nav__item">
																										<a href="profile.html" class="m-nav__link">
																											<i class="m-nav__link-icon flaticon-lifebuoy"></i>
																											<span class="m-nav__link-text">
																												Support
																											</span>
																										</a>
																									</li>
																									<li class="m-nav__separator m-nav__separator--fit"></li>
																									<li class="m-nav__item">
																										<form action="LogOutServlet" method="POST">
																											<button class="btn m-btn--pill btn-secondary m-btn m-btn--custom m-btn--label-brand m-btn--bolder">
																												Logout
																											</button>
																										</form>
																									</li>
																								</ul>
																							</div>
																						</div>
																					</div>
																				</div>
																			</li>
																			<li class="m-nav__item m-topbar__notifications m-topbar__notifications--img m-dropdown m-dropdown--large m-dropdown--header-bg-fill m-dropdown--arrow m-dropdown--align-center 	m-dropdown--mobile-full-width"
																			 data-dropdown-toggle="click" data-dropdown-persistent="true">
																				<a href="#" class="m-nav__link m-dropdown__toggle" id="m_topbar_notification_icon">
																					<span class="m-nav__link-badge m-badge m-badge--dot m-badge--dot-small m-badge--danger"></span>
																					<span class="m-nav__link-icon">
																						<span class="m-nav__link-icon-wrapper">
																							<i class="flaticon-music-2"></i>
																						</span>
																					</span>
																				</a>
																				<div class="m-dropdown__wrapper">
																					<span class="m-dropdown__arrow m-dropdown__arrow--center"></span>
																					<div class="m-dropdown__inner">
																						<div class="m-dropdown__header m--align-center" style="background: url(assets/app/media/img/misc/notification_bg.jpg); background-size: cover;">
																							<span class="m-dropdown__header-title">
																								9 New
																							</span>
																							<span class="m-dropdown__header-subtitle">
																								User Notifications
																							</span>
																						</div>
																						<div class="m-dropdown__body">
																							<div class="m-dropdown__content">
																								<ul class="nav nav-tabs m-tabs m-tabs-line m-tabs-line--brand" role="tablist">
																									<li class="nav-item m-tabs__item">
																										<a class="nav-link m-tabs__link active" data-toggle="tab" href="#topbar_notifications_notifications" role="tab">
																											Alerts
																										</a>
																									</li>
																									<li class="nav-item m-tabs__item">
																										<a class="nav-link m-tabs__link" data-toggle="tab" href="#topbar_notifications_events" role="tab">
																											Events
																										</a>
																									</li>
																									<li class="nav-item m-tabs__item">
																										<a class="nav-link m-tabs__link" data-toggle="tab" href="#topbar_notifications_logs" role="tab">
																											Logs
																										</a>
																									</li>
																								</ul>
																								<div class="tab-content">
																									<div class="tab-pane active" id="topbar_notifications_notifications" role="tabpanel">
																										<div class="m-scrollable" data-scrollable="true" data-max-height="250" data-mobile-max-height="200">
																											<div class="m-list-timeline m-list-timeline--skin-light">
																												<div class="m-list-timeline__items">
																													<div class="m-list-timeline__item">
																														<span class="m-list-timeline__badge -m-list-timeline__badge--state-success"></span>
																														<span class="m-list-timeline__text">
																															12 new users registered
																														</span>
																														<span class="m-list-timeline__time">
																															Just now
																														</span>
																													</div>
																													<div class="m-list-timeline__item">
																														<span class="m-list-timeline__badge"></span>
																														<span class="m-list-timeline__text">
																															System shutdown
																															<span class="m-badge m-badge--success m-badge--wide">
																																pending
																															</span>
																														</span>
																														<span class="m-list-timeline__time">
																															14 mins
																														</span>
																													</div>
																													<div class="m-list-timeline__item">
																														<span class="m-list-timeline__badge"></span>
																														<span class="m-list-timeline__text">
																															New invoice received
																														</span>
																														<span class="m-list-timeline__time">
																															20 mins
																														</span>
																													</div>
																													<div class="m-list-timeline__item">
																														<span class="m-list-timeline__badge"></span>
																														<span class="m-list-timeline__text">
																															DB overloaded 80%
																															<span class="m-badge m-badge--info m-badge--wide">
																																settled
																															</span>
																														</span>
																														<span class="m-list-timeline__time">
																															1 hr
																														</span>
																													</div>
																													<div class="m-list-timeline__item">
																														<span class="m-list-timeline__badge"></span>
																														<span class="m-list-timeline__text">
																															System error -
																															<a href="#" class="m-link">
																																Check
																															</a>
																														</span>
																														<span class="m-list-timeline__time">
																															2 hrs
																														</span>
																													</div>
																													<div class="m-list-timeline__item m-list-timeline__item--read">
																														<span class="m-list-timeline__badge"></span>
																														<span href="" class="m-list-timeline__text">
																															New order received
																															<span class="m-badge m-badge--danger m-badge--wide">
																																urgent
																															</span>
																														</span>
																														<span class="m-list-timeline__time">
																															7 hrs
																														</span>
																													</div>
																													<div class="m-list-timeline__item m-list-timeline__item--read">
																														<span class="m-list-timeline__badge"></span>
																														<span class="m-list-timeline__text">
																															Production server down
																														</span>
																														<span class="m-list-timeline__time">
																															3 hrs
																														</span>
																													</div>
																													<div class="m-list-timeline__item">
																														<span class="m-list-timeline__badge"></span>
																														<span class="m-list-timeline__text">
																															Production server up
																														</span>
																														<span class="m-list-timeline__time">
																															5 hrs
																														</span>
																													</div>
																												</div>
																											</div>
																										</div>
																									</div>
																									<div class="tab-pane" id="topbar_notifications_events" role="tabpanel">
																										<div class="m-scrollable" m-scrollabledata-scrollable="true" data-max-height="250" data-mobile-max-height="200">
																											<div class="m-list-timeline m-list-timeline--skin-light">
																												<div class="m-list-timeline__items">
																													<div class="m-list-timeline__item">
																														<span class="m-list-timeline__badge m-list-timeline__badge--state1-success"></span>
																														<a href="" class="m-list-timeline__text">
																															New order received
																														</a>
																														<span class="m-list-timeline__time">
																															Just now
																														</span>
																													</div>
																													<div class="m-list-timeline__item">
																														<span class="m-list-timeline__badge m-list-timeline__badge--state1-danger"></span>
																														<a href="" class="m-list-timeline__text">
																															New invoice received
																														</a>
																														<span class="m-list-timeline__time">
																															20 mins
																														</span>
																													</div>
																													<div class="m-list-timeline__item">
																														<span class="m-list-timeline__badge m-list-timeline__badge--state1-success"></span>
																														<a href="" class="m-list-timeline__text">
																															Production server up
																														</a>
																														<span class="m-list-timeline__time">
																															5 hrs
																														</span>
																													</div>
																													<div class="m-list-timeline__item">
																														<span class="m-list-timeline__badge m-list-timeline__badge--state1-info"></span>
																														<a href="" class="m-list-timeline__text">
																															New order received
																														</a>
																														<span class="m-list-timeline__time">
																															7 hrs
																														</span>
																													</div>
																													<div class="m-list-timeline__item">
																														<span class="m-list-timeline__badge m-list-timeline__badge--state1-info"></span>
																														<a href="" class="m-list-timeline__text">
																															System shutdown
																														</a>
																														<span class="m-list-timeline__time">
																															11 mins
																														</span>
																													</div>
																													<div class="m-list-timeline__item">
																														<span class="m-list-timeline__badge m-list-timeline__badge--state1-info"></span>
																														<a href="" class="m-list-timeline__text">
																															Production server down
																														</a>
																														<span class="m-list-timeline__time">
																															3 hrs
																														</span>
																													</div>
																												</div>
																											</div>
																										</div>
																									</div>
																									<div class="tab-pane" id="topbar_notifications_logs" role="tabpanel">
																										<div class="m-stack m-stack--ver m-stack--general" style="min-height: 180px;">
																											<div class="m-stack__item m-stack__item--center m-stack__item--middle">
																												<span class="">
																													All caught up!
																													<br> No new logs.
																												</span>
																											</div>
																										</div>
																									</div>
																								</div>
																							</div>
																						</div>
																					</div>
																				</div>
																			</li>
																			<li class="m-nav__item m-topbar__quick-actions m-topbar__quick-actions--img m-dropdown m-dropdown--large m-dropdown--header-bg-fill m-dropdown--arrow m-dropdown--align-right m-dropdown--align-push m-dropdown--mobile-full-width m-dropdown--skin-light"
																			 data-dropdown-toggle="click">
																				<a href="#" class="m-nav__link m-dropdown__toggle">
																					<span class="m-nav__link-badge m-badge m-badge--dot m-badge--info m--hide"></span>
																					<span class="m-nav__link-icon">
																						<span class="m-nav__link-icon-wrapper">
																							<i class="flaticon-share"></i>
																						</span>
																					</span>
																				</a>
																				<div class="m-dropdown__wrapper">
																					<span class="m-dropdown__arrow m-dropdown__arrow--right m-dropdown__arrow--adjust"></span>
																					<div class="m-dropdown__inner">
																						<div class="m-dropdown__header m--align-center" style="background: url(assets/app/media/img/misc/quick_actions_bg.jpg); background-size: cover;">
																							<span class="m-dropdown__header-title">
																								Quick Actions
																							</span>
																							<span class="m-dropdown__header-subtitle">
																								Shortcuts
																							</span>
																						</div>
																						<div class="m-dropdown__body m-dropdown__body--paddingless">
																							<div class="m-dropdown__content">
																								<div class="m-scrollable" data-scrollable="false" data-max-height="380" data-mobile-max-height="200">
																									<div class="m-nav-grid m-nav-grid--skin-light">
																										<div class="m-nav-grid__row">
																											<a href="#" class="m-nav-grid__item">
																												<i class="m-nav-grid__icon flaticon-file"></i>
																												<span class="m-nav-grid__text">
																													Generate Report
																												</span>
																											</a>
																											<a href="#" class="m-nav-grid__item">
																												<i class="m-nav-grid__icon flaticon-time"></i>
																												<span class="m-nav-grid__text">
																													Add New Event
																												</span>
																											</a>
																										</div>
																										<div class="m-nav-grid__row">
																											<a href="#" class="m-nav-grid__item">
																												<i class="m-nav-grid__icon flaticon-folder"></i>
																												<span class="m-nav-grid__text">
																													Create New Task
																												</span>
																											</a>
																											<a href="#" class="m-nav-grid__item">
																												<i class="m-nav-grid__icon flaticon-clipboard"></i>
																												<span class="m-nav-grid__text">
																													Completed Tasks
																												</span>
																											</a>
																										</div>
																									</div>
																								</div>
																							</div>
																						</div>
																					</div>
																				</div>
																			</li>

																		</ul>
																	</div>
																</div>
															</div>
															<!-- end::Topbar -->
														</div>
													</div>
												</div>
												<div class="m-header__bottom">
													<div class="m-container m-container--responsive m-container--xxl m-container--full-height m-page__container">
														<div class="m-stack m-stack--ver m-stack--desktop">
															<!-- begin::Horizontal Menu -->
															<div class="m-stack__item m-stack__item--middle m-stack__item--fluid">
																<button class="m-aside-header-menu-mobile-close  m-aside-header-menu-mobile-close--skin-light " id="m_aside_header_menu_mobile_close_btn">
																	<i class="la la-close"></i>
																</button>
																<div id="m_header_menu" class="m-header-menu m-aside-header-menu-mobile m-aside-header-menu-mobile--offcanvas  m-header-menu--skin-dark m-header-menu--submenu-skin-light m-aside-header-menu-mobile--skin-light m-aside-header-menu-mobile--submenu-skin-light ">
																	<ul class="m-menu__nav  m-menu__nav--submenu-arrow ">
																		<li class="m-menu__item  m-menu__item--active " aria-haspopup="true">
																			<a href="index.jsp" class="m-menu__link ">
																				<span class="m-menu__item-here"></span>
																				<span class="m-menu__link-text">
																					Dashboard
																				</span>
																			</a>
																		</li>
																		<li class="m-menu__item  m-menu__item--submenu m-menu__item--rel" data-menu-submenu-toggle="click" aria-haspopup="true">
																			<a href="#" class="m-menu__link m-menu__toggle">
																				<span class="m-menu__item-here"></span>
																				<span class="m-menu__link-text">
																					Actions
																				</span>
																				<i class="m-menu__hor-arrow la la-angle-down"></i>
																				<i class="m-menu__ver-arrow la la-angle-right"></i>
																			</a>
																			<div class="m-menu__submenu m-menu__submenu--classic m-menu__submenu--left">
																				<span class="m-menu__arrow m-menu__arrow--adjust"></span>
																				<ul class="m-menu__subnav">
																					<li class="m-menu__item " aria-haspopup="true">
																						<a href="inner.html" class="m-menu__link ">
																							<i class="m-menu__link-icon flaticon-diagram"></i>
																							<span class="m-menu__link-title">
																								<span class="m-menu__link-wrap">
																									<span class="m-menu__link-text">
																										Generate Reports
																									</span>
																									<span class="m-menu__link-badge">
																										<span class="m-badge m-badge--success">
																											2
																										</span>
																									</span>
																								</span>
																							</span>
																						</a>
																					</li>
																					<li class="m-menu__item  m-menu__item--submenu" data-menu-submenu-toggle="hover" data-redirect="true" aria-haspopup="true">
																						<a href="#" class="m-menu__link m-menu__toggle">
																							<i class="m-menu__link-icon flaticon-business"></i>
																							<span class="m-menu__link-text">
																								Manage Orders
																							</span>
																							<i class="m-menu__hor-arrow la la-angle-right"></i>
																							<i class="m-menu__ver-arrow la la-angle-right"></i>
																						</a>
																						<div class="m-menu__submenu m-menu__submenu--classic m-menu__submenu--right">
																							<span class="m-menu__arrow "></span>
																							<ul class="m-menu__subnav">
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<span class="m-menu__link-text">
																											Latest Orders
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<span class="m-menu__link-text">
																											Pending Orders
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<span class="m-menu__link-text">
																											Processed Orders
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<span class="m-menu__link-text">
																											Delivery Reports
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<span class="m-menu__link-text">
																											Payments
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<span class="m-menu__link-text">
																											Customers
																										</span>
																									</a>
																								</li>
																							</ul>
																						</div>
																					</li>
																					<li class="m-menu__item  m-menu__item--submenu" data-menu-submenu-toggle="hover" data-redirect="true" aria-haspopup="true">
																						<a href="#" class="m-menu__link m-menu__toggle">
																							<i class="m-menu__link-icon flaticon-chat-1"></i>
																							<span class="m-menu__link-text">
																								Customer Feedbacks
																							</span>
																							<i class="m-menu__hor-arrow la la-angle-right"></i>
																							<i class="m-menu__ver-arrow la la-angle-right"></i>
																						</a>
																						<div class="m-menu__submenu m-menu__submenu--classic m-menu__submenu--right">
																							<span class="m-menu__arrow "></span>
																							<ul class="m-menu__subnav">
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<span class="m-menu__link-text">
																											Customer Feedbacks
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<span class="m-menu__link-text">
																											Supplier Feedbacks
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<span class="m-menu__link-text">
																											Reviewed Feedbacks
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<span class="m-menu__link-text">
																											Resolved Feedbacks
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<span class="m-menu__link-text">
																											Feedback Reports
																										</span>
																									</a>
																								</li>
																							</ul>
																						</div>
																					</li>
																					<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																						<a href="inner.html" class="m-menu__link ">
																							<i class="m-menu__link-icon flaticon-users"></i>
																							<span class="m-menu__link-text">
																								Register Member
																							</span>
																						</a>
																					</li>
																				</ul>
																			</div>
																		</li>
																		<li class="m-menu__item  m-menu__item--submenu m-menu__item--rel" data-menu-submenu-toggle="click" data-redirect="true" aria-haspopup="true">
																			<a href="#" class="m-menu__link m-menu__toggle">
																				<span class="m-menu__item-here"></span>
																				<span class="m-menu__link-text">
																					Reports
																				</span>
																				<i class="m-menu__hor-arrow la la-angle-down"></i>
																				<i class="m-menu__ver-arrow la la-angle-right"></i>
																			</a>
																			<div class="m-menu__submenu  m-menu__submenu--fixed m-menu__submenu--left" style="width:600px">
																				<span class="m-menu__arrow m-menu__arrow--adjust"></span>
																				<div class="m-menu__subnav">
																					<ul class="m-menu__content">
																						<li class="m-menu__item">
																							<h3 class="m-menu__heading m-menu__toggle">
																								<span class="m-menu__link-text">
																									Finance Reports
																								</span>
																								<i class="m-menu__ver-arrow la la-angle-right"></i>
																							</h3>
																							<ul class="m-menu__inner">
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<i class="m-menu__link-icon flaticon-map"></i>
																										<span class="m-menu__link-text">
																											Annual Reports
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<i class="m-menu__link-icon flaticon-user"></i>
																										<span class="m-menu__link-text">
																											HR Reports
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<i class="m-menu__link-icon flaticon-clipboard"></i>
																										<span class="m-menu__link-text">
																											IPO Reports
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<i class="m-menu__link-icon flaticon-graphic-1"></i>
																										<span class="m-menu__link-text">
																											Finance Margins
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<i class="m-menu__link-icon flaticon-graphic-2"></i>
																										<span class="m-menu__link-text">
																											Revenue Reports
																										</span>
																									</a>
																								</li>
																							</ul>
																						</li>
																						<li class="m-menu__item">
																							<h3 class="m-menu__heading m-menu__toggle">
																								<span class="m-menu__link-text">
																									Project Reports
																								</span>
																								<i class="m-menu__ver-arrow la la-angle-right"></i>
																							</h3>
																							<ul class="m-menu__inner">
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<i class="m-menu__link-bullet m-menu__link-bullet--line">
																											<span></span>
																										</i>
																										<span class="m-menu__link-text">
																											Coca Cola CRM
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<i class="m-menu__link-bullet m-menu__link-bullet--line">
																											<span></span>
																										</i>
																										<span class="m-menu__link-text">
																											Delta Airlines Booking Site
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<i class="m-menu__link-bullet m-menu__link-bullet--line">
																											<span></span>
																										</i>
																										<span class="m-menu__link-text">
																											Malibu Accounting
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<i class="m-menu__link-bullet m-menu__link-bullet--line">
																											<span></span>
																										</i>
																										<span class="m-menu__link-text">
																											Vineseed Website Rewamp
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<i class="m-menu__link-bullet m-menu__link-bullet--line">
																											<span></span>
																										</i>
																										<span class="m-menu__link-text">
																											Zircon Mobile App
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<i class="m-menu__link-bullet m-menu__link-bullet--line">
																											<span></span>
																										</i>
																										<span class="m-menu__link-text">
																											Mercury CMS
																										</span>
																									</a>
																								</li>
																							</ul>
																						</li>
																					</ul>
																				</div>
																			</div>
																		</li>
																		<li class="m-menu__item  m-menu__item--submenu" data-menu-submenu-toggle="click" data-redirect="true" aria-haspopup="true">
																			<a href="#" class="m-menu__link m-menu__toggle">
																				<span class="m-menu__item-here"></span>
																				<span class="m-menu__link-text">
																					Orders
																				</span>
																				<i class="m-menu__hor-arrow la la-angle-down"></i>
																				<i class="m-menu__ver-arrow la la-angle-right"></i>
																			</a>
																			<div class="m-menu__submenu  m-menu__submenu--fixed-xl m-menu__submenu--center">
																				<span class="m-menu__arrow m-menu__arrow--adjust"></span>
																				<div class="m-menu__subnav">
																					<ul class="m-menu__content">
																						<li class="m-menu__item">
																							<h3 class="m-menu__heading m-menu__toggle">
																								<span class="m-menu__link-text">
																									Finance Reports
																								</span>
																								<i class="m-menu__ver-arrow la la-angle-right"></i>
																							</h3>
																							<ul class="m-menu__inner">
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<i class="m-menu__link-icon flaticon-map"></i>
																										<span class="m-menu__link-text">
																											Annual Reports
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<i class="m-menu__link-icon flaticon-user"></i>
																										<span class="m-menu__link-text">
																											HR Reports
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<i class="m-menu__link-icon flaticon-clipboard"></i>
																										<span class="m-menu__link-text">
																											IPO Reports
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<i class="m-menu__link-icon flaticon-graphic-1"></i>
																										<span class="m-menu__link-text">
																											Finance Margins
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<i class="m-menu__link-icon flaticon-graphic-2"></i>
																										<span class="m-menu__link-text">
																											Revenue Reports
																										</span>
																									</a>
																								</li>
																							</ul>
																						</li>
																						<li class="m-menu__item">
																							<h3 class="m-menu__heading m-menu__toggle">
																								<span class="m-menu__link-text">
																									Project Reports
																								</span>
																								<i class="m-menu__ver-arrow la la-angle-right"></i>
																							</h3>
																							<ul class="m-menu__inner">
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<i class="m-menu__link-bullet m-menu__link-bullet--line">
																											<span></span>
																										</i>
																										<span class="m-menu__link-text">
																											Coca Cola CRM
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<i class="m-menu__link-bullet m-menu__link-bullet--line">
																											<span></span>
																										</i>
																										<span class="m-menu__link-text">
																											Delta Airlines Booking Site
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<i class="m-menu__link-bullet m-menu__link-bullet--line">
																											<span></span>
																										</i>
																										<span class="m-menu__link-text">
																											Malibu Accounting
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<i class="m-menu__link-bullet m-menu__link-bullet--line">
																											<span></span>
																										</i>
																										<span class="m-menu__link-text">
																											Vineseed Website Rewamp
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<i class="m-menu__link-bullet m-menu__link-bullet--line">
																											<span></span>
																										</i>
																										<span class="m-menu__link-text">
																											Zircon Mobile App
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<i class="m-menu__link-bullet m-menu__link-bullet--line">
																											<span></span>
																										</i>
																										<span class="m-menu__link-text">
																											Mercury CMS
																										</span>
																									</a>
																								</li>
																							</ul>
																						</li>
																						<li class="m-menu__item">
																							<h3 class="m-menu__heading m-menu__toggle">
																								<span class="m-menu__link-text">
																									HR Reports
																								</span>
																								<i class="m-menu__ver-arrow la la-angle-right"></i>
																							</h3>
																							<ul class="m-menu__inner">
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<i class="m-menu__link-bullet m-menu__link-bullet--dot">
																											<span></span>
																										</i>
																										<span class="m-menu__link-text">
																											Staff Directory
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<i class="m-menu__link-bullet m-menu__link-bullet--dot">
																											<span></span>
																										</i>
																										<span class="m-menu__link-text">
																											Client Directory
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<i class="m-menu__link-bullet m-menu__link-bullet--dot">
																											<span></span>
																										</i>
																										<span class="m-menu__link-text">
																											Salary Reports
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<i class="m-menu__link-bullet m-menu__link-bullet--dot">
																											<span></span>
																										</i>
																										<span class="m-menu__link-text">
																											Staff Payslips
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<i class="m-menu__link-bullet m-menu__link-bullet--dot">
																											<span></span>
																										</i>
																										<span class="m-menu__link-text">
																											Corporate Expenses
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<i class="m-menu__link-bullet m-menu__link-bullet--dot">
																											<span></span>
																										</i>
																										<span class="m-menu__link-text">
																											Project Expenses
																										</span>
																									</a>
																								</li>
																							</ul>
																						</li>
																						<li class="m-menu__item">
																							<h3 class="m-menu__heading m-menu__toggle">
																								<span class="m-menu__link-text">
																									Reporting Apps
																								</span>
																								<i class="m-menu__ver-arrow la la-angle-right"></i>
																							</h3>
																							<ul class="m-menu__inner">
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<span class="m-menu__link-text">
																											Report Adjusments
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<span class="m-menu__link-text">
																											Sources & Mediums
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<span class="m-menu__link-text">
																											Reporting Settings
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<span class="m-menu__link-text">
																											Conversions
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<span class="m-menu__link-text">
																											Report Flows
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<span class="m-menu__link-text">
																											Audit & Logs
																										</span>
																									</a>
																								</li>
																							</ul>
																						</li>
																					</ul>
																				</div>
																			</div>
																		</li>
																		<li class="m-menu__item  m-menu__item--submenu m-menu__item--rel m-menu__item--more m-menu__item--icon-only" data-menu-submenu-toggle="click"
																		 data-redirect="true" aria-haspopup="true">
																			<a href="#" class="m-menu__link m-menu__toggle">
																				<span class="m-menu__item-here"></span>
																				<i class="m-menu__link-icon flaticon-more-v3"></i>
																				<span class="m-menu__link-text"></span>
																			</a>
																			<div class="m-menu__submenu m-menu__submenu--classic m-menu__submenu--left m-menu__submenu--pull">
																				<span class="m-menu__arrow m-menu__arrow--adjust"></span>
																				<ul class="m-menu__subnav">
																					<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																						<a href="inner.html" class="m-menu__link ">
																							<i class="m-menu__link-icon flaticon-business"></i>
																							<span class="m-menu__link-text">
																								eCommerce
																							</span>
																						</a>
																					</li>
																					<li class="m-menu__item  m-menu__item--submenu" data-menu-submenu-toggle="hover" data-redirect="true" aria-haspopup="true">
																						<a href="crud/datatable_v1.html" class="m-menu__link m-menu__toggle">
																							<i class="m-menu__link-icon flaticon-computer"></i>
																							<span class="m-menu__link-text">
																								Audience
																							</span>
																							<i class="m-menu__hor-arrow la la-angle-right"></i>
																							<i class="m-menu__ver-arrow la la-angle-right"></i>
																						</a>
																						<div class="m-menu__submenu m-menu__submenu--classic m-menu__submenu--right">
																							<span class="m-menu__arrow "></span>
																							<ul class="m-menu__subnav">
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<i class="m-menu__link-icon flaticon-users"></i>
																										<span class="m-menu__link-text">
																											Active Users
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<i class="m-menu__link-icon flaticon-interface-1"></i>
																										<span class="m-menu__link-text">
																											User Explorer
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<i class="m-menu__link-icon flaticon-lifebuoy"></i>
																										<span class="m-menu__link-text">
																											Users Flows
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<i class="m-menu__link-icon flaticon-graphic-1"></i>
																										<span class="m-menu__link-text">
																											Market Segments
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<i class="m-menu__link-icon flaticon-graphic"></i>
																										<span class="m-menu__link-text">
																											User Reports
																										</span>
																									</a>
																								</li>
																							</ul>
																						</div>
																					</li>
																					<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																						<a href="inner.html" class="m-menu__link ">
																							<i class="m-menu__link-icon flaticon-map"></i>
																							<span class="m-menu__link-text">
																								Marketing
																							</span>
																						</a>
																					</li>
																					<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																						<a href="inner.html" class="m-menu__link ">
																							<i class="m-menu__link-icon flaticon-graphic-2"></i>
																							<span class="m-menu__link-title">
																								<span class="m-menu__link-wrap">
																									<span class="m-menu__link-text">
																										Campaigns
																									</span>
																									<span class="m-menu__link-badge">
																										<span class="m-badge m-badge--success">
																											3
																										</span>
																									</span>
																								</span>
																							</span>
																						</a>
																					</li>
																					<li class="m-menu__item  m-menu__item--submenu" data-menu-submenu-toggle="hover" data-redirect="true" aria-haspopup="true">
																						<a href="#" class="m-menu__link m-menu__toggle">
																							<i class="m-menu__link-icon flaticon-infinity"></i>
																							<span class="m-menu__link-text">
																								Cloud Manager
																							</span>
																							<i class="m-menu__hor-arrow la la-angle-right"></i>
																							<i class="m-menu__ver-arrow la la-angle-right"></i>
																						</a>
																						<div class="m-menu__submenu m-menu__submenu--classic m-menu__submenu--left">
																							<span class="m-menu__arrow "></span>
																							<ul class="m-menu__subnav">
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<i class="m-menu__link-icon flaticon-add"></i>
																										<span class="m-menu__link-title">
																											<span class="m-menu__link-wrap">
																												<span class="m-menu__link-text">
																													File Upload
																												</span>
																												<span class="m-menu__link-badge">
																													<span class="m-badge m-badge--danger">
																														3
																													</span>
																												</span>
																											</span>
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<i class="m-menu__link-icon flaticon-signs-1"></i>
																										<span class="m-menu__link-text">
																											File Attributes
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<i class="m-menu__link-icon flaticon-folder"></i>
																										<span class="m-menu__link-text">
																											Folders
																										</span>
																									</a>
																								</li>
																								<li class="m-menu__item " data-redirect="true" aria-haspopup="true">
																									<a href="inner.html" class="m-menu__link ">
																										<i class="m-menu__link-icon flaticon-cogwheel-2"></i>
																										<span class="m-menu__link-text">
																											System Settings
																										</span>
																									</a>
																								</li>
																							</ul>
																						</div>
																					</li>
																				</ul>
																			</div>
																		</li>
																	</ul>
																</div>
															</div>
															<!-- end::Horizontal Menu -->

														</div>
													</div>
												</div>
											</header>
											<!-- end::Header -->
											<!-- begin::Body -->
											<div class="m-grid__item m-grid__item--fluid  m-grid m-grid--ver-desktop m-grid--desktop 	m-container m-container--responsive m-container--xxl m-page__container m-body">
												<div class="m-grid__item m-grid__item--fluid m-wrapper">
													<!-- BEGIN: Subheader -->
													<div class="m-subheader ">
														<div class="d-flex align-items-center">
															<div class="mr-auto">
																<h3 class="m-subheader__title ">
																	Dashboard - Officina
																	<%=a.getDenominazione()%>
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
																				<p style="text-align:center;" class="smooth-scroll">
																					<a href="#tableguasti" style="background-color:#716aca !important" class="btn btn-info btn-box">Visualizza</a>
																				</p>
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
																					983728
																				</span>
																				<div class="m--space-10"></div>

																				<p style="text-align:center;">
																					<a data-toggle="modal" data-target="#modaladduser" style="background-color:#36a3f7  !important" class="btn btn-info btn-box">Visualizza</a>
																				</p>
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
																					567
																				</span>
																				<div class="m--space-10"></div>
																				<p style="text-align:center;">
																					<a data-toggle="modal" data-target="#modaladduser" style="background-color:#f4516c   !important" class="btn btn-info btn-box">Visualizza</a>
																				</p>
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
																					276
																				</span>
																				<div class="m--space-10"></div>
																				<p style="text-align:center;">
																					<a data-toggle="modal" data-target="#modaladduser" style="background-color:#34bfa3   !important" class="btn btn-info btn-box">Visualizza</a>
																				</p>
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
																					<i class="fa fa-user fah3"></i>
																					Clienti Privati
																				</h3>
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
																							<td>
																								<%=listaUtentiPrivati.get(i).getID()%>
																							</td>
																							<td>
																								<%=listaUtentiPrivati.get(i).getNome()%>
																							</td>
																							<td>
																								<%=listaUtentiPrivati.get(i).getCognome()%>
																							</td>
																							<td>
																								<%=listaUtentiPrivati.get(i).getEmail()%>
																							</td>
																							<td>
																								<%=listaUtentiPrivati.get(i).getTelefono()%>
																							</td>
																							<td>
																								<%=listaUtentiPrivati.get(i).getDataRegistrazione()%>
																							</td>
																							<td>
																								<ul class="fa-ul">
																									<li class="fa-li">
																										<a class="ali" href="list_auto_utente.jsp?idutente=<%=listaUtentiPrivati.get(i).getID()%>" target="_blank">
																											<i class="fa fa-car" title="Visualizza lista auto"></i>
																										</a>
																									</li>
																									<li class="fa-li">
																										<i class="fa fa-pencil modcliente" title="Modifica cliente" data-id="<%=listaUtentiPrivati.get(i).getID()%>" data-nome="<%=listaUtentiPrivati.get(i).getNome()%>"
																										 data-cognome="<%=listaUtentiPrivati.get(i).getCognome()%>" data-email="<%=listaUtentiPrivati.get(i).getEmail()%>"
																										 data-telefono="<%=listaUtentiPrivati.get(i).getTelefono()%>"></i>
																									</li>
																									<li class="fa-li">
																										<i class="fa fa-remove" title="Rimuovi cliente"></i>
																									</li>
																								</ul>
																							</td>
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
																					<i class="fa fa-briefcase fah3"></i>
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
																							<td>
																								<%=listaClientiBusiness.get(i).id%>
																							</td>
																							<td>
																								<%=listaClientiBusiness.get(i).getDenominazione()%>
																							</td>
																							<td>
																								<%=listaClientiBusiness.get(i).getNomeReferente()%>
																							</td>
																							<td>
																								<%=listaClientiBusiness.get(i).getCognomeReferente()%>
																							</td>
																							<td>
																								<%=listaClientiBusiness.get(i).getEmail()%>
																							</td>
																							<td>
																								<%=listaClientiBusiness.get(i).getTelefono()%>
																							</td>
																							<td>
																								<%=listaClientiBusiness.get(i).getCitta()%>
																							</td>
																							<td>
																								<%=listaClientiBusiness.get(i).getDataInserimento()%>
																							</td>
																							<td>
																								<ul class="fa-ul">
																									<li class="fa-li">
																										<a class="ali" href="list_auto_business.jsp?idutente=<%=listaClientiBusiness.get(i).id%>" target="_blank">
																											<i class="fa fa-car" title="Visualizza lista auto"></i>
																										</a>
																									</li>
																									<li class="fa-li">
																										<i class="fa fa-pencil modbusiness" title="Modifica cliente" data-id="<%=listaClientiBusiness.get(i).id%>" data-nome="<%=listaClientiBusiness.get(i).getNomeReferente()%>"
																										 data-cognome="<%=listaClientiBusiness.get(i).getCognomeReferente()%>" data-email="<%=listaClientiBusiness.get(i).getEmail()%>"
																										 data-telefono="<%=listaClientiBusiness.get(i).getTelefono()%>" data-citta="<%=listaClientiBusiness.get(i).getCitta()%>"
																										 data-denominazione="<%=listaClientiBusiness.get(i).getDenominazione()%>"></i>
																									</li>
																									<li class="fa-li">
																										<i class="fa fa-remove" title="Rimuovi cliente"></i>
																									</li>
																								</ul>
																							</td>
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
																					<i class="fa fa-car fah3"></i> Auto
																					<%=a.getDenominazione()%>
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
																							<td>
																								<%=listaAutoOfficina.get(i).getID()%>
																							</td>
																							<td>
																								<%=listaAutoOfficina.get(i).getMarca()%>
																							</td>
																							<td>
																								<%=listaAutoOfficina.get(i).getModello()%>
																							</td>
																							<td>
																								<%=listaAutoOfficina.get(i).getTarga()%>
																							</td>
																							<td>
																								<%=listaAutoOfficina.get(i).getNumeroTelaio()%>
																							</td>



																							<%clienteBusiness = DaoUtility.noleggioAutoClienteBusiness(listaAutoOfficina.get(i).getID());
									clientePrivato = DaoUtility.noleggioAutoClientePrivato(listaAutoOfficina.get(i).getID());
									
									System.out.println(1);
									if((clienteBusiness != null) || (clientePrivato != null)){
										if(clienteBusiness != null){if(clienteBusiness.KmMaxNoleggio != 0) %>
																								<td>In noleggio</td>
																								<%;}
										else if(clientePrivato.KmMaxNoleggio != 0){ %>
																									<td>In noleggio</td>
																									<%;}
										else {%>
																										<td>Auto Privata</td>
																										<%;}
										}else {%>
																											<td>Non in noleggio</td>
																											<%; System.out.println(4);}
	
									%>
																												<td>
																													<ul class="fa-ul">
																														<li class="fa-li">
																															<i class="fa fa-user" title="Visualizza Utente associato"></i>
																														</li>
																														<li class="fa-li">
																															<i class="fa fa-calendar" title="Visualizza scadenze auto"></i>
																														</li>
																														<li class="fa-li">
																															<i class="fa fa-pencil" title="Modifica auto"></i>
																														</li>
																														<li class="fa-li">
																															<i class="fa fa-remove" title="Rimuovi auto"></i>
																														</li>
																													</ul>
																												</td>
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
																					<i class="fa fa-wrench fah3"></i>
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
																							<td>
																								<%=guasti.get(i).getId()%>
																							</td>
																							<td>
																								<%=guasti.get(i).getCodice()%>
																							</td>
																							<td>
																								<%=guasti.get(i).getData()%>
																							</td>
																							<td>
																								<%=guasti.get(i).getDescrizione()%>
																							</td>
																							<td>
																								<%=guasti.get(i).getIdDispositivo()%>
																							</td>
																							<td>
																								<%=guasti.get(i).getMarcaAuto()%>
																							</td>
																							<td>
																								<%=guasti.get(i).getModelloAuto()%>
																							</td>
																							<td>
																								<%=guasti.get(i).getNumeroTarga()%>
																							</td>
																							<td>
																								<%=guasti.get(i).getNumeroTelaio()%>
																							</td>
																							<td>
																								<ul class="fa-ul">
																									<li class="fa-li">
																										<i class="fa fa-bar-chart" title="Visualizza dati telemetria"></i>
																									</li>
																									<li class="fa-li">
																										<i class="fa fa-user" title="Visualizza dati cliente"></i>
																									</li>

																								</ul>
																							</td>
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
											<!-- begin::Footer -->
											<footer class="m-grid__item m-footer ">
												<div class="m-container m-container--responsive m-container--xxl m-container--full-height m-page__container">
													<div class="m-footer__wrapper">
														<div class="m-stack m-stack--flex-tablet-and-mobile m-stack--ver m-stack--desktop">
															<div class="m-stack__item m-stack__item--left m-stack__item--middle m-stack__item--last">
																<span class="m-footer__copyright">
																	2018 &copy; Contrader Vianello
																	<a href="https://contrader.it" class="m-link">
																		Contrader.it
																	</a>
																</span>
															</div>
															<div class="m-stack__item m-stack__item--right m-stack__item--middle m-stack__item--first">
																<ul class="m-footer__nav m-nav m-nav--inline m--pull-right">
																	<li class="m-nav__item">
																		<a href="#" class="m-nav__link">
																			<span class="m-nav__link-text">
																				About
																			</span>
																		</a>
																	</li>
																	<li class="m-nav__item">
																		<a href="#" class="m-nav__link">
																			<span class="m-nav__link-text">
																				Privacy
																			</span>
																		</a>
																	</li>
																	<li class="m-nav__item">
																		<a href="#" class="m-nav__link">
																			<span class="m-nav__link-text">
																				T&C
																			</span>
																		</a>
																	</li>
																	<li class="m-nav__item">
																		<a href="#" class="m-nav__link">
																			<span class="m-nav__link-text">
																				Purchase
																			</span>
																		</a>
																	</li>
																	<li class="m-nav__item m-nav__item--last">
																		<a href="#" class="m-nav__link" data-toggle="m-tooltip" title="Support Center" data-placement="left">
																			<i class="m-nav__link-icon flaticon-info m--icon-font-size-lg3"></i>
																		</a>
																	</li>
																</ul>
															</div>
														</div>
													</div>
												</div>
											</footer>
											<!-- end::Footer -->
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
																<input type="text" class="form-control" id="nomeclientebusiness" aria-describedby="nomeclientebusiness" placeholder="Denominazione Cliente Business..."
																 name="nomeclientebusiness" required>

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
													<div class="modal-footer " style="text-align:center;">
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
																<label for="nomecliente">Nome</label>
																<input type="text" class="form-control" id="nomecliente" aria-describedby="nomecliente" placeholder="Nome..." name="nome"
																 required>

															</div>
															<div class="form-group">
																<label for="cognomecliente">Cognome</label>
																<input type="text" class="form-control" id="cognomecliente" placeholder="Cognome..." name="cognomecliente">
															</div>
															<div class="form-group">
																<label for="emailcliente">Email</label>
																<input type="email" class="form-control" id="emailcliente" placeholder="Email..." name="emailcliente" required>
															</div>
															<div class="form-group">
																<label for="pwdcliente">Password</label>
																<input type="text" class="form-control" id="pwdcliente" placeholder="Password..." name="pwdcliente" required>
															</div>
															<div class="form-group">
																<label for="idazienda">ID Officina</label>
																<input type="number" class="form-control" id="idazienda" placeholder="ID Azienda..." name="idazienda">
															</div>
															<div class="form-group">
																<label for="telefonocliente">Telefono</label>
																<input type="text" class="form-control" id="telefonocliente" placeholder="Telefono..." name="telefonocliente">
															</div>


													</div>
													<div class="modal-footer " style="text-align:center;">
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
																<input type="text" class="form-control" id="nomeclientebusiness" aria-describedby="nomeclientebusiness" placeholder="Denominazione Cliente Business..."
																 name="nomeclientebusiness" required>

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
													<div class="modal-footer " style="text-align:center;">
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
														<h5 class="modal-title">Modifica cliente privato
															<span id=modcliente></span>
														</h5>
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
													<div class="modal-footer " style="text-align:center;">
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
														<h5 class="modal-title">Modifica cliente business
															<span id=modbusiness></span>
														</h5>
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
													<div class="modal-footer " style="text-align:center;">
														<button type="submit" class="btn btn-primary savebutton">Salva</button>
														</form>
													</div>
												</div>
											</div>
										</div>
										<!-- end::modal modifica cliente business -->
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

											$('.modcliente').on('click', function () {
												var nome = $(this).data("nome");
												var cognome = $(this).data("cognome");
												var telefono = $(this).data("telefono");
												var email = $(this).data("email");
												var id = $(this).data("id");
												$('#modcliente').html(nome + " " + cognome);
												$('#nomemod').val(nome);
												$('#cognomemod').val(cognome);
												$('#telefonomod').val(telefono);
												$('#emailmod').val(email);
												$('#idmod').val(id);
												$('#modalmodcliente').modal("show");
											});
											$('.modbusiness').on('click', function () {
												var denominazione = $(this).data("denominazione");
												var citta = $(this).data("citta");
												var nome = $(this).data("nome");
												var cognome = $(this).data("cognome");
												var telefono = $(this).data("telefono");
												var email = $(this).data("email");
												var id = $(this).data("id");
												$('#modbusiness').html(nome + " " + cognome);
												$('#nomemodbusiness').val(nome);
												$('#denominazionemodbusiness').val(denominazione);
												$('#cittamodbusiness').val(citta);
												$('#cognomemodbusiness').val(cognome);
												$('#telefonomodbusiness').val(telefono);
												$('#emailmodbusiness').val(email);
												$('#idmodbusiness').val(id);
												$('#modalmodbusiness').modal("show");
											});

										</script>
										<% } %>
	</body>
	<!-- end::Body -->

	</html>