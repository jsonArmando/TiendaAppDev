/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.TiendaApp.controller.ejb;

import com.TiendaApp.controller.dto.ProductoDTO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author INDRA
 */
@Local
public interface ProductoDTOFacadeLocal {

    void create(ProductoDTO productoDTO);

    void edit(ProductoDTO productoDTO);

    void remove(ProductoDTO productoDTO);

    ProductoDTO find(Object id);

    List<ProductoDTO> findAll();

    List<ProductoDTO> findRange(int[] range);

    int count();
    
}
