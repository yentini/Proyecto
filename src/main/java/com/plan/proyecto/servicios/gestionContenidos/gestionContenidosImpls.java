/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plan.proyecto.servicios.gestionContenidos;

import com.plan.proyecto.beans.Contenido;
import com.plan.proyecto.beans.Cuenta;
import com.plan.proyecto.repositorios.DaoContenido;
import com.plan.proyecto.repositorios.DaoCuenta;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrador
 */
@Service
@Transactional
public class gestionContenidosImpls implements GestionContenidos {

    @Autowired
    DaoCuenta dao;

    @Autowired
    DaoContenido daoG;

    @Override
    public boolean publicarContenido(Cuenta cuenta, Contenido mensaje, Contenido comentario) {
        if (cuenta == null) {
            return false;
        }
        if (mensaje == null) {
            return false;
        }

        Cuenta cuentaRecuperada = dao.findByEmail(cuenta.getEmail());

        if (comentario == null) {
            cuentaRecuperada.getContenidos().add(mensaje);
            mensaje.setCuenta(cuentaRecuperada);
//        dao.modificar(recuperado);
            return true;
        } else {
            Contenido mensajeRecuperado = dao.findContenidosByCuenta(mensaje.getId()).get(0);

            mensajeRecuperado.getComentarios().add(comentario);
            cuentaRecuperada.getContenidos().add(comentario);
            comentario.setCuenta(cuentaRecuperada);
            return true;
        }
    }

    @Override
    public boolean eliminarContenido(Contenido contenido) {

        if (contenido == null) {
            return false;
        }

        Contenido mensaje = daoG.findByComentarioId(contenido.getId());

        if (mensaje == null) {
            daoG.eliminar(contenido);
            return true;
        } else {
            mensaje.getComentarios().remove(contenido);
            daoG.eliminar(contenido);
            return true;
        }
    }

    @Override
    public List<Contenido> mostrarContenidos(Cuenta cuenta) {
        if (cuenta == null) {

            return null;
        }

        Cuenta c = dao.findByNombre(cuenta.getNombre()).get(0);
        return dao.findContenidosByCuenta(c.getId());
    }

}
