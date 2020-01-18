<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<% 	String pageTitle= "Storico prenotazioni";
   	request.setAttribute("pageTitle", pageTitle);%>
   	
<jsp:include page="Header.jsp" />

<div class="container" style="padding-top:180px">
	<p>
		<span><%= pageTitle %> per ###(dipartimento)</span>
	</p>
</div>

<!--INIZIO CONTAINER CENTRALE-->
<div id="container-centrale">
    <div class="row" id="container-tabelle">
        <div class="col">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col"># Prenotazione</th>
                    <th scope="col">Motivazione</th>
                    <th scope="col">Aula</th>
                    <th scope="col">Dipartimento</th>
                    <th scope="col">Data</th>
                    <th scope="col">Ora inizio</th>
                    <th scope="col">Ora fine</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listaPrenotazioni}" var="i">
                <tr>
                <th scope="row">1
                        <a class="btn action-button" role="button" href="EliminaPrenotazione">
                            <i class="material-icons">delete</i>
                        </a>
                        <form action="EliminaPrenotazione" method="get">
						<input type="hidden" name="id" value="${i.IDprenotazione}">
						 <input type="submit" value="Elimina"/>
				</form>
                    </th>
                    <td>${i.titolo}</td>
                    <td>${i.edificio}</td>
                    <td>${i.aulaPrenotata}</td>
                    <td>${i.data}</td>
                    <td>${i.oraInizio}</td>
                    <td>${i.oraFine}</td>
                </tr>
                
                
					
                </c:forEach>
              
                </tbody>
            </table>
        </div>
    </div>    
</div>
<!--FINE CONTAINER CENTRALE-->

<jsp:include page="Footer.jsp"/>
