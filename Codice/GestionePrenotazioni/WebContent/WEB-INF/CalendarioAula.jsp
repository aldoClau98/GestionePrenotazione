<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="Model.Struttura"%>
<%@ page import="Model.Prenotazione"%>
<%@ page import="java.util.ArrayList"%>
<%@	page import="Model.Utente"%>


<%
	final String[] array = { "Lunedi", "Martedi", "Mercoledi", "Giovedi", "Venerdi", "Sabato", "Domenica" };
%>

<%
	String pageTitle = "Calendario";
	request.setAttribute("pageTitle", pageTitle);
	Utente c = (Utente) session.getAttribute("utente");
%>

<jsp:include page="Header.jsp" />

<div class="container" style="padding-top: 160px">
	<p>
		<span>Nome aula: ${strutt.aula}</span><br>
	</p>
	<p>
		<span>Edificio: ${strutt.edificio}</span><br>
	</p>
	<p>
		<span>Dipartimento: ${strutt.dipartimento}</span><br>
	</p>
	<p>
		<span>Tipo aula: ${strutt.descrizione}</span><br>
	</p>
	<br> <br> <br>
	<p style="display: block ruby">
		<span>Seleziona data</span> <span> <input id="datepicker"
			width="200px" onchange="getData(this.value, '${strutt.aula}')" />
		</span> <span>
			<button class="btn btn-secondary" style="height: 38px;">
				<i class="material-icons">calendar_today</i>
			</button>
		</span>
	</p>
	<% if (request.getAttribute("messaggio") != null) { %>
	<div id="snackbar"><%= request.getAttribute("messaggio") %></div>
	<% } %>
</div>

<!--INIZIO CONTAINER CENTRALE-->
<div id="container-centrale">
	<div class="row" id="container-tabelle">
		<div class="col">
			<table class="table table-hover" style="border-collapse: inherit">
				<thead>
					<tr>
						<th>Orario</th>
						<%
							for (int k = 9; k < 19; k++) {
						%>
						<th><%=k%>:00</th>
						<%
							}
						%>
					</tr>
				</thead>
				<tbody id="orario"></tbody>
			</table>
		</div>

		<%
			if (c != null) {
		%>
		<div class="col">
			<div class="login-clean">
				<form method="POST" action="DomandaPrenotazione">
					<div class="form-group">
						<input class="form-control" name="titolo" id="titolo"
							placeholder="Titolo" onchange="verifyA(this.id, this.value)" />
						<div class="invalid-feedback">Da 5 a 32 caratteri, no
							caratteri speciali</div>
					</div>
					<div class="form-group">
						<input class="form-control" name="data" id="data"
							placeholder="Data" type="hidden"/>
					</div>
					<div class="form-group">
						<div class="wrapper">
							<select name="oraInizio" class="custom-select" tabindex="-1"
								id="oraInizio" onchange=getOra(this.value)>
								<option value="" selected>Orario inizio..</option>
								<%
									for (int k = 9; k < 19; k++) {
								%>
								<option value="<%=k%>"><%=k%>:00
								</option>
								<%
									}
								%>
							</select>
						</div>
					</div>
					<div class="form-group">
						<select name="oraFine" class="custom-select" tabindex="-1"
							id="oraFine">
						</select>
					</div>
					<div class="form-group">
						<input class="form-control" name="descrizione" id="descrizione"
							placeholder="Descrizione" onchange="verifyA(this.id, this.value)" />
						<div class="invalid-feedback">Da 15 a 250 caratteri, no
							caratteri speciali</div>
					</div>
					<input type="hidden" name="aula" value="${strutt.aula}" /> <input
						type="hidden" name="edificio" value="${strutt.edificio}" />
					<div class="form-group">
						<button class="btn btn-secondary btn-block" id="submit">Prenota</button>
					</div>
				</form>
			</div>
			<%
				if (c.getTipoUtente() == 2) {
			%>
			<form action="" method="GET">
				<button class="btn btn-secondary" type="submit"
					style="margin-left: 100px;">Rendi aula prenotabile</button>
			</form>
			<%
				}
			%>
		</div>
		<%
			}
		%>
	</div>
</div>
<!--FINE CONTAINER CENTRALE-->

<jsp:include page="Footer.jsp" />