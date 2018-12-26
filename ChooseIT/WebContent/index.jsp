<%@page import="it.chooseit.bean.UtenteBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="utf-8">
	<!--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">-->

	<title>ChooseIT - Login</title>
	<meta name="description" content="">
	<meta name="author" content="">

	<meta name="viewport"
		content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

	<!-- Basic Styles -->
	<link rel="stylesheet" type="text/css" media="screen"
		href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" media="screen"
		href="css/font-awesome.min.css">

	<!-- SmartAdmin Styles : Caution! DO NOT change the order -->
	<link rel="stylesheet" type="text/css" media="screen"
		href="css/smartadmin-production-plugins.min.css">
	<link rel="stylesheet" type="text/css" media="screen"
		href="css/smartadmin-production.min.css">
	<link rel="stylesheet" type="text/css" media="screen"
		href="css/smartadmin-skins.min.css">

	<!-- SmartAdmin RTL Support  -->
	<link rel="stylesheet" type="text/css" media="screen"
		href="css/smartadmin-rtl.min.css">

	<!-- We recommend you use "your_style.css" to override SmartAdmin
		     specific styles this will also ensure you retrain your customization with each SmartAdmin update.
		<link rel="stylesheet" type="text/css" media="screen" href="css/your_style.css"> -->

	<!-- Demo purpose only: goes with demo.js, you can delete this css when designing your own WebApp -->
	<link rel="stylesheet" type="text/css" media="screen"
		href="css/demo.min.css">

	<!-- FAVICONS -->
	<link rel="shortcut icon" href="img/favicon/favicon.ico"
		type="image/x-icon">
	<link rel="icon" href="img/favicon/favicon.ico" type="image/x-icon">

	<!-- GOOGLE FONT -->
	<link rel="stylesheet"
		href="https://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,300,400,700">

	<!-- Specifying a Webpage Icon for Web Clip 
			 Ref: https://developer.apple.com/library/ios/documentation/AppleApplications/Reference/SafariWebContent/ConfiguringWebApplications/ConfiguringWebApplications.html -->
	<link rel="apple-touch-icon" href="img/splash/sptouch-icon-iphone.png">
	<link rel="apple-touch-icon" sizes="76x76"
		href="img/splash/touch-icon-ipad.png">
	<link rel="apple-touch-icon" sizes="120x120"
		href="img/splash/touch-icon-iphone-retina.png">
	<link rel="apple-touch-icon" sizes="152x152"
		href="img/splash/touch-icon-ipad-retina.png">

</head>

<body>

	<%
		//Recupero del ruolo: se non esiste, ruolo è "guest"
		String ruolo = (String) request.getSession().getAttribute("ruolo");
		if (ruolo == null) {
			ruolo = "guest";
			request.getSession().setAttribute("ruolo", ruolo);
		}
	%>

	<!-- HEADER -->
	<header id="header"> </header>
	<!-- END HEADER -->

	<!-- Left panel : Navigation area -->
	<!-- Note: This width of the aside area can be adjusted through LESS variables -->
	<aside id="left-panel">

		<!-- User info -->
		<div class="login-info"></div>
		<!-- end user info -->

		<!-- NAVIGATION : This navigation is also responsive-->
		<nav>
			<!-- 
				NOTE: Notice the gaps after each icon usage <i></i>..
				Please note that these links work a bit different than
				traditional href="" links. See documentation for details.
				-->

			<ul>
				<li class="active open"><a href="#" title="Login"><i
						class="fa fa-lg fa-fw fa-home"></i> <span class="menu-item-parent">Login</span></a>
				</li>
				<li><a href="Registrazione.jsp"><i
						class="fa fa-lg fa-fw fa-inbox"></i> <span
						class="menu-item-parent">Registrazione</span></a></li>
			</ul>
		</nav>

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

			<!-- You can also add more buttons to the
				ribbon for further usability

				Example below:

				<span class="ribbon-button-alignment pull-right">
				<span id="search" class="btn btn-ribbon hidden-xs" data-title="search"><i class="fa-grid"></i> Change Grid</span>
				<span id="add" class="btn btn-ribbon hidden-xs" data-title="add"><i class="fa-plus"></i> Add</span>
				<span id="search" class="btn btn-ribbon" data-title="search"><i class="fa-search"></i> <span class="hidden-mobile">Search</span></span>
				</span> -->

		</div>
		<!-- END RIBBON -->

		<!-- MAIN CONTENT -->
		<div id="content">

			<!-- row -->
			<div class="row">
				<article class="col-sm-12">

					<div class="well no-padding">
						<form action="ServletLogin" method="post" id="login-form"
							class="smart-form client-form">
							<header> Login </header>

							<fieldset>

								<section>
									<label class="label">E-mail</label> <label class="input">
										<i class="icon-append fa fa-user"></i> <input type="email"
										name="email"> <b class="tooltip tooltip-top-right"><i
											class="fa fa-user txt-color-teal"></i> Inserire l'indirizzo
											email</b>
									</label>
								</section>

								<section>
									<label class="label">Password</label> <label class="input">
										<i class="icon-append fa fa-lock"></i> <input type="password"
										name="password"> <b class="tooltip tooltip-top-right"><i
											class="fa fa-lock txt-color-teal"></i> Inserire la password</b>
									</label>
									<div class="note">
										<a href="forgotpassword.html">Password dimenticata?</a>
									</div>
								</section>

								<section>
									<label class="checkbox"> <input type="checkbox"
										name="remember"> <i></i>Resta connesso
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
	
	<!-- PAGE FOOTER -->
	<div class="page-footer">
		<div class="row">
			<div class="col-xs-12 col-sm-6">
				<span class="txt-color-white">ChooseIT <span
					class="hidden-xs"></span> © 2018-2019
				</span>
			</div>
		</div>
	</div>
	<!-- END PAGE FOOTER -->
</body>

	<%
		if(request.getSession().getAttribute("loginOK") != null){
			boolean loginOK = (boolean) request.getSession().getAttribute("loginOK");
			request.getSession().removeAttribute("loginOK");
			if (!loginOK) {
			%>
			<script type="text/javascript">
				alert("ERRORE.\nLe credenziali sono errate.");
			</script>	
			<%
			}
		}
	%>
</html>