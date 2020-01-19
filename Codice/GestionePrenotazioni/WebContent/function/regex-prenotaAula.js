function verifyA(id, value){
    submit = document.getElementById("submit");
    titolo = document.getElementById("titolo");
    descrizione = document.getElementById("descrizione");
    oraInizio = document.getElementById("oraInizio");
    oraFine = document.getElementById("oraFine");

    if (id == "titolo"){
        var regex = /^[\w+\s?\w+]{5,32}$/;
        if (regex.test(value)) {
            titolo.setAttribute("class", "form-control is-valid");
            if (descrizione.getAttribute("class") != "form-control is-invalid")
                submit.disabled = false;
        }
        else{
            titolo.setAttribute("class", "form-control is-invalid");
            submit.disabled = true;
        }
    }

    else if (id == "oraInizio"){
    	oraFine.innerHTML= '';
        var n = parseInt(oraInizio.value) + 1;
        while (n < 19){
        	option = document.createElement('option');
        	option.value = n;
        	option.innerHTML = n + ":00"
        	oraFine.appendChild(option);
        	n++;
        }
        
    }

    else if (id == "descrizione") {
        var regex = /^[\w+\s?]{15,250}$/;
        if (regex.test(value)) {
            descrizione.setAttribute("class", "form-control is-valid");
            if (titolo.getAttribute("class") != "form-control is-invalid")
                submit.disabled = false;
        }
        else{
            descrizione.setAttribute("class", "form-control is-invalid");
            submit.disabled = true;
        }
    }
}