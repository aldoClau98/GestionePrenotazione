<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="Header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

String docente =  request.getParameter("email");

%>
<div class="container" style="padding-top: 200px;">
	<p>Docente Selezionato: ${docente}</p>
</div>

<!--INIZIO CONTAINER CENTRALE-->
<div id="container-centrale">
    <div class="login-clean">
        <form method="GET" action="CambiaDipartimento">
        <input type="hidden" name="email" value="${docente}"/>
            <div class="illustration">
                <img src="profilo.png" width="80%">
            </div>
            <div class="form-group">
                <div class="wrapper">
                    <select name="dip" class="custom-select" tabindex="-1" id="select-name">
                        <option value="" selected>Selezione un Dipartimento</option>
                           <c:forEach items="${listaDipartimenti}" var="i">
                            <option value="${i.dip}">${i.dip}</option>
                            </c:forEach>
                           
                    </select>
                </div>
            </div>
            <div class="form-group">
                <button class="btn btn-secondary btn-block" type="submit" >Cambia dipartimento</button>
            </div>
        </form>
        
        
        <div class="login-clean">
        <form method="GET" action="RimuoviAmministratore">
        <input type="hidden" name="flag" value="1">
        <input type="hidden" name="email" value="${docente}"/>
            <div class="illustration">
                <img src="profilo.png" width="80%">
            </div>
            <div class="form-group">
                <button class="btn btn-secondary btn-block" type="submit" >Rimuovi Nomina Amministratore</button>
            </div>
        </form>
    </div>
    </div>
</div>
<!--FINE CONTAINER CENTRALE-->

<jsp:include page="Footer.jsp" />