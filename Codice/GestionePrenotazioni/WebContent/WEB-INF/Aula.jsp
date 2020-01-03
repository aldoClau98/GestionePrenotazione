<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="Header.jsp" />
<%@ page import="Model.Struttura"%>

<%
	final String[] array = { "Lunedi", "Martedi", "Mercoledi", "Giovedi", "Venerdi", "Sabato",
			"Domenica" };
%>
<div class="container" style="padding-top: 200px;">
	<p>${struttura.aula}</p>
	<p>${struttura.edificio}</p>
	<p>${astruttura.dipartimento}</p>

	<span> Data </span>
	<form method="GET" action="CercaPrenotazioni">
		<input type="text" id="datepicker" name="date" width="200px" /> <input
			type="submit">Calendar Today</input>
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
							int i = 0;
							
							for (i = 0; i < array.length; i++) {
								out.print("<th>"+array[i] + "</th>");
								}
							out.print("</tr>");
								
								
								
								
								
								
								int hours=0;
								for ( hours= 9; hours < 18; hours++) {
									String h;
									
									out.write("<tr><th>" + hours+"</th></tr>");
									
									
									%>
									
									<c:forEach items="listaPren" var="i">
									
									<td>
									<%
									
									if(hours==i.oraInizio){
											out.write("<p>"+i.oraInizio"+</p>");
									 %>
									 
									
									</td>
									
									</c:forEach>
									
									<%
						}
						 %>
			
						
						</tr>
						<!-- <th>Martedì</th>
						<th>Mercoledì</th>
						<th>Giovedì</th>
						<th>Venerdì</th>
					</tr> -->
				</thead>
				<tbody>


					<!-- <tr>
						<th>8:00</th>
						<td>Informatica</td>
						<td>Informatica</td>
						<td>Informatica</td>
						<td>Informatica</td>
						<td>Informatica</td>
					</tr>
					<tr>
						<th>9:00</th>
						<td>Informatica</td>
						<td>Informatica</td>
						<td>Informatica</td>
						<td>Informatica</td>
						<td>Informatica</td>
					</tr>
					<tr>
						<th>10:00</th>
						<td>Informatica</td>
						<td>Informatica</td>
						<td>Informatica</td>
						<td>Informatica</td>
						<td>Informatica</td>
					</tr>
					<tr>
						<th>11:00</th>
						<td>Informatica</td>
						<td>Informatica</td>
						<td>Informatica</td>
						<td>Informatica</td>
						<td>Informatica</td>
					</tr>
					<tr>
						<th>12:00</th>
						<td>Informatica</td>
						<td>Informatica</td>
						<td>Informatica</td>
						<td>Informatica</td>
						<td>Informatica</td>
					</tr>
					<tr>
						<th>13:00</th>
						<td>Informatica</td>
						<td>Informatica</td>
						<td>Informatica</td>
						<td>Informatica</td>
						<td>Informatica</td>
					</tr>
					<tr>
						<th>14:00</th>
						<td>Informatica</td>
						<td>Informatica</td>
						<td>Informatica</td>
						<td>Informatica</td>
						<td>Informatica</td>
					</tr>
					<tr>
						<th>15:00</th>
						<td>Informatica</td>
						<td>Informatica</td>
						<td>Informatica</td>
						<td>Informatica</td>
						<td>Informatica</td>
					</tr>
					<tr>
						<th>16:00</th>
						<td>Informatica</td>
						<td>Informatica</td>
						<td>Informatica</td>
						<td>Informatica</td>
						<td>Informatica</td>
					</tr>
					<tr>
						<th>17:00</th>
						<td>Informatica</td>
						<td>Informatica</td>
						<td>Informatica</td>
						<td>Informatica</td>
						<td>Informatica</td>
					</tr>
					<tr>
						<th>18:00</th>
						<td>Informatica</td>
						<td>Informatica</td>
						<td>Informatica</td>
						<td>Informatica</td>
						<td>Informatica</td>
					</tr> -->
				</tbody>
			</table>
		</div>
	</div>
</div>
<jsp:include page="Footer.jsp" />