<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="Header.jsp" />

<div class="container" style="padding-top: 160px;">
	<div id="container-centrale">
		<div class="login-clean">
			<form method="POST" action="DomandaPrenotazione">
				<div class="form-group">
					<input type="text" id="datepicker" name="data" width="200px" placeholder="data"/>
				</div>
				<div class="form-group">
					<input class="form-control" name="titolo" placeholder="Titolo" />
				</div>
				<div class="form-group">
					<select class="form-control" name="oraInizio">
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="15">15</option>
						<option value="16">16</option>
						<option value="17">17</option>
						<option value="18">18</option>
					</select>
				</div>
				<div class="form-group">

					<select class="form-control" name="oraFine">
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="15">15</option>
						<option value="16">16</option>
						<option value="17">17</option>
						<option value="18">18</option>
					</select>

				</div>
				<div class="form-group">
					<input class="form-control" name="descrizione"
						placeholder="Descrizione" />
				</div>
				<div class="form-group">
					<input type="text" name="aula" placeholder="aula" />
				</div>
				<div class="form-group">
					<input type="text" name="edificio" placeholder="Edificio" />
				</div>

				<div class="form-group">
					<input class="btn btn-secondary btn-block" type="submit"
						value="Prenota" />
				</div>
			</form>
		</div>
	</div>
</div>


<jsp:include page="Footer.jsp" />