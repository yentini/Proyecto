/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plan.proyecto.repositorios;

import com.plan.proyecto.beans.Contenido;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrador
 */
@Repository
@Transactional
public class DaoContenidoImpl extends DaoGenericoImpl<Contenido, Long> implements DaoContenido {

    @PersistenceContext
    EntityManager em;

    @Override
    public Contenido findByComentarioId(Long id) {
        TypedQuery<Contenido> query = em.createNamedQuery("Contenido.findByComentarioId", Contenido.class);
        query.setParameter("valor", id);
        return query.getSingleResult();
    }

}
