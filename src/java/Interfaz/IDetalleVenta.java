/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import TranferObject.DetalleVenta;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public interface IDetalleVenta {
    public abstract ArrayList<DetalleVenta> listadetalleVenta();
    public abstract boolean insertarVenta (DetalleVenta detven);
    public abstract boolean ActualizarVenta (DetalleVenta detven);
    public abstract boolean EliminarVenta (int IdDetalleVenta);
}
