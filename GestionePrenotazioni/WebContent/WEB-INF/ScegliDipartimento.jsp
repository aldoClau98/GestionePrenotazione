<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% 	String pageTitle= "Scegli Dipartimento";
   	request.setAttribute("pageTitle", pageTitle);
   	
   	String aula = (String) request.getAttribute("aula");
	String edificio = (String) request.getAttribute("edificio");
   	
%>

<jsp:include page="Header.jsp" />
<!--INIZIO CONTAINER CENTRALE-->
<div id="container-centrale">
	<div class="login-clean">
		<form method="Post" action="AssegnaDipartimentoAula">
			<input type="hidden" value="<%= aula %>" name="aula" /> <input
				type="hidden" value="<%= edificio %>" name="edificio" />

			<div class="illustration">
				<img src="img/dipartimento.jpg" width="80%">
			</div>
			<div class="form-group">
				<div class="wrapper">
					<select name="dipartimento" class="custom-select" tabindex="-1"
						id="select-name">
						<option value="" selected>Assegna un dipartimento</option>
						<c:forEach items="${listaDip}" var="i">

							<option value="${i}">${i}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<button class="btn btn-secondary btn-block" type="submit">Assegna</button>
			</div>
		</form>
	</div>
</div>
<!--FINE CONTAINER CENTRALE-->
