/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.conexion;
import Interfaz.IDetalleVenta;
import TranferObject.DetalleVenta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class DetalleVentaDao implements IDetalleVenta{
   @Override
    public ArrayList<DetalleVenta> listadetalleVenta() {
     ArrayList<DetalleVenta> listadetven =new ArrayList<>();
     
     conexion db = new conexion();
     Connection cn=db.getConnection();
     String procedimientoalmacenado ="{CALL SP_listaDetalleVenta()}";
     //proceso
     if (cn !=null){
        try{
            CallableStatement cs = cn.prepareCall(procedimientoalmacenado);
            ResultSet rs= cs.executeQuery();
            while (rs.next());
            DetalleVenta detventa = new DetalleVenta(); 
          
            detventa.setIdDetalleVenta(rs.getInt("idDetalleVenta"));
            detventa.setCantidad(rs.getDouble("cantidad"));
            listadetven.add(detventa);
            detventa.setIdDetalleVenta(rs.getInt("detalleventa"));
            listadetven.add(detventa);
            detventa.setSubtotal(rs.getString("total"));
            listadetven.add(detventa);
            
}
 catch (SQLException e){
        }finally{
            try{
                cn.close();
            }catch (SQLException e){
        }
     }
    
}
     return listadetven;   
    }

    @Override
    public boolean insertarVenta(DetalleVenta detven) {
       boolean insert=false;
     
     //proceso
     return insert;
    }

    @Override
    public boolean ActualizarVenta(DetalleVenta detven) {
       boolean update=false;
     
     //proceso
     return update;
    }

    @Override
    public boolean EliminarVenta(int IdDetalleVenta) {
      boolean delete=false;
     
     //proceso
     return delete;  
    }
}