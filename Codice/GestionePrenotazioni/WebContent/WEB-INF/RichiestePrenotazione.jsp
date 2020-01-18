<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<% 	String pageTitle= "Richieste prenotazione";
   	request.setAttribute("pageTitle", pageTitle);%>
   	
<jsp:include page="Header.jsp" />

<div class="container" style="padding-top:180px">
	<p>
		<span><%= pageTitle %></span>
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
					
					<% int k = 1; %>
					<c:forEach items="${listaPrenotazioni}" var="i">
						<tr>
							<th style="display: block ruby;"><%= k %> <% k++; %>
								<form action="EliminaRichiesta" method="GET">
									<input type="hidden" value="${i.IDprenotazione}" name="id" />
									<button class="btn action-button" type="submit">
										<i class="material-icons">delete</i>
									</button>
								</form>
								<form action="AccettaRichiesta" method="GET">
									<input type="hidden" value="${i.IDprenotazione}" name="id"/>
									<button type="submit" class="btn action-button" style="padding-bottom:10px;">
										<i class="material-icons btn action-button" role="button" type="submit">check_circle</i>
									</button>
								</form>
							</th>
							<td>${i.titolo}</td>
							<td>${i.utente}</td>
							<td>${i.descrizione}</td>
							<td>${i.edificio}</td>
							<td>${i.aulaPrenotata}</td>
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
