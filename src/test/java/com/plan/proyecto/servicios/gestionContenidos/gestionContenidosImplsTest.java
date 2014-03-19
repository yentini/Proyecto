/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plan.proyecto.servicios.gestionContenidos;

import com.plan.proyecto.beans.Contenido;
import com.plan.proyecto.beans.Mensaje;
import com.plan.proyecto.beans.ContenidoImagen;
import com.plan.proyecto.beans.Comentario;
import com.plan.proyecto.beans.Cuenta;
import com.plan.proyecto.repositorios.DaoCuenta;
import com.plan.proyecto.servicios.gestionCuentas.GestionCuentas;
import com.plan.proyecto.servicios.gestionCuentas.GestionCuentasImplTest;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Administrador
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "../applicationContext.xml")
public class gestionContenidosImplsTest {

    @Autowired
    private GestionCuentas instance;

    @Autowired
    private DaoCuenta dao;

    @Autowired
    private GestionContenidos gc;

    Logger log = Logger.getLogger(GestionCuentasImplTest.class.getName());

    public gestionContenidosImplsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
////        dao.limpiezaCuentas();
    }

    /**
     * Test of publicarContenido method, of class gestionContenidosImpls.
     */
//    @Test
//    public void testPublicarContenido() {
//        log.log(Level.INFO, "Publicar Contenido");
//        log.log(Level.INFO, "Prueba de publicación de un contenido");
//
//        Cuenta cuenta = new Cuenta();
//        cuenta.setNombre("cesar");
//        cuenta.setEmail("miemail");
//        instance.AltaCuenta(cuenta);
//
//        Contenido contenido = new Mensaje("Texto prueba");
//
//        Boolean result = gc.publicarContenido(cuenta, contenido);
//
//        Boolean expResult = true;
//        assertEquals(expResult, result);
//        log.log(Level.INFO, "Prueba de inserción de un contenido, terminada");
//    }

//    /**
//     * Test of eliminarContenido method, of class gestionContenidosImpls.
//     */
//    @Test
//    public void testEliminarContenido() {
//        log.log(Level.INFO, "Publicar Contenido");
//
//        log.log(Level.INFO, "Prueba de publicación de un contenido");
//        Cuenta cuenta = new Cuenta();
//        cuenta.setNombre("cesar");
//        cuenta.setEmail("cesar1");
//        instance.AltaCuenta(cuenta);
//
//        Contenido contenido = new Mensaje("Texto prueba");
//        gc.publicarContenido(cuenta, contenido);
//
//        cuenta = dao.findByNombre("cesar").get(0);
//        Contenido contenido1 = new Mensaje("Texto prueba");
//        gc.publicarContenido(cuenta, contenido1);
//
//        cuenta = dao.findByNombre("cesar").get(0);
//        Contenido contenido2 = new ContenidoImagen("url imagen pruebas");
//        gc.publicarContenido(cuenta, contenido2);
//
//        Boolean result = gc.eliminarContenido(cuenta, contenido);
//
//        Boolean expResult = true;
//        assertEquals(expResult, result);
//        log.log(Level.INFO, "Prueba de inserción de un segundo usuario repetido, terminada");
//    }

    /**
     * Test of mostrarContenidos method, of class gestionContenidosImpls.
     */
//    @Test
//    public void testMostrarContenidos() {
//        log.log(Level.INFO, "Mostrar Contenido");
//
//        log.log(Level.INFO, "Prueba de mostrar de un contenido");
//        Cuenta cuenta = new Cuenta();
//        cuenta.setNombre("piedad");
//        cuenta.setEmail("miemail2");
//        instance.AltaCuenta(cuenta);
//
//        Contenido contenido1 = new Mensaje("Texto prueba 1");
//        gc.publicarContenido(cuenta, contenido1);
//
//        cuenta = dao.findByNombre("piedad").get(0);
//        List<Contenido> contenidos = gc.mostrarContenidos(cuenta);
//
//        Contenido contenido2 = new Mensaje("Texto prueba 2");
//        gc.publicarContenido(cuenta, contenido2);
//
//        Contenido contenido3 = new ContenidoImagen("url imagen pruebas");
//        cuenta = dao.findByEmail("miemail2");
//        contenidos = gc.mostrarContenidos(cuenta);
//        gc.publicarContenido(cuenta, contenido3);
//
//        cuenta = dao.findByEmail("miemail2");
//        contenidos = gc.mostrarContenidos(cuenta);
//        assertEquals(contenidos.size(), 3);
//
//    }

    /**
     * Test of publicarComentario method, of class gestionContenidosImpls.
     */
    @Test
    public void testPublicarComentario() {
        log.log(Level.INFO, "Publicar comentario");
        log.log(Level.INFO, "Prueba de publicación de un comentario");

        Cuenta cuenta = new Cuenta();
        cuenta.setNombre("Cesar");
        cuenta.setEmail("cesaremail");
        instance.AltaCuenta(cuenta);
        
        Cuenta cuenta2 = new Cuenta();
        cuenta2.setNombre("Antonio");
        cuenta2.setEmail("antonioemail");
        instance.AltaCuenta(cuenta2);
        
        Cuenta cuenta3 = new Cuenta();
        cuenta3.setNombre("Piedad");
        cuenta3.setEmail("piedademail");
        instance.AltaCuenta(cuenta3);

        Contenido mensaje = new Mensaje("Mensaje prueba");
        gc.publicarContenido(cuenta, mensaje,null);
        
        Boolean result = true;
        
        Contenido comentario = new Comentario("Comentario prueba1");
        result = gc.publicarContenido(cuenta2, mensaje, comentario);
        
        Contenido comentario2 = new Comentario("Comentario prueba2");
        result = gc.publicarContenido(cuenta3, mensaje, comentario2);
        
//        gc.eliminarContenido(comentario2);
//        
        gc.eliminarContenido(comentario);
        
//        gc.eliminarContenido(mensaje);

        Boolean expResult = true;
        assertEquals(expResult, result);
        log.log(Level.INFO, "Prueba de inserción de un contenido, terminada");
    }

}
