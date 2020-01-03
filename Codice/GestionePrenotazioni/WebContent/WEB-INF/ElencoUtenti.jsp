<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="Header.jsp" />

<div class="container" style="padding-top: 200px;">
	<p>Elenco utenti</p>
</div>

<!--INIZIO CONTAINER CENTRALE-->
<div id="container-centrale">
    <div class="row" id="container-tabelle">
        <div class="col">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col"># ID</th>
                    <th scope="col">Nome</th>
                    <th scope="col">Cognome</th>
                    <th scope="col">E-mail</th>
                    <th scope="col">Tipo utente</th>
                    <th scope="col">Amministratore</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>Pippo</td>
                    <td>Pippotto</td>
                    <td>pippo@pippotto.studenti.it</td>
                    <td>Studente</td>
                    <td>No</td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>Pippone</td>
                    <td>Pippottone</td>
                    <td>pippone@pippottone.it</td>
                    <td>Insegnante</td>
                    <td>Si 
                        <a class="btn action-button" role="button" href=>
                            <i class="material-icons">edit</i>
                        </a>
                    </td>
                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td>Pipponeone</td>
                    <td>Pippottoneone</td>
                    <td>pipponeone@pippottoneone.studenti.it</td>
                    <td>Studente</td>
                    <td>No</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>    
</div>
<!--FINE CONTAINER CENTRALE-->

<jsp:include page="Footer.jsp" />
