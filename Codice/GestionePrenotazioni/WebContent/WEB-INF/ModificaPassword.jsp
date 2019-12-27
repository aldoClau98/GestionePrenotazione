
<jsp:include page="Header.jsp"/>

<%@ page import="Model.Utente"%>



<% Utente c = (Utente) session.getAttribute("utente");
 	 %>

<!--INIZIO CONTAINER CENTRALE-->
        <div id="container-centrale">
            <div class="row register-form">
                <div class="col-md-8 offset-md-2">
                    <form method="POST" action="ModificaPassword" class="custom-form">
                        <h1>Modifica password</h1>
                        <div class="form-row form-group">
                            <div class="col-sm-4 label-column">
                                <label for="validationServer01">Password</label>
                            </div>
                            <div class="col-sm-6 input-column">
                                <input type="text" class="form-control is-valid" id="validationServer01" value="pippolo66" required>
                                <div class="valid-feedback">Funziona!</div>
                            </div>
                        </div>
                        <div class="form-row form-group">
                            <div class="col-sm-4 label-column">
                                <label for="validationServer02">Nuova Password</label>
                            </div>
                            <div class="col-sm-6 input-column">
                                <input type="text" class="form-control is-invalid" id="validationServer02" value="pippone" required>
                                <div class="invalid-feedback">Non va bene!</div>
                            </div>
                        </div>
                        <input type="hidden" name="email" value="${utente.email}"/>
                        <button class="btn btn-secondary" type="submit">Submit</button>
                    </form>
                </div>
            </div>                
        </div>
<!--FINE CONTAINER CENTRALE-->
<jsp:include page="Footer.jsp"/>
