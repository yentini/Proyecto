<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" href="js/jquery-ui-1.10.4/css/ui-lightness/jquery-ui-1.10.4.custom.css">
        <link rel="stylesheet" href="css/estilosMuro.css">
        <script src="js/jquery-1.11.0.js"></script>
        <script src="js/jquery-ui-1.10.4/js/jquery-ui-1.10.4.custom.js"></script>
        <script src="js/utilidadesMuro.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido a tu muro</title>
    </head>
    <body>  
        <div id="dialog-mensajePrincipal">
            <div id="dialog-mensaje" title="Crear nuevo mensaje">
                <form:form id="login" action="formularioPublicarContenido.html?ident=${cuenta.id}" commandName="mensaje">
                    <form:textarea id="mensajeTexto" rows="6" cols="35" path="texto"></form:textarea>
                </form:form>
            </div>
        </div>
        <div id="dialog-comentarioPrincipal">
            <div id="dialog-comentario" title="Crear nuevo comentario">
                <form:form id="comentarioForm" commandName="comentario">
                    <form:textarea id="comentarioTexto" rows="6" cols="35" path="texto"></form:textarea>
                </form:form>
            </div>                
        </div>
        <input id="idCuenta" type="hidden" value="${cuenta.id}"/>
        <input id="idMuro" type="hidden" value="${muroId.id}"/>
        <input id="nombreMuro" type="hidden" value="${muroId.nombre}"/>

        <div class="principal">
            <div id="cabecera">
                <div id="fondo" class="izquierda">
                    <div id="rotulo">${cuenta.nombre} estás en <span id="huecoCabecera"></span></div>                
                    <div id="retorno" ><h3><a id="vuelveEwall" href="cambiarMuro.html?idAmigo=${cuenta.id}&ident=${cuenta.id}">Vuelve a tu EWALL</a></h3></div>
                    <div id="rotuloPublicar">
                        <button id="crearMensaje">Publicar mensaje</button>
                    </div></div>  
                <div id="botonSalir" class="derecha">
                    <a href="alta.html"><img src='<c:url value="/imagenes/Boton-Salir.png" />'/></a>
                </div>


            </div>
            <div id="cuerpo" class="clear">
                <div id="contenidosMuro">
                    <div id="rotuloCotenidos">Contenidos del muro</div>
                    <div id="mensajeAcordeon" class="acordeonPrincipal">  
                        <c:if test="${vacio == true}">
                            <div id="rotuloMensajes"><h2>No tienes mensajes</h2></div>
                        </c:if>
                        <c:if test="${vacio == false}">
                            <c:forEach items="${mensajes}" var="mensaje">
                                <h2>
                                    ${mensaje.resumen}
                                </h2>
                                <div>    
                                    <div>
                                        <form:form id="eliminarForm" action="eliminarMensaje.html?identMensaje=${mensaje.id}&ident=${cuenta.id}">
                                            <p>${mensaje.texto}</p>
                                            <!--  <input id="eliminarBoton" class="eliminarBoton" type="button" value="Eliminar">-->
                                            <input id="crearComentario" class="crearComentario" name="${mensaje.id}" type="button" value="Comentar">
                                            <input type="submit" value="Eliminar">
                                        </form:form>
                                    </div>
                                    <div id="comentarioAcordeon" class="acordeonSecundario">
                                        <c:forEach items="${mensaje.comentarios}" var="comentario">
                                            <h3>
                                                ${comentario.cuenta.nombre} dice: ${comentario.resumen}
                                            </h3>
                                            <div>
                                                <form:form id="eliminarComentarioForm" action="eliminarMensaje.html?identMensaje=${comentario.id}&ident=${cuenta.id}">
                                                    <p>${comentario.texto}</p>
                                                    <input id="eliminarBoton" type="button" value="Eliminar"/>
                                                </form:form>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>
                            </c:forEach>
                        </c:if>
                    </div>
                </div>

                <div id = "murosAmigosPrincipal" >
                    <div id="rotuloMuros">Puedes visitar los siguientes muros</div>
                    <div id="murosAmigos">
                        <c:if test="${vacioMuros == true}">
                            <div id="rotuloSiMuros"><h2>No tienes muros que visitar</h2></div>
                        </c:if>
                        <c:if test="${vacioMuros == false}">
                            <c:forEach items="${muros}" var="muro">
                                <a class="enlacesMuro" href="cambiarMuro.html?idAmigo=${muro.id}&ident=${cuenta.id}">${muro.nombre} </a>
                            </c:forEach>
                        </c:if>
                        <div id="muros">

                        </div>
                    </div>
                </div>
                <div id ="relacionesPrincipal" >
                    <div id="rotuloMuros">Gestión de amigos</div>
                    <div id="relaciones">
                        <ul>
                            <li><a id="tabAmigos" href="#amigos">Amigos</a></li>
                            <li><a id="tabnAmigos" href="#posiblesAmigos">Nuevos Amigos</a></li>
                        </ul>
                        <div id="amigos">
                            <c:forEach items="${amigos}" var="amigo">
                                <a class="enlacesAmigos" href="quitarAmigo.html?idAmigo=${amigo.id}&ident=${cuenta.id}">${amigo.nombre}</a>
                            </c:forEach>
                        </div>
                        <div id="posiblesAmigos">
                            <c:forEach items="${usuarios}" var="usuario">
                                <a class="enlacesAmigos" href="hacerAmigo.html?idAmigo=${usuario.id}&ident=${cuenta.id}">${usuario.nombre}</a>
                            </c:forEach>
                        </div>
                    </div>

                </div>
                <div id="abajo">Todos los derechos reservados by Yentini</div>
            </div>

        </div>
    </body>
</html>
