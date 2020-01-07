<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="Header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="Model.Struttura"%>
<%@ page import="java.util.ArrayList"%>

<div class="container" style="padding-top: 200px;">
	<p>Edifici</p>
</div>

<!--INIZIO CONTAINER CENTRALE-->
<div id="container-centrale">
	<div class="row" id="container-tabelle">
		<div class="col">
				<!-- ciclo  che crea tutte le aule  -->
			<c:forEach items="${listaEdifici}" var="i">
			
				<table class="table table-hover">
					<thead class="show-hidden-menu-1">
						<tr>
							<th>
								<form method="post" action="Edifici">
									<input type="hidden" name="edificio" value="${i}" />
									<input type="submit" value="${i}"/>
								</form>
							</th>
						</tr>
					</thead>
					</table>
					
					</c:forEach>
					<table>
					<c:forEach items="${listaAule}" var="l">
					
						<!-- le aule dell'edificio  vengono visualizzate  di seguito -->
						<tbody tbody class="" style="display:">
							<tr>
							<!-- Qui ci vuole per forza un form,  da vedere con  Andrea -->
								<th>
									<form method="post" action="NavAula">
									<input type="hidden" name="edificio" value="${i}" />
										<input type="hidden" name="aula" value="${l.aula}" />
										<button type="submit">${l.aula}</button>
									</form>
								</th>
								<td>Prenotabile da studenti: ${l.tipoAula}</td>
								<td>Descrizione: ${l.descrizione}</td>
								
							</tr>
						</tbody>
					</c:forEach>
				</table>
			
		</div>

		<!--FINE CONTAINER CENTRALE-->
		<script>
			$(document).ready(function() {
				$('.show-hidden-menu-1').click(function() {
					$('.hidden-menu-1').slideToggle("fast");
				});
			});

			$(document).ready(function() {
				$('.show-hidden-menu-2').click(function() {
					$('.hidden-menu-2').slideToggle("fast");
				});
			});

			$(document).ready(function() {
				$('.show-hidden-menu-3').click(function() {
					$('.hidden-menu-3').slideToggle("fast");
				});
			});
		</script>



		<jsp:include page="Footer.jsp" />