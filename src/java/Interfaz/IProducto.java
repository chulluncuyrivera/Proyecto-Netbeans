/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import TranferObject.Producto;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public interface IProducto {
   
    public abstract ArrayList<Producto> listaProducto();
    public abstract boolean insertarProducto (Producto pro);
    public abstract boolean ActualizarProducto (Producto pro);
    public abstract boolean EliminarProducto (int idProducto);
}
