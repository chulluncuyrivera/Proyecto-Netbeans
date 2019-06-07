/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TranferObject;

import java.util.List;

/**
 *
 * @author USUARIO
 */
public class Categoria {
    
    private int idCategoria;
    private String descripcion;
    private char estado;
    private List<Producto> listProducto;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public List<Producto> getListProducto() {
        return listProducto;
    }

    public void setListProducto(List<Producto> listProducto) {
        this.listProducto = listProducto;
    }

  
}
