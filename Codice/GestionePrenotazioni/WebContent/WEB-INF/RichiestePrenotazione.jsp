<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="Header.jsp" />

<!--INIZIO CONTAINER CENTRALE-->
<div id="container-centrale">
    <div class="row" id="container-tabelle">
        <div class="col">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col"># Prenotazione</th>
                    <th scope="col">Motivazione</th>
                    <th scope="col">Utente</th>
                    <th scope="col">Aula</th>
                    <th scope="col">Dipartimento</th>
                    <th scope="col">Data</th>
                    <th scope="col">Ora inizio</th>
                    <th scope="col">Ora fine</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">1
                        <a class="btn action-button" role="button" href="ModificaPassword.html">
                            <i class="material-icons">check_circle</i>
                        </a>
                        <a class="btn action-button" role="button" href="ModificaPassword.html">
                            <i class="material-icons">delete</i>
                        </a>
                    </th>
                    <td>Ballo di gruppo</td>
                    <td>Studente</td>
                    <td>P1</td>
                    <td>Ingegneria</td>
                    <td>20/12/2019</td>
                    <td>10:00</td>
                    <td>18:00</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>    
</div>
<!--FINE CONTAINER CENTRALE-->

<jsp:include page="Footer.jsp"/>
