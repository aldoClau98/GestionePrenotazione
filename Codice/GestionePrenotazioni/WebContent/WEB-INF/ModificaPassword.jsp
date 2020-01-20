<% 	String pageTitle= "Modifica password";
   	request.setAttribute("pageTitle", pageTitle);%>
   	
<jsp:include page="Header.jsp" />

<%@ page import="Model.Utente"%>

<% Utente c = (Utente) session.getAttribute("utente");
   out.write("Utente: "+c.getEmail()); %>
		
<div class="container" style="padding-top:180px">
	<p>
		<span><%= pageTitle %></span>
	</p>
</div>

<!--INIZIO CONTAINER CENTRALE-->
<div id="container-centrale">
	<div class="row register-form">
		<div class="col-md-8 offset-md-2">
		
			<form method="POST" action="ModificaPassword" class="custom-form">
				<h1>Modifica password</h1>
				<div class="form-row form-group">
					<div class="col-sm-4 label-column">
						<label for="validationServer01"> Vecchia Password</label>
					</div>
					<div class="col-sm-6 input-column">
						<input type="text" class="form-control" id="password" Name="password" value="pippolo66" required onchange="verifyP(this.id, this.value, ${utente.password})" />
						<div class="invalid-feedback">Improbabile che sia la tua password originale..</div>
					</div>
				</div>
				<div class="form-row form-group">
					<div class="col-sm-4 label-column">
						<label for="validationServer02">Nuova Password</label>
					</div>
					<div class="col-sm-6 input-column">
						<input type="text" class="form-control" id="rpassword" Name="rpassword" value="pippone" required onchange="verifyP(this.id, this.value)">
                        <div class="invalid-feedback">Pu� contenere solo '.' o '-' all'interno</div>
					</div>
				</div>
				<div class="form-group">
                    <div class="form-check">
                      <input class="form-check-input" type="checkbox" id="check" Name="check" required onchange=submittingP(this.form)>
                      <label class="form-check-label" for="check">
                          Confermi di esser sicuro <br> di questo cambiamento.
                      </label>
                    </div>
                </div>
				<input type="hidden" name="email" value="${utente.email}" />
				<button class="btn btn-secondary" type="submit" Name="submit" id="submit">Submit</button>
			</form>
			
		</div>
	</div>
</div>
<!--FINE CONTAINER CENTRALE-->

<jsp:include page="Footer.jsp" />
