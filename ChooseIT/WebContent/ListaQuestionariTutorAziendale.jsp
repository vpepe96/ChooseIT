<%@page import="java.util.ArrayList"%>
<%@page import="it.chooseit.bean.TutorAziendaleBean"%>
<%@ page import="it.chooseit.impl.QuestionarioStudente"%>
<%@ page import="it.chooseit.bean.QuestionarioStudenteBean"%>
<%@ page import="it.chooseit.bean.QuestionarioStudenteBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Lista questionari</title>
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
				<li>Lista Questionari</li>

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
							QuestionarioStudente questionario = new QuestionarioStudente();
							ArrayList<QuestionarioStudenteBean> questionarioEnte = (ArrayList<QuestionarioStudenteBean>) questionario.getQuestionariNonCompilati(tutor);

							if (questionarioEnte.size() != 0) {
					%>

					<header>

						<h2>Lista Questionari</h2>

					</header>

					<!-- widget div-->
					<div>

						<!-- widget content -->
						<div class="widget-body">

							<div class="table-responsive">


								<div class="contenuto">
									
									<table class="table table-bordered">
									<thead><tr>
												<th><strong>Id Registro</strong></th>
												<th><strong>Nome</strong></th>
												<th><strong>Cognome</strong></th>
												<th><strong>Link Questionario</strong></th>
											</tr>
									</thead>
										<%
											for (QuestionarioStudenteBean x : questionarioEnte) {
										%>
										<tr>
											<td><%=x.getRegistroTirocinio().getIdentificativo()%></td>
											<td><%=x.getRegistroTirocinio().getStudente().getNome()%></td>
											<td><%=x.getRegistroTirocinio().getStudente().getCognome()%></td>
											<td><a href="ListaQuestionariTutorAziendaliServlet?registroId=<%=x.getRegistroTirocinio().getIdentificativo()%>">Questionario</a>
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