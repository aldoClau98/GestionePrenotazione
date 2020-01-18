<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 	String pageTitle= "Rimozione dipartimento";
   	request.setAttribute("pageTitle", pageTitle);%>
   	
<jsp:include page="Header.jsp" />

<div class="container" style="padding-top:180px">
	<p>
		<span><%= pageTitle %></span>
	</p>
</div>

<!--INIZIO CONTAINER CENTRALE-->
<div id="container-centrale">
    <div class="login-clean">
        <form method="GET" action="">
            <div class="illustration">
                <img src="dipartimento.jpg" width="80%">
            </div>
            <div class="form-group">
                <div class="wrapper">
                    <select name="characters" class="custom-select" tabindex="-1" id="select-name">
                        <option value="" selected>Selezione un dipartimento</option>
                            <option value="">Informatica</option>
                            <option value="">Ingegneria</option>
                            <option value="">Farmacia</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <a class="btn btn-secondary btn-block" href=>Elimina</a>
            </div>
        </form>
    </div>
</div>
<!--FINE CONTAINER CENTRALE-->

<jsp:include page="Footer.jsp" />
