function submitting(form){
    password = form.password
    rpassword = form.rpassword
    check = form.check
    button = form.submit
    if (check.checked) {
        if (password.getAttribute("class") == "form-control is-valid" 
            && rpassword.getAttribute("class") == "form-control is-valid"){
                button.disabled = false
        }
        else {
            button.disabled = true;
            check.checked = false;
        }
    }
}

function verifyP(id, str) {
    if (id == "password") {
        var regex = /^\w+([\.-])?\w+$/;
        input = document.getElementById(id);
        var button = document.getElementById("submit");
        var check = document.getElementById("check");
        if (regex.test(str)) {
            input.setAttribute("class", "form-control is-valid");
        }
        else {
            input.setAttribute("class", "form-control is-invalid");
            button.disabled = true;
            check.checked = false;
        }        
    }

    else if (id == "rpassword") {
        var regex = /^\w+([\.-])?\w+$/;
        input = document.getElementById(id);
        var button = document.getElementById("submit");
        var check = document.getElementById("check");
        if (regex.test(str)) {
            input.setAttribute("class", "form-control is-valid");
            if(document.getElementById("password").getAttribute("class") ==  "form-control is-valid") {
                button.disabled = false;
            }
        }
        else {
            input.setAttribute("class", "form-control is-invalid");
            check.checked = false;
            button.disabled = true;
        }
    }
}