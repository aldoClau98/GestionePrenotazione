<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ page import="Model.Dipartimento"%>
	
<jsp:include page="Header.jsp" />

<div class="container" style="padding-top: 200px;">
	<p>Dipartimenti</p>
</div>
<!--INIZIO CONTAINER CENTRALE-->
<div id="container-centrale">
	<div class="row" id="container-tabelle">
		<c:forEach items="${listaDipartimenti}" var="i">
			<div class="col">
				<table class="table table-hover">
					<thead class="show-hidden-menu-1">
						<tr>
							<th scope="col">
								<form method="post" action="Dipartimento">
									<input type="hidden" name="dip" value="${i.dip}" />
									<button type="submit">${i.dip}</button>
								</form>
							</th>
							<th>
							Amministratore: ${i.ammDip}
							</th>
						</tr>
					</thead>
					<%
						if ((request.getParameter("listaStr")) == null) {
					%>
					<c:forEach items="${listaStr}" var="l">
						<tbody class="hidden-menu-1" style="">
							<tr data-href="Aula">
								<th scope="row">Edificio: ${l.edificio}</th>
								<td>Aula: ${l.aula}</td>
								<td>Prenotabile dagli  studenti: ${l.tipoAula}</td>
								
							
							</tr>
						</tbody>
					</c:forEach>
					<%
						}
					%>
				</table>
			</div>
		</c:forEach>

	</div>
</div>
<!--FINE CONTAINER CENTRALE-->


<jsp:include page="Footer.jsp" />