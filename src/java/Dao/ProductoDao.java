/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.conexion;
import Interfaz.IProducto;
import TranferObject.Producto;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class ProductoDao implements IProducto{
    
    @Override
    public ArrayList<Producto> listaProducto() {
     ArrayList<Producto> listaPro =new ArrayList<>();
     
     conexion db = new conexion();
     Connection cn=db.getConnection();
     String procedimientoalmacenado ="{CALL SP_ListaProducto()}";
     //proceso
     if (cn !=null){
        try{
            CallableStatement cs = cn.prepareCall(procedimientoalmacenado);
            ResultSet rs= cs.executeQuery();
            while (rs.next());
            Producto pro = new Producto();
           
            
            pro.setNombre(rs.getString("nombre"));
            listaPro.add(pro);
            pro.setMarca(rs.getString("marca"));
            listaPro.add(pro);
            pro.setPrecio(rs.getDouble("precio"));
            listaPro.add(pro);
            pro.setStock(rs.getInt("stock"));
            listaPro.add(pro);
      
        }
        catch (SQLException e){
        }finally{
            try{
                cn.close();
            }catch (SQLException e){
        }
     }
    
}
     return listaPro;
    
    }

    @Override
    public boolean insertarProducto(Producto pro) {
   boolean insert=false;
     
     //proceso
     return insert;
    }

    @Override
    public boolean ActualizarProducto(Producto pro) {
    boolean update=false;
     
     //proceso
     return update;    
    }

    @Override
    public boolean EliminarProducto(int idProducto) {
      boolean delete=false;
     
     //proceso
     return delete; 
    }
}
