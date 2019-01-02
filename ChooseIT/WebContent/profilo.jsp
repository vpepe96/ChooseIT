
<%@page import="it.chooseit.bean.*"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en-us">
	<head>
		<meta charset="utf-8">
		<!--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">-->

		<title> ChooseIT - Profilo</title>
		<meta name="description" content="">
		<meta name="author" content="">
			
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<!-- Basic Styles -->
		<link rel="stylesheet" type="text/css" media="screen" href="css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" media="screen" href="css/font-awesome.min.css">

		<!-- SmartAdmin Styles : Caution! DO NOT change the order -->
		<link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-production-plugins.min.css">
		<link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-production.min.css">
		<!--  <link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-skins.min.css"> -->

		<!-- SmartAdmin RTL Support -->
		<link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-rtl.min.css"> 

		<!-- We recommend you use "your_style.css" to override SmartAdmin
		     specific styles this will also ensure you retrain your customization with each SmartAdmin update.
		<link rel="stylesheet" type="text/css" media="screen" href="css/your_style.css"> -->

		<!-- Demo purpose only: goes with demo.js, you can delete this css when designing your own WebApp -->
		<link rel="stylesheet" type="text/css" media="screen" href="css/demo.min.css">

		<!-- FAVICONS -->
		<link rel="shortcut icon" href="img/favicon/favicon.ico" type="image/x-icon">
		<link rel="icon" href="img/favicon/favicon.ico" type="image/x-icon">

		<!-- GOOGLE FONT -->
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,300,400,700">

		<!-- Specifying a Webpage Icon for Web Clip 
			 Ref: https://developer.apple.com/library/ios/documentation/AppleApplications/Reference/SafariWebContent/ConfiguringWebApplications/ConfiguringWebApplications.html -->
		<link rel="apple-touch-icon" href="img/splash/sptouch-icon-iphone.png">
		<link rel="apple-touch-icon" sizes="76x76" href="img/splash/touch-icon-ipad.png">
		<link rel="apple-touch-icon" sizes="120x120" href="img/splash/touch-icon-iphone-retina.png">
		<link rel="apple-touch-icon" sizes="152x152" href="img/splash/touch-icon-ipad-retina.png">

	</head>
	
	<!--

	TABLE OF CONTENTS.
	
	Use search to find needed section.
	
	===================================================================
	
	|  01. #CSS Links                |  all CSS links and file paths  |
	|  02. #FAVICONS                 |  Favicon links and file paths  |
	|  03. #GOOGLE FONT              |  Google font link              |
	|  04. #APP SCREEN / ICONS       |  app icons, screen backdrops   |
	|  05. #BODY                     |  body tag                      |
	|  06. #HEADER                   |  header tag                    |
	|  07. #PROJECTS                 |  project lists                 |
	|  08. #TOGGLE LAYOUT BUTTONS    |  layout buttons and actions    |
	|  09. #MOBILE                   |  mobile view dropdown          |
	|  10. #SEARCH                   |  search field                  |
	|  11. #NAVIGATION               |  left panel & navigation       |
	|  12. #RIGHT PANEL              |  right panel userlist          |
	|  13. #MAIN PANEL               |  main panel                    |
	|  14. #MAIN CONTENT             |  content holder                |
	|  15. #PAGE FOOTER              |  page footer                   |
	|  16. #SHORTCUT AREA            |  dropdown shortcuts area       |
	|  17. #PLUGINS                  |  all scripts and plugins       |
	
	===================================================================
	
	-->
	
	<!-- #BODY -->
	<!-- Possible Classes

		* 'smart-style-{SKIN#}'
		* 'smart-rtl'         - Switch theme mode to RTL
		* 'menu-on-top'       - Switch to top navigation (no DOM change required)
		* 'no-menu'			  - Hides the menu completely
		* 'hidden-menu'       - Hides the main menu but still accessable by hovering over left edge
		* 'fixed-header'      - Fixes the header
		* 'fixed-navigation'  - Fixes the main menu
		* 'fixed-ribbon'      - Fixes breadcrumb
		* 'fixed-page-footer' - Fixes footer
		* 'container'         - boxed layout mode (non-responsive: will not work with fixed-navigation & fixed-ribbon)
	-->
	<body class="">

		<%@ include file = "navbar.jsp" %>

		
		
				<%
					
					UtenteBean profilo= (UtenteBean) session.getAttribute("utente");
					String matricola="";
					String descrizione="";
					if(ruolo.equals("studente")){
						StudenteBean stud= (StudenteBean) session.getAttribute("utente");
						//Me li prendo così in quanto sono gli unici valori che lo studente possiede in più rispetto a un normale Utente
						descrizione=stud.getDescrizione();
						matricola=stud.getMatricola();
					}
				%>

		<!-- MAIN PANEL -->
		<div id="main" role="main">

			
			<!-- MAIN CONTENT -->
			<div id="content">

				<!-- Bread crumb is created dynamically -->
				
				
				<!-- row -->
				
				<div class="row">
				
					<div class="col-sm-12">
				
				
							<div class="well well-sm">
				
								<div class="row">
				
									<div class="col-sm-12 col-md-12 col-lg-6">
										<div class="well well-light well-sm no-margin no-padding">
				
											<div class="row">
				
												<div class="col-sm-12">
													
												</div>
				
												<div class="col-sm-12">
				
													<div class="row">
				
														<div class="col-sm-3 profile-pic">
														
															<% System.out.println("Tentativo: "+profilo.getFotoProfilo()); %>
															<img src=<%= profilo.getFotoProfilo() %>  alt="Immagine profilo">

														</div>
														
														
														
														
														
														<div class="col-sm-6">
															<h1><%=profilo.getNome() %> <%=profilo.getCognome() %> </h1>
				
															<ul class="list-unstyled">
																<%if(ruolo=="studente"){ %>
																<li>
																	<p> Matricola: </p>
																	<p class="text-muted"> <%=matricola %> </p>
																</li>
															
																<%} %>
															
															
																<li>
																	<p> Telefono: </p>
																	<p class="text-muted"> <%=profilo.getTelefono() %> </p>
																</li>
																<li>
																	<p>E-mail:</p>
																	<p class="text-muted"> <a href=<%="mailto:"+profilo.getEmail() %>><%=profilo.getEmail() %></a></p>
																</li>
																<br>
																
																<li>
																	<p>Data di nscita:</p>
																	<p class="text-muted"> <%=profilo.getDataNascita().toString() %></a></p>
																</li>
																<li>
																	<p>Indirizzo:</p>
																	<p class="text-muted"> <%=profilo.getIndirizzo() %></a></p>
																</li>
																<br>
																<%if(ruolo=="studente"){ %>
																<li>
																	<p> Descrizione: </p>
																	<p class="text-muted"> <%=descrizione %> </p>
																</li>
															
																<%} %>
																
															</ul>
															
															<br>
															<button class="button" style="vertical-align:middle" onclick="displayForm()"><span>Modifica Profilo</span></button>
															<br>
															<br>
				
														</div>
														
													</div>
				
												</div>
				
											</div>
				
											
															
														</div>
				
													</div>
				
												</div>
				
											</div>
											<!-- end row -->
											<%String ModificaProfiloUrl=response.encodeURL("ModificaProfiloServlet"); %>
												<form style="display:none" id="form_modifica_profilo" name="form_modifica_profilo" method="post" action="<%=ModificaProfiloUrl%>"  class="smart-form client-form" enctype="multipart/form-data" >
													
													<section>
														<label class="label">Telefono</label> <label class="input">
															<i class="icon-append fa fa-user"></i> <input type="text"
															name="telefono" id="telefono" 
															pattern="^[0-9]{10}$" value="<%=profilo.getTelefono() %>">
														</label>
													</section>


													<section>
														<label class="label">Indirizzo</label> <label class="input">
															<i class="icon-append fa fa-user"></i> <input type="text"
															name="indirizzo" id="indirizzo" 
															pattern="^[A-Za-z0-9,()\s]{3,60}" value= "<%=profilo.getIndirizzo() %>" >
														</label>
													</section>
														
													<%if(ruolo.equals("studente")) {%>
													<section>
														<label class="label">Descrizione</label> <label class="input">
															<i class="fa"></i> <textarea rows="4" cols="50" maxlength="300"
																name="descrizione" form="form-reg" value="<%=descrizione%>"></textarea>
														</label>
													</section>
	
													<%
														}
													%>

													<section>
														<label class="label">Immagine del Profilo</label> <label
															class="input"> <i class="fa"></i> <input type="file"
															name="fotoProfilo" id="fotoProfilo" accept=".jpg">
														</label>
													</section>

													<button type="submit" class="btn btn-primary">Modifica</button>
										</form>
											
										</div>
				
									</div>
									
								</div>
				
							</div>
				
				
					

		<!-- PAGE FOOTER -->
		<div class="page-footer">
			<%@ include file = "footer.jsp" %>
		</div>
		<!-- END PAGE FOOTER -->

		

		<!--================================================== -->

		<script type="text/javascript">
		function displayForm(){
				$("#form_modifica_profilo").fadeIn();
		}
		
		</script>
		<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)-->
		<script data-pace-options='{ "restartOnRequestAfter": true }' src="js/plugin/pace/pace.min.js"></script>

		<!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
		
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

		<!--[if IE 8]>

		<h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>

		<![endif]-->

		

		

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