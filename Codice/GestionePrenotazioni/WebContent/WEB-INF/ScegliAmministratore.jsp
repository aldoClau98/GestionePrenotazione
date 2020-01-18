<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
        <form method="GET" action="">
            <div class="illustration">
                <img src="profilo.png" width="80%">
            </div>
            <div class="form-group">
                <div class="wrapper">
                    <select name="characters" class="custom-select" tabindex="-1" id="select-name">
                        <option value="" selected>Selezione un utente</option>
                            <option value="">Pippolo</option>
                            <option value="">Pippolone</option>
                            <option value="">F2Pippotto</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <a class="btn btn-secondary btn-block" href=>Assegna</a>
            </div>
        </form>
    </div>
</div>
<!--FINE CONTAINER CENTRALE-->

<jsp:include page="Footer.jsp" />
