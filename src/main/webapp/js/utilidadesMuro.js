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

    $("#dialog-comentario").dialog({
        autoOpen: false,
        height: 300,
        width: 350,
        modal: true,
        buttons: {
            "Comentar": function() {
                $(this).dialog('close');
                $("#comentarioForm").submit();
            }}
    });

    $("#eliminarBoton").button().click(function() {
        $("#eliminarForm").submit();
    });

    $("#crearMensaje").button().click(function() {
        $("#dialog-mensaje").dialog("open");
    });

    $("#crearComentario").button().click(function() {
        $("#dialog-comentario").dialog("open");
    });

    $("#mensajeAcordeon").accordion({
        collapsible: true
    });

    $("#relaciones").tabs({
//            event: "mouseover"
    });

    if ($("#idCuenta").val() != $("#idMuro").val()) {
        $("#murosAmigosPrincipal").hide();
        $("#relacionesPrincipal").hide();
        $("#dialog-mensajePrincipal").hide();
        $(":input[value='Eliminar']").hide();
        $("#retorno").show();
        $("#huecoCabecera").text("el EWALL de " + $("#nombreMuro").val());
    } else {
        $("#huecoCabecera").text("en tu EWALL");
        $("#retorno").hide();
    }
    ;
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
        