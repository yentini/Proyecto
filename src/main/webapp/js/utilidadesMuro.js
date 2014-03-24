$(document).ready(function() {
    /*function llamadaAjax() {*/
        $.ajax({
            url: "otro.html",
            type: "GET",
            data: {
                id: $("#id").val()
            },
            dataType: "json",
            success: function(json) {
                $("#hueco").text("Datos del usuario: " + json);
            },
            error: function(xhr, status) {
                alert("Ha ocurrido un error");
            },
            complete: function(xhr, status) {
                alert("Fin de la llamada Ajax");
            }
        });
    /*}*/
    /*llamadaAjax();*/
});