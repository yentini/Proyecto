/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.plan.proyecto.beans;

import javax.persistence.Entity;

/**
 *
 * @author Administrador
 */
@Entity
public class ContenidoTexto extends Contenido{
    
    private String texto;

    public ContenidoTexto() {
    }

    public ContenidoTexto(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "ContenidoTexto{" + "id=" + super.getId() + "texto=" + texto + '}';
    }

   
    
}
