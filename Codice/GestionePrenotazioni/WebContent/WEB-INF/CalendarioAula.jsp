<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="Model.Struttura"%>
<%@ page import="Model.Prenotazione"%>
<%@ page import="java.util.ArrayList"%>

<% final String[] array = {"Lunedi", "Martedi", "Mercoledi", "Giovedi", "Venerdi", "Sabato", "Domenica"}; %>

<% 	String pageTitle= "Calendario";
   	request.setAttribute("pageTitle", pageTitle);%>
   	
<jsp:include page="Header.jsp" />

<div class="container" style="padding-top:180px">
	<p>
		<span>Nome: ${strutt.aula}</span><br>
	</p>
	<p>
		<span>Edificio: ${strutt.edificio}</span><br>
	</p>
	<p>
		<span>Dipartimento: ${strutt.dipartimento}</span><br>
	</p>
	<p>
		<span>Tipologia: ${strutt.descrizione}</span><br>
	</p>
	<br><br><br>
	<p style="display: block ruby">
		<span>Seleziona data</span>
		<span>
			<input id="datepicker" width="200px" onchange="getData(this.value, '${strutt.aula}')"/>
		</span>
		<span>
            <button class="btn btn-secondary" style="height: 38px;">
                <i class="material-icons">calendar_today</i>
            </button>
        </span>
    </p>
</div>

<!--INIZIO CONTAINER CENTRALE-->
<div id="container-centrale">
	<div class="row" id="container-tabelle">
		<div class="col">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Orario</th>
						<th>Lunedì</th>
						<th>Martedì</th>
						<th>Mercoledì</th>
						<th>Giovedì</th>
						<th>Venerdì</th>

						<%-- <%
							if ((session.getAttribute("listaPren")) == null) {

							} else {
								ArrayList<Prenotazione> lista = (ArrayList<Prenotazione>) session.getAttribute("listaPren");

								int i = 0;

								for (i = 0; i < array.length; i++) {
									out.print("<th>" + array[i] + "</th>");
								}
								out.print("</tr></thead><tbody>");
								int hours = 0;
								if (lista.size() > 0) {
									int j = 0;
									for (hours = 9; hours < 18; hours++) {
										out.write("<tr><th>" + hours + "</th></tr>");

										if (hours == (lista.get(j)).getOraInizio()) {
											out.write("<td>" + lista.get(j).getAulaPrenotata() + "</td>");

										}
									}
									out.print("<tbody></table>");
								}
							}
						%> --%>
					</tr>
				</thead>
				<tbody id="orario"></tbody>
			</table>
		</div>
		<div class="col">
			<div class="login-clean">
				<form method="GET" action="Prenotazione">
					<div class="form-group">
						<input class="form-control" name="titolo" id="titolo" placeholder="Titolo" onchange="verifyA(this.id, this.value)"/>
                        <div class="invalid-feedback">Da 5 a 32 caratteri, no caratteri speciali</div>
					</div>
					<div class="form-group">
						<input class="form-control" name="data" id="data" placeholder="Data" disabled/>
					</div>
					<div class="form-group">
						<input class="form-control" name="oraInizio" id="oraInizio" placeholder="Ora inizio" onchange="verifyA(this.id, this.value)"/>
                        <div class="invalid-feedback">Formato ora 00:00</div>
					</div>
					<div class="form-group">
						<input class="form-control" name="oraFine" id="oraFine" placeholder="Ora fine" onchange="verifyA(this.id, this.value)"/>
                        <div class="invalid-feedback">Formato ora 00:00</div>
					</div>
					<div class="form-group">
						<input class="form-control" name="descrizione" id="descrizione" placeholder="Descrizione" onchange="verifyA(this.id, this.value)"/>
                        <div class="invalid-feedback">Da 15 a 250 caratteri, no caratteri speciali</div>
					</div>
					<input type="hidden" name="aula" value="${struttura.aula}" />
				 	<input type="hidden" name="edificio" value="${struttura.edificio}" />
				 	<div class="form-group">
						<button class="btn btn-secondary btn-block" id="submit">Prenota</button>
					</div>
				</form>
			</div>
			<button class="btn btn-secondary" style="margin-left: 100px;">Rendi aula prenotabile</button>
		</div>
	</div>
</div>
<!--FINE CONTAINER CENTRALE-->

<jsp:include page="Footer.jsp" />