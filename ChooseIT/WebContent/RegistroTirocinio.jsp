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
<title>Registro</title>
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
											<td><%=statoImpl.getStatoReport(x)%></td>
											<td><%=statoImpl.getStatoReport(x).getDataStato() %></td>
											<td><a href="ValutaReportServlet?action=download&dataInserimento=<%=x.getDataInserimento()%>&path=<%=x.getPath()%>">Download</a>
											<td><form action="ValutaReportServlet?action=valuta&dataInserimento=<%=x.getDataInserimento()%>&path=<%=x.getPath()%>" method="post">
													<input type="submit" value="Valuta">
												</form>
											</td>
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
						} else if (ruolo.trim().equals("tutorUniversitario") || ruolo.trim().equals("segreteria")) {
							TutorUniversitarioBean tutor = (TutorUniversitarioBean) request.getSession().getAttribute("utente");
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
											<td><%=statoImpl.getStatoReport(x)%></td>
											<td><%=statoImpl.getStatoReport(x).getDataStato() %></td>
											<td><a href="ValutaReportServlet?action=download&dataInserimento=<%=x.getDataInserimento()%>&path=<%=x.getPath()%>">Download</a>
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
												<th><strong>Upload</strong></th>
											</tr>
										</thead>
										<%
											for (ReportBean x : reports) {
										%>
										<tr>
											<td><%=statoImpl.getStatoReport(x)%></td>
											<td><%=statoImpl.getStatoReport(x).getDataStato() %></td>
											<td><a href="ValutaReportServlet?action=download&dataInserimento=<%=x.getDataInserimento()%>&path=<%=x.getPath()%>">Download</a>
											<td><form action="ValutaReportServlet?action=upload&dataInserimento=<%=x.getDataInserimento()%>&path=<%=x.getPath()%>" method="post">
													<input type="submit" value="Upload">
												</form>
											</td>
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
						} %>
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