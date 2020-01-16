<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="Model.Struttura"%>
<%@ page import="java.util.ArrayList"%>

<jsp:include page="Header.jsp" />

<div class="container" style="padding-top: 200px;">
	<p>
		<span>Edifici</span>
	</p>
</div>

<!--INIZIO CONTAINER CENTRALE-->
<div id="container-centrale">
	<div class="row" id="container-tabelle">
			
			<!-- ciclo  che crea tutte le aule  -->
			<c:forEach items="${listaEdifici}" var="i">
				<div class="col">
					<table class="table table-hover">
						<thead class="show-hidden-menu-1">
							<tr>
								<th>${i}</th>
							</tr>
						</thead>
						<!-- <tbody class="hidden-menu-1" style="display:none">
		                	<tr data-href="Aula.html">
			                    <th scope="row">1</th>
			                    <td>S2</td>
			                    <td>Room</td>
		                  	</tr>
		                  	<tr data-href="Aula.html">
			                    <th scope="row">2</th>
			                    <td>P2</td>
			                    <td>Laboratory</td>
		                  	</tr>
		                  	<tr data-href="Aula.html">
			                    <th scope="row">3</th>
			                    <td>F2</td>
			                    <td>Room</td>
		                  	</tr>
                		</tbody> -->
					</table>
				</div>
			</c:forEach>
		
	</div>
</div>

<jsp:include page="Footer.jsp" />