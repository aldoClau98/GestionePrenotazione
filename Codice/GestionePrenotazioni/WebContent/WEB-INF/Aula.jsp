<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="Header.jsp" />
<%@ page import="Model.Struttura"%>
<%@ page import="Model.Prenotazione"%>
<%@ page import="java.util.ArrayList"%>

<%
	final String[] array = { "Lunedi", "Martedi", "Mercoledi", "Giovedi", "Venerdi", "Sabato", "Domenica" };
%>
<div class="container" style="padding-top: 200px;">
	<p>${struttura.aula}</p>
	<p>${struttura.edificio}</p>
	<p>${astruttura.dipartimento}</p>

	<span> Data </span>
	<form method="GET" action="Aula">
		<input type="text" id="datepicker" name="date" width="200px" />
		<input type="hidden" name="aula" value="${struttura.aula}" />
		 <input type="submit"/>
	</form>


</div>
<div id="container-centrale">
	<div class="row" id="container-tabelle">
		<div class="col">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Orario</th>

						<%
						
						if((session.getAttribute("listaPren"))==null){
								
							} else {
							ArrayList<Prenotazione> lista = (ArrayList<Prenotazione>) session.getAttribute("listaPren");
							
								int i = 0;

								for (i = 0; i < array.length; i++) {
									out.print("<th>" + array[i] + "</th>");
								}
								out.print("</tr></thead><tbody>");
								int hours = 0;
								
								int j = 0;
								for (hours = 9; hours < 18; hours++) {
									out.write("<tr><th>" + hours + "</th></tr>");

									if (hours == lista.get(j).getOraInizio()) {
										out.write("<td>" + lista.get(j).getAulaPrenotata() + "</td>");
										
									}
								}
								out.print("<tbody></table>");
							}
						%>
		</div>
	</div>
</div>
<jsp:include page="Footer.jsp" />