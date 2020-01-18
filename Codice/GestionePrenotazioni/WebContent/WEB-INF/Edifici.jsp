<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="Model.Struttura"%>
<%@ page import="java.util.ArrayList"%>

<% 	String pageTitle= "Edifici";
   	request.setAttribute("pageTitle", pageTitle);%>
   	
<jsp:include page="Header.jsp" />

<div class="container" style="padding-top:180px">
	<p>
		<span><%= pageTitle %></span>
	</p>
</div>

<!--INIZIO CONTAINER CENTRALE-->
<div id="container-centrale">
	<div class="row" id="container-tabelle">
			
			<!-- ciclo  che crea tutte le aule  -->
			<c:forEach items="${listaEdifici}" var="i">
				<div class="col">
					<table class="table table-hover">
						<thead onclick="getAule('${i}')">
							<tr>
								<th>Edificio ${i}</th>
							</tr>
						</thead>
						<tbody id="${i}"></tbody>
					</table>
				</div>
			</c:forEach>
		
	</div>
</div>
<!--FINE CONTAINER CENTRALE-->

<jsp:include page="Footer.jsp" />