<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="utf-8">

</head>

<body>
<jsp:include page="header.jsp" />
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
						String urlRegistrazione=response.encodeURL("ServletRegistrazione");
					%>
					
					<div class="well no-padding">
						<form name="registrazione" id="form_reg" action="<%=urlRegistrazione%>" method="post" enctype="multipart/form-data"
							class="smart-form client-form">
							<header> Registrazione </header>

							<fieldset>
								<legend>Informazioni Account</legend>
								<section>
									<label class="label">E-mail</label> 
									<label class="input">
										<i class="icon-append fa fa-user"></i> 
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
										<i class="icon-append fa fa-user"></i> 
										<input type="text" name="indirizzo" id="indirizzo" required="required" pattern="^[A-Za-z0-9,()\s]{3,60}">
									</label>
								</section>
								
								<section>
									<label class="label">Data di Nascita</label> 
									<label class="input">
										<i class="icon-append fa fa-user"></i> 
										<input type="text" name="dataNascita" id="dataNascita" placeholder="gg/mm/aaaa" required="required" pattern="^(0[1-9]|1[0-9]|2[0-9]|3[01])/(0[1-9]|1[012])/[0-9]{4}$">
									</label>
								</section>
								
								<section>
									<label class="label">Telefono</label> 
									<label class="input">
										<i class="icon-append fa fa-user"></i> 
										<input type="text" name="telefono" id="telefono" required="required" pattern="^[0-9]{10}$">
									</label>
								</section>
								
								<section>
									<label class="label">Matricola</label> 
									<label class="input">
										<i class="icon-append fa fa-user"></i> 
										<input type="text" name="matricola" id="matricola" required="required" pattern="^[0-9]{10}$">
									</label>
								</section>
								
								<section>
									<label class="label">Descrizione</label> 
									<label class="input">
										<i class="fa"></i> 
										<textarea rows="4" cols="50" maxlength="300" name="descrizione" form="form-reg"></textarea>
									</label>
								</section>
								
								<section>
									<label class="label">Immagine del Profilo</label> 
									<label class="input">
										<i class="fa"></i> 
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
	
<jsp:include page="footer.jsp" />
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
			}else{
			%>
			<script type="text/javascript">
				alert("La registrazione è avvenuta con successo.");
			</script>	
			<%
			}
			request.getSession().removeAttribute("registrazioneOK");
		}
	%>
</html>