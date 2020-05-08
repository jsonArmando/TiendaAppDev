/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TiendaApp.controller.managedBeanProducto;

import com.TiendaApp.controller.dto.ProductoDTO;
import com.TiendaApp.controller.ejb.ProductoDTOFacadeLocal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author INDRA
 */
@ManagedBean
@SessionScoped
public class managedBeanProducto {

    @EJB
    private ProductoDTOFacadeLocal productoFacade;
    private List<ProductoDTO> listProducto;
    private ProductoDTO producto;
    String mensaje = "";

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }

    public List<ProductoDTO> getListProducto() {
        this.listProducto = this.productoFacade.findAll();
        return listProducto;
    }

    public void setListProducto(List<ProductoDTO> listProducto) {
        this.listProducto = listProducto;
    }

    @PostConstruct
    public void init() {
        this.producto = new ProductoDTO();
    }

    public void guardar() {
        try {
            if ("null".equals(this.producto.getId()) || "".equals(this.producto.getId())) {
                this.productoFacade.create(producto);
                this.mensaje = "Datos Guardado con éxito";
                this.producto = new ProductoDTO();
            } else {
                this.productoFacade.edit(producto);
                this.mensaje = "Datos se han actualizado con éxito";
                this.producto = new ProductoDTO();
            }

        } catch (Exception e) {
            this.mensaje = "Datos no han sido guardados";
        }
        FacesMessage mjs = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(null, mjs);
    }

    public void eliminar(ProductoDTO prod) {
        try {
            this.productoFacade.remove(prod);
            this.mensaje = "Datos Eliminados correctamente";
        } catch (Exception e) {
            this.mensaje = "Error" + e.getMessage();
        }
        FacesMessage mjs = new FacesMessage(this.mensaje);
        FacesContext.getCurrentInstance().addMessage(null, mjs);
    }

    public void editar(ProductoDTO prod) {
        this.producto.setNombreProducto(prod.getNombreProducto());
        this.producto.setDescripcionProducto(prod.getDescripcionProducto());
        this.producto.setPrecioProducto(prod.getPrecioProducto());
        this.producto.setCantidad(prod.getCantidad());
        this.producto.setFechaProducto(prod.getFechaProducto());
        this.producto = prod;
    }
    
    public void limpiar(){
        this.producto= new ProductoDTO();
        this.producto.setNombreProducto("");
    }

}
