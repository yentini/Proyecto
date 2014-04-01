<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" href="js/jquery-ui-1.10.4/css/ui-lightness/jquery-ui-1.10.4.custom.css">
        <link rel="stylesheet" href="css/estilosPortada.css">
        <script src="js/jquery-1.11.0.js"></script>
        <script src="js/jquery-ui-1.10.4/js/jquery-ui-1.10.4.custom.js"></script>  
        <script src="js/jquery-validation-1.11.1/jquery.validate.js"></script> 
        <script src="js/jquery-validation-1.11.1/additional-methods.js"></script> 
        <script src="js/utilidades.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta de nuevas cuentas</title>
    </head>
    <body>
        <div id="principal">
            <div id="cabecera">
                <div id="rotuloEwall" class="izquierda">EWALL</div>
                <div id ="loginDiv" class="izquierda">
                    <div>
                        <form:form id="login" action="formularioLogin.html" commandName="cuentaLogin">
                            <table>   
                                <tr>
                                    <td colspan="2">Email:</td>
                                    <td colspan="2">Contraseña:</td>                            
                                </tr>
                                <tr>       
                                    <td>
                                        <form:input class="cajasLogin" path="email"/>
                                    </td>
                                    <td>
                                        <form:errors  class="cajasLogin" path="email"/>
                                    </td>
                                    <td>
                                        <form:password  class="cajasLogin" path="password"/>
                                    </td>
                                    <td>
                                        <form:errors  class="cajasLogin" path="password"/>
                                    </td>

                                    <td colspan="3">
                                        <input id="botonEntrar" type="submit" value="Entrar"/>
                                    </td>
                                </tr>

                            </table>
                        </form:form>
                    </div>
                    <div><h3>${mensajeLogin}</h3></div>
                </div>
            </div>
            <div id="cuerpo" class="clear">
                <div id="imagen" class="izquierda"><img src='<c:url value="/imagenes/amigos.gif" />'/></div>
                <div id="registro" class="izquierda">
                    <div id="rotuloRegistro">Regístrate</div>
                    <div id="formularioAlta">
                        <form:form id="alta" action="formularioAlta.html" commandName="cuentaAlta">

                            <table>
                                <tr>
                                    <td>Nombre:</td>
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
                                    <td>Correo electrónico:</td>
                                    <td>
                                        <form:input id="emailAlta" name="emailAlta" path="email"/>
                                    </td>
                                    <td>
                                        <form:errors path="email"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Vuelve a introducir el correo:</td>
                                    <td>
                                        <input name="email_again"/>
                                    </td>
                                    <td>
                                        <form:errors id="email_again"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Contraseña:</td>
                                    <td>
                                        <form:password id="password" name="password" path="password"/>
                                    </td>
                                    <td>
                                        <form:errors path="password"/>
                                    </td>
                                </tr>                
                                <tr>
                                    <td colspan="3">
                                        <input id="botonContinuar" type="submit" value=""/>
                                    </td>
                                </tr>
                            </table>
                        </form:form>
                    </div>
                </div>
                <div class="clear" id="mensajeAlta"><h3>${mensajeAlta}</h3></div>
            </div>
        </div>
    </body>
</html>
