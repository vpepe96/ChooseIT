<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
		<!--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">-->

		<title> ChooseIT | Questionario </title>
		<meta name="description" content="Questionario">
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
				<li>Lista Questionari</li>
				<li>Questionario</li>
			</ol>

		</div>
		<!-- END RIBBON -->

		<!-- MAIN CONTENT -->
		<div id="content">

			<!-- row -->
			<div class="row">
				<article class="col-sm-12">


					<%
						if (ruolo.equals("tutorAziendale")) {
					%>
					<header>
						
						<h2>Questionario Valutativo Ente Ospitante</h2>
					</header>

					<!-- widget div-->
					<div>

						<!-- widget content -->
						<div class="widget-body">

							<div class="table-responsive">
							<%
								String urlQuestionari=response.encodeURL("QuestionariServlet");
							%>
								<form name="formQuestionarioEnte" method="post"
									action="<%=urlQuestionari%>">
								

									<table class="table table-bordered">

										<thead>
											<tr>
												<th><strong>Relativamente al progetto di
														Tirocinio e all'Esperienza:</strong></th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>Le attività svolte sono state coerenti con le
													conoscenze possedute</td>
												<td><span>
														<label><input type="radio" value="1" name="pdt1">1</label> 
														<label><input type="radio" value="2" name="pdt1">2</label> 
														<label><input type="radio" value="3" name="pdt1" checked="checked">3</label> 
														<label><input type="radio" value="4" name="pdt1">4</label> 
														<label><input type="radio" value="5" name="pdt1">5</label> </span></td>

											</tr>
											<tr>
												<td>Il tirocinio ha migliorato la formazione tecnico</td>
												<td><span>
														<label><input type="radio" value="1" name="pdt2">1</label> 
														<label><input type="radio" value="2" name="pdt2">2</label> 
														<label><input type="radio" value="3" name="pdt2" checked="checked">3</label> 
														<label><input type="radio" value="4" name="pdt2">4</label> 
														<label><input type="radio" value="5" name="pdt2">5</label> </span></td>

											</tr>
											<tr>
												<td>Il tirocinio ha migliorato le soft skill (capacità
													di relazionarsi, di lavorare in team, organizzarsi...)</td>
												<td><span>
														<label><input type="radio" value="1" name="pdt3">1</label> 
														<label><input type="radio" value="2" name="pdt3">2</label> 
														<label><input type="radio" value="3" name="pdt3" checked="checked">3</label> 
														<label><input type="radio" value="4" name="pdt3">4</label> 
														<label><input type="radio" value="5" name="pdt3">5</label> </span></td>
											</tr>
											<tr>
												<td>La durata del tirocinio è stata adeguata agli
													obiettivi del progetto</td>
												<td><span>
														<label><input type="radio" value="1" name="pdt4">1</label> 
														<label><input type="radio" value="2" name="pdt4">2</label> 
														<label><input type="radio" value="3" name="pdt4" checked="checked">3</label> 
														<label><input type="radio" value="4" name="pdt4">4</label> 
														<label><input type="radio" value="5" name="pdt4">5</label> </span></td>
											</tr>
										<thead>
											<tr>
												<td><strong>Relativamente al tirocinante:</strong></td>
											</tr>
										</thead>
											<tr>
												<td>Competenze informatiche possedute in ingresso</td>
												<td><span>
														<label><input type="radio" value="1" name="t1">1</label> 
														<label><input type="radio" value="2" name="t1">2</label> 
														<label><input type="radio" value="3" name="t1" checked="checked">3</label> 
														<label><input type="radio" value="4" name="t1">4</label> 
														<label><input type="radio" value="5" name="t1">5</label> </span></td>
											</tr>
											<tr>
												<td>Competenze acquisite al termine del tirocinio nella
													specifica disciplina</td>
												<td><span>
														<label><input type="radio" value="1" name="t2">1</label> 
														<label><input type="radio" value="2" name="t2">2</label> 
														<label><input type="radio" value="3" name="t2" checked="checked">3</label> 
														<label><input type="radio" value="4" name="t2">4</label> 
														<label><input type="radio" value="5" name="t2">5</label> </span></td>
											</tr>
											<tr>
												<td>Motivazione, e interesse</td>
												<td><span>
														<label><input type="radio" value="1" name="t3">1</label> 
														<label><input type="radio" value="2" name="t3">2</label> 
														<label><input type="radio" value="3" name="t3" checked="checked">3</label> 
														<label><input type="radio" value="4" name="t3">4</label> 
														<label><input type="radio" value="5" name="t3">5</label> </span></td>
											</tr>
											<tr>
												<td>Soft skill (capacità  di relazionarsi, di
													comunicare, di lavorare in team ...)</td>
												<td><span>
														<label><input type="radio" value="1" name="t4">1</label> 
														<label><input type="radio" value="2" name="t4">2</label> 
														<label><input type="radio" value="3" name="t4" checked="checked">3</label> 
														<label><input type="radio" value="4" name="t4">4</label> 
														<label><input type="radio" value="5" name="t4">5</label> </span></td>
											</tr>
										<thead>
											<tr>
												<td><strong>Relativamente alle strutture
														universitarie addette alla gestione dei Tirocini:</strong></td>
											</tr>
										</thead>
											<tr>
												<td>Hanno fornito informazioni chiare ed esaustive</td>
												<td><span>
														<label><input type="radio" value="1" name="su1">1</label> 
														<label><input type="radio" value="2" name="su1">2</label> 
														<label><input type="radio" value="3" name="su1" checked="checked">3</label> 
														<label><input type="radio" value="4" name="su1">4</label> 
														<label><input type="radio" value="5" name="su1">5</label> </span></td>
											</tr>
											<tr>
												<td>Hanno fornito assistenza e disponibilità </td>
												<td><span>
														<label><input type="radio" value="1" name="su2">1</label> 
														<label><input type="radio" value="2" name="su2">2</label> 
														<label><input type="radio" value="3" name="su2" checked="checked">3</label> 
														<label><input type="radio" value="4" name="su2">4</label> 
														<label><input type="radio" value="5" name="su2">5</label> </span></td>
											</tr>
											<tr>
												<td>I servizi/informazioni fornite via Web sono
													esaustivi</td>
												<td><span>
														<label><input type="radio" value="1" name="su3">1</label> 
														<label><input type="radio" value="2" name="su3">2</label> 
														<label><input type="radio" value="3" name="su3" checked="checked">3</label> 
														<label><input type="radio" value="4" name="su3">4</label> 
														<label><input type="radio" value="5" name="su3">5</label> </span></td>
											</tr>
										</tbody>
									</table>
									<input type="submit" value="Conferma Questionario"
										id="Conferma">
								</form>

							</div>
						</div>
						<!-- end widget content -->

					</div>
					<!-- end widget div -->

					<%
						}else if(ruolo.equals("studente")){
					%>
					<header>
						
						<h2>Questionario Valutativo Studente</h2>
					</header>

					<!-- widget div-->
					<div>

						<!-- widget content -->
						<div class="widget-body">

							<div class="table-responsive">
							<%
								String urlQuestionari=response.encodeURL("QuestionariServlet");
							%>
								<form name="formQuestionarioStudente" method="post"
									action="<%=urlQuestionari%>">

									<table class="table table-bordered">

										<thead>
											<tr>
												<th><strong>Relativamente al progetto di
														Tirocinio e all'Esperienza:</strong></th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>Le attività svolte sono state coerenti con le
													conoscenze possedute</td>
												<td><span>
														<label><input type="radio" value="1" name="pdt1">1</label> 
														<label><input type="radio" value="2" name="pdt1">2</label> 
														<label><input type="radio" value="3" name="pdt1" checked="checked">3</label> 
														<label><input type="radio" value="4" name="pdt1">4</label> 
														<label><input type="radio" value="5" name="pdt1">5</label> </span></td>

											</tr>
											<tr>
												<td>Il tirocinio ha migliorato la formazione tecnico</td>
												<td><span>
														<label><input type="radio" value="1" name="pdt2">1</label> 
														<label><input type="radio" value="2" name="pdt2">2</label> 
														<label><input type="radio" value="3" name="pdt2" checked="checked">3</label> 
														<label><input type="radio" value="4" name="pdt2">4</label> 
														<label><input type="radio" value="5" name="pdt2">5</label> </span></td>

											</tr>
											<tr>
												<td>Il tirocinio ha migliorato le soft skill (capacità
													di relazionarsi, di lavorare in team, organizzarsi...)</td>
												<td><span>
														<label><input type="radio" value="1" name="pdt3">1</label> 
														<label><input type="radio" value="2" name="pdt3">2</label> 
														<label><input type="radio" value="3" name="pdt3" checked="checked">3</label> 
														<label><input type="radio" value="4" name="pdt3">4</label> 
														<label><input type="radio" value="5" name="pdt3">5</label> </span></td>
											</tr>
											<tr>
												<td>La durata del tirocinio è stata adeguata agli
													obiettivi del progetto</td>
												<td><span>
														<label><input type="radio" value="1" name="pdt4">1</label> 
														<label><input type="radio" value="2" name="pdt4">2</label> 
														<label><input type="radio" value="3" name="pdt4" checked="checked">3</label> 
														<label><input type="radio" value="4" name="pdt4">4</label> 
														<label><input type="radio" value="5" name="pdt4">5</label> </span></td>
											</tr>
											<tr>
												<td>Valutazione complessiva dell'esperienza</td>
												<td><span>
														<label><input type="radio" value="1" name="pdt5">1</label> 
														<label><input type="radio" value="2" name="pdt5">2</label> 
														<label><input type="radio" value="3" name="pdt5" checked="checked">3</label> 
														<label><input type="radio" value="4" name="pdt5">4</label> 
														<label><input type="radio" value="5" name="pdt5">5</label> </span></td>
											</tr>
										<thead>
											<tr>
												<td><strong>Relativamente all'Ente Ospitante:</strong></td>
											</tr>
										</thead>
											<tr>
												<td>Mansioni assegnate</td>
												<td><span>
														<label><input type="radio" value="1" name="eo1">1</label> 
														<label><input type="radio" value="2" name="eo1">2</label> 
														<label><input type="radio" value="3" name="eo1" checked="checked">3</label> 
														<label><input type="radio" value="4" name="eo1">4</label> 
														<label><input type="radio" value="5" name="eo1">5</label> </span></td>
											</tr>
											<tr>
												<td>Ambiente di lavoro</td>
												<td><span>
														<label><input type="radio" value="1" name="eo2">1</label> 
														<label><input type="radio" value="2" name="eo2">2</label> 
														<label><input type="radio" value="3" name="eo2" checked="checked">3</label> 
														<label><input type="radio" value="4" name="eo2">4</label> 
														<label><input type="radio" value="5" name="eo2">5</label> </span></td>
											</tr>
											<tr>
												<td>Competenze tecniche presenti</td>
												<td><span>
														<label><input type="radio" value="1" name="eo3">1</label> 
														<label><input type="radio" value="2" name="eo3">2</label> 
														<label><input type="radio" value="3" name="eo3" checked="checked">3</label> 
														<label><input type="radio" value="4" name="eo3">4</label> 
														<label><input type="radio" value="5" name="eo3">5</label> </span></td>
											</tr>
											<tr>
												<td>Logistica e supporto strumentale</td>
												<td><span>
														<label><input type="radio" value="1" name="eo4">1</label> 
														<label><input type="radio" value="2" name="eo4">2</label> 
														<label><input type="radio" value="3" name="eo4" checked="checked">3</label> 
														<label><input type="radio" value="4" name="eo4">4</label> 
														<label><input type="radio" value="5" name="eo4">5</label> </span></td>
											</tr>
											<tr>
												<td>Assistenza del tutor Ente Ospitante</td>
												<td><span>
														<label><input type="radio" value="1" name="eo5">1</label> 
														<label><input type="radio" value="2" name="eo5">2</label> 
														<label><input type="radio" value="3" name="eo5" checked="checked">3</label> 
														<label><input type="radio" value="4" name="eo5">4</label> 
														<label><input type="radio" value="5" name="eo5">5</label> </span></td>
											</tr>
										<thead>
											<tr>
												<td><strong>Relativamente alle strutture
														universitarie addette alla gestione dei Tirocini:</strong></td>
											</tr>
										</thead>
											<tr>
												<td>Hanno fornito informazioni chiare ed esaustive</td>
												<td><span>
														<label><input type="radio" value="1" name="su1">1</label> 
														<label><input type="radio" value="2" name="su1">2</label> 
														<label><input type="radio" value="3" name="su1" checked="checked">3</label> 
														<label><input type="radio" value="4" name="su1">4</label> 
														<label><input type="radio" value="5" name="su1">5</label> </span></td>
											</tr>
											<tr>
												<td>Hanno fornito assistenza e disponibilità </td>
												<td><span>
														<label><input type="radio" value="1" name="su2">1</label> 
														<label><input type="radio" value="2" name="su2">2</label> 
														<label><input type="radio" value="3" name="su2" checked="checked">3</label> 
														<label><input type="radio" value="4" name="su2">4</label> 
														<label><input type="radio" value="5" name="su2">5</label> </span></td>
											</tr>
											<tr>
												<td>I servizi/informazioni fornite via Web sono
													esaustivi</td>
												<td><span>
														<label><input type="radio" value="1" name="su3">1</label> 
														<label><input type="radio" value="2" name="su3">2</label> 
														<label><input type="radio" value="3" name="su3" checked="checked">3</label> 
														<label><input type="radio" value="4" name="su3">4</label> 
														<label><input type="radio" value="5" name="su3">5</label> </span></td>
											</tr>
										</tbody>
									</table>
									<input type="submit" value="Conferma Questionario"
										id="Conferma">
								</form>

							</div>
						</div>
						<!-- end widget content -->

					</div>
					<!-- end widget div -->					
					
					
					<%
						}
					%>

				</article>
			</div>
			<!-- end row -->

		</div>
		<!-- END MAIN CONTENT -->
	</div>
	<!-- END MAIN PANEL -->
	<jsp:include page="footer.jsp" />
</body>
</html>