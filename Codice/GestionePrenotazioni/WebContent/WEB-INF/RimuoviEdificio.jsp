<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="Header.jsp" />

<div class="container" style="padding-top: 200px;">
	<p>Rimozione edificio</p>
</div>

<!--INIZIO CONTAINER CENTRALE-->
<div id="container-centrale">
    <div class="login-clean">
        <form method="GET" action="">
            <div class="illustration">
                <img src="edificio.png" width="80%">
            </div>
            <div class="form-group">
                <div class="wrapper">
                    <select name="characters" class="custom-select" tabindex="-1" id="select-name">
                        <option value="" selected>Selezione un edificio</option>
                            <option value="">F</option>
                            <option value="">E</option>
                            <option value="">F2</option>
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
