<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String pageTitle = "Elenco utenti";
	request.setAttribute("pageTitle", pageTitle);
%>
<jsp:include page="Header.jsp" />

<div class="container" style="padding-top: 160px;">
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
						<th scope="col"># ID</th>
						<th scope="col">Nome</th>
						<th scope="col">Cognome</th>
						<th scope="col">E-mail</th>
						<th scope="col">Tipo utente</th>
						<th scope="col">Amministratore</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listaUtente}" var="i">
						<c:choose>
							<c:when test="${i.tipoUtente !='3'}">
								<tr>
									<th scope="row">1</th>
									<td>${i.nome}</td>
									<td>${i.cognome}</td>
									<td>${i.email}</td>

									<td><c:choose>
											<c:when test="${i.tipoUtente=='0'}">Studente</c:when>
											<c:when test="${i.tipoUtente=='1'}">Docente</c:when>
											<c:when test="${i.tipoUtente=='2'}">Amministratore</c:when>
										</c:choose></td>
									<td style="display: block ruby;"><c:choose>
											<c:when test="${i.tipoUtente == '2'}">
    						Si
    						<form method="POST" action="NavEditAmm">
													<input type="hidden" name="email" value="${i.email}" /> <span>
														<button class="btn action-button" type="submit">
															<i class="material-icons">edit</i>
														</button>
													</span>
												</form>
												<a class="btn action-button"
													href="ScegliAmministratore?email=${i.email}&flag=1"> <i
													class="material-icons">delete</i>
												</a>
											</c:when>
											<c:otherwise>
    						No
    						</c:otherwise>
										</c:choose></td>
								</tr>
							</c:when>
						</c:choose>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
<!--FINE CONTAINER CENTRALE-->

<jsp:include page="Footer.jsp" />
