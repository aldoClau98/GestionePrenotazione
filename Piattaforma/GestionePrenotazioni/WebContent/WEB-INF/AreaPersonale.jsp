<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%
	String pageTitle = "Area-Personale";
	request.setAttribute("pageTitle", pageTitle);
%>

<jsp:include page="Header.jsp" />

<%@ page import="Model.Utente"%>

<%
	Utente c = (Utente) session.getAttribute("utente");
	String result = request.getParameter("result");
%>

<div class="container" style="padding-top: 180px">
	<p>
		<span><%=pageTitle%></span>
	</p>
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
						<th scope="col"> Tipo utente </th>
						<th scope="col">Password</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${utente.nome}</td>
						<td>${utente.cognome}</td>
						<td>${utente.email}</td>
						<!-- AGGIORNAMENTO: aggiunta visualizzazione tipo di utente -->
						<td><c:choose>
											<c:when test="${utente.tipoUtente=='0'}">Studente</c:when>
											<c:when test="${utente.tipoUtente=='1'}">Docente</c:when>
											<c:when test="${utente.tipoUtente=='2'}">Amministratore</c:when>
										</c:choose></td>
										
						<td><c:forEach var="i" begin="1"
								end='${fn:length(utente.password)}'>
							*</c:forEach> <a class="btn action-button" role="button"
							href="NavModificaPassword"> <i class="material-icons">edit</i>
						</a></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
<!--FINE CONTAINER CENTRALE-->

<jsp:include page="Footer.jsp" />
