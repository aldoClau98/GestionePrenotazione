function submitting(form){
    nome = form.nome
    cognome = form.cognome
    email = form.email
    password = form.password
    rpassword = form.rpassword
    check = form.check
    button = form.submit
    if (check.checked) {
        if ((nome.getAttribute("class") == "form-control is-valid") && (cognome.getAttribute("class") == "form-control is-valid") 
            && email.getAttribute("class") == "form-control is-valid" && password.getAttribute("class") == "form-control is-valid" 
            && rpassword.getAttribute("class") == "form-control is-valid"){
                button.disabled = false
        }
        else {
            button.disabled = true;
            check.checked = false;
        }
    }
}

function verify(id, str) {
    if (id == "nome") {
        var regex = /^[a-zA-Z]+$/;
        input = document.getElementById(id);
        var check = document.getElementById("check");
        if (str.length < 2 || str.length > 25) {
            input.setAttribute("class", "form-control is-invalid");
            check.checked = false;
        }
        else {
            if (regex.test(str)) {
                input.setAttribute("class", "form-control is-valid");
            }
            else {
                input.setAttribute("class", "form-control is-invalid");
            }
        }
    }

    else if (id == "cognome") {
        var regex = /^[a-zA-Z]+$/;
        input = document.getElementById(id);
        var check = document.getElementById("check");
        if (str.length < 2 || str.length > 25) {
            input.setAttribute("class", "form-control is-invalid");
            check.checked = false;
        }
        else {
            if (regex.test(str)) {
                input.setAttribute("class", "form-control is-valid")
            }
            else {
                input.setAttribute("class", "form-control is-invalid");
                check.checked = false;
            }
        }
    }

    else if (id == "email") {
        var regex1 = /^(\w+([\.-])?\w+)+@?(studenti\.unisa\.it)?$/;
        var regex2 = /^(\w+([\.-])?\w+)+@?(unisa\.it)?$/;
        input = document.getElementById(id);
        var check = document.getElementById("check");
        if (str.length < 0 || str.length > 254) {
            input.setAttribute("class", "form-control is-invalid");
            check.checked = false;
        }
        else {
            if (regex1.test(str) || regex2.test(str)) {
                input.setAttribute("class", "form-control is-valid")
            }
            else {
                input.setAttribute("class", "form-control is-invalid");
                check.checked = false;
            }
        }
    }

    else if (id == "password") {
        var regex = /^\w+([\.-])?\w+$/;
        input = document.getElementById(id);
        var check = document.getElementById("check");
        if (regex.test(str)) {
                input.setAttribute("class", "form-control is-valid");
        }
        else {
            input.setAttribute("class", "form-control is-invalid");
            check.checked = false;
        }
    }

    else if (id == "rpassword") {
        input = document.getElementById(id);
        inp = document.getElementById("password");
        if (str == inp.value) {
            input.setAttribute("class", "form-control is-valid")
        }
        else {
            input.setAttribute("class", "form-control is-invalid")
            var check = document.getElementById("check");
            check.checked = false;
        }
    }

}