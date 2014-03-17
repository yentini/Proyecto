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
public class ContenidoEnlace extends Contenido {

    private String texto;

    private String url;

    public ContenidoEnlace() {
    }

    public ContenidoEnlace(String texto, String url) {
        this.texto = texto;
        this.url = url;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ContenidoEnlace{" + "texto=" + texto + ", url=" + url + '}';
    }

}
