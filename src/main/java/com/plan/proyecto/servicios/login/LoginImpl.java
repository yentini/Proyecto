/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.plan.proyecto.servicios.login;

import com.plan.proyecto.repositorios.DaoCuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrador
 */
@Service
public class LoginImpl implements GestionLogin{

    @Autowired
    DaoCuenta dao;
    
    @Override
    public Boolean login(String email, String pwd) {
        return dao.findByEmailAndPassword(email, pwd) !=null ? true : false;
    }
    
}
