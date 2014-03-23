/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plan.proyecto.controladores;

import com.plan.proyecto.beans.Cuenta;
import com.plan.proyecto.servicios.gestionCuentas.GestionCuentas;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Administrador
 */
@Controller
@RequestMapping(value = {"/alta.html","/formularioLogin.html","/formularioAlta.html"})
public class AltaControlador {
    
    @Autowired
    GestionCuentas gc;

    @ModelAttribute("cuenta")
    public Cuenta getCuenta() {
        return new Cuenta();
    }

    @RequestMapping(method = RequestMethod.GET)
    public void tratarGet() {
    }

    @RequestMapping(method = RequestMethod.POST)
    public String tratarPost(@ModelAttribute("cuenta") Cuenta cuenta) {
       
//        if (gc.AltaCuenta(cuenta)!=null) {
//            log.log(Level.INFO, "Entramos");
//            return "muro";
//        }
        return "muro";
    }
}
