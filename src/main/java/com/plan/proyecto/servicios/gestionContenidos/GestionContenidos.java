/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plan.proyecto.servicios.gestionContenidos;

import com.plan.proyecto.beans.Contenido;
import com.plan.proyecto.beans.Cuenta;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface GestionContenidos {

    boolean publicarContenido(Cuenta cuenta, Contenido mensaje, Contenido comentario);
    
    boolean eliminarContenido(Contenido contenido);

    List<Contenido> mostrarContenidos(Cuenta cuenta);
    
    
    
}
