<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="Model.Utente"%>
     <% Utente c = (Utente) session.getAttribute("utente");	%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- MATERIAL DESIGN -->
		<script src="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.js"></script>
		<link rel="stylesheet" href="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.css">
<!-- JQUERY -->
		<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
<!-- BOOTSTRAP -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" >
		
		<script src="https://code.iconify.design/1/1.0.3/iconify.min.js"></script>

		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		
		<link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />
		<script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
		
		<link rel="icon" type="image/ico" href="logo.png">
		<link rel="stylesheet" href="style.css">
		<script src="funz.js"></script>
		<script>
			$(document).ready(function() {
			    $('.show-hidden-menu-1').click(function() {
			      $('.hidden-menu-1').slideToggle("fast");
			    });
			    
			    $('.show-hidden-menu-2').click(function() {
					$('.hidden-menu-2').slideToggle("fast");
			    });
			    
			    $('.show-hidden-menu-3').click(function() {
			    	$('.hidden-menu-3').slideToggle("fast");
			    });
			});
		</script>
    </head>
    <body>
 	
<!--INIZIO NAV BAR-->
	    <nav class="navbar navbar-light navbar-expand-md fixed-top">
			<a class="navbar-brand" href="ServletHome">
		    	<img src="logo.png" width="140px" height="140px" alt="">
			</a>
			
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
			    <span class="navbar-toggler-icon"></span>
			</button>
			
			<div class="collapse navbar-collapse" id="navbarText">
			    <ul class="navbar-nav mr-auto">
			        <li class="nav-item active">
			            <a href="NavEdifici">Edifici</a>
			        </li>
			        <li class="nav-item active">
			            <a href="NavDipartimento">Dipartimenti</a>
			        </li>
			    </ul>
			    <span class="navbar-text actions">
			        <a class="login" href="NavLogin">Log In</a>
			        <a class="btn btn-secondary" type="button" href="NavRegistrazione">Registrazione</a>
			    </span>
			</div>
	    </nav>
<!--FINE NAVBAR-->