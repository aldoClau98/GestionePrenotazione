<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@	page import="java.util.ArrayList"%>


<%
	String pageTitle = "Rimozione aula";
	request.setAttribute("pageTitle", pageTitle);
	ArrayList<String> listaEdifici = (ArrayList<String>) request.getAttribute("listaEdifici");
%>

<jsp:include page="Header.jsp" />

<div class="container" style="padding-top: 180px">
	<p>
		<span><%=pageTitle%></span>
	</p>
</div>

<!--INIZIO CONTAINER CENTRALE-->
<div id="container-centrale">
	<div class="login-clean">
		<form action="RimuoviAula" method="GET" if="form-rimozione">
			<div class="illustration">
				<img src="img/aula.png" width="80%">
			</div>
			<div class="form-group">
				<select name="edificio" class="custom-select" tabindex="-1"
					id="select-edificio" onchange="rimAula(this.value)">
					<option value="" selected>Selezione un edificio..</option>
					<% for(String str: listaEdifici){ %>
					<option value="<%= str %>"><%= str %></option>
					<% } %>
				</select>
			</div>
			<div class="form-group">
				<select name="aula" class="custom-select" tabindex="-1"
					id="select-aula" onchange="rimAula()">
					<option value="" selected>Selezione un aula..</option>
				</select>
			</div>
			<div class="form-group">
				<button class="btn btn-secondary btn-block" type="submit">Elimina</button>
			</div>
		</form>
	</div>
</div>
<!--FINE CONTAINER CENTRALE-->

<jsp:include page="Footer.jsp" />
