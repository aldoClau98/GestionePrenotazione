<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="Header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="Model.Struttura"%>

<%@ page import="java.util.ArrayList"%>


<!--INIZIO CONTAINER CENTRALE-->
<div id="container-centrale">
	<div class="row" id="container-tabelle">
		<div class="col">

			<c:forEach items="${listaEdifici}" var="i">
				<!-- ciclo  che crea tutte le aule  -->
				<table class="table table-hover">
					<thead>

						<tr>
							<th>
								<form method="post" action="Edifici">
									<input type="hidden" name="edificio" value="${i}" />
									<!--  quando un  aula viene cliccata mando il  
                   nome al controller che si  va a prendere le aule dell'edificio e le rimanda alla jsp   -->
									<button type="submit">${i}</button>
								</form>
							</th>
						</tr>
					</thead>
					<c:forEach items="${listaAule}" var="l">
						<!-- le aule dell'edificio  vengono visualizzate  di seguito -->
						<tbody style="">
							<!-- PROBLEMA: quando  vengono visualizzate le aule, escono  sotto tutti gli edifici -->
							<tr data-href="Aula">
								<th>
									<form method="post" action="Aula">
									<input type="hidden" name="edificio" value="${i}" />
										<input type="hidden" name="aula" value="${l.nome}" />
										<button type="submit">${l.nome}</button>
									</form>
								</th>
								<td>${l.isAulaStd}</td>
								<td>${l.descrizione}</td>
							</tr>



						</tbody>
					</c:forEach>
				</table>
			</c:forEach>
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