<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="Header.jsp"/>
  
<div class="container" style="padding-top: 200px;">
	<p>Registrazione</p>
</div> 

<!--INIZIO CONTAINER CENTRALE-->
<div id="container-centrale">
    <div class="row register-form">
        <div class="col-md-8 offset-md-2">
            <form class="custom-form" method="GET" action="Registrazione">
                <h1>Inserire i dati</h1>
                <div class="form-row form-group">
                    <div class="col-sm-4 label-column">
                        <label for="validationServer01">Nome</label>
                    </div>
                    <div class="col-sm-6 input-column">
                        <input type="text" class="form-control is-valid" id="validationServer01" value="Gianluca" required>
                        <div class="valid-feedback">Funziona!</div>
                    </div>
                </div>
                <div class="form-row form-group">
                    <div class="col-sm-4 label-column">
                        <label for="validationServer02">Cognome</label>
                    </div>
                    <div class="col-sm-6 input-column">
                        <input type="text" class="form-control is-valid" id="validationServer02" value="Grignani" required>
                        <div class="valid-feedback">Funziona!</div>
                    </div>
                </div>
                <div class="form-row form-group">
                    <div class="col-sm-4 label-column">
                        <label for="validationServer03">E-mail</label>
                    </div>
                    <div class="col-sm-6 input-column">
                        <input type="text" class="form-control is-valid" id="validationServer03" value="pippo@pippotto.studenti.it" required>
                        <div class="valid-feedback">Funziona!</div>
                    </div>
                </div>
                <div class="form-row form-group">
                    <div class="col-sm-4 label-column">
                        <label for="validationServer04">Password</label>
                    </div>
                    <div class="col-sm-6 input-column">
                        <input type="text" class="form-control is-valid" id="validationServer04" value="pippolo66" required>
                        <div class="valid-feedback">Funziona!</div>
                    </div>
                </div>
                <div class="form-row form-group">
                    <div class="col-sm-4 label-column">
                        <label for="validationServer05">Ripeti password</label>
                    </div>
                    <div class="col-sm-6 input-column">
                        <input type="text" class="form-control is-invalid" id="validationServer05" value="pippolo65" required>
                        <div class="invalid-feedback">Non va bene!</div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-check">
                      <input class="form-check-input is-invalid" type="checkbox" value="" id="invalidCheck3" required>
                      <label class="form-check-label" for="invalidCheck3">
                          Accetta termini e condizioni, <br>per l'utilizzo dei dati per profilazione.
                      </label>
                      <div class="invalid-feedback">Senza aver accettato, non potrai registrarti.</div>
                    </div>
                  </div>
                <button class="btn btn-secondary" type="submit">Submit</button>
            </form>
        </div>
    </div>                
</div>
<!--FINE CONTAINER CENTRALE-->

<jsp:include page="Footer.jsp"/>