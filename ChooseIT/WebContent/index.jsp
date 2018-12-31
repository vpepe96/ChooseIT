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
						String urlLogin=response.encodeURL("ServletLogin");
					%>


					<div class="well no-padding">
						<form action="<%=urlLogin%>" method="post" id="login-form"
							class="smart-form client-form">
							<header> Login </header>

							<fieldset>

								<section>
									<label class="label">E-mail</label> 
									<label class="input">
										<i class="icon-append fa fa-user"></i> 
										<input type="email" name="email" required="required">
									</label>
								</section>

								<section>
									<label class="label">Password</label> 
									<label class="input">
										<i class="icon-append fa fa-lock"></i> 
										<input type="password" name="password" required="required">
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
	
<jsp:include page="footer.jsp" />
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
			request.getSession().removeAttribute("loginOK");
		}
	%>
</html>