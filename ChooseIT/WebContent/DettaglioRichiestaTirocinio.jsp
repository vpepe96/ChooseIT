<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="it.chooseit.bean.*, it.chooseit.impl.*, it.chooseit.dao.*, it.chooseit.services.ConvertEnum"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<!--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">-->

		<title> ChooseIT | Dettaglio richiesta tirocinio </title>
		<meta name="description" content="Dettaglio richiesta tirocinio">
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
			StatoRichiestaDAO statoRichiestaDao = new StatoRichiesta();
			String ruoloUtente = (String) session.getAttribute("ruolo");
			RichiestaTirocinioBean richiesta = (RichiestaTirocinioBean) session.getAttribute("richiesta");
			StatoRichiestaBean statoRichiesta = statoRichiestaDao.getStatoRichiesta(richiesta);
	
			ConvertEnum convert = new ConvertEnum();
		 	String stato = convert.convertStatoRichiestaString(statoRichiesta.getTipo());
		 	System.out.println("STATO RICHIESTA"+stato);

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
		<!-- MAIN PANEL -->
		<div id="main" role="main">

			<!-- RIBBON -->
			<div id="ribbon">

				<!-- breadcrumb -->
				<ol class="breadcrumb">
					<li>Home</li><li>Lista richieste tirocinio</li><li>Dettaglio richiesta tirocinio</li>
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
							<%
								//Pagina per lo studente
								if(ruoloUtente.equals("studente")){
									
							%>	
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
																<span class="semi-bold">Dettaglio richiesta tirocinio</span><br>
															</h1>
		
															<ul class="list-unstyled">
																<li>
																	<p class="text-muted">
																		<i class="fa fa-fw fa-calendar"></i>&nbsp;&nbsp;<i class="txt-color-darken">Data:</i>&nbsp;&nbsp;<span class="txt-color-darken"><%=richiesta.getDataRichiesta() %></span>
																	</p>
																</li>
																<li>
																	<p class="text-muted">
																		<i class="glyphicon glyphicon-stats"></i>&nbsp;&nbsp;<i class="txt-color-darken">Stato:</i>&nbsp;&nbsp;<span class="txt-color-darken"><%=statoRichiesta.getTipo().toString() %></span>
																	</p>
																</li>
																<%
																	if(richiesta.getTutorUniversitario() == null){
																%>
																<li>
																	<p class="text-muted">
																		<i class="fa fa-fw fa-user"></i>&nbsp;&nbsp;<i class="txt-color-darken">Tutor Universitario:</i>&nbsp;&nbsp;<span class="txt-color-darken"></span>
																	</p>
																</li>
																<%
																	}
																	else
																	{
																%>
																<li>
																	<p class="text-muted">
																		<i class="fa fa-fw fa-user"></i>&nbsp;&nbsp;<i class="txt-color-darken">Tutor Universitario:</i>&nbsp;&nbsp;<span class="txt-color-darken"><%=richiesta.getTutorUniversitario().getEmail() %></span>
																	</p>
																</li>
																<%
																	}
																	if(richiesta.getTutorUniversitario() == null){
																%>
																<li>
																	<p class="text-muted">
																		<i class="fa fa-fw fa-user"></i>&nbsp;&nbsp;<i class="txt-color-darken">Tutor Aziendale:</i>&nbsp;&nbsp;<span class="txt-color-darken"></span>
																	</p>
																</li>
																<%
																	}
																	else
																	{
																%>
																<li>
																	<p class="text-muted">
																		<i class="fa fa-fw fa-user"></i>&nbsp;&nbsp;<i class="txt-color-darken">Tutor Aziendale:</i>&nbsp;&nbsp;<span class="txt-color-darken"><%=richiesta.getTutorAziendale().getEmail() %></span>
																	</p>
																</li>
																<%
																	}
																%>
																<li>
																	<p class="text-muted">
																		<i class="fa fa-map-marker"></i>&nbsp;&nbsp;<i class="txt-color-darken">Azienda:</i>&nbsp;&nbsp;<span class="txt-color-darken"><%=richiesta.getAzienda().getRagioneSociale() %></span>
																	</p>
																</li>
																<li>
																	<p class="text-muted">
																		<i class="fa fa-file-pdf-o"></i>&nbsp;&nbsp;<span class="txt-color-darken"><i>Progetto formativo:</i>&nbsp;&nbsp;</span>
																		
																		<%
																		String DownloadPFUrl = response.encodeURL("DownloadProgettoFormativoServlet");
																		System.out.println(richiesta.getAzienda().getProgettoFormativo());
																		%>
																		
																		<form  id="form_modifica_profilo" name="form_download_pf" method="post" action="<%=DownloadPFUrl%>" class="smart-form client-form">
																		<span> <input type="hidden" name="progetto_formativo" id="progetto_formativo" value="<%=richiesta.getProgettoFormativo() %>">
																		<button type="submit" class="btn btn-primary">Download</button></span>
																	</form>
																	
																
																</li>
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

																		String urlReturn = response.encodeURL("ListaRichiesteTirocinioServlet");
																%>
																<div class="padding-gutter">
																	<form id="form_upload_pf"
															name="form_upload_pf" method="post"
															action="<%=urlReturn %>" class="smart-form client-form"
															enctype="multipart/form-data">													
															<button type="submit" class="btn btn-primary">
														 		<span class="btn-label" style="margin-right: 5px; left: 0px;">
														  		<i class="glyphicon glyphicon-share-alt"></i>
														 		</span>Indietro
															</button>
														</form>
																</div>
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
									
								</div>
								<%
									}
								//Pagina per segerteria
								else if(ruoloUtente.equals("segreteria")){
							%>	
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
															<img src="img/avatars/sunny-big.png" alt="demo user">
														</div>
						
														<div class="col-sm-6">
															<h1>
																<span class="semi-bold">Dettaglio richiesta tirocinio</span><br>
															</h1>
		
															<ul class="list-unstyled">
																<li>
																	<p class="text-muted">
																		<i class="fa fa-fw fa-user"></i>&nbsp;&nbsp;<i class="txt-color-darken">Studente:</i>&nbsp;&nbsp;<span class="txt-color-darken"><%=richiesta.getStudente().getEmail() %></span>
																	</p>
																</li>
																<li>
																	<p class="text-muted">
																		<i class="fa fa-fw fa-calendar"></i>&nbsp;&nbsp;<i class="txt-color-darken">Data:</i>&nbsp;&nbsp;<span class="txt-color-darken"><%=richiesta.getDataRichiesta() %></span>
																	</p>
																</li>
																<li>
																	<p class="text-muted">
																		<i class="glyphicon glyphicon-stats"></i>&nbsp;&nbsp;<i class="txt-color-darken">Stato:</i>&nbsp;&nbsp;<span class="txt-color-darken"><%=statoRichiesta.getTipo().toString()%></span>
																	</p>
																</li>
																<%
																	if(richiesta.getTutorUniversitario() == null){
																%>
																<li>
																	<p class="text-muted">
																		<i class="fa fa-fw fa-user"></i>&nbsp;&nbsp;<i class="txt-color-darken">Tutor Universitario:</i>&nbsp;&nbsp;<span class="txt-color-darken"> </span>
																	</p>
																</li>
																<%
																	}
																	else{
																%>
																<li>
																	<p class="text-muted">
																		<i class="fa fa-fw fa-user"></i>&nbsp;&nbsp;<i class="txt-color-darken">Tutor Universitario:</i>&nbsp;&nbsp;<span class="txt-color-darken"><%=richiesta.getTutorUniversitario().getEmail() %></span>
																	</p>
																</li>
																<%
																	}
																	if(richiesta.getTutorAziendale() == null){
																%>
																<li>
																	<p class="text-muted">
																		<i class="fa fa-fw fa-user"></i>&nbsp;&nbsp;<i class="txt-color-darken">Tutor Aziendale:</i>&nbsp;&nbsp;<span class="txt-color-darken"> </span>
																	</p>
																</li>
																<%
																	}
																	else{
																%>
																<li>
																	<p class="text-muted">
																		<i class="fa fa-fw fa-user"></i>&nbsp;&nbsp;<i class="txt-color-darken">Tutor Aziendale:</i>&nbsp;&nbsp;<span class="txt-color-darken"><%=richiesta.getTutorAziendale().getEmail() %></span>
																	</p>
																</li>
																<%
																	}
																%>
																<li>
																	<p class="text-muted">
																		<i class="fa fa-map-marker"></i>&nbsp;&nbsp;<i class="txt-color-darken">Azienda:</i>&nbsp;&nbsp;<span class="txt-color-darken"><%=richiesta.getAzienda().getRagioneSociale() %></span>
																	</p>
																</li>
																<li>
																	<p class="text-muted">
																		<i class="fa fa-file-pdf-o"></i>&nbsp;&nbsp;<span class="txt-color-darken"><i>Progetto formativo:</i>&nbsp;&nbsp;</span>
																		
																		<%
																		String DownloadPFUrl = response.encodeURL("DownloadProgettoFormativoServlet");
																		System.out.println(richiesta.getAzienda().getProgettoFormativo());
																		%>
																		
																		<form  id="form_modifica_profilo" name="form_download_pf" method="post" action="<%=DownloadPFUrl%>" class="smart-form client-form">
																		 <input type="hidden" name="progetto_formativo" id="progetto_formativo" value="<%=richiesta.getProgettoFormativo() %>">
																		<button type="submit" class="btn btn-primary">Download</button>
																	</form>
																	
																
																</li>
															</ul>
															<br>
														</div>
														<div class="col-sm-3">
															
														</div>
				
													</div>
				
												</div>
				
											</div>
											<hr>
											<div class="row">
				
												<div class="col-sm-12">

													<div class="padding-gutter">
				
														<div class="tab-content padding-top-10">
															<div class="tab-pane fade in active" id="a1">
																<div class="padding-gutter">
															
															<%
															if(stato.equalsIgnoreCase("nuova")){
																String urlValutazioneIniziale = response.encodeURL("ValutazioneInizialeRichiestaTirocinioServlet");
															%>
															<form id="form_upload_pf"
															name="form_upload_pf" method="post"
															action="<%=urlValutazioneIniziale %>" class="smart-form client-form"
															enctype="multipart/form-data">
															
															<section>
																<label class="label">Progetto formativo compilato:</label> <label class="input"><i class="icon-append fa fa-file-pdf-o"></i> 
																<input type="file" name="progettoFormativo" id="progettoFormativo" 
																	value=""  accept=".pdf" onchange="controlla_estensione(document.getElementById('progettoFormativo').value);"  required>
																</label>
															</section>
															
															<section>
																<label class="label">Seleziona tutor universitario:</label>
																<select class="form-control" id="email_tutor_universitario" name="email_tutor_universitario">
																<%
																TutorUniversitarioDAO tutorUniversitarioDao = new TutorUniversitario();
																Collection<TutorUniversitarioBean> tutorUniversitari = tutorUniversitarioDao.retrieveAll(null);
																TutorUniversitarioBean tutorUniversitario = new TutorUniversitarioBean();
																Iterator<?> it = tutorUniversitari.iterator();
																while (it.hasNext()) {
																	tutorUniversitario = (TutorUniversitarioBean) it.next();
																%>
																	<option value="<%=tutorUniversitario.getEmail()%>">
																		<%=tutorUniversitario.getNome() + " " + tutorUniversitario.getCognome()%>
																	</option>
																<%
																	}
																%>
																</select>
															</section>
															
															<section>
																<label class="label">Seleziona tutor aziendale:</label>
																<select class="form-control" id="email_tutor_aziendale" name="email_tutor_aziendale">
																<%
																TutorAziendaleDAO tutorAziendaleDao = new TutorAziendale();
																Collection<TutorAziendaleBean> tutorAziendali = tutorAziendaleDao.getTutorDiAzienda(richiesta.getAzienda());
																TutorAziendaleBean tutorAziendale = new TutorAziendaleBean();
																Iterator<?> it2 = tutorAziendali.iterator();
																while (it2.hasNext()) {
																	tutorAziendale = (TutorAziendaleBean) it2.next();
																%>
																	<option value="<%=tutorAziendale.getEmail()%>">
																		<%=tutorAziendale.getNome() + " " + tutorAziendale.getCognome()%>
																	</option>
																<%
																	}
																%>
																</select>
															</section>
															
															<section>			
																<label class="label">Valuta la richiesta:</label>
																<select class="form-control" id="scelta" name="scelta">
																	<option value="rifiutata">Rifiuta</option>
																	<option value="inValidazione">In Validazione</option>
																</select>
															</section>
																													
															<section>
																<button type="submit" name="submit" value="submit" class="btn btn-primary" style="width:70px; " onclick="controllaProgettoFormativo()">
														 			<span class="btn-label" style="margin-right: 5px; left: 0px;">
														  			<i class="glyphicon glyphicon-check"></i>
														 			</span>OK
																</button>
															</section>
															</form>
															<%
															}
																	else if(stato.equalsIgnoreCase("invalidazione")){
																			String urlValutazioneFinale = response.encodeURL("ValutazioneFinaleRichiestaTirocinioServlet");
																%>
															<form id="form_upload_pf"
															name="form_upload_pf" method="post"
															action="<%=urlValutazioneFinale %>" class="smart-form client-form"
															enctype="multipart/form-data">
															
															<section>
																<label class="label">Progetto formativo compilato:</label> <label class="input"><i class="icon-append fa fa-file-pdf-o"></i> 
																<input type="file"
																	name="progettoFormativo" id="progettoFormativo" 
																	value=""  accept=".pdf" onchange="controlla_estensione(document.getElementById('progettoFormativo').value);"  required>
																</label>
															</section>
															
															<section>			
																<label class="label">Valuta la richiesta:</label>
																<select class="form-control" id="scelta" name="scelta">
																	<option value="rifiutata">Rifiuta</option>
																	<option value="inConvalida">In Convalida</option> 
																</select>
															</section>
															
															<section>
																<button type="submit" name="submit" value="submit" class="btn btn-primary" style="width:70px; " onclick="controllaProgettoFormativo()">
														 			<span class="btn-label" style="margin-right: 5px; left: 0px;">
														  			<i class="glyphicon glyphicon-check"></i>
														 			</span>OK
																</button>
															</section>
															
															</form>
															<%
																	}
															%>
														
																</div>
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
									
								</div>
								<%
									}
								//Pagina per presidente
								else if(ruoloUtente.equals("presidente")){
							%>	
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
															<img src="img/avatars/sunny-big.png" alt="demo user">
														</div>
						
														<div class="col-sm-6">
															<h1>
																<span class="semi-bold">Dettaglio richiesta tirocinio</span><br>
															</h1>
		
															<ul class="list-unstyled">
																<li>
																	<p class="text-muted">
																		<i class="fa fa-fw fa-user"></i>&nbsp;&nbsp;<i class="txt-color-darken">Studente:</i>&nbsp;&nbsp;<span class="txt-color-darken"><%=richiesta.getStudente().getEmail() %></span>
																	</p>
																</li>
																<li>
																	<p class="text-muted">
																		<i class="fa fa-fw fa-calendar"></i>&nbsp;&nbsp;<i class="txt-color-darken">Data:</i>&nbsp;&nbsp;<span class="txt-color-darken"><%=richiesta.getDataRichiesta() %></span>
																	</p>
																</li>
																<li>
																	<p class="text-muted">
																		<i class="glyphicon glyphicon-stats"></i>&nbsp;&nbsp;<i class="txt-color-darken">Stato:</i>&nbsp;&nbsp;<span class="txt-color-darken"><%=statoRichiesta.getTipo().toString() %></span>
																	</p>
																</li>
																<%
																	if(richiesta.getTutorUniversitario() == null){
																%>
																<li>
																	<p class="text-muted">
																		<i class="fa fa-fw fa-user"></i>&nbsp;&nbsp;<i class="txt-color-darken">Tutor Universitario:</i>&nbsp;&nbsp;<span class="txt-color-darken"> </span>
																	</p>
																</li>
																<%
																	}
																	else{
																%>
																<li>
																	<p class="text-muted">
																		<i class="fa fa-fw fa-user"></i>&nbsp;&nbsp;<i class="txt-color-darken">Tutor Universitario:</i>&nbsp;&nbsp;<span class="txt-color-darken"><%=richiesta.getTutorUniversitario().getEmail() %></span>
																	</p>
																</li>
																<%
																	}
																	if(richiesta.getTutorAziendale() == null){
																%>
																<li>
																	<p class="text-muted">
																		<i class="fa fa-fw fa-user"></i>&nbsp;&nbsp;<i class="txt-color-darken">Tutor Aziendale:</i>&nbsp;&nbsp;<span class="txt-color-darken"> </span>
																	</p>
																</li>
																<%
																	}
																	else{
																%>
																<li>
																	<p class="text-muted">
																		<i class="fa fa-fw fa-user"></i>&nbsp;&nbsp;<i class="txt-color-darken">Tutor Aziendale:</i>&nbsp;&nbsp;<span class="txt-color-darken"><%=richiesta.getTutorAziendale().getEmail() %></span>
																	</p>
																</li>
																<%
																	}
																%>
																<li>
																	<p class="text-muted">
																		<i class="fa fa-map-marker"></i>&nbsp;&nbsp;<i class="txt-color-darken">Azienda:</i>&nbsp;&nbsp;<span class="txt-color-darken"><%=richiesta.getAzienda().getRagioneSociale() %></span>
																	</p>
																</li>
																<li>
																	<p class="text-muted">
																		<i class="fa fa-file-pdf-o"></i>&nbsp;&nbsp;<span class="txt-color-darken"><i>Progetto formativo:</i>&nbsp;&nbsp;</span>
																		
																		<%
																		String DownloadPFUrl = response.encodeURL("DownloadProgettoFormativoServlet");
																		System.out.println(richiesta.getAzienda().getProgettoFormativo());
																		%>
																		
																		<form  id="form_modifica_profilo" name="form_download_pf" method="post" action="<%=DownloadPFUrl%>" class="smart-form client-form">
																		 <input type="hidden" name="progetto_formativo" id="progetto_formativo" value="<%=richiesta.getProgettoFormativo() %>">
																		<button type="submit" class="btn btn-primary">Download</button>
																	</form>
																	
																
																</li>
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
															<div class="padding-gutter">
																<%
																	if(stato.equalsIgnoreCase("inconvalida")){
																		String urlConvalida = response.encodeURL("ConvalidaRichiestaTirocinioServlet");
																%>
																	<form id="form_upload_pf"
															name="form_upload_pf" method="post"
															action="<%=urlConvalida %>" class="smart-form client-form"
															enctype="multipart/form-data">
															
															<section>
																<label class="label">Progetto formativo compilato:</label> <label class="input"><i class="icon-append fa fa-file-pdf-o"></i> 
																<input type="file" name="progettoFormativo" id="progettoFormativo" 
																	value=""  accept=".pdf" onchange="controlla_estensione(document.getElementById('progettoFormativo').value);"  required>
																</label>
															</section>
															
															<section>			
																<label class="label">Valuta la richiesta:</label>
																<select class="form-control" id="scelta" name="scelta">
																	<option value="rifiutata">Rifiuta</option>
																	<option value="accettata">Accetta</option>
																</select>
															</section>
															
															<section>
																<button type="submit" name="submit" value="submit" class="btn btn-primary" style="width:70px; " onclick="controllaProgettoFormativo()">
														 			<span class="btn-label" style="margin-right: 5px; left: 0px;">
														  			<i class="glyphicon glyphicon-check"></i>
														 			</span>OK
																</button>
															</section>
															
															</form>
															<%
																	}
															%>
																</div>
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
									
								</div>
								<%
									}
								%>
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
		function controllaProgettoFormativo(){
			var progettoFormativo = document.form_upload_pf.progettoFormativo.value;
			
			if(progettoFormativo == ""){
				window.alert("Inserisci un file per il progetto formativo");
				return;
			}
			else {
				window.alert("Valutazione effettuata con successo");
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