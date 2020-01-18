<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<% 	String pageTitle= "Aula";
   	request.setAttribute("pageTitle", pageTitle);%>
   	
<jsp:include page="Header.jsp" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="Model.Struttura"%>
<%@ page import="java.util.ArrayList"%>

<div class="container" style="padding-top:180px">
	<p>
		<span><%= pageTitle %></span>
	</p>
</div>

<!--INIZIO CONTAINER CENTRALE-->
<div id="container-centrale">
	<div class="row" id="container-tabelle">
		<div class="col">
			<table>
					
				<tbody class="" >
					<tr>
					<c:forEach items="${listaAule}" var="i">
						<th>
							<form method="post" action="NavAula">
							<input type="hidden" name="edificio" value="${edificio}" />
								<input type="hidden" name="aula" value="${i.aula}" />
								<button type="submit">${i.aula}</button>
							</form>
						</th>
						<td>Prenotabile da studenti: ${i.tipoAula}</td>
						<td>Descrizione: ${i.descrizione}</td>
						
						</c:forEach>
					</tr>
				</tbody>
					
			</table>
		</div>
	</div>
</div>

<!--FINE CONTAINER CENTRALE-->

<jsp:include page="Footer.jsp" />