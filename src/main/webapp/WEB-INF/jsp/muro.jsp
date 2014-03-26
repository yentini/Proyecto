<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" href="js/jquery-ui-1.10.4/css/ui-lightness/jquery-ui-1.10.4.custom.css">
        <script src="js/jquery-1.11.0.js"></script>
        <script src="js/jquery-ui-1.10.4/js/jquery-ui-1.10.4.custom.js"></script>
        <script src="js/utilidadesMuro.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido a tu muro</title>
    </head>
    <body>       
        <input id="idCuenta" type="hidden" value="${cuenta.id}"/>
        <input id="idMuro" type="hidden" value="${muroId.id}"/>
        <input id="nombreMuro" type="hidden" value="${muroId.nombre}"/>
        
        <div><h1>${cuenta.nombre} estás en <span id="huecoCabecera"></span></h1></div>
        <div id="retorno"><h3><a href="cambiarMuro.html?idAmigo=${cuenta.id}&ident=${cuenta.id}">Vuelve a tu EWALL</a></h3></div>
        <div>
            <div id="dialog-mensajePrincipal">
                <div id="dialog-mensaje" title="Crear nuevo mensaje">
                    <form:form id="login" action="formularioPublicarContenido.html?ident=${cuenta.id}" commandName="mensaje">
                        <form:textarea id="mensajeTexto" rows="6" cols="35" path="texto"></form:textarea>
                    </form:form>
                </div>
                <div>
                    <button id="crearMensaje">Publicar mensaje</button>
                </div>
            </div>
            <div id="dialog-comentarioPrincipal">
                <div id="dialog-comentario" title="Crear nuevo comentario">
                    <form:form id="comentarioForm" action="formularioPublicarContenido.html?ident=${cuenta.id}" commandName="mensaje">
                        <form:textarea id="comentarioTexto" rows="6" cols="35" path="texto"></form:textarea>
                    </form:form>
                </div>                
            </div>
            <br>
            <h2>Contenidos del muro</h2>
            <div id="mensajeAcordeon">
                <c:if test="${vacio == true}">
                    <h2>No tienes mensajes</h2>
                </c:if>
                <c:if test="${vacio == false}">
                    <c:forEach items="${mensajes}" var="mensaje">
                        <h3>
                            ${mensaje.resumen}
                        </h3>
                        <div>
                            <form:form id="eliminarForm" action="eliminarMensaje.html?identMensaje=${mensaje.id}&ident=${cuenta.id}">
                                <p>${mensaje.texto}</p>
                                <input id="eliminarBoton" type="button" value="Eliminar">
                                <input id="crearComentario" type="button" value="Comentar">
                            </form:form>
                        </div>
                    </c:forEach>
                </c:if>
            </div>
        </div>
        <br>
        <div id = "murosAmigosPrincipal">
            <h2>Puedes visitar los siguientes muros</h2>
            <div id="murosAmigos">
                    <c:forEach items="${muros}" var="muro">
                        <h3><a href="cambiarMuro.html?idAmigo=${muro.id}&ident=${cuenta.id}">${muro.nombre}</a></h3><br>
                    </c:forEach>
                <div id="muros">
                    
                </div>
            </div>
        </div>
        <div id ="relacionesPrincipal">
            <h2>Gestión de amigos</h2>
            <div id="relaciones">
                <ul>
                    <li><a href="#amigos">Amigos</a></li>
                    <li><a href="#posiblesAmigos">Nuevos Amigos</a></li>
                </ul>
                <div id="amigos">
                    <c:forEach items="${amigos}" var="amigo">
                        <a href="quitarAmigo.html?idAmigo=${amigo.id}&ident=${cuenta.id}">${amigo.nombre}</a><br>
                    </c:forEach>
                </div>
                <div id="posiblesAmigos">
                    <c:forEach items="${usuarios}" var="usuario">
                        <a href="hacerAmigo.html?idAmigo=${usuario.id}&ident=${cuenta.id}">${usuario.nombre}</a><br>
                    </c:forEach>
                </div>
            </div>
        </div>
    </body>
</html>
