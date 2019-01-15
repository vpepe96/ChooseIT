<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="it.chooseit.bean.StatoTirocinioBean"%>
<%@page import="it.chooseit.bean.StatoReportBean"%>
<%@page import="it.chooseit.bean.TutorUniversitarioBean"%>
<%@page import="it.chooseit.impl.StatoReport"%>
<%@page import="it.chooseit.bean.ReportBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="it.chooseit.impl.StatoTirocinio"%>
<%@page import="it.chooseit.bean.RegistroTirocinioBean"%>
<%@page import="it.chooseit.bean.TutorAziendaleBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
		<!--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">-->

		<title> ChooseIT | Registro di tirocinio </title>
		<meta name="description" content="Registro Tirocinio">
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
				<li>Registro</li>
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
							RegistroTirocinioBean reg = (RegistroTirocinioBean) request.getSession().getAttribute("registroTirocinio");
							if (reg != null) {
								StatoReport statoImpl = new StatoReport();
								ArrayList<ReportBean> reports = reg.getReports();
					%>

					<header>

						<h2>Lista Report</h2>

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
												<th><strong>Stato</strong></th>
												<th><strong>Data Report</strong>
												<th><strong>Download</strong></th>
												<th><strong>Firma</strong></th>
											</tr>
										</thead>
										<%
											for (ReportBean x : reports) {
										%>
										<tr>
											<td><%=statoImpl.getStatoReport(x).getTipo()%></td>
											<td><%=statoImpl.getStatoReport(x).getDataStato() %></td>
											<td><form action="ValutaReportServlet?action=download"  method="post" enctype="multipart/form-data">
												<input type="hidden" name="dataInserimento" id="dataInserimento" value="<%=x.getDataInserimento() %>">
												<input type="hidden" name="path" id="path" value="<%=x.getPath()%>">
												<input type="submit" value="Download">
											</form></td>
											<%if(statoImpl.getStatoReport(x).getTipo().equals(StatoReportBean.StatoReport.COMPILATO)){ %>
											<td>
												<td><form action="ValutaReportServlet?action=valuta"  method="post" enctype="multipart/form-data">
												<input type="hidden" name="dataInserimento" id="dataInserimento" value="<%=x.getDataInserimento() %>">
												<input type="hidden" name="path" id="path" value="<%=x.getPath()%>">
												<input type="file" required="required" name="fileReport" size="50" accept="application/pdf">
												<input type="submit" value="Valuta">
											</form>
											</td>
											<%}else{%>
												<td>Il report non può essere modificato.</td>	
											<% }%>
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
							RegistroTirocinioBean reg = (RegistroTirocinioBean) request.getSession().getAttribute("registroTirocinio");
							if (reg != null) {
								StatoReport statoImpl = new StatoReport();
								ArrayList<ReportBean> reports = reg.getReports();
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
												<th><strong>Stato</strong></th>
												<th><strong>Data Report</strong>
												<th><strong>Download</strong></th>
											</tr>
										</thead>
										<%
											for (ReportBean x : reports) {
										%>
										<tr>
											<td><%=statoImpl.getStatoReport(x).getTipo()%></td>
											<td><%=statoImpl.getStatoReport(x).getDataStato() %></td>
											<td><form action="ValutaReportServlet?action=download"  method="post" enctype="multipart/form-data">
												<input type="hidden" name="dataInserimento" id="dataInserimento" value="<%=x.getDataInserimento() %>">
												<input type="hidden" name="path" id="path" value="<%=x.getPath()%>">
												<input type="submit" value="Download">
											</form></td>
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
							RegistroTirocinioBean reg = (RegistroTirocinioBean) request.getSession().getAttribute("registroTirocinio");
							StatoTirocinio statoTirDao = new StatoTirocinio();
							StatoTirocinioBean stato = statoTirDao.getStatoTirocinio(reg);
							request.getSession().setAttribute("stato", stato);
							if (reg != null) {
								StatoReport statoImpl = new StatoReport();
								ArrayList<ReportBean> reports = reg.getReports();
					%>

					<header>

						<h2>Lista Report</h2>

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
												<th><strong>Stato</strong></th>
												<th><strong>Data Report</strong>
												<th><strong>Download</strong></th>
											</tr>
										</thead>
										<%
											for (ReportBean x : reports) {
										%>
										<tr>
											<td><%=statoImpl.getStatoReport(x).getTipo() %></td>
											<td><%=statoImpl.getStatoReport(x).getDataStato() %></td>
											<td><form action="ValutaReportServlet?action=download"  method="post" enctype="multipart/form-data">
												<input type="hidden" name="dataInserimento" id="dataInserimento" value="<%=x.getDataInserimento() %>">
												<input type="hidden" name="path" id="path" value="<%=x.getPath()%>">
												<input type="submit" value="Download">
											</form></td>
										</tr>
										<%
											}
											if(stato.getTipo().equals(StatoTirocinioBean.StatoTirocinio.INCORSO)){
											  ReportBean ultimoReport = null;
											  for(ReportBean x : reports){
											   	ultimoReport = x;
											  }
											  if(ultimoReport != null){
											    StatoReportBean ultimoStato = statoImpl.getStatoReport(ultimoReport);
											    if(ultimoStato.getTipo().equals(StatoReportBean.StatoReport.VALIDATO) && ultimoReport.getDataInserimento().getTime() == System.currentTimeMillis()){
											      %>
											      <tr>
													<td><form action="ValutaReportServlet?action=upload" method="post" enctype="multipart/form-data">
														<input type="file" required="required" name="fileReport" size="50" accept="application/pdf">
														<input type="submit" value="Invia Report">
													</form>
												</td>
											</tr>	      
											      <% 
											    }
											  }else{
											    %>
											    	<tr>
													<td><form action="ValutaReportServlet?action=upload" method="post" enctype="multipart/form-data">
														<input type="file" required="required" name="fileReport" size="50" accept="application/pdf">
														<input type="submit" value="Invia Report">
													</form>
												</td>
											</tr>	   
											    
											    <%
											  }
										%>
										
										<%} %>
									</table>
								</div>
								<!--  end div contenuto -->

							</div>
							<!-- end div table -->
							
							<%
							if(stato.getTipo().equals(StatoTirocinioBean.StatoTirocinio.TERMINATO)){
							%>	
								<a href="Questionari.jsp">Compila il Questionario</a>
							<% 	
							}
							%>
							
						</div>
						<!-- end div widget body -->
					</div>
					<!-- widget div -->
					<%
						}
						} %>
						<% 
							if (ruolo.trim().equals("segreteria")) {
							RegistroTirocinioBean reg = (RegistroTirocinioBean) request.getSession().getAttribute("registroTirocinio");
							StatoTirocinio statoTirDao = new StatoTirocinio();
							StatoTirocinioBean stato = statoTirDao.getStatoTirocinio(reg);
							request.getSession().setAttribute("stato", stato);
							if (reg != null) {
								StatoReport statoImpl = new StatoReport();
								ArrayList<ReportBean> reports = reg.getReports();
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
												<th><strong>Stato</strong></th>
												<th><strong>Data Report</strong>
												<th><strong>Download</strong></th>
											</tr>
										</thead>
										<%
											for (ReportBean x : reports) {
										%>
										<tr>
											<td><%=statoImpl.getStatoReport(x).getTipo()%></td>
											<td><%=statoImpl.getStatoReport(x).getDataStato() %></td>
											<td><form action="ValutaReportServlet?action=download"  method="post" enctype="multipart/form-data">
												<input type="hidden" name="dataInserimento" id="dataInserimento" value="<%=x.getDataInserimento() %>">
												<input type="hidden" name="path" id="path" value="<%=x.getPath()%>">
												<input type="submit" value="Download">
											</form></td>
										</tr>
										<%
											}
										%>
									</table>
								</div>
								<!--  end div contenuto -->

							</div>
							<!-- end div table -->
							<%
							if(stato.getTipo().equals(StatoTirocinioBean.StatoTirocinio.INCORSO)){
							%>	
								<form action="ValutaTirocinioServlet" method="post">
												<input type="submit" value="Termina Tirocinio">
								</form>
							<% 	
							}
							%>
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