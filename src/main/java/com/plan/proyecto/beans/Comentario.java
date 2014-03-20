/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plan.proyecto.beans;

import java.util.Objects;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Administrador
 */
@Entity
@DiscriminatorValue("C")
@NamedQueries({
    @NamedQuery(name = "Comentario.findComentarioByCuenta", query = "SELECT m FROM Comentario m WHERE m.cuenta.id = :idValor")
})
public class Comentario extends Contenido {

    private String texto;

    public Comentario() {
    }

    public Comentario(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.texto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comentario other = (Comentario) obj;
        if (!Objects.equals(this.texto, other.texto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Comentario{" + "texto=" + texto + '}';
    }

}
