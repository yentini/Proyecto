/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plan.proyecto.servicios.gestionCuentas;

import com.plan.proyecto.beans.Cuenta;
import com.plan.proyecto.repositorios.DaoCuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrador
 */
@Service
@Transactional
public class GestionCuentasImpl implements GestionCuentas {

    @Autowired
    DaoCuenta dao;

    @Override
    public Boolean AltaCuenta(Cuenta cuenta) {

        if (cuenta == null) {
            return false;
        }
        if (!existeCuenta(cuenta)) {

            Cuenta c = dao.insertar(cuenta);

            if (c != null) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public Boolean ModificarCuenta(Cuenta cuenta) {
        if (cuenta == null) {
            return false;
        }

        if (existeCuenta(cuenta)) {
            dao.modificar(cuenta);
            return true;
        }
        return false;
    }

    @Override
    public Boolean BajaCuenta(Cuenta cuenta) {
        if (cuenta == null) {
            return false;
        }

        if (existeCuenta(cuenta)) {
            dao.eliminar(cuenta);
            return true;
        }
        return false;
    }

    private Boolean existeCuenta(Cuenta cuenta) {

        return !dao.findByNombre(cuenta.getNombre()).isEmpty();
    }

}
