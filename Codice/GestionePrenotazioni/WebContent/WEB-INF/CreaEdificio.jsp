<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 	String pageTitle= "Creazione edificio";
   	request.setAttribute("pageTitle", pageTitle);%>
   	
<jsp:include page="Header.jsp" />

<div class="container" style="padding-top:160px">
	<p>
		<span><%= pageTitle %></span>
	</p>
</div>

<!--INIZIO CONTAINER CENTRALE-->
<div id="container-centrale">
    <div class="login-clean">
        <form method="GET" action="CreaEdificio">
            <div class="illustration">
                <img src="edificio.png" width="50%">
            </div>
            <div class="form-group">
                <input class="form-control" name="edificio" placeholder="Nome Edificio" />
            </div>
            <div class="form-group">
                <input class="form-control" name="aula" placeholder="Nome Aula" />
            </div>
            <div class="form-group">
                <input class="form-control" name="descrizione" placeholder="Descrizione" />
            </div>
            <div class="form-group">
            <button class="btn action-button" type="submit">
										Crea Edificio
									</button>
            </div>
        </form>
    </div>
</div>
<!--FINE CONTAINER CENTRALE-->

<jsp:include page="Footer.jsp" />
