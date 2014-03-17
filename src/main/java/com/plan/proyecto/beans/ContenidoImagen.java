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
public class ContenidoImagen extends Contenido {

    private String url;

    public ContenidoImagen() {
    }

    public ContenidoImagen(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ContenidoImagen{" + "url=" + url + '}';
    }

}
