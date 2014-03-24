/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plan.proyecto.controladores;

import com.plan.proyecto.beans.Cuenta;
import com.plan.proyecto.servicios.gestionCuentas.GestionCuentas;
import com.plan.proyecto.servicios.login.GestionLogin;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Administrador
 */
@Controller
//@RequestMapping(value = {"alta.html","formularioLogin.html"})
////@RequestMapping(value = {"alta.html","formularioLogin.html","formularioAlta.html"})
public class AltaControlador {

    @Autowired
    GestionCuentas gc;

    @Autowired
    GestionLogin gl;

    @ModelAttribute("cuentaAlta")
    public Cuenta getCuentaAlta() {
        return new Cuenta();
    }

    @ModelAttribute("cuentaLogin")
    public Cuenta getCuentaLogin() {

        return new Cuenta();
    }

    @RequestMapping(value="/alta.html",method = RequestMethod.GET)
    public void tratarGet() {
    }

    @RequestMapping(value = "formularioAlta.html", method = RequestMethod.POST)
    public String tratarAlta(@ModelAttribute("cuentaAlta") @Valid Cuenta cuenta, Model model) {

        if (gc.existeCuenta(cuenta)) {
            model.addAttribute("mensajeAlta", "El usuario ya existe");
            return "alta";
        } else {
            gc.AltaCuenta(cuenta);
            return "muro";
        }
    }

    @RequestMapping(value = "/formularioLogin.html", method = RequestMethod.POST)
    public String tratarLogin(@ModelAttribute("cuentaLogin") Cuenta cuenta, Model model) {

        Cuenta retornoCuenta = gl.autenticarse(cuenta);

        if (retornoCuenta != null) {
            model.addAttribute("cuenta", retornoCuenta);
            return "muro";
        } else {
            model.addAttribute("mensajeLogin", "El usuario no existe o la contraseña es incorrecta");
            return "alta";
        }

    }
}
