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
            if (descrizione.getAttribute("class") != "form-control is-invalid"  &&  oraInizio.getAttribute("class") != "form-control is-invalid"  && oraFine.getAttribute("class") != "form-control is-invalid")
                submit.disabled = false;
        }
        else{
            titolo.setAttribute("class", "form-control is-invalid");
            submit.disabled = true;
        }
    }

    else if (id == "oraInizio"){
        var regex = /^[0-9]{1,2}:[0-9]{1,2}$/;
        if (regex.test(value)) {
            oraInizio.setAttribute("class", "form-control is-valid");
            if (descrizione.getAttribute("class") != "form-control is-invalid"  &&  titolo.getAttribute("class") != "form-control is-invalid"  && oraFine.getAttribute("class") != "form-control is-invalid")
                submit.disabled = false;
        }
        else{
            oraInizio.setAttribute("class", "form-control is-invalid");
            submit.disabled = true;
        }
    }

    else if (id == "oraFine"){
        var regex = /^[0-9]{1,2}:[0-9]{1,2}$/;
        if (regex.test(value)) {
            oraFine.setAttribute("class", "form-control is-valid");
            if (descrizione.getAttribute("class") != "form-control is-invalid"  &&  oraInizio.getAttribute("class") != "form-control is-invalid"  && titolo.getAttribute("class") != "form-control is-invalid")
                submit.disabled = false;
        }
        else{
            oraFine.setAttribute("class", "form-control is-invalid");
            submit.disabled = true;
        }
    }

    else if (id == "descrizione") {
        var regex = /^[\w+\s?]{15,250}$/;
        if (regex.test(value)) {
            descrizione.setAttribute("class", "form-control is-valid");
            if (titolo.getAttribute("class") != "form-control is-invalid"  &&  oraInizio.getAttribute("class") != "form-control is-invalid"  && oraFine.getAttribute("class") != "form-control is-invalid")
                submit.disabled = false;
        }
        else{
            descrizione.setAttribute("class", "form-control is-invalid");
            submit.disabled = true;
        }
    }
}