<jsp:include page="Header.jsp" />

<% 	String resultLogin = (String) request.getAttribute("resultLogin");
	String resultPassw = (String) request.getAttribute("resultPassword"); 
	String pageTitle= "Home";
   	request.setAttribute("pageTitle", pageTitle);%>
	
<div class="container" style="padding-top:180px">
	<p>
		<span><%= pageTitle %></span>
	</p>
	
	  
  
  <% if (resultLogin != null) {
  		if (resultLogin.equals("1")) { %>
	  		<div id="snackbar">Login  avvenuto  con successo!</div>
	  		<% request.setAttribute("resultLogin", ""); 

		} else { %>
			<div id="snackbar">Login  errato!</div>	
		<% }
  	}
  
  	if (resultPassw != null) {
		if (resultPassw.equals("1")) { %>
			<div id="snackbar">Password modificata con successo!</div>
			<%request.setAttribute("resultPassw", "");
	
		} else { %>
			<div id="snackbar">C'è stato u n  errore,  la password non è stata modificata</div>
	<% 	} 
	} %>
</div>



<!--INIZIO CONTAINER CENTRALE-->
<div id="container-centrale">
	<div id="container-centrale-back">
		<div id="calendar-background">
			<header>
				<div class="calendar">
					<h5 id="date"></h5>
					<h2 id="day"></h2>
				</div>
			</header>
		</div>
	</div>
</div>
<!--FINE CONTAINER CENTRALE-->

<jsp:include page="Footer.jsp" />