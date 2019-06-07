/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import TranferObject.Venta;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public interface IVenta {
    
    public abstract ArrayList<Venta> listaVenta();
    public abstract boolean insertarVenta (Venta ven);
    public abstract boolean ActualizarVenta (Venta ven);
    public abstract boolean EliminarVenta (int idVenta);
}
