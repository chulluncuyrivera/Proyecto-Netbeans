/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.conexion;
import Interfaz.IVenta;
import TranferObject.Producto;
import TranferObject.Venta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author USUARIO
 */
public class VentaDao implements IVenta{
 
    @Override
    public ArrayList<Venta> listaVenta() {
    ArrayList<Venta> listaVen =new ArrayList<>();
     
     conexion db = new conexion();
     Connection cn=db.getConnection();
     String procedimientoalmacenado ="{CALL SP_ListaVenta()}";
     //proceso
     if (cn !=null){
        try{
            CallableStatement cs = cn.prepareCall(procedimientoalmacenado);
            ResultSet rs= cs.executeQuery();
            while (rs.next());
            Venta ven = new Venta();
            
          
           ven.setDate(rs.getString("date"));
           
           ven.setTotal(rs.getDouble("total"));
       }
        catch (SQLException e){
        }finally{
            try{
                cn.close();
            }catch (SQLException e){
        }
     }
    
}
     return listaVen;   
    }

    @Override
    public boolean insertarVenta(Venta ven) {
     boolean insert=false;
     
     //proceso
     return insert;
    }

    @Override
    public boolean ActualizarVenta(Venta ven) {
     boolean update=false;
     
     //proceso
     return update; 
    }

    @Override
    public boolean EliminarVenta(int idVenta) {
    boolean delete=false;
     
     //proceso
     return delete;   
    }
}

