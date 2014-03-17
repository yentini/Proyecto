/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plan.proyecto.servicios.utilidades;

import java.util.logging.Logger;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Component;

/**
 *
 * @author Administrador
 */
@Component
public class Encriptar {

    @Value("${claveEncrypt}")
//    @Value("#{systemProperties['constantes.claveEncrypt']}")
//    @Value("#{constantes['claveEncrypt']}")  
    private String claveEncrypt;

    private Logger log = Logger.getLogger(Encriptar.class.getName());

    public String encrypt(String cadena, String clave) {
        StandardPBEStringEncryptor s = new StandardPBEStringEncryptor();
        s.setPassword(clave);
        String temporal = s.encrypt(cadena);
        return s.encrypt(cadena);
    }

    public String encrypt(String cadena) {
        return encrypt(cadena, claveEncrypt);
    }

    public String decrypt(String cadena, String clave) {
        StandardPBEStringEncryptor s = new StandardPBEStringEncryptor();
        s.setPassword(clave);
        String devuelve = "";
        try {
            devuelve = s.decrypt(cadena);
        } catch (Exception e) {
        }
        return devuelve;
    }

    public String decrypt(String cadena) {
        return decrypt(cadena, claveEncrypt);
    }

//    public String encryptURL(String cadena) { 
//        String encrypt = encrypt(cadena,Constantes.CLAVE_ENCRYPT);
//        String encode="";
//        try {
//            encode = URLEncoder.encode(encrypt, "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        return encode; 
//    }
}
