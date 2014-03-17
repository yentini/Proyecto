/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plan.proyecto.repositorios;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrador
 */
@Repository
@Transactional
public class DaoGenericoImpl<T, Long> implements DaoGenerico<T, Long> {

    @PersistenceContext
    EntityManager em;

    @Override
    public T insertar(T t) {
        em.persist(t);
        return t;
    }

    @Override
    public T eliminar(T t) {
        T uno = em.merge(t);
        em.remove(uno);
        return t;
    }
    
     @Override
    public void eliminarById(Long id) {
        em.remove(id);
    }

    @Override
    public T modificar(T t) {        
        return em.merge(t);
    }

}
