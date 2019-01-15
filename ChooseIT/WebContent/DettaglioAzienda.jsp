<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="it.chooseit.bean.*, it.chooseit.impl.*, it.chooseit.dao.*"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<!--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">-->

		<title> ChooseIT | Dettaglio azienda </title>
		<meta name="description" content="Dettaglio azienda">
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
		<%@
			include file = "navbar.jsp"
		%>
		<%
			if (request.getSession().getAttribute("progettoFormativoBoolean") != null) {
			boolean progettoFormativoBoolean = (boolean) request.getSession().getAttribute("progettoFormativoBoolean");
			System.out.println(progettoFormativoBoolean);
			request.getSession().removeAttribute("progettoFormativoBoolean");
			if (!progettoFormativoBoolean) {
		%>
		<script type="text/javascript">
			alert("ERRORE.\nImpossibile recuperare il progetto formativo.");
		</script>
		<%
			}
				request.getSession().removeAttribute("progettoFormativoBoolean");
			}
		%>
			
			
		<%
			AziendaBean azienda = (AziendaBean) request.getSession().getAttribute("azienda");
		%>

		<!-- MAIN PANEL -->
		<div id="main" role="main">

			<!-- RIBBON -->
			<div id="ribbon">

				<!-- breadcrumb -->
				<ol class="breadcrumb">
					<li>Home</li><li>Lista aziende</li><li><%=azienda.getRagioneSociale() %></li>
				</ol>
				<!-- end breadcrumb -->

			</div>
			<!-- END RIBBON -->

			<!-- MAIN CONTENT -->
			<div id="content">

				<!-- Bread crumb is created dynamically -->
				<!-- row -->
				<div class="row">
				
				</div>
				<!-- end row -->
				
				<!-- row -->
				<div class="row">
				
					<div class="col-sm-12">
				
				
							<div class="well well-sm">
				
								<div class="row">
				
									<div class="col-sm-12 col-md-12 col-lg-6">
										<div class="well well-light well-sm no-margin no-padding">
				
											<div class="row">
				
												<div class="col-sm-12">
													<div id="myCarousel" class="carousel fade profile-carousel">
														<div class="carousel-inner">
															<!-- Slide 1 -->
															<div class="">
																<img src="img/demo/s1.jpg" alt="demo user">
															</div>
														</div>
													</div>
												</div>
				
												<div class="col-sm-12">
				
													<div class="row">
				
														<div class="col-sm-3 profile-pic">
														</div>
														<div class="col-sm-6">
															<h1>
																<span class="semi-bold"><%=azienda.getRagioneSociale() %></span><br>
															</h1>
		
															<ul class="list-unstyled">
																<li>
																	<p class="text-muted">
																		<i class="fa fa-map-marker"></i>&nbsp;&nbsp;<i class="txt-color-darken">Sede legale:</i>&nbsp;&nbsp;<span class="txt-color-darken"><%=azienda.getSedeLegale() %></span>
																	</p>
																</li>
																<li>
																	<p class="text-muted">
																		<i class="fa fa-map-marker"></i>&nbsp;&nbsp;<i class="txt-color-darken">Sede operativa:</i>&nbsp;&nbsp;<span class="txt-color-darken"><%=azienda.getSedeOperativa() %></span>
																	</p>
																</li>
																<li>
																	<p class="text-muted">
																		<i class="fa fa-file-pdf-o"></i>&nbsp;&nbsp;<span class="txt-color-darken"><i>Progetto formativo:</i>&nbsp;&nbsp;</span>
																		
																		<%
																		String DownloadPFUrl = response.encodeURL("DownloadProgettoFormativoServlet");
																		System.out.println(azienda.getProgettoFormativo());
																		%>
																		
																		<form  id="form_modifica_profilo" name="form_download_pf" method="post" action="<%=DownloadPFUrl%>" class="smart-form client-form">
																		 <input type="hidden" name="progetto_formativo" id="progetto_formativo" value="<%=azienda.getProgettoFormativo() %>">
																		<button type="submit" class="btn btn-primary">Download</button>
																	</form>
																	
																
																</li>
																
																<br>
																<%
																	String ruoloUtente = (String) session.getAttribute("ruolo");
																	if(ruoloUtente.equals("segreteria")){
																%>
																<li>
																	<button type="button" class="btn btn-labeled btn-default" onclick="displayForm()">
														 				<span class="btn-label">
														  					<i class="glyphicon glyphicon-chevron-right"></i>
														 				</span>Modifica azienda
																	</button>
																</li>
																<%
																	}
																%>
															</ul>
															<br>
														</div>
														<div class="col-sm-3">
															
														</div>
				
													</div>
				
												</div>
				
											</div>
				
											<div class="row">
				
												<div class="col-sm-12">
				
													<hr>
				
													<div class="padding-gutter">
													
														<div class="tab-content padding-top-10">
										
															<div class="tab-pane fade in active" id="a1">
																<%
																	if(ruoloUtente.equals("studente")){
																		StudenteBean studente = (StudenteBean) request.getSession().getAttribute("utente");
																		RichiestaTirocinioDAO richiestaTirocinioDao = new RichiestaTirocinio();
																		RichiestaTirocinioBean richiestaTirocinio = new RichiestaTirocinioBean();
																		Collection<RichiestaTirocinioBean> richieste = richiestaTirocinioDao.getRichiestePerStudente(studente);
																		StatoRichiestaDAO statoRichiestaDao  = new StatoRichiesta();
																		StatoRichiestaBean statoRichiesta = new StatoRichiestaBean();
																		
																		int numRichiesteTot = richieste.size();
																		int numRichiesteAcc = 0;
																		int numRichiesteRif = 0;
																		int numRichiesteAlt = 0;
																		
																		Iterator<?> it = richieste.iterator();
																		while(it.hasNext()){
																			richiestaTirocinio = (RichiestaTirocinioBean) it.next();
																			numRichiesteTot++;
																			statoRichiesta = statoRichiestaDao.getStatoRichiesta(richiestaTirocinio);
																			if(statoRichiesta.getTipo().toString().equalsIgnoreCase("accettata"))
																				numRichiesteAcc++;
																			else if(statoRichiesta.getTipo().toString().equalsIgnoreCase("rifiutata"))
																				numRichiesteRif++;
																			else if(statoRichiesta.getTipo().toString().equalsIgnoreCase("nuova") ||statoRichiesta.getTipo().toString().equalsIgnoreCase("invalidazione") || statoRichiesta.getTipo().toString().equalsIgnoreCase("inconvalida"))
																				numRichiesteAlt++;
																		}
																		
																		System.out.println("RICHIESTE TOT"+numRichiesteTot);
																		System.out.println("RICHIESTE ACC"+numRichiesteAcc);
																		System.out.println("RICHIESTE RIF"+numRichiesteRif);
																		System.out.println("RICHIESTE ALTRO STATO"+numRichiesteAlt);
																		
																																	
																		String urlInviaRichiesta;
																		if(numRichiesteTot == 1 && numRichiesteAlt == 1)
																			urlInviaRichiesta = response.encodeURL("ListaRichiesteTirocinioServlet");
																		else if(numRichiesteTot >= 2 && numRichiesteAcc == 2)
																			urlInviaRichiesta = response.encodeURL("ListaRichiesteTirocinioServlet");																		
																		else if(numRichiesteTot >= 2 && numRichiesteAcc == 1 && numRichiesteRif == 0 && numRichiesteAlt == 1)
																			urlInviaRichiesta = response.encodeURL("ListaRichiesteTirocinioServlet");
																		else
																			urlInviaRichiesta = response.encodeURL("InviaRichiestaTirocinioServlet");
																%>
																<div class="padding-gutter">
																	<form id="form_upload_pf"
																		name="form_upload_pf" method="post"
																		action="<%=urlInviaRichiesta %>" class="smart-form client-form"
																		enctype="multipart/form-data">
																		<section>
																			<label class="label">Progetto formativo compilato:</label> <label class="input"><i class="icon-append fa fa-file-pdf-o"></i>
																			<input type="file" name="progettoFormativo" id="progettoFormativo" 
																	value=""  accept=".pdf" onchange="controlla_estensione(document.getElementById('progettoFormativo').value);"  required>
																			</label>
																		</section>
																		
																		<section>
																			<button type="submit" class="btn btn-labeled btn-primary" onclick="controllaRichieste(<%=numRichiesteTot%>,<%=numRichiesteAcc%>,<%=numRichiesteRif%>,<%=numRichiesteAlt%>)">
																				<span class="btn-label" style="margin-right: 5px; left: 0px;">
																					<i class="glyphicon glyphicon-share-alt"></i>
																				 </span>Invia richiesta
																			</button>
																		</section>
																		
																	</form>
																</div>
																<%
																	}
																%>
															</div>
															<div class="tab-pane fade" id="a2">
	
															</div><!-- end tab -->
														</div>
				
													</div>
				
												</div>
				
											</div>
											<!-- end row -->
				
										</div>
				
									</div>
									<div class="col-sm-12 col-md-12 col-lg-6">
										<%
											String urlAggiornaAzienda = response.encodeURL("AggiornaAziendaServlet");
										%>
										<form id="form_modifica_azienda" style="display: none"
											name="form_modifica_azienda" method="post"
											action="<%=urlAggiornaAzienda%>" class="smart-form client-form"
											enctype="multipart/form-data">
		
											<section>
												<label class="label">Nome</label> <label class="input">
													<i class="icon-append fa fa-user"></i> <input type="text" name="ragioneSociale" id="ragioneSociale" value="<%=azienda.getRagioneSociale()%>" readonly>
												</label>
											</section>
		
											<section>
												<label class="label">Sede legale</label> <label class="input">
													<i class="icon-append fa fa-user"></i> <input type="text" name="sedeLegale" id="sedeLegale" required="required" pattern="^[A-Za-z0-9,()\s]{3,60}" value="<%=azienda.getSedeLegale() %>">
												</label>
											</section>
	
											<section>
												<label class="label">Sede operativa</label> <label class="input">
													<i class="icon-append fa fa-user"></i> <input type="text" name="sedeOperativa" id="sedeOperativa" required="required" pattern="^[A-Za-z0-9,()\s]{3,60}" value="<%=azienda.getSedeOperativa() %>">
												</label>
											</section>
		
											<section>
												<label class="label">Progetto formativo</label> <label class="input"> <i class="fa">
													</i> <input type="file" name="progettoFormativo" id="progettoFormativo" accept=".pdf" value="<%=azienda.getProgettoFormativo() %>">
												</label>
											</section>
			
											<button type="submit" class="btn btn-labeled btn-success">
												 <span class="btn-label" style="margin-right: 5px; left: 0px;">
												 	<i class="glyphicon glyphicon-ok"></i>
												 </span>Conferma
											</button>
											
										</form>
										
									</div>
								</div>
				
							</div>
				
				
					</div>
				
				</div>
				
				<!-- end row -->

			</div>
			<!-- END MAIN CONTENT -->

		</div>
		<!-- END MAIN PANEL -->

		<!-- PAGE FOOTER -->
			<%@
				include file = "footer.jsp"
			%>
		<!-- END PAGE FOOTER -->

		<!--================================================== -->

		<script type="text/javascript">
		function displayForm(){
				$("#form_upload_pf").fadeIn();
		}
		
		</script>
		
		<script type="text/javascript">
		function displayForm(){
				$("#form_modifica_azienda").fadeIn();
		}
		
		</script>
		
		<script type="text/javascript">
		function controllaRichieste(numRichiesteTot, numRichiesteAcc, numRichiesteRif, numRichiesteAlt){
			var progettoFormativo = document.form_upload_pf.progettoFormativo.value;
			
			if(progettoFormativo == ""){
				window.alert("Inserisci un file per il progetto formativo");
				return;
			}
			
			if(numRichiesteTot == 1 && numRichiesteAlt == 1){
				window.alert("Impossibile inviare la richiesta, una richiesta è ancora in attesa di completamento");
			}
			else if(numRichiesteTot >= 2 && numRichiesteAcc == 2){
				window.alert("Impossibile inviare la richiesta, effettuato numero massimo di richieste consentite");
			}
			else if(numRichiesteTot >= 2 && numRichiesteAcc == 1 && numRichiesteRif == 0 && numRichiesteAlt == 1){
				window.alert("Impossibile inviare la richiesta, una richiesta è ancora in attesa di completamento");
			}
			else {
				window.alert("Richiesta inviata con successo");
			}
		}
		</script>
		
		<script>
		function get_estensione(path) {
			posizione_punto = path.lastIndexOf(".");
			lunghezza_stringa = path.length;
			estensione = path.substring(posizione_punto + 1, lunghezza_stringa);
			return estensione;
		}

		function controlla_estensione(path) {
			if (get_estensione(path) != "pdf") {
				document.getElementById("progettoFormativo").value = "";
				alert("Il file deve essere in formato pdf");
			}
		}
		</script>

		<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)-->
		<script data-pace-options='{ "restartOnRequestAfter": true }' src="js/plugin/pace/pace.min.js"></script>

		<!-- JS TOUCH : include this plugin for mobile drag / drop touch events-->
		<script src="js/plugin/jquery-touch/jquery.ui.touch-punch.min.js"></script> 

		<!-- CUSTOM NOTIFICATION -->
		<script src="js/notification/SmartNotification.min.js"></script>

		<!-- JARVIS WIDGETS -->
		<script src="js/smartwidgets/jarvis.widget.min.js"></script>

		<!-- EASY PIE CHARTS -->
		<script src="js/plugin/easy-pie-chart/jquery.easy-pie-chart.min.js"></script>

		<!-- SPARKLINES -->
		<script src="js/plugin/sparkline/jquery.sparkline.min.js"></script>

		<!-- JQUERY VALIDATE -->
		<script src="js/plugin/jquery-validate/jquery.validate.min.js"></script>

		<!-- JQUERY MASKED INPUT -->
		<script src="js/plugin/masked-input/jquery.maskedinput.min.js"></script>

		<!-- JQUERY SELECT2 INPUT -->
		<script src="js/plugin/select2/select2.min.js"></script>

		<!-- JQUERY UI + Bootstrap Slider -->
		<script src="js/plugin/bootstrap-slider/bootstrap-slider.min.js"></script>

		<!-- browser msie issue fix -->
		<script src="js/plugin/msie-fix/jquery.mb.browser.min.js"></script>

		<!-- FastClick: For mobile devices -->
		<script src="js/plugin/fastclick/fastclick.min.js"></script>

		<!-- ENHANCEMENT PLUGINS : NOT A REQUIREMENT -->
		<!-- Voice command : plugin -->
		<script src="js/speech/voicecommand.min.js"></script>

		<!-- SmartChat UI : plugin -->
		<script src="js/smart-chat-ui/smart.chat.ui.min.js"></script>
		<script src="js/smart-chat-ui/smart.chat.manager.min.js"></script>

		<!-- PAGE RELATED PLUGIN(S) 
		<script src="..."></script>-->

		<script>
		
		// DO NOT REMOVE : GLOBAL FUNCTIONS!
		
		$(document).ready(function() {
			
			pageSetUp();
		
		})

		</script>
	</body>
</html>