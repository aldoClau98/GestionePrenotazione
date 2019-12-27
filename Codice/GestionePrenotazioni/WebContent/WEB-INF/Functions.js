//DATE PICKER 
$('#datepicker').datepicker({
    uiLibrary: 'bootstrap'
});


//REDIRECT TABELLA
$('tr[data-href]').on("click", function() {
    document.location = $(this).data('href');
});