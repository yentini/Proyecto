/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plan.proyecto.controladores;

import com.plan.proyecto.beans.Cuenta;
import com.plan.proyecto.servicios.gestionCuentas.GestionCuentas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrador
 */
@RestController
public class MuroControlador {

    @Autowired
    GestionCuentas gc;

    @RequestMapping(value = "/otro.html")
    public Cuenta test(@RequestParam("id") Long id) {
        return gc.devolverCuenta(id);
    }
}
