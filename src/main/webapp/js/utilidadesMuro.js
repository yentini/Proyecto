$(document).ready(function() {
    $("#dialog-mensaje").dialog({
        autoOpen: false,
        height: 300,
        width: 350,
        modal: true,
        buttons: {
            "Publicar": function() {
                $(this).dialog('close');
                $("#login").submit();
            }}
    });

    $("#crearMensaje").button().click(function() {
        $("#dialog-mensaje").dialog("open");
    });

    $("#mensajeAcordeon").accordion({
        collapsible: true   
    });

    $(function() {
        $("#relaciones").tabs({
            event: "mouseover"
        });
    });

});
function eliminarMensaje(id) {
    var mensaje = "#mensaje" + id;

    $(mensaje).submit();
}
//    function llamadaAjax() {
//        $.ajax({
//            url: "muro.html",
//            type: "GET",
//            data: {
//                id: $("#id").val()
//            },
//            dataType: "json",
//            success: function(json) {
//                $("#hueco").text("Datos del usuario: " +json.nombre);
//            },
//            error: function(xhr, status) {
//                alert("Ha ocurrido un error" + xhr);
//                alert("Ha ocurrido un error" + status);
//            }
//        });
//    }
//    ;
//    llamadaAjax();
        