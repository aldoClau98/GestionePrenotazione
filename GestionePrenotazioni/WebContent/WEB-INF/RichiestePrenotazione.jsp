<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String pageTitle = "Richieste prenotazione";
	request.setAttribute("pageTitle", pageTitle);
%>

<jsp:include page="Header.jsp" />

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
						<th scope="col"># Prenotazione</th>
						<th scope="col">Motivazione</th>
						<th scope="col">Utente</th>
						<th scope="col">Descrizione</th>
						<th scope="col">Edificio</th>
						<th scope="col">Aula</th>
						<th scope="col">Data</th>
						<th scope="col">Ora inizio</th>
						<th scope="col">Ora fine</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${listaPrenotazioni}" var="i">
						<tr>
							<th style="display: ruby block">1
								<form action="EliminaRichiesta" method="get">
									<input type="hidden" value="${i.IDprenotazione}" name="id" />
									<button class="btn action-button" role="button" type="submit">
										<i class="material-icons">delete</i>
									</button>
								</form>
								<form action="AccettaRichiesta" method="POST">
									<input type="hidden" value="${i.IDprenotazione}" name="id" />
									<input type="hidden" value="${i.data}" name="data" />
									<input type="hidden" value="${i.aula}" name="aula" />
									<input type="hidden" value="${i.edificio}" name="edificio" />
									<input type="hidden" value="${i.oraInizio}" name="oraInizio" />
									<input type="hidden" value="${i.oraFine}" name="oraFine" />
									<button class="btn action-button" role="button" type="submit">
										<i class="material-icons">check_circle</i>
									</button>
								</form>
							</th>
							<td>${i.titolo}</td>
							<td>${i.utente}</td>
							<td>${i.descrizione}</td>
							<td>${i.edificio}</td>
							<td>${i.aula}</td>
							<td>${i.data}</td>
							<td>${i.oraInizio}</td>
							<td>${i.oraFine}</td>
						</tr>
					</c:forEach>

				</tbody>

			</table>
		</div>
	</div>
</div>
<!--FINE CONTAINER CENTRALE-->

<jsp:include page="Footer.jsp" />
