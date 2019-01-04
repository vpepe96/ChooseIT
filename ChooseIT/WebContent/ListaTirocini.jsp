<%@page import="it.chooseit.bean.StudenteBean"%>
<%@page import="it.chooseit.facade.GestioneReportFacade"%>
<%@page import="it.chooseit.bean.TutorUniversitarioBean"%>
<%@page import="it.chooseit.impl.StatoTirocinio"%>
<%@page import="java.util.ArrayList"%>
<%@page import="it.chooseit.bean.RegistroTirocinioBean"%>
<%@page import="it.chooseit.impl.RegistroTirocinio"%>
<%@page import="it.chooseit.bean.TutorAziendaleBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
		<!--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">-->

		<title> ChooseIT | Lista dei tirocini </title>
		<meta name="description" content="Lista dei tirocini">
		<meta name="author" content="RocketStudios">
			
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<!-- Basic Styles -->
		<link rel="stylesheet" type="text/css" media="screen" href="css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" media="screen" href="css/font-awesome.min.css">

		<!-- SmartAdmin Styles : Caution! DO NOT change the order -->
		<link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-production-plugins.min.css">
		<link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-production.min.css">
		<link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-skins.min.css">

		<!-- SmartAdmin RTL Support -->
		<link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-rtl.min.css"> 

		<!-- We recommend you use "your_style.css" to override SmartAdmin
		     specific styles this will also ensure you retrain your customization with each SmartAdmin update.
		<link rel="stylesheet" type="text/css" media="screen" href="css/your_style.css"> -->

		<!-- Demo purpose only: goes with demo.js, you can delete this css when designing your own WebApp -->
		<link rel="stylesheet" type="text/css" media="screen" href="css/demo.min.css">

		<!-- FAVICONS -->
		<link rel="shortcut icon" href="img/logo2.png" type="image/x-icon">
		<link rel="icon" href="img/logo2.png" type="image/x-icon">

		<!-- GOOGLE FONT -->
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,300,400,700">

		<!-- Specifying a Webpage Icon for Web Clip 
			 Ref: https://developer.apple.com/library/ios/documentation/AppleApplications/Reference/SafariWebContent/ConfiguringWebApplications/ConfiguringWebApplications.html -->
		<link rel="apple-touch-icon" href="img/splash/sptouch-icon-iphone.png">
		<link rel="apple-touch-icon" sizes="76x76" href="img/splash/touch-icon-ipad.png">
		<link rel="apple-touch-icon" sizes="120x120" href="img/splash/touch-icon-iphone-retina.png">
		<link rel="apple-touch-icon" sizes="152x152" href="img/splash/touch-icon-ipad-retina.png">
</head>
<body>
	<jsp:include page="navbar.jsp" />

	<%
		String ruolo = (String) request.getSession().getAttribute("ruolo");
	%>

	<!-- MAIN PANEL -->
	<div id="main" role="main">

		<!-- RIBBON -->
		<div id="ribbon">

			<!-- breadcrumb -->
			<ol class="breadcrumb">
				<li>Home</li>
				<li>Lista Tirocini</li>

			</ol>

		</div>
		<!-- END RIBBON -->

		<!-- MAIN CONTENT -->
		<div id="content">

			<!-- row -->
			<div class="row">
				<article class="col-sm-12">


					<%
						if (ruolo.trim().equals("tutorAziendale")) {
							TutorAziendaleBean tutor = (TutorAziendaleBean) request.getSession().getAttribute("utente");
							RegistroTirocinio registroImpl = new RegistroTirocinio();
							ArrayList<RegistroTirocinioBean> registri = (ArrayList<RegistroTirocinioBean>) registroImpl.getRegistriDiTutorAziendale(tutor);

							if (registri.size() != 0) {
								StatoTirocinio statoImpl = new StatoTirocinio();
					%>

					<header>

						<h2>Lista Tirocini</h2>

					</header>

					<!-- widget div-->
					<div>

						<!-- widget content -->
						<div class="widget-body">

							<div class="table-responsive">


								<div class="contenuto">

									<table class="table table-bordered">
										<thead>
											<tr>
												<th><strong>Id Registro</strong></th>
												<th><strong>Nome</strong></th>
												<th><strong>Cognome</strong></th>
												<th><strong>Data Inizio</strong></th>
												<th><strong>Stato</strong></th>

												<th><strong>Link Registro</strong></th>
											</tr>
										</thead>
										<%
											for (RegistroTirocinioBean x : registri) {
										%>
										<tr>
											<td><%=x.getIdentificativo()%></td>
											<td><%=x.getStudente().getNome()%></td>
											<td><%=x.getStudente().getCognome()%></td>
											<td><%=x.getDataInizio()%></td>
											<td><%=statoImpl.getStatoTirocinio(x).getTipo()%></td>
											<td><a
												href="ListaTirocinioServlet?registroId=<%=x.getIdentificativo()%>">Registro</a>
										</tr>
										<%
											}
										%>
									</table>
								</div>
								<!--  end div contenuto -->

							</div>
							<!-- end div table -->
						</div>
						<!-- end div widget body -->
					</div>
					<!-- widget div -->
					<%
						}
						} else if (ruolo.trim().equals("tutorUniversitario")) {
							TutorUniversitarioBean tutor = (TutorUniversitarioBean) request.getSession().getAttribute("utente");
							RegistroTirocinio registroImpl = new RegistroTirocinio();
							ArrayList<RegistroTirocinioBean> registri = (ArrayList<RegistroTirocinioBean>) registroImpl.getRegistriDiTutorUniversitario(tutor);

							if (registri.size() != 0) {
								StatoTirocinio statoImpl = new StatoTirocinio();
					%>

					<header>

						<h2>Lista Tirocini</h2>

					</header>

					<!-- widget div-->
					<div>

						<!-- widget content -->
						<div class="widget-body">

							<div class="table-responsive">


								<div class="contenuto">

									<table class="table table-bordered">
										<thead>
											<tr>
												<th><strong>Id Registro</strong></th>
												<th><strong>Nome</strong></th>
												<th><strong>Cognome</strong></th>
												<th><strong>Data Inizio</strong></th>
												<th><strong>Stato</strong></th>
												<th><strong>Link Registro</strong></th>
											</tr>
										</thead>
										<%
											for (RegistroTirocinioBean x : registri) {
										%>
										<tr>
											<td><%=x.getIdentificativo()%></td>
											<td><%=x.getStudente().getNome()%></td>
											<td><%=x.getStudente().getCognome()%></td>
											<td><%=x.getDataInizio()%></td>
											<td><%=statoImpl.getStatoTirocinio(x).getTipo()%></td>
											<td><a
												href="ListaTirocinioServlet?registroId=<%=x.getIdentificativo()%>">Registro</a>
										</tr>
										<%
											}
										%>
									</table>
								</div>
								<!--  end div contenuto -->

							</div>
							<!-- end div table -->
						</div>
						<!-- end div widget body -->
					</div>
					<!-- widget div -->
					<%
						}
						} else if (ruolo.trim().equals("segreteria") || ruolo.trim().equals("presidente")) {
							GestioneReportFacade g = new GestioneReportFacade();
							ArrayList<RegistroTirocinioBean> registri = (ArrayList<RegistroTirocinioBean>) g.listaRegistroTirocinio();

							if (registri.size() != 0) {
								StatoTirocinio statoImpl = new StatoTirocinio();
					%>

					<header>

						<h2>Lista Tirocini</h2>

					</header>

					<!-- widget div-->
					<div>

						<!-- widget content -->
						<div class="widget-body">

							<div class="table-responsive">


								<div class="contenuto">

									<table class="table table-bordered">
										<thead>
											<tr>
												<th><strong>Id Registro</strong></th>
												<th><strong>Nome</strong></th>
												<th><strong>Cognome</strong></th>
												<th><strong>Data Inizio</strong></th>
												<th><strong>Stato</strong></th>
												<th><strong>Link Registro</strong></th>
											</tr>
										</thead>
										<%
											for (RegistroTirocinioBean x : registri) {
										%>
										<tr>
											<td><%=x.getIdentificativo()%></td>
											<td><%=x.getStudente().getNome()%></td>
											<td><%=x.getStudente().getCognome()%></td>
											<td><%=x.getDataInizio()%></td>
											<td><%=statoImpl.getStatoTirocinio(x).getTipo()%></td>
											<td><a
												href="ListaTirocinioServlet?registroId=<%=x.getIdentificativo()%>">Registro</a>
										</tr>
										<%
											}
										%>
									</table>
								</div>
								<!--  end div contenuto -->

							</div>
							<!-- end div table -->
						</div>
						<!-- end div widget body -->
					</div>
					<!-- widget div -->
					<%
						}
						}
					%>
										<%
						if (ruolo.trim().equals("studente")) {
							StudenteBean studente = (StudenteBean) request.getSession().getAttribute("utente");
							RegistroTirocinio registroImpl = new RegistroTirocinio();
							ArrayList<RegistroTirocinioBean> registri = (ArrayList<RegistroTirocinioBean>) registroImpl.getRegistriDiStudente(studente);

							if (registri.size() != 0) {
								StatoTirocinio statoImpl = new StatoTirocinio();
					%>

					<header>

						<h2>Lista Tirocini</h2>

					</header>

					<!-- widget div-->
					<div>

						<!-- widget content -->
						<div class="widget-body">

							<div class="table-responsive">


								<div class="contenuto">

									<table class="table table-bordered">
										<thead>
											<tr>
												<th><strong>Id Registro</strong></th>
												<th><strong>Data Inizio</strong></th>
												<th><strong>Stato</strong></th>

												<th><strong>Link Registro</strong></th>
											</tr>
										</thead>
										<%
											for (RegistroTirocinioBean x : registri) {
										%>
										<tr>
											<td><%=x.getIdentificativo()%></td>
											<td><%=x.getDataInizio()%></td>
											<td><%=statoImpl.getStatoTirocinio(x).getTipo()%></td>
											<td><a
												href="ListaTirocinioServlet?registroId=<%=x.getIdentificativo()%>">Registro</a>
										</tr>
										<%
											}
										%>
									</table>
								</div>
								<!--  end div contenuto -->

							</div>
							<!-- end div table -->
						</div>
						<!-- end div widget body -->
					</div>
					<!-- widget div -->
					<%
						}
						}
										%>
				</article>
			</div>
			<!-- end div row -->

		</div>
		<!-- END MAIN CONTENT -->
	</div>
	<!-- END MAIN PANEL -->
	<jsp:include page="footer.jsp" />
</body>
</html>