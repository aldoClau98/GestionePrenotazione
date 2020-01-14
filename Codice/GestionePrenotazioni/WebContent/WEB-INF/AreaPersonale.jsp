<jsp:include page="Header.jsp" />
<%@ page import="Model.Utente"%>

<!--INIZIO CONTAINER CENTRALE-->
<%
	Utente c = (Utente) session.getAttribute("utente");
%>
<div class="container" style="padding-top: 200px;">
	<p>Area personale</p>
</div>

<!--INIZIO CONTAINER CENTRALE-->
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
						<td><a class="btn action-button" role="button"
							href="NavModificaPassword"> <i class="material-icons">edit</i>
						</a></td>

					</tr>
					<%
						if (request.getParameter("result") != null) {
							String result = request.getParameter("result");
							if (result.equals("1")) {
								out.write("<script>alert('Password modificata con successo!');</script>");
							} else {
								out.write("<script>alert('Errore modifica password!');</script>");
							}

						}
					%>

				</tbody>
			</table>
		</div>
	</div>
</div>
<!--FINE CONTAINER CENTRALE-->
<jsp:include page="Footer.jsp" />
