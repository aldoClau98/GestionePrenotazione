<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String pageTitle = "Rimozione dipartimento";
	request.setAttribute("pageTitle", pageTitle);
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
		<form method="POST" action="RimuoviDipartimento">
			<div class="illustration">
				<img src="img/dipartimento.jpg" width="80%">
			</div>
			<div class="form-group">
				<div class="wrapper">
					<select name="dipartimento" class="custom-select" tabindex="-1"
						id="select-name">
						<option value="" selected>Selezione un dipartimento</option>
						<c:forEach items="${listaDip}" var="i">
							<option value="${i}">${i}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<button class="btn btn-secondary btn-block" type="submit">Elimina</button>
			</div>
		</form>
	</div>
</div>
<!--FINE CONTAINER CENTRALE-->

<jsp:include page="Footer.jsp" />
