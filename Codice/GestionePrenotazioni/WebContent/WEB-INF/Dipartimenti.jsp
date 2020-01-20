<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<%@ page import="Model.Dipartimento" 
		 import="java.util.ArrayList" %>
		 
<% ArrayList<Model.Dipartimento> listaAmministratori = (ArrayList<Model.Dipartimento>)session.getAttribute("listaAmministratori"); 
	ArrayList<String> listaDipartimenti =(ArrayList<String>) session.getAttribute("listaDipartimenti"); %>

<% 	String pageTitle= "Dipartimenti";
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
	
		<%for (String str: listaDipartimenti){ %>
			<div class="col">
				<table class="table table-hover">
					<thead onclick="getDipartimenti('<%= str %>')">
						<tr>
							<th colspan="2">Dipartimento <%= str %></th>
							<th>Amministratore:
							<% for(Model.Dipartimento d: listaAmministratori) {
									if (d.getDip().equals(str)) {%>
										<%= d.getAmmDip() %>
									<% } %>
								<% } %>
							</th>
						</tr>
					</thead>
					<tbody id="<%= str %>"></tbody>
				</table>
			</div>
		<% } %>

	</div>
</div>
<!--FINE CONTAINER CENTRALE-->

<jsp:include page="Footer.jsp" />