
<% 	String pageTitle= "Home";
   	request.setAttribute("pageTitle", pageTitle);%>

<jsp:include page="Header.jsp" />

<div class="container" style="padding-top: 160px">
	<p>
		<span><%= pageTitle %></span>
	</p>

	<% if (request.getAttribute("messaggio") != null) { %>
	<div id="snackbar"><%= request.getAttribute("messaggio") %></div>
	<% } %>
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