<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<% 	String pageTitle= "Rimozione aula";
   	request.setAttribute("pageTitle", pageTitle);%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="Header.jsp" />

<div class="container" style="padding-top:180px">
	<p>
		<span><%= pageTitle %></span>
	</p>
</div>

<!--INIZIO CONTAINER CENTRALE-->
<div id="container-centrale">
	<div class="login-clean">
		<form action="RimuoviAula" method="GET">
			<div class="illustration">
				<img src="img/aula.png" width="80%">
			</div>
			<div class="form-group">
				<input class="form-control" type="text" name="edificio" placeholder="Nome edificio" />
			</div>
			<div class="form-group">
				<input class="form-control" type="text" name="aula" placeholder="Nome Aula" />
			</div>
			<div class="form-group">
				<button class="btn btn-secondary btn-block" type="submit"
					>Elimina</button>
			</div>
		</form>
	</div>
</div>
<!--FINE CONTAINER CENTRALE-->

<jsp:include page="Footer.jsp" />
