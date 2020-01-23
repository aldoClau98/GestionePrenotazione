<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@	page import="java.util.ArrayList"%>


<% 	String pageTitle= "Creazione aula";
   	request.setAttribute("pageTitle", pageTitle);
   	ArrayList<String> strutt = (ArrayList<String>) request.getAttribute("strutt");%>

<jsp:include page="Header.jsp" />

<div class="container" style="padding-top: 160px">
	<p>
		<span><%= pageTitle %></span>
	</p>
</div>

<!--INIZIO CONTAINER CENTRALE-->
<div id="container-centrale">
	<div class="login-clean">
		<form method="GET" action="CreaAula">
			<div class="illustration">
				<img src="img/aula.png" width="80%">
			</div>
			<div class="form-group">
				<input class="form-control" name="nome" placeholder="Nome" />
			</div>
			<div class="form-group">
				<select name="edificio" class="custom-select" tabindex="-1"
					id="select-name">
					<option value="" selected>Selezione un edificio</option>
						<% for(String st: strutt){ %>
						<option value="<%= st %>"><%= st %></option>
						<% } %>
				</select>
			</div>
			<div class="form-group">
				<input class="form-control" name="descrizione"
					placeholder="descrizione" />
			</div>
			<div class="form-group">
				<button class="btn btn-secondary btn-block" type="submit">Crea</button>
			</div>
		</form>
	</div>
</div>
<!--FINE CONTAINER CENTRALE-->
<jsp:include page="Footer.jsp" />
