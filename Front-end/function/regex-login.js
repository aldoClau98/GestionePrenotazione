function verifyL(value) {
    var regex1 = /^(\w+([\.-])?\w+)+@?(studenti\.unisa\.it)?$/;
    var regex2 = /^(\w+([\.-])?\w+)+@?(unisa\.it)?$/;
    input = document.getElementById("email");
    button = document.getElementById("submit");
    if (value.length < 0 || value.length > 254 || !(regex1.test(value) || regex2.test(value))) {
        input.setAttribute("class", "form-control is-invalid");
        button.disabled = true;
    }
    else {
        input.setAttribute("class", "form-control is-valid")
        button.disabled = false;
    }

}