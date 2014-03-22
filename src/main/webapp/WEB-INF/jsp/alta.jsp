<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <script src="js/utilidades.js"></script>
        <script src="js/jquery-1.11.0.js"></script>
        <script src="js/jquery-ui/jquery-ui.min.js"></script>
        <script>
            $(document).ready(function() {
                $("#fechaNacimiento").datepicker();
            });
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta de nuevas cuentas</title>
    </head>
    <body>
        <h2>Formulario de alta para EWallBook</h2>
        <form:form commandName="cuenta">
            <table>
                <tr>
                    <td>Nombre de usuario:</td>
                    <td>
                        <form:input path="nombre"/>
                    </td>
                    <td>
                        <form:errors path="nombre"/>
                    </td>
                </tr>
                <tr>
                    <td>Apellidos:</td>
                    <td>
                        <form:input path="apellidos"/>
                    </td>
                    <td>
                        <form:errors path="apellidos"/>
                    </td>
                </tr>
                <tr>
                    <td>Fecha de nacimiento:</td>
                    <td>                        
                        <form:input id="fechaNacimiento" path="fechaNacimiento"/>
                    </td>
                    <td>
                        <form:errors path="fechaNacimiento"/>
                    </td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td>
                        <form:input path="email"/>
                    </td>
                    <td>
                        <form:errors path="email"/>
                    </td>
                </tr>
                <tr>
                    <td>Contraseña:</td>
                    <td>
                        <form:password path="password"/>
                    </td>
                    <td>
                        <form:errors path="password"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="3">
                        <input type="submit" value="Continuar"/>
                    </td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
