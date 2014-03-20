/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plan.proyecto.servicios.utilidades;

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
 * @author ccabrerizo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "../applicationContext.xml")
public class UrlParserTest {

    @Autowired
    UrlParser urlParser;

    Logger log = Logger.getLogger(UrlParserTest.class.getName());

    public UrlParserTest() {
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
    }

    /**
     * Test of pullLinks method, of class UrlParser.
     */
    @Test
    public void testPullLinks() {
        log.log(Level.INFO, "Prueba de parsear url");
        String text = "mira este enlace... www.as.com";
        List<String> expResult = null;
        List<String> result = urlParser.pullLinks(text);

        for (String string : result) {
            System.out.println("ppppppppp " + string);
        }
        
        text = text.replace(result.get(0), "<A href='" + result.get(0) + "'/>");

        System.out.println("ooooooooooooooooooooo " + text);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
