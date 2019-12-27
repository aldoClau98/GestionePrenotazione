<jsp:include page="Header.jsp" />
<%@ page import="Model.Utente"%>

<!--INIZIO CONTAINER CENTRALE-->
<%
	Utente c = (Utente) session.getAttribute("utente");
%>
<div id="container-centrale">
	<div class="row" id="container-tabelle">
		<div class="col">
			<table class="table table-hover">
				<thead>
					<tr>

						<th scope="col">Nome</th>
						<th scope="col">Cognome</th>
						<th scope="col">E-mail</th>
						<th scope="col">Password</th>
					</tr>
				</thead>
				<tbody>
					<tr>

						<td>${utente.nome}</td>
						<td>${utente.cognome}</td>
						<td>${utente.email}</td>
						<td>${utente.password}</td>
							<form method="POST" action="NavModificaPassword">
								<button class="btn action-button" role="button"
									href="NavModificaPassword">
									<i class="material-icons">edit</i>
								</button>
							</form>
						
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
<!--FINE CONTAINER CENTRALE-->
<jsp:include page="Footer.jsp" />
