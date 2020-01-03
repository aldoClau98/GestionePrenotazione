<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="Header.jsp" />

<div class="container" style="padding-top: 200px;">
	<p>Rimozione aula</p>
</div>

<!--INIZIO CONTAINER CENTRALE-->
<div id="container-centrale">
    <div class="login-clean">
        <form method="GET" action="">
            <div class="illustration">
                <img src="aula.png" width="80%">
            </div>
            <div class="form-group">
                <div class="wrapper">
                    <select name="characters" class="custom-select" tabindex="-1" id="select-name">
                        <option value="" selected>Selezione un aula</option>
                            <optgroup label="Ingegneria">
                                <option value="leo">S2</option>
                                <option value="raph">P2</option>
                                <option value="raph">F2</option>
                            </optgroup>
                            <optgroup label="Informatica">
                                <option value="red">S1</option>
                                <option value="pink">P1</option>
                                <option value="pink">F1</option>
                            </optgroup>
                            <optgroup label="Lingue">
                                <option value="red">S3</option>
                                <option value="pink">P3</option>
                                <option value="pink">F3</option>
                            </optgroup>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <a class="btn btn-secondary btn-block" href=>Elimina</a>
            </div>
        </form>
    </div>
</div>
<!--FINE CONTAINER CENTRALE-->

<jsp:include page="Footer.jsp" />
