<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="Header.jsp" />
<%@ page import="Model.Struttura" %>

<%
Struttura a = (Struttura) session.getAttribute("struttura");

String aula=  a.getAula();
String edificio = a.getEdificio();
String dipartimento = a.getDipartimento();
%>
<div class="container" style="padding-top: 200px;">
            <p>${struttura.aula}</p>
            <p>${struttura.edificio}</p>
            <p>${struttura.Dipartimento}</p>
            <p>
                <span>
                    Data
                </span>
                <span>
                    <input id="datepicker" width="200px" />
                </span>
                <span>
                    <button class="btn btn-secondary" style="height: 38px;">
                        <i class="material-icons">calendar_today</i>
                    </button>
                </span>
            </p>
        </div>
<div id="container-centrale">
            <div class="row" id="container-tabelle">
                <div class="col">
                  <table class="table table-hover" >
                    <thead>
                      <tr>
                        <th>Orario</th>
                        <th>Lunedì</th>
                        <th>Martedì</th>
                        <th>Mercoledì</th>
                        <th>Giovedì</th>
                        <th>Venerdì</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <th>8:00</th>
                        <td>Informatica</td>
                        <td>Informatica</td>
                        <td>Informatica</td>
                        <td>Informatica</td>
                        <td>Informatica</td>
                      </tr>
                      <tr>
                        <th>9:00</th>
                        <td>Informatica</td>
                        <td>Informatica</td>
                        <td>Informatica</td>
                        <td>Informatica</td>
                        <td>Informatica</td>
                      </tr>
                      <tr> 
                        <th>10:00</th>
                        <td>Informatica</td>
                        <td>Informatica</td>
                        <td>Informatica</td>
                        <td>Informatica</td>
                        <td>Informatica</td>
                      </tr>
                      <tr> 
                        <th>11:00</th>
                        <td>Informatica</td>
                        <td>Informatica</td>
                        <td>Informatica</td>
                        <td>Informatica</td>
                        <td>Informatica</td>
                      </tr>
                      <tr> 
                        <th>12:00</th>
                        <td>Informatica</td>
                        <td>Informatica</td>
                        <td>Informatica</td>
                        <td>Informatica</td>
                        <td>Informatica</td>
                      </tr>
                      <tr> 
                        <th>13:00</th>
                        <td>Informatica</td>
                        <td>Informatica</td>
                        <td>Informatica</td>
                        <td>Informatica</td>
                        <td>Informatica</td>
                      </tr>
                      <tr> 
                        <th>14:00</th>
                        <td>Informatica</td>
                        <td>Informatica</td>
                        <td>Informatica</td>
                        <td>Informatica</td>
                        <td>Informatica</td>
                      </tr>
                      <tr> 
                        <th>15:00</th>
                        <td>Informatica</td>
                        <td>Informatica</td>
                        <td>Informatica</td>
                        <td>Informatica</td>
                        <td>Informatica</td>
                      </tr>
                      <tr> 
                        <th>16:00</th>
                        <td>Informatica</td>
                        <td>Informatica</td>
                        <td>Informatica</td>
                        <td>Informatica</td>
                        <td>Informatica</td>
                      </tr>
                      <tr> 
                        <th>17:00</th>
                        <td>Informatica</td>
                        <td>Informatica</td>
                        <td>Informatica</td>
                        <td>Informatica</td>
                        <td>Informatica</td>
                      </tr>
                      <tr> 
                        <th>18:00</th>
                        <td>Informatica</td>
                        <td>Informatica</td>
                        <td>Informatica</td>
                        <td>Informatica</td>
                        <td>Informatica</td>
                      </tr>
                    </tbody>
                  </table>
                </div>
            </div>
        </div>
<jsp:include page="Footer.jsp" />