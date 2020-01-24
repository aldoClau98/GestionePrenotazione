$(document).ready(function() {
    $('.show-hidden-menu-1').click(function() {
        $('.hidden-menu-1').slideToggle("fast");
    });

    $('.show-hidden-menu-2').click(function() {
        $('.hidden-menu-2').slideToggle("fast");
    });

    $('.show-hidden-menu-3').click(function() {
        $('.hidden-menu-3').slideToggle("fast");
    });
});

$('tr[data-href]').on("click", function() {
    document.location = $(this).data('href');
});