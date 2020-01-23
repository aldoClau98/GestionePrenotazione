<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@	page import="Model.Utente"%>

<%
	Utente c = (Utente) session.getAttribute("utente");
	String pageTitle = (String) request.getAttribute("pageTitle");
%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link
	href="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css"
	rel="stylesheet" type="text/css" />
<script
	src="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
<script src="https://code.iconify.design/1/1.0.3/iconify.min.js"></script>
<script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js"
	type="text/javascript"></script>
<link rel="icon" type="image/ico" href="img/logo.png">
<link rel="stylesheet" href="style/style.css">

<title>GePo- <%=request.getAttribute("pageTitle")%></title>
</head>
<body>

	<!--INIZIO NAV BAR-->
	<nav class="navbar navbar-light navbar-expand-md fixed-top">
		<a class="navbar-brand" href="ServletHome"> <img
			src="img/logo.png" width="140px" height="140px" alt="">
		</a>

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarText" aria-controls="navbarText"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a href="NavEdifici" id="elementoL">Edifici</a>
				</li>
				<li class="nav-item active"><a href="NavDipartimento">Dipartimenti</a>
				</li>
			</ul>


			<!-- se l utente non è  registrato -->
			<%
				if (c == null) {
					if (pageTitle.equals("Login")) {
			%>
			<span class="navbar-text actions"> <a
				class="btn btn-secondary" type="button" href="NavRegistrazione">Registrazione</a>
			</span>
			<%
				} else if (pageTitle.equals("Registrazione")) {
			%>
			<span class="navbar-text actions"> <a class="login"
				href="NavLogin">Log In</a>
			</span>
			<%
				} else {
			%>
			<span class="navbar-text actions"> <a class="login"
				href="NavLogin">Log In</a>
			</span> <span class="navbar-text actions"> <a
				class="btn btn-secondary" type="button" href="NavRegistrazione">Registrazione</a>
			</span>
			<%
				}
				}
				// l' utente è Studente
				else if (c.getTipoUtente() == 0) {
			%>
			<span class="navbar-text actions"> <a class="login"
				href="Logout">Log Out</a>
			</span> <span class="navbar-text actions">
				<div class="btn-group" role="group">
					<button id="btnGroupDrop1" type="button"
						class="btn btn-secondary dropdown-toggle" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">
						<i class="material-icons">face</i>
					</button>
					<div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
						<a class="dropdown-item" href="NavAreaPersonale">Area
							personale</a> <a class="dropdown-item" href="NavStoricoPrenotazioni">Storico
							prenotazioni</a>
					</div>
				</div>
			</span>


			<%
				// l'utente è docente
				} else if (c.getTipoUtente() == 1) {
			%>
			<span class="navbar-text actions"> <a class="login"
				href="Logout">Log Out</a>
			</span> <span class="navbar-text actions">
				<div class="btn-group" role="group">
					<button id="btnGroupDrop1" type="button"
						class="btn btn-secondary dropdown-toggle" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">
						<i class="material-icons">face</i>
					</button>
					<div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
						<a class="dropdown-item" href="NavAreaPersonale">Area
							personale</a> <a class="dropdown-item" href="NavStoricoPrenotazioni">Storico
							prenotazioni</a>
					</div>
				</div>
			</span>


			<%
				// l'utente è amministratore di dipartimento
				} else if (c.getTipoUtente() == 2) {
			%>
			<span class="navbar-text actions"> <a class="login"
				href="Logout">Log Out</a>
			</span> <span class="navbar-text actions">
				<div class="btn-group" role="group">
					<button id="btnGroupDrop1" type="button"
						class="btn btn-secondary dropdown-toggle" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">
						<i class="material-icons">face</i>
					</button>
					<div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
						<a class="dropdown-item" href="NavAreaPersonale">Area
							personale</a> <a class="dropdown-item" href="NavStoricoPrenotazioni">Storico
							prenotazioni</a> <a class="dropdown-item"
							href="NavRichiestePrenotazioni">Richieste prenotazione</a>
					</div>
				</div>
			</span>


			<%
				// l'utente è amministratore ateneo
				} else if (c.getTipoUtente() == 3) {
			%>
			<span class="navbar-text actions"> <a class="login"
				href="Logout">Log Out</a>
			</span> <span class="navbar-text actions">
				<div class="btn-group" role="group">
					<button id="btnGroupDrop1" type="button"
						class="btn btn-secondary dropdown-toggle" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">
						<i class="material-icons">face</i>
					</button>
					<div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
						<a class="dropdown-item" href="NavAreaPersonale">Area
							personale</a> <a class="dropdown-item" href="NavStoricoPrenotazioni">Storico
							prenotazioni</a><a class="dropdown-item" href="NavElencoUtenti">Elenco
							utenti</a> <a class="dropdown-item" href="NavCreaEdificio">Crea
							edificio</a> <a class="dropdown-item" href="NavRimuoviEdificio">Rimuovi
							edificio</a> <a class="dropdown-item" href="NavCreaDipartimento">Crea
							Dipartimento</a> <a class="dropdown-item"
							href="NavEliminaDipartimento">Rimuovi Dipartimento</a> <a
							class="dropdown-item" href="NavCreaAula">Crea aula</a> <a
							class="dropdown-item" href="NavEliminaAula">Rimuovi aula</a> <a
							class="dropdown-item" href="NavScegliAmministratore">Scegli
							Amministratore</a>

					</div>
				</div>
			</span>
			<%
				}
			%>
		</div>
	</nav>
	<!--FINE NAVBAR-->