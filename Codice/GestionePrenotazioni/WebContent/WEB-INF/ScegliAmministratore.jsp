<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% 	String pageTitle= "Assegnamento amministrazione";
   	request.setAttribute("pageTitle", pageTitle);%>
   	
<jsp:include page="Header.jsp" />

<div class="container" style="padding-top:180px">
	<p>
		<span><%= pageTitle %> per ###(dipartimento)</span>
	</p>
</div>

<!--INIZIO CONTAINER CENTRALE-->
<div id="container-centrale">
    <div class="login-clean">
        <form method="GET" action="ScegliAmministratore">
        <input type="hidden" name="flag" value="2">
            <div class="illustration">
                <img src="profilo.png" width="80%">
            </div>
            <div class="form-group">
                <div class="wrapper">
                    <select name="email" class="custom-select" tabindex="-1" id="select-name">
                        <option  selected>Selezione un utente</option>
                           <c:forEach items="${listaUtente}" var="i">
                           
                            <option value="${i.email}">${i.email}</option>
                            </c:forEach>
                           
                    </select>
                </div>
            </div>
            <div class="form-group">
                <button  class="btn btn-secondary btn-block" type="submit">Assegna</button>
            </div>
        </form>
    </div>
</div>
<!--FINE CONTAINER CENTRALE-->

<jsp:include page="Footer.jsp" />
