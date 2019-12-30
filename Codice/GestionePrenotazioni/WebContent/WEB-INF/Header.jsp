<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="Model.Utente"%>
<!DOCTYPE html>
<html>
 <head>
        <!--  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
      <link href="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.css" rel="stylesheet">
      <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
      <script src="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.js"></script>
      <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
      <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>  
      <script src="https://code.iconify.design/1/1.0.3/iconify.min.js"></script>
      <script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
      <link rel="stylesheet" href="style.css">
       <script>
        $(document).ready(function() {
          $('.show-hidden-menu-1').click(function() {
            $('.hidden-menu-1').slideToggle("fast");
          });
        });

        $(document).ready(function() {
          $('.show-hidden-menu-2').click(function() {
            $('.hidden-menu-2').slideToggle("fast");
          });
        });

        $(document).ready(function() {
          $('.show-hidden-menu-3').click(function() {
            $('.hidden-menu-3').slideToggle("fast");
          });
        });
      </script>
   -->  </head>
    
    <body>
    <% Utente c = (Utente) session.getAttribute("utente");	%>
 	
<!--INIZIO NAV BAR-->
        <nav class="navbar navbar-light navbar-expand-md fixed-top">
          <!--  <a class="navbar-brand" href="ServletHome">
                <img src="logo.png" width="140px" height="140px" alt="">
            </a> --> 

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