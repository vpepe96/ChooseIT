<%@page import="it.chooseit.bean.UtenteBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="description" content="">
		<meta name="author" content="">
		
		<meta name="viewport"
			content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		
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
				<span id="logo"> <img src="img/logo-chooseit.png"
					alt="ChooseIT">
				</span>
				<!-- END LOGO PLACEHOLDER -->
	
			</div>
	
			<!-- Navigation bar -->
			<div class="topnav"></div>
			<!-- END navigation bar -->
	
			<!-- #TOGGLE LAYOUT BUTTONS -->
			<!-- pulled right: nav area -->
			<div class="pull-right">
	
				<!-- collapse menu button -->
				<div id="hide-menu" class="btn-header pull-right">
					<span> <a href="javascript:void(0);" data-action="toggleMenu"
						title="Collapse Menu"><i class="fa fa-reorder"></i></a>
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
					<li><a href="index.jsp" title="Dashboard"><span
							class="menu-item">Login</span></a></li>
					<li><a href="Registrazione.jsp" title="Dashboard"><span
							class="menu-item">Registrazione</span></a></li>
				</ul>
	
				<%
					}
				%>
			</nav>
	
			<span class="minifyme" data-action="minifyMenu"> <i
				class="fa fa-arrow-circle-left hit"></i>
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