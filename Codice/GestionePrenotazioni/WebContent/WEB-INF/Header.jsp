<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="Model.Utente"%>
<!DOCTYPE html>
<html>
    <head>
     <script src="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" ></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" ></script>  
        <script src="https://code.iconify.design/1/1.0.3/iconify.min.js"></script>
        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" >
        <link href="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
       <link rel="stylesheet" href="WEB-INF/style.css">
    </head>
    <body>
    <% Utente c = (Utente) session.getAttribute("utente");	%>
 	}
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
                    <a class="btn btn-secondary" type="button" href="Registrazione">Registrazione</a>
                </span>
            </div>
        </nav>
<!--FINE NAVBAR-->