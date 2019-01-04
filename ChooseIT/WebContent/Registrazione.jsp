<%@page import="it.chooseit.bean.UtenteBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title> ChooseIT | Registrazione </title>
		<meta name="description" content="Registrazione">
		<meta name="author" content="RocketStudios">
		
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		
		<!-- Basic Styles -->
		<link rel="stylesheet" type="text/css" media="screen" href="css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" media="screen" href="css/font-awesome.min.css">
		
		<!-- SmartAdmin Styles : Caution! DO NOT change the order -->
		<link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-production-plugins.min.css">
		<link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-production.min.css">
		<link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-skins.min.css">
		
		<!-- SmartAdmin RTL Support  -->
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
	
		<%
			UtenteBean utente = null;
			String ruolo = (String) request.getSession().getAttribute("ruolo");
			
			if (ruolo == null) {
				request.getSession().setAttribute("ruolo", "guest");
				ruolo = "guest";
			} else if (!ruolo.equals("guest")) {
				utente = (UtenteBean) request.getSession().getAttribute("utente");
			}
		%>
		
		<!-- #HEADER -->
		<header id="header">
			<div id="logo-group">
	
				<!-- PLACE YOUR LOGO HERE -->
				<span id="logo">
					<img src="img/logo-chooseit.png" alt="ChooseIT">
				</span>
				<!-- END LOGO PLACEHOLDER -->
	
			</div>
	
			<!-- #TOGGLE LAYOUT BUTTONS -->
			<!-- pulled right: nav area -->
			<div class="pull-right">
	
				<!-- collapse menu button -->
				<div id="hide-menu" class="btn-header pull-right">
					<span>
						<a href="javascript:void(0);" data-action="toggleMenu" title="Collapse Menu"><i class="fa fa-reorder"></i></a>
					</span>
				</div>
				<!-- end collapse menu -->

			</div>
			<!-- end pulled right: nav area -->
	
		</header>
		<!-- END HEADER -->
	
		<!-- #NAVIGATION -->
		<!-- Left panel : Navigation area -->
		<!-- Note: This width of the aside area can be adjusted through LESS/SASS variables -->
		<aside id="left-panel">
	
			<!-- User info -->
			<div class="login-info">
				<span> <!-- User image size is adjusted inside CSS, it should stay as is -->

				</span>
			</div>
			<!-- end user info -->
	
			<!-- NAVIGATION : This navigation is also responsive
	
				To make this navigation dynamic please make sure to link the node
				(the reference to the nav > ul) after page load. Or the navigation
				will not initialize.
				-->
			<nav>
				<!-- 
					NOTE: Notice the gaps after each icon usage <i></i>..
					Please note that these links work a bit different than
					traditional href="" links. See documentation for details.
					-->
				<%
					if (ruolo.equals("guest")) {
				%>
				
				<ul>
					<li class="top-menu-invisible">
						<a href="index.jsp" title="Dashboard"><i class="fa fa-lg fa-fw fa fa-sign-in"></i> <span class="menu-item-parent">Login</span></a>
					</li>
					<li class="active open">
						<a href="Registrazione.jsp"><i class="fa fa-lg fa-fw fa fa-check-square-o txt-color-blue"></i> <span class="menu-item-parent">Registrazione</span></a>
					</li>
				</ul>
	
				<%
					}
				%>
			</nav>
	
			<span class="minifyme" data-action="minifyMenu">
				<i class="fa fa-arrow-circle-left hit"></i>
			</span>
	
		</aside>
		<!-- END NAVIGATION -->
		
		<!-- MAIN PANEL -->
		<div id="main" role="main">
	
			<!-- RIBBON -->
			<div id="ribbon">
	
				<!-- breadcrumb -->
				<ol class="breadcrumb">
					<li>Home</li>
					<li>Registrazione</li>
				</ol>
	
			</div>
			<!-- END RIBBON -->
	
			<!-- MAIN CONTENT -->
			<div id="content">
	
				<!-- row -->
				<div class="row">
					<article class="col-sm-12">
	
						<%
							String urlRegistrazione=response.encodeURL("RegistrazioneServlet");
						%>
						
						<div class="well no-padding">
							<form name="registrazione" id="form_reg" action="<%=urlRegistrazione%>" method="post" enctype="multipart/form-data" class="smart-form client-form">
								<header> Registrazione </header>
	
								<fieldset>
									<legend>Informazioni Account</legend>
									<section>
										<label class="label">E-mail</label> 
										<label class="input">
											<i class="icon-append fa fa-envelope-o"></i> 
											<input type="text" name="email" id="email" required="required" pattern="^[A-Za-z0-9.]+@(studenti.unisa.it){1}$">
										</label>
									</section>
	
									<section>
										<label class="label">Password</label> 
										<label class="input">
											<i class="icon-append fa fa-lock"></i> 
											<input type="password" name="password" id="pwd" required="required" pattern="^[A-Za-z0-9.,-_+#!?]{4,8}$">
										</label>
									</section>
	
								</fieldset>
								
								<fieldset>
									<legend>Informazioni Utente</legend>
									<section>
										<label class="label">Nome</label> 
										<label class="input">
											<i class="icon-append fa fa-user"></i> 
											<input type="text" name="nome" id="nome" required="required" pattern="^[A-Za-z\s]{3,20}">
										</label>
									</section>
	
									<section>
										<label class="label">Cognome</label> 
										<label class="input">
											<i class="icon-append fa fa-user"></i> 
											<input type="text" name="cognome" id="cognome" required="required" pattern="^[A-Za-z\s]{3,20}">
										</label>
									</section>
									
									<section>
										<label class="label">Indirizzo</label> 
										<label class="input">
											<i class="icon-append fa fa-map-marker"></i> 
											<input type="text" name="indirizzo" id="indirizzo" required="required" pattern="^[A-Za-z0-9,()\s]{3,60}">
										</label>
									</section>
									
									<section>
										<label class="label">Data di Nascita</label> 
										<label class="input">
											<i class="icon-append fa fa-calendar-o"></i> 
											<input type="text" name="dataNascita" id="dataNascita" placeholder="gg/mm/aaaa" required="required" pattern="^(0[1-9]|1[0-9]|2[0-9]|3[01])/(0[1-9]|1[012])/[0-9]{4}$">
										</label>
									</section>
									
									<section>
										<label class="label">Telefono</label> 
										<label class="input">
											<i class="icon-append fa fa-phone"></i> 
											<input type="text" name="telefono" id="telefono" required="required" pattern="^[0-9]{10}$">
										</label>
									</section>
									
									<section>
										<label class="label">Matricola</label> 
										<label class="input">
											<i class="icon-append fa fa-mortar-board"></i> 
											<input type="text" name="matricola" id="matricola" required="required" pattern="^[0-9]{10}$">
										</label>
									</section>
									
									<section>
										<label class="label">Descrizione</label> 
										<label class="input">
											<textarea rows="4" cols="50" maxlength="300" name="descrizione" form="form-reg"></textarea>
										</label>
									</section>

									<section>
										<label class="label">Immagine del Profilo</label> 
										<label class="input">
											<input type="file" name="fotoProfilo" id="fotoProfilo" accept=".jpg" class="btn btn-default">
										</label>
									</section>
									
								</fieldset>
								<footer>
									<button type="submit" class="btn btn-primary">Registrati</button>
								</footer>
							</form>
	
						</div>
	
	
					</article>
				</div>
				<!-- end row -->
	
			</div>
			<!-- END MAIN CONTENT -->
		</div>
		<!-- END MAIN PANEL -->
		
		<%@
			include file = "footer.jsp"
		%>
		
		<!--================================================== -->

		<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)-->
		<script data-pace-options='{ "restartOnRequestAfter": true }' src="js/plugin/pace/pace.min.js"></script>

		<!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script>
			if (!window.jQuery) {
				document.write('<script src="js/libs/jquery-3.2.1.min.js"><\/script>');
			}
		</script>

		<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
		<script>
			if (!window.jQuery.ui) {
				document.write('<script src="js/libs/jquery-ui.min.js"><\/script>');
			}
		</script>

		<!-- IMPORTANT: APP CONFIG -->
		<script src="js/app.config.js"></script>

		<!-- JS TOUCH : include this plugin for mobile drag / drop touch events-->
		<script src="js/plugin/jquery-touch/jquery.ui.touch-punch.min.js"></script> 

		<!-- BOOTSTRAP JS -->
		<script src="js/bootstrap/bootstrap.min.js"></script>

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

		<!-- MAIN APP JS FILE -->
		<script src="js/app.min.js"></script>

		<!-- ENHANCEMENT PLUGINS : NOT A REQUIREMENT -->
		<!-- Voice command : plugin -->
		<script src="js/speech/voicecommand.min.js"></script>

		<!-- SmartChat UI : plugin -->
		<script src="js/smart-chat-ui/smart.chat.ui.min.js"></script>
		<script src="js/smart-chat-ui/smart.chat.manager.min.js"></script>
		
		<!-- PAGE RELATED PLUGIN(S) -->
		
		<!-- Flot Chart Plugin: Flot Engine, Flot Resizer, Flot Tooltip -->
		<script src="js/plugin/flot/jquery.flot.cust.min.js"></script>
		<script src="js/plugin/flot/jquery.flot.resize.min.js"></script>
		<script src="js/plugin/flot/jquery.flot.time.min.js"></script>
		<script src="js/plugin/flot/jquery.flot.tooltip.min.js"></script>
		
		<!-- Vector Maps Plugin: Vectormap engine, Vectormap language -->
		<script src="js/plugin/vectormap/jquery-jvectormap-1.2.2.min.js"></script>
		<script src="js/plugin/vectormap/jquery-jvectormap-world-mill-en.js"></script>
		
		<!-- Full Calendar -->
		<script src="js/plugin/moment/moment.min.js"></script>
		<script src="js/plugin/fullcalendar/fullcalendar.min.js"></script>
		
		<script type="text/javascript">
			var inputEmail = document.getElementById('email');
			inputEmail.oninput= function(event){
				event.target.setCustomValidity('');
			}
			inputEmail.oninvalid= function(event){
				event.target.setCustomValidity('Inserire un indirizzo email istituzionale e.g. m.rossi@studenti.unisa.it');
			}
			
			
			var inputPwd = document.getElementById('pwd');
			inputPwd.oninput= function(event){
				event.target.setCustomValidity('');
			}
			inputPwd.oninvalid= function(event){
				event.target.setCustomValidity('La password deve avere una lunghezza compresa tra 4 e 8 caratteri. Sono ammessi i seguenti caratteri speciali: .,-_+#!?');
			}
			
			
			var inputNome = document.getElementById('nome');
			inputNome.oninput= function(event){
				event.target.setCustomValidity('');
			}
			inputNome.oninvalid= function(event){
				event.target.setCustomValidity('Il nome deve avere una lunghezza compresa tra 3 e 20 caratteri.');
			}
			
			
			var inputCognome = document.getElementById('cognome');
			inputCognome.oninput= function(event){
				event.target.setCustomValidity('');
			}
			inputCognome.oninvalid= function(event){
				event.target.setCustomValidity('Il cognome deve avere una lunghezza compresa tra 3 e 20 caratteri.');
			}
			
			
			var inputIndirizzo = document.getElementById('indirizzo');
			inputIndirizzo.oninput= function(event){
				event.target.setCustomValidity('');
			}
			inputIndirizzo.oninvalid= function(event){
				event.target.setCustomValidity('L\'indirizzo deve avere una lunghezza compresa tra 3 e 60 caratteri. Non sono ammessi caratteri speciali');
			}
			
			
			var inputData = document.getElementById('dataNascita');
			inputData.oninput= function(event){
				event.target.setCustomValidity('');
			}
			inputData.oninvalid= function(event){
				event.target.setCustomValidity('La data di nascita deve avere il seguente formato: GG/MM/AAAA');
			}
			
			
			var inputTelefono = document.getElementById('telefono');
			inputTelefono.oninput= function(event){
				event.target.setCustomValidity('');
			}
			inputTelefono.oninvalid= function(event){
				event.target.setCustomValidity('Il numero di telefono deve avere una lunghezza di 10 cifre.');
			}
			
			
			var inputMatricola = document.getElementById('matricola');
			inputMatricola.oninput= function(event){
				event.target.setCustomValidity('');
			}
			inputMatricola.oninvalid= function(event){
				event.target.setCustomValidity('La matricola deve avere una lunghezza di 10 cifre.');
			}
		</script>

		<%
			if(request.getSession().getAttribute("registrazioneOK") != null){
				boolean registrazioneOK = (boolean) request.getSession().getAttribute("registrazioneOK");
				request.getSession().removeAttribute("registrazioneOK");
				if (!registrazioneOK) {
				%>
				<script type="text/javascript">
					alert("ERRORE.\nLa registrazione non è andata a buon fine.");
				</script>	
				<%
				} else {
				%>
				<script type="text/javascript">
					alert("La registrazione è avvenuta con successo.");
				</script>	
				<%
				}
				request.getSession().removeAttribute("registrazioneOK");
			}
		
			if(request.getSession().getAttribute("formatoOK") != null){
				boolean formatoOK = (boolean) request.getSession().getAttribute("formatoOK");
				request.getSession().removeAttribute("formatoOK");
				if(!formatoOK){
					%>
					<script type="text/javascript">
						alert("ERRORE.\nIl formato consentito per le immagini è .jpeg");
					</script>	
					<%				
				}
			}
		%>
		
	</body>
</html>