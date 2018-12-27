<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="utf-8">
	<!--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">-->

	<title>ChooseIT - Registrazione</title>
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
				<li>
					<a href="index.jsp">
						<span class="menu-item-parent">Login</span>
					</a>
				</li>
				<li class="active open">
					<a href="Registrazione.jsp">
						<span class="menu-item-parent">Registrazione</span>
					</a>
				</li>
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
				<li>Registrazione</li>
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
						<form name="registrazione" id="form_reg" action="ServletRegistrazione" method="post"
							class="smart-form client-form">
							<header> Registrazione </header>

							<fieldset>
								<legend>Informazioni Account</legend>
								<section>
									<label class="label">E-mail</label> 
									<label class="input">
										<i class="icon-append fa fa-lock"></i> 
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
										<i class="icon-append fa fa-lock"></i> 
										<input type="text" name="cognome" id="cognome" required="required" pattern="^[A-Za-z\s]{3,20}">
									</label>
								</section>
								
								<section>
									<label class="label">Indirizzo</label> 
									<label class="input">
										<i class="icon-append fa fa-lock"></i> 
										<input type="text" name="indirizzo" id="indirizzo" required="required" pattern="^[A-Za-z0-9,()\s]{3,60}">
									</label>
								</section>
								
								<section>
									<label class="label">Data di Nascita</label> 
									<label class="input">
										<i class="icon-append fa fa-lock"></i> 
										<input type="text" name="dataNascita" id="dataNascita" placeholder="gg/mm/aaaa" required="required" pattern="^(0[1-9]|1[0-9]|2[0-9]|3[01])/(0[1-9]|1[012])/[0-9]{4}$">
									</label>
								</section>
								
								<section>
									<label class="label">Telefono</label> 
									<label class="input">
										<i class="icon-append fa fa-lock"></i> 
										<input type="text" name="telefono" id="telefono" required="required" pattern="^[0-9]{10}$">
									</label>
								</section>
								
								<section>
									<label class="label">Matricola</label> 
									<label class="input">
										<i class="icon-append fa fa-lock"></i> 
										<input type="text" name="matricola" id="matricola" required="required" pattern="^[0-9]{10}$">
									</label>
								</section>
								
								<section>
									<label class="label">Descrizione</label> 
									<label class="input">
										<i class="icon-append fa fa-lock"></i> 
										<textarea rows="4" cols="50" maxlength="300" name="descrizione" form="form-reg"></textarea>
									</label>
								</section>
								
								<section>
									<label class="label">Immagine del Profilo</label> 
									<label class="input">
										<i class="icon-append fa fa-lock"></i> 
										<input type="file" name="fotoProfilo" id="fotoProfilo" accept=".jpg">
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
			}
		}
	%>
</html>