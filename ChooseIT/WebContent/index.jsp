<%@page import="it.chooseit.bean.UtenteBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title> ChooseIT | Login </title>
		<meta name="description" content="Login">
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
		<!-- Note: This width of the aside area can be adjusted through LESS variables -->
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
					<li class="active open">
						<a href="index.jsp" title="Dashboard"><i class="fa fa-lg fa-fw fa fa-sign-in"></i> <span class="menu-item-parent">Login</span></a>
					</li>
					<li class="top-menu-invisible">
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
					<li>Login</li>
				</ol>
				<!-- end breadcrumb -->
	
			</div>
			<!-- END RIBBON -->
	
			<!-- MAIN CONTENT -->
			<div id="content">
	
				<!-- row -->
				<div class="row">
					<article class="col-sm-12">
	
						<%
							String urlLogin = response.encodeURL("LoginServlet");
						%>

						<div class="well no-padding">
							<form action="<%=urlLogin%>" method="post" id="login-form" class="smart-form client-form">
								<header> Login </header>
	
								<fieldset>
									<section>
										<label class="label">E-mail</label> <label class="input">
											<i class="icon-append fa fa-user"></i> <input type="email" id="email" required="required" pattern="^[A-Za-z0-9.]+@[A-Za-z._]+(it|.com){1}$" name="email">
										</label>
									</section>
	
									<section>
										<label class="label">Password</label> <label class="input">
											<i class="icon-append fa fa-lock"></i> <input type="password" name="password" required="required">
										</label>
										<div class="note">
											<a href="forgotpassword.html">Password dimenticata?</a>
										</div>
									</section>
	
									<section>
										<label class="checkbox"> <input type="checkbox" name="remember">
											<i></i>Resta connesso
										</label>
									</section>
								</fieldset>
								<footer>
									<button type="submit" class="btn btn-primary">Accedi</button>
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

		<%
		if (request.getSession().getAttribute("loginOK") != null) {
			boolean loginOK = (boolean) request.getSession().getAttribute("loginOK");
			request.getSession().removeAttribute("loginOK");
			if (!loginOK) {
		%>
		<script type="text/javascript">
			alert("ERRORE.\nLe credenziali sono errate.");
		</script>
		<%
			}
				request.getSession().removeAttribute("loginOK");
			}
		%>
		
		<script type="text/javascript">
		
			var inputEmail = document.getElementById('email');
			inputEmail.oninput= function(event){
				event.target.setCustomValidity('');
			}
			inputEmail.oninvalid= function(event){
				event.target.setCustomValidity('Inserire un indirizzo email valido');
			}
		</script>
		
	</body>
</html>