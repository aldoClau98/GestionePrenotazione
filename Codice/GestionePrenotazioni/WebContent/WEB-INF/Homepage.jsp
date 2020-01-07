
<jsp:include page="Header.jsp" />
<%
	String resultlogin = request.getParameter("resultlogin");
	String resultPassw = request.getParameter("resultPassword");
	if (resultlogin != null) {
		if (resultlogin.equals("1")) {
%>
<script>
	alert("Login  avvenuto  con successo!");
</script>
<%
	} else {
%>
<script>
	alert("Login  Errato!");
</script>
<%
	}
	}

	if (resultPassw != null) {
		if (resultPassw.equals("1")) {
%>
<script>
	alert("Password modificata con successo!");
</script>
<%
	} else {
%>
<script>
	alert("C'è stato un errore, la password on è stata modificata!");
</script>
<%
	}
	}
%>

<div class="container" style="padding-top: 200px;">
	<p>Home</p>
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
<script>
	//INIZIO SCRIPT CALENDARIO
	var date = new Date();
	// Returns the current day of the month
	var day = date.getDate();
	// Returns the month
	var months = new Array();
	months[0] = "January";
	months[1] = "February";
	months[2] = "March";
	months[3] = "April";
	months[4] = "May";
	months[5] = "June";
	months[6] = "July";
	months[7] = "August";
	months[8] = "September";
	months[9] = "October";
	months[10] = "November";
	months[11] = "December";
	var month = months[date.getMonth()];
	// Returns the year
	var year = date.getFullYear();
	document.getElementById("date").innerHTML = month + " " + year;
	document.getElementById("day").innerHTML = day;
	//FINE SCRIPT CALENDARIO
</script>
<jsp:include page="Footer.jsp" />