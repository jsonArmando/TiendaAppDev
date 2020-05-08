/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.TiendaApp.controller.ejb;

import com.TiendaApp.controller.dto.ProductoDTO;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author INDRA
 */
@Stateless
public class ProductoDTOFacade extends AbstractFacade<ProductoDTO> implements ProductoDTOFacadeLocal {
    @PersistenceContext(unitName = "TiendaAppDevPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoDTOFacade() {
        super(ProductoDTO.class);
    }
    
}
