/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plan.proyecto.servicios.gestionCuentas;

import com.plan.proyecto.servicios.gestionCuentas.GestionCuentas;
import com.plan.proyecto.beans.Cuenta;
import com.plan.proyecto.repositorios.DaoCuenta;
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
public class GestionCuentasImplTest {

    @Autowired
    private GestionCuentas instance;

    @Autowired
    DaoCuenta dao;

    Logger log = Logger.getLogger(GestionCuentasImplTest.class.getName());

    public GestionCuentasImplTest() {

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
     * Test of AltaCuenta method, of class GestionCuentasImpl.
     */
    @Test
    public void testAltaCuenta() {
        log.log(Level.INFO, "AltaCuenta");

        log.log(Level.INFO, "Prueba de inserción de usuario");
        Cuenta cuenta = new Cuenta();
        cuenta.setNombre("cesar");
        Boolean expResult = true;
        Boolean result = instance.AltaCuenta(cuenta);
        assertEquals(expResult, result);
        log.log(Level.INFO, "Prueba de inserción de usuario terminada");

        log.log(Level.INFO, "Prueba de inserción de un segundo usuario repetido");
        expResult = false;
        result = instance.AltaCuenta(cuenta);
        assertEquals(expResult, result);
        log.log(Level.INFO, "Prueba de inserción de un segundo usuario repetido, terminada");
    }

    /**
     * Test of ModificarCuenta method, of class GestionCuentasImpl.
     */
    @Test
    public void testModificarCuenta() {
        log.log(Level.INFO, "ModificarCuenta");

        log.log(Level.INFO, "Prueba de modificación de una cuenta");
        log.log(Level.INFO, "Creo una cuenta");
        Cuenta cuenta = new Cuenta();
        cuenta.setNombre("maria");
        instance.AltaCuenta(cuenta);

        log.log(Level.INFO, "cuenta: " + cuenta.getApellidos());

        log.log(Level.INFO, "Modifico la cuenta");
        cuenta.setApellidos("marin");
        Boolean result = instance.ModificarCuenta(cuenta);
        Cuenta c = dao.findByNombre("maria").get(0);
                
        assertTrue(c.getApellidos().equals("marin"));
        log.log(Level.INFO, "Prueba de inserción de un segundo usuario repetido, terminada");
    }

    /**
     * Test of BajaCuenta method, of class GestionCuentasImpl.
     */
    @Test
    public void testBajaCuenta() {
        log.log(Level.INFO, "BajaCuenta");

        log.log(Level.INFO, "Prueba de eliminación de una cuenta");
        log.log(Level.INFO, "Creo una cuenta");
        Cuenta cuenta = new Cuenta();
        cuenta.setNombre("antonio");
        instance.AltaCuenta(cuenta);

        log.log(Level.INFO, "cuenta: " + cuenta.toString());

        log.log(Level.INFO, "Elimino la cuenta");
        Boolean expResult = true;
        Boolean result = instance.BajaCuenta(cuenta);
        assertEquals(expResult, result);
        log.log(Level.INFO, "Prueba de inserción de un segundo usuario repetido, terminada");
    }
}
