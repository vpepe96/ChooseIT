<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title> ChooseIT | Header </title> 
		<meta name="description" content="Header">
		<meta name="author" content="RocketStudios">
			
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		
		<!-- #CSS Links -->
		<!-- Basic Styles -->
		<link rel="stylesheet" type="text/css" media="screen" href="css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" media="screen" href="css/font-awesome.min.css">
		<link rel="stylesheet" type="text/css" media="screen" href="css/header.css">

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
		<!-- #HEADER -->
		<header id="header">
			<div id="logo-group">
	
				<!-- PLACE YOUR LOGO HERE -->
				<span id="logo"> <img src="img/logo-chooseit.png" alt="ChooseIT"> </span>
				<!-- END LOGO PLACEHOLDER -->

			</div>
			
			<!-- Navigation bar -->
			<div class="topnav">
				
				<%
					String urlAreaPersonale = response.encodeURL("AreaPersonale.jsp");
				%>
				
  				<a href="<%=urlAreaPersonale%>">Area Personale</a>
  				
  				<%
					String ruolo = (String) session.getAttribute("ruolo");
					if(!ruolo.equals("segreteria")) {
						String urlProfilo = response.encodeURL("Profilo.jsp");
				%>
				
				<a href="<%=urlProfilo%>">Profilo</a>
  				
  				<%
					}
  				%>
  				
  				<%
					String urlContatti = response.encodeURL("Contatti.jsp");
				%>
				
  				<a href="<%=urlContatti%>">Contatti</a>
  				
			</div>
			<!-- END navigation bar -->
			
			<!-- #TOGGLE LAYOUT BUTTONS -->
			<!-- pulled right: nav area -->
			<div class="pull-right">
				
				<!-- collapse menu button -->
				<div id="hide-menu" class="btn-header pull-right">
					<span> <a href="javascript:void(0);" data-action="toggleMenu" title="Collapse Menu"><i class="fa fa-reorder"></i></a> </span>
				</div>
				<!-- end collapse menu -->

				<!-- logout button -->
				<div id="logout" class="btn-header transparent pull-right">
					<%
						String urlLogout = response.encodeURL("LogoutServlet");
					%>
					<span> <a href=<%=urlLogout %> title="Sign Out" data-action="userLogout" data-logout-msg="Sei sicuro di voler uscire?"><i class="fa fa-sign-out"></i></a> </span>
				</div>
				<!-- end logout button -->

			</div>
			<!-- end pulled right: nav area -->

		</header>
		<!-- END HEADER -->

	</body>
</html>