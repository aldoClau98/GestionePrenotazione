<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	String pageTitle = "Assegnamento Tutor";
	request.setAttribute("pageTitle", pageTitle);
%>

<jsp:include page="Header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

String email = request.getParameter("email"); 

%>
<div class="container" style="padding-top: 180px;">
	<p><%= pageTitle %></p>
</div>

<!--INIZIO CONTAINER CENTRALE-->
<div id="container-centrale">
	<div class="login-clean">
		<form method="POST" action="EditTutor">
			<input type="hidden" name="email" value="${email}" />
			<div class="illustration">
				<img src="img/profilo.png" width="80%">
			</div>
			<div class="form-group">
				<div class="wrapper">
					<select name="corso" class="custom-select" tabindex="-1"
						id="select-name">
						<option value="" selected>Selezione un Corso</option>
						<c:forEach items="${listaCorsi}" var="i">
							<option  value="${i.nomeCorso}">${i.nomeCorso} - ${i.nomeDip}</option>
						</c:forEach>

					</select>
				</div>
			</div>
			<div class="form-group">
				<button class="btn btn-secondary btn-block" type="submit">Assegna Tutor</button>
			</div>
		</form>
	</div>
</div>
<!--FINE CONTAINER CENTRALE-->

<jsp:include page="Footer.jsp" />