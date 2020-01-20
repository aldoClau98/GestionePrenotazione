function verifyA(id, value) {
	submit = document.getElementById("submit");
	titolo = document.getElementById("titolo");
	descrizione = document.getElementById("descrizione");
	oraInizio = document.getElementById("oraInizio");
	oraFine = document.getElementById("oraFine");

	if (id == "titolo") {
		var regex = /^[\w+\s?\w+]{5,32}$/;
		document.getElementById("data").value = document
				.getElementById("datepicker").value
		if (regex.test(value)) {
			titolo.setAttribute("class", "form-control is-valid");
			if (descrizione.getAttribute("class") != "form-control is-invalid")
				submit.disabled = false;
		} else {
			titolo.setAttribute("class", "form-control is-invalid");
			submit.disabled = true;
		}
	}

	else if (id == "descrizione") {
		var regex = /^[\w+\W\s]{15,250}$/;
		document.getElementById("data").value = document
				.getElementById("datepicker").value
		if (regex.test(value)) {
			descrizione.setAttribute("class", "form-control is-valid");
			if (titolo.getAttribute("class") != "form-control is-invalid")
				submit.disabled = false;
		} else {
			descrizione.setAttribute("class", "form-control is-invalid");
			submit.disabled = true;
		}
	}
}

function getOra(value) {
	oraF = document.getElementById("oraFine");
	oraF.innerHTML = ''
	document.getElementById("data").value = document
			.getElementById("datepicker").value

	for (var i = parseInt(value) + 1; i < 19; i++) {
		opt = document.createElement('option');
		opt.value = i
		opt.innerHTML = i + ":00"
		oraF.appendChild(opt)
	}
}