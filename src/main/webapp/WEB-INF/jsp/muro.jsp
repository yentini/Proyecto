<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <script src="js/jquery-1.11.0.js"></script>
        <script src="js/utilidadesMuro.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido a tu muro</title>
    </head>
    <body>
        <input id="id" type="hidden" value="${cuenta.id}">         
        <div><h2>${cuenta.nombre} estás en tu EWALL</h2></div>
        <div>
            <form:form id="login" action="formularioPublicarContenido.html" modelAttribute="mensaje">
                <form:textarea id="mensajeTexto" rows="8" cols="50" path="texto"></form:textarea>
                    <br>
                <input type="submit" id="botonPublicar" value="Publicar mensaje"></input>
            </form:form>
        </div>
    </body>
</html>
