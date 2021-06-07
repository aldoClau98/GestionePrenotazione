<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="Model.Struttura"%>
<%@ page import="Model.Prenotazione"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="Model.Utente"%>
<%@ page import="Model.Dipartimento"%>



<%
	final String[] array = { "Lunedi", "Martedi", "Mercoledi", "Giovedi", "Venerdi", "Sabato", "Domenica" };
%>

<%
	Struttura s = (Struttura) request.getAttribute("strutt");
	Dipartimento dip = (Dipartimento) request.getAttribute("dip");
	String pageTitle = "Calendario";
	request.setAttribute("pageTitle", pageTitle);
	Utente c = (Utente) session.getAttribute("utente");
%>

<jsp:include page="Header.jsp" />


<div class="container" style="padding-top: 180px">
	<p>
		<span>Nome aula: ${strutt.aula}</span><br>
	</p>
	<p>
		<span>Edificio: ${strutt.edificio}</span><br>
	</p>
	<p style="display: block ruby;">
		<span>Dipartimento: ${strutt.dipartimento}</span>
		<%
			if ((c != null) && (c.getTipoUtente() == 3)) {
		%>

		<span> <a class="btn action-button"
			href="NavScegliDipartimento?dipartimento=${strutt.dipartimento}&aula=${strutt.aula}&edificio=${strutt.edificio}"
			role="button"> <i class="material-icons">edit</i>
		</a>
		</span>
		<%
			}
		%>
	</p>
	<p>
		<span>Tipo Aula: ${strutt.descrizione}</span><br>
	</p>
	<p>
		<span>Prenotabilita': 
			<c:if test="${strutt.tipoAula == 1}">docenti/studenti</c:if>
			<c:if test="${strutt.tipoAula == 0}">docenti</c:if>
			<c:if test="${strutt.tipoAula == 2}">docenti/Tutor/studenti</c:if>
			<c:if test="${strutt.tipoAula == 3}">docenti/tutor</c:if>
		</span> <span> <%
 	if (c != null) {
 		if (c.getTipoUtente() == 2 && dip.getAmmDip().equals(c.getEmail())) {
 %> <c:choose>
				<c:when test="${strutt.tipoAula=='1'}">
					<form action="AulaStudenti" method="POST">
						<input type="hidden" name="aula" value="${strutt.aula}" /> <input
							type="hidden" name="edificio" value="${strutt.edificio}" /> <input
							type="hidden" name="flag" value="0" />
						<button class="btn btn-secondary" type="submit">Rimuovi
							prenotabilita' agli studenti</button>
					</form>
				</c:when>
				<c:when test="${strutt.tipoAula=='2'}">
					<form action="AulaStudenti" method="POST">
						<input type="hidden" name="aula" value="${strutt.aula}" /> <input
							type="hidden" name="edificio" value="${strutt.edificio}" /> <input
							type="hidden" name="flag" value="3" />
						<button class="btn btn-secondary" type="submit">Rimuovi
							prenotabilita' agli studenti</button>
					</form>
				</c:when>

				<c:otherwise>
					<form action="AulaStudenti" method="POST">
						<input type="hidden" name="aula" value="${strutt.aula}" /> <input
							type="hidden" name="edificio" value="${strutt.edificio}" /> 
							<c:if test="${strutt.tipoAula == 3}"><input type="hidden" name="flag" value="2"/></c:if>
							<c:if test="${strutt.tipoAula == 0}"><input type="hidden" name="flag" value="1"/></c:if>
									
						<button class="btn btn-secondary" type="submit">Rendi
							aula prenotabile agli studenti</button>
					</form>
				</c:otherwise>

			</c:choose> <%
 	}
 	}
 %>
		</span>
	</p>
	<!--  l'aula puo essere prenotata da studenti o da docenti ed ora anche da Tutor -->
	<p>
		<span>Aula Tutor: 
			<c:if test="${strutt.tipoAula == 2}">Si</c:if>
			<c:if test="${strutt.tipoAula == 3}">Si</c:if>
			<c:if test="${strutt.tipoAula == 1}">No</c:if>
			<c:if test="${strutt.tipoAula == 0}">No</c:if>
		</span>
		 <span> <%
 			if (c != null) {
 					if (c.getTipoUtente() == 2 && dip.getAmmDip().equals(c.getEmail())) {
 					%> <c:choose>
							<c:when test="${strutt.tipoAula=='2'}">
								<form action="AulaStudenti" method="POST">
									<input type="hidden" name="aula" value="${strutt.aula}" /> 
									<input type="hidden" name="edificio" value="${strutt.edificio}" />
							 		<input type="hidden" name="flag" value="1"/>
										<button class="btn btn-secondary" type="submit">Rimuovi prenotabilita' tutor</button>
								</form>
						</c:when>
						<c:when test="${strutt.tipoAula=='3'}">
								<form action="AulaStudenti" method="POST">
									<input type="hidden" name="aula" value="${strutt.aula}" /> 
									<input type="hidden" name="edificio" value="${strutt.edificio}" />
							 		<input type="hidden" name="flag" value="0"/>
										<button class="btn btn-secondary" type="submit">Rimuovi prenotabilita' tutor</button>
								</form>
						</c:when>

							<c:otherwise>
								<form action="AulaStudenti" method="POST">
									<input type="hidden" name="aula" value="${strutt.aula}" /> 
									<input type="hidden" name="edificio" value="${strutt.edificio}" />
									<!--  se l'aula è prenotabile solo da docenti (0) allora diventa 3, se invece è prenotabile da studenti  e docenti (1) allora diventa 2 -->
									<c:if test="${strutt.tipoAula == 1}"><input type="hidden" name="flag" value="2"/></c:if>
									<c:if test="${strutt.tipoAula == 0}"><input type="hidden" name="flag" value="3"/></c:if>
									<input type="hidden" name="flag" value=""/>
										<button class="btn btn-secondary" type="submit">Rendi aula prenotabile ai Tutor</button>
								</form>
							</c:otherwise>

					</c:choose> <%
			 		}
			 	}
			 %>
		</span>
	</p>

	<br> <br> <br>
	<p style="display: block ruby">
		<span>Seleziona data</span> <span> <input id="datepicker"
			width="200px" onchange="getData(this.value, '${strutt.aula}')" />
		</span>
	</p>
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
						<th style="text-align:center"><%=k%>:00</th>
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
				//se è  docente,  se invece è uno studente e l aula è prenotabile
				if ( (c.getTipoUtente() == 1) || (c.getTipoUtente() == 0 && s.getTipoAula() == 1) ||
						(c.getTipoUtente() == 2) || (c.getTipoUtente() == 4 && ( ( s.getTipoAula() == 2) || (s.getTipoAula() == 3) ) )) {
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
							placeholder="Data" type="hidden" />
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
		</div>
		<%
			}

			}
		%>
	</div>
</div>
<!--FINE CONTAINER CENTRALE-->

<jsp:include page="Footer.jsp" />