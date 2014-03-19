/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plan.proyecto.repositorios;

import com.plan.proyecto.beans.Contenido;

/**
 *
 * @author Administrador
 */
public interface DaoContenido extends DaoGenerico<Contenido, Long> {

    Contenido findByComentarioId(Long id);
}
