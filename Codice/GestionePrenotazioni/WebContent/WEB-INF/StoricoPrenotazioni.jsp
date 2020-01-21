<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@	page import="Model.Utente"%>
<%@	page import="java.util.ArrayList"%>
<%@	page import="Model.Prenotazione"%>



<%
	String pageTitle = "Storico prenotazioni";
	request.setAttribute("pageTitle", pageTitle);
	Utente c = (Utente) session.getAttribute("utente");
	ArrayList<Model.Prenotazione> listaPrenotazioni = (ArrayList<Model.Prenotazione>)request.getAttribute("listaPrenotazioni");
%>

<jsp:include page="Header.jsp" />

<div class="container" style="padding-top: 160px">
	<p>
		<span><%=pageTitle%></span>
	</p>

	<% if (request.getAttribute("messaggio") != null) { %>
	<div id="snackbar"><%= request.getAttribute("messaggio") %></div>
	<% } %>
</div>
<!--INIZIO CONTAINER CENTRALE-->
<div id="container-centrale">
	<div class="row" id="container-tabelle">
		<div class="col">
			<table class="table table-hover">
				<thead>
					<tr>
						<th># Prenotazione</th>
						<th>Motivazione</th>
						<th>Aula</th>
						<th>Edificio</th>
						<th>Data</th>
						<th>Ora inizio</th>
						<th>Ora fine</th>
					</tr>
				</thead>
				<tbody>

					<% int k = 1;
					for(Prenotazione p : listaPrenotazioni) { %>
					<tr>
						<th># <%=k%> <%= p.getTitolo() %>

							<form action="EliminaPrenotazione" method="get">
								<input type="hidden" name="id"
									value="<%= p.getIDprenotazione() %>">
								<button class="btn action-button" role="button" type="submit">
									<i class="material-icons">delete</i>
								</button>
							</form>
						</th>
						<td><%= p.getDescrizione() %></td>
						<td><%= p.getAula() %></td>
						<td><%= p.getEdificio() %></td>
						<td><%= p.getData() %></td>
						<td><%= p.getOraInizio() %>:00</td>
						<td><%= p.getOraFine() %>:00</td>
					</tr>
					<%
							k++;
						}
						%>

				</tbody>
			</table>
		</div>
	</div>
</div>
<!--FINE CONTAINER CENTRALE-->

<jsp:include page="Footer.jsp" />
