<%@page import="it.chooseit.bean.UtenteBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title> ChooseIT | Navigation Bar </title>  
		<meta name="description" content="Navigation Bar">
		<meta name="author" content="RocketStudios">
			
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		
		<!-- #CSS Links -->
		<!-- Basic Styles -->
		<link rel="stylesheet" type="text/css" media="screen" href="css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" media="screen" href="css/font-awesome.min.css">

		<!-- SmartAdmin Styles : Caution! DO NOT change the order -->
		<link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-production.min.css">
		<link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-skins.min.css">

		<!-- We recommend you use "your_style.css" to override SmartAdmin
		     specific styles this will also ensure you retrain your customization with each SmartAdmin update.
		<link rel="stylesheet" type="text/css" media="screen" href="css/your_style.css"> -->

		<!-- #FAVICONS -->
		<link rel="shortcut icon" href="img/logo2.png" type="image/x-icon">
		<link rel="icon" href="img/logo2.png" type="image/x-icon">

		<!-- #GOOGLE FONT -->
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,300,400,700">

		<!-- #APP SCREEN / ICONS -->
		<!-- Specifying a Webpage Icon for Web Clip 
			 Ref: https://developer.apple.com/library/ios/documentation/AppleApplications/Reference/SafariWebContent/ConfiguringWebApplications/ConfiguringWebApplications.html -->
		<link rel="apple-touch-icon" href="img/splash/sptouch-icon-iphone.png">
		<link rel="apple-touch-icon" sizes="76x76" href="img/splash/touch-icon-ipad.png">
		<link rel="apple-touch-icon" sizes="120x120" href="img/splash/touch-icon-iphone-retina.png">
		<link rel="apple-touch-icon" sizes="152x152" href="img/splash/touch-icon-ipad-retina.png">
		
		<!-- iOS web-app metas : hides Safari UI Components and Changes Status Bar Appearance -->
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		
		<!-- Startup image for web apps -->
		<link rel="apple-touch-startup-image" href="img/splash/ipad-landscape.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:landscape)">
		<link rel="apple-touch-startup-image" href="img/splash/ipad-portrait.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:portrait)">
		<link rel="apple-touch-startup-image" href="img/splash/iphone.png" media="screen and (max-device-width: 320px)">
	</head>
	
	<body>

		<%@
			include file = "header.jsp"
		%>
		
		<!-- #NAVIGATION -->
		<!-- Left panel : Navigation area -->
		<!-- Note: This width of the aside area can be adjusted through LESS/SASS variables -->
		<aside id="left-panel">

			<!-- User info -->
			<div class="login-info">
				<span> <!-- User image size is adjusted inside CSS, it should stay as is --> 
					<%
						UtenteBean utente = (UtenteBean) session.getAttribute("utente");
					%>
					<a href="javascript:void(0);" id="show-shortcut" data-action="toggleShortcut">
<!-- 					Bisognerà inserire la seguente istruzione "utente.getFotoProfilo()" all'interno di dell'attributo src di img seguente -->
						<img src="img/avatars/1.png" alt="foto profilo" class="online" />
						<span>
							<%=utente.getNome() %> <%=utente.getCognome() %>
						</span>
					</a> 
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
					if(ruolo.equals("segreteria")) {
						String urlListaAziende = response.encodeURL("ListaAziendeServlet");
						String urlNuovaAzienda = response.encodeURL("InserimentoAzienda.jsp");
						String urlListaRichiesteTirocinio = response.encodeURL("ListaRichiesteTirocinioServlet");
						String urlListaTirocini = response.encodeURL("ListaTirocini.jsp");
				%>
				
				<ul>
					<li class="top-menu-invisible">
						<a href="#" title="Dashboard"><i class="fa fa-lg fa-fw fa fa-industry"></i> <span class="menu-item-parent">Aziende</span></a>
						<ul style="display: block;">
							<li class="top-menu-invisible">
								<a href="<%=urlListaAziende %>" title="Dashboard"><span class="menu-item-parent">Aziende convenzionate</span></a>
							</li>
							<li>
								<a href="<%=urlNuovaAzienda %>" title="Dashboard"><span class="menu-item-parent">Inserimento nuova azienda</span></a>
							</li>
						</ul>	
					</li>
					<li class="top-menu-invisible">
						<a href="<%=urlListaRichiesteTirocinio %>" title="Dashboard"><i class="fa fa-lg fa-fw fa fa-send-o"></i> <span class="menu-item-parent">Lista richieste</span></a>
					</li>
					<li class="top-menu-invisible">
						<a href="#" title="Dashboard"><i class="fa fa-lg fa-fw fa fa-folder-open-o"></i> <span class="menu-item-parent">Registro di tirocinio</span></a>
						<ul style="display: block;">
							<li class="top-menu-invisible">
								<a href="<%=urlListaTirocini %>" title="Dashboard"><span class="menu-item-parent">Lista Tirocini</span></a>
							</li>
						</ul>	
					</li>
				</ul>
				
				<%
					} else if(ruolo.equals("studente")) {
						String urlListaAziende = response.encodeURL("ListaAziendeServlet");
						String urlListaRichiesteTirocinio = response.encodeURL("ListaRichiesteTirocinioServlet");
						String urlListaTirocini = response.encodeURL("ListaTirocini.jsp");
				%>
				
				<ul>
					<li class="top-menu-invisible">
						<a href="<%=urlListaAziende %>" title="Dashboard"><i class="fa fa-lg fa-fw fa fa-industry"></i> <span class="menu-item-parent">Lista aziende</span></a>
					</li>
					<li class="top-menu-invisible">
						<a href="<%=urlListaRichiesteTirocinio %>" title="Dashboard"><i class="fa fa-lg fa-fw fa fa-send-o"></i> <span class="menu-item-parent">Lista richieste</span></a>
					</li>
					<li class="top-menu-invisible">
						<a href="#" title="Dashboard"><i class="fa fa-lg fa-fw fa fa-folder-open-o"></i> <span class="menu-item-parent">Registro di tirocinio</span></a>
						<ul style="display: block;">
							<li class="top-menu-invisible">
								<a href="<%=urlListaTirocini %>" title="Dashboard"><span class="menu-item-parent">Lista Tirocini</span></a>
							</li>
						</ul>	
					</li>
				</ul>
				
				<%
					} else if(ruolo.equals("presidente")) {
						String urlListaRichiesteTirocinio = response.encodeURL("ListaRichiesteTirocinioServlet");
				%>
				
				<ul>
					<li class="top-menu-invisible">
						<a href="<%=urlListaRichiesteTirocinio %>" title="Dashboard"><i class="fa fa-lg fa-fw fa fa-send-o"></i> <span class="menu-item-parent">Lista richieste</span></a>
					</li>
				</ul>
				
				<%
					} else if(ruolo.equals("tutorUniversitario")) {
						String urlListaTirocini = response.encodeURL("ListaTirocini.jsp");
				%>
				
				<ul>
					<li class="top-menu-invisible">
						<a href="#" title="Dashboard"><i class="fa fa-lg fa-fw fa fa-folder-open-o"></i> <span class="menu-item-parent">Registro di tirocinio</span></a>
						<ul style="display: block;">
							<li class="top-menu-invisible">
								<a href="<%=urlListaTirocini %>" title="Dashboard"><span class="menu-item-parent">Lista Tirocini</span></a>
							</li>
						</ul>	
					</li>
				</ul>
				
				<%
					} else if(ruolo.equals("tutorAziendale")) {
						String urlListaTirocini = response.encodeURL("ListaTirocini.jsp");
						String urlListaQuestionari = response.encodeURL("ListaQuestionariTutorAziendale.jsp");
				%>
				
				<ul>
					<li class="top-menu-invisible">
						<a href="#" title="Dashboard"><i class="fa fa-lg fa-fw fa fa-folder-open-o"></i> <span class="menu-item-parent">Registro di tirocinio</span></a>
						<ul style="display: block;">
							<li class="top-menu-invisible">
								<a href="<%=urlListaTirocini %>" title="Dashboard"><span class="menu-item-parent">Lista Tirocini</span></a>
							</li>
						</ul>	
					</li>
					<li class="top-menu-invisible">
						<a href="#" title="Dashboard"><i class="fa fa-lg fa-fw fa fa-pencil-square-o"></i> <span class="menu-item-parent">Questionario valutativo</span></a>
						<ul style="display: block;">
							<li class="top-menu-invisible">
								<a href="<%=urlListaQuestionari %>" title="Dashboard"><span class="menu-item-parent">Lista questionari</span></a>
							</li>
						</ul>	
					</li>
				</ul>
				
				<%
					}
				%>
				
			</nav>

			<span class="minifyme" data-action="minifyMenu"> <i class="fa fa-arrow-circle-left hit"></i> </span>

		</aside>
		<!-- END NAVIGATION -->
		
		<!-- #PLUGINS -->
		<!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
		<script src="//ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script>
			if (!window.jQuery) {
				document.write('<script src="js/libs/jquery-3.2.1.min.js"><\/script>');
			}
		</script>

		<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
		<script>
			if (!window.jQuery.ui) {
				document.write('<script src="js/libs/jquery-ui.min.js"><\/script>');
			}
		</script>

		<!-- IMPORTANT: APP CONFIG -->
		<script src="js/app.config.js"></script>

		<!-- BOOTSTRAP JS -->
		<script src="js/bootstrap/bootstrap.min.js"></script>

		<!--[if IE 8]>
			<h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>
		<![endif]-->

		<!-- MAIN APP JS FILE -->
		<script src="js/app.min.js"></script>

		<!-- Your GOOGLE ANALYTICS CODE Below -->
		<script>
	
		  var _gaq = _gaq || [];
		  _gaq.push(['_setAccount', 'UA-XXXXXXXX-X']);
		  _gaq.push(['_trackPageview']);
		
		  (function() {
		    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
		    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
		    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
		  })();
		
		</script>
		
	</body>
</html>