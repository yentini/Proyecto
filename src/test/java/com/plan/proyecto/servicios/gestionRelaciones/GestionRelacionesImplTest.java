/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plan.proyecto.servicios.gestionRelaciones;

import com.plan.proyecto.beans.Cuenta;
import com.plan.proyecto.repositorios.DaoCuenta;
import com.plan.proyecto.servicios.gestionCuentas.GestionCuentas;
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
public class GestionRelacionesImplTest {

    Logger log = Logger.getLogger(GestionRelacionesImplTest.class.getName());

    @Autowired
    private GestionCuentas instance;

    @Autowired
    private DaoCuenta dao;

    @Autowired
    private GestionRelaciones gr;

    public GestionRelacionesImplTest() {
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
        dao.limpiezaCuentas();
    }

    /**
     * Test of mostrarCuentasSistema method, of class GestionRelacionesImpl.
     */
    @Test
    public void testMostrarCuentasSistema() {
        log.log(Level.INFO, "Muestra Cuentas Sistema");

        log.log(Level.INFO, "Prueba de mostrar cuentas");

        Cuenta cuenta = new Cuenta();
        cuenta.setNombre("antonio");
        cuenta.setEmail("antonioemail");
        instance.AltaCuenta(cuenta);

        List<Cuenta> cuentas = gr.mostrarCuentasSistema();

        assertEquals(cuentas.size(), 1);

        instance.BajaCuenta(cuenta);

        cuentas = gr.mostrarCuentasSistema();

        assertEquals(cuentas.size(), 0);
        log.log(Level.INFO, "Prueba de mostrar cuentas, terminada");
    }

    /**
     * Test of hacerAmigos method, of class GestionRelacionesImpl.
     */
    @Test
    public void testHacerAmigos() {
        System.out.println("sonAmigos");
        Cuenta origen = new Cuenta("email1", "pwd1");
        Cuenta destino = new Cuenta("email2", "pwd2");

        instance.AltaCuenta(origen);
        instance.AltaCuenta(destino);

        List<Cuenta> amigosNuevos = gr.hacerAmigos(origen, destino);
        List<Cuenta> amigos = gr.mostrarAmigos(origen);
        assertEquals(1, amigos.size());

    }

    /**
     * Test of sonAmigos method, of class GestionRelacionesImpl.
     */
    @Test
    public void testSonAmigos() {
        System.out.println("sonAmigos");
        Cuenta origen = new Cuenta("email1", "pwd1");
        Cuenta destino = new Cuenta("email2", "pwd2");
        Cuenta destino2 = new Cuenta("email3", "pwd3");

        instance.AltaCuenta(origen);
        instance.AltaCuenta(destino);
        instance.AltaCuenta(destino2);

        Boolean expResult = false;
        Boolean result = gr.sonAmigos(origen, destino);
        assertEquals(expResult, result);

        gr.hacerAmigos(origen, destino);
        List<Cuenta> amigos = gr.mostrarAmigos(origen);
        assertEquals(1, amigos.size());
        
        gr.hacerAmigos(origen, destino2);
        amigos = gr.mostrarAmigos(origen);
        assertEquals(2, amigos.size());
        
        expResult = true;
        result = gr.sonAmigos(origen, destino);
        assertEquals(expResult, result);
        
        expResult = true;
        result = gr.sonAmigos(origen, destino2);
        assertEquals(expResult, result);
        
        expResult = false;
        result = gr.sonAmigos(destino, destino2);
        assertEquals(expResult, result);
    }
}
