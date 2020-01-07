
<jsp:include page="Header.jsp" />

<%@ page import="Model.Utente"%>
<%
	Utente c = (Utente) session.getAttribute("utente");
		out.write("Utente: "+c.getEmail());
%>
<div class="container" style="padding-top: 200px;">
	<p>Modifica password</p>
</div>
<!--INIZIO CONTAINER CENTRALE-->
<div id="container-centrale">
	<div class="row register-form">
		<div class="col-md-8 offset-md-2">
			<form method="POST" action="ModificaPassword" class="custom-form">
				<!-- Aggiungere controllo  Jquery  per i campi  Nuova passowrd e ripeti password -->
				<h1>Modifica password</h1>
				<div class="form-row form-group">
					<div class="col-sm-4 label-column">
						<label for="validationServer01"> Vecchia Password</label>
					</div>
					<div class="col-sm-6 input-column">
						<input type="password" class="form-control is-valid"
							id="validationServer01" name="oldPassw" required>
						<div class="valid-feedback">Funziona!</div>
					</div>
				</div>
				<div class="form-row form-group">
					<div class="col-sm-4 label-column">
						<label for="validationServer02">Nuova Password</label>
					</div>
					<div class="col-sm-6 input-column">
						<input type="password" class="form-control is-invalid"
							id="validationServer02" name="newPassw" required>
						<div class="invalid-feedback"></div>
					</div>
				</div>
				<div class="form-row form-group">
					<div class="col-sm-4 label-column">
						<label for="validationServer02">Ripeti Password</label>
					</div>
					<div class="col-sm-6 input-column">
						<input type="password" class="form-control is-invalid"
							id="validationServer03" name="repPassw" required>
						<div class="invalid-feedback"></div>
					</div>
				</div>
				<input type="hidden" name="email" value="${utente.email}" />
				<button class="btn btn-secondary" type="submit">Modifica</button>
			</form>
		</div>
	</div>
</div>
<!--FINE CONTAINER CENTRALE-->
<jsp:include page="Footer.jsp" />
<!--  Aggiungere il controllo  per la password  -->