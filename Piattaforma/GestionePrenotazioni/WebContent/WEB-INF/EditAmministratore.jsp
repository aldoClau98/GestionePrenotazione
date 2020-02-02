<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	String pageTitle = "Assegnamento dipartimento";
	request.setAttribute("pageTitle", pageTitle);
%>

<jsp:include page="Header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

String email = request.getParameter("docente"); %>
<div class="container" style="padding-top: 180px;">
	<p><%= pageTitle %></p>
</div>

<!--INIZIO CONTAINER CENTRALE-->
<div id="container-centrale">
	<div class="login-clean">
		<form method="GET" action="EditAmministratore">
			<input type="hidden" name="email" value="${email}" />
			<div class="illustration">
				<img src="img/profilo.png" width="80%">
			</div>
			<div class="form-group">
				<div class="wrapper">
					<select name="dip" class="custom-select" tabindex="-1"
						id="select-name">
						<option value="" selected>Selezione un Dipartimento</option>
						<c:forEach items="${listaDipartimenti}" var="i">
							<option value="${i.dip}">${i.dip}</option>
						</c:forEach>

					</select>
				</div>
			</div>
			<div class="form-group">
				<button class="btn btn-secondary btn-block" type="submit">Cambia
					dipartimento</button>
			</div>
		</form>
	</div>
</div>
<!--FINE CONTAINER CENTRALE-->

<jsp:include page="Footer.jsp" />