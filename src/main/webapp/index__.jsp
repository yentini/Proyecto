<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
        <title>JSP Page</title>
        <script type="text/javascript">
            function llamadaAjax() {
                $.ajax({
                    url: "muro.html",
                    type: "GET",
                    data: {
                        nombre: $("#nombre").val(),
                        clave: $("#clave").val()
                    },
                    dataType: "text",
                    success: function(json) {                        
                        $("#hueco").text("Datos del usuario: " + json.nombre + " " + json.clave);
                    },
                    error: function(xhr, status) {
                        alert("Ha ocurrido un error" + xhr);
                         alert("Ha ocurrido un error" + status);
                    },
                    complete: function(xhr, status) {
                        alert("Fin de la llamada Ajax");
                    }
                });
            }
        </script>
    </head>
    <body>        
        <table>
            <tr>
                <td>Nombre de usuario:</td>
                <td>
                    <input type="text" id="nombre"/>
                </td>
            </tr>
            <tr>
                <td>Clave de acceso:</td>
                <td>
                    <input type="text" id="clave"/>
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    <button onclick="llamadaAjax()">Login</button>
                </td>
            </tr>
        </table>
        <div id="hueco"/>
    </body>
</html>
