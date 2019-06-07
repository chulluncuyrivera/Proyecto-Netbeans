
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.conexion;
import Interfaz.ICategoria;
import TranferObject.Categoria;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class CategoriaDao implements ICategoria {

    @Override
    public ArrayList<Categoria> listarCategorias() {
        ArrayList<Categoria> listaCate = new ArrayList<>();//Almacenar los valores a Bd

        conexion db = new conexion();
        Connection cn = db.getConnection();
        String procedimientoalmacenado = "{CALL SP_ListaCategorias()}";
        //proceso
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(procedimientoalmacenado);
                ResultSet rs = cs.executeQuery();
                while(rs.next()){

                Categoria cate = new Categoria();
                cate.setIdCategoria(rs.getInt("idCategoria"));
                cate.setDescripcion(rs.getString("descripcion"));
                cate.setEstado(rs.getString("estado").charAt(0));
                listaCate.add(cate);
                }

            } catch (SQLException e) {
                System.out.println("error" + e);
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                    System.out.println("error" + e);
                }
            }

        }
        return listaCate;

    }

    @Override
    public boolean insertarCategoria(Categoria cate) {
        boolean insert = false;
        int res;
        conexion conn = new conexion();
        Connection cn = conn.getConnection();

        if (cn != null){

        try {
            CallableStatement cs = cn.prepareCall("CALL sp_insertarcategoria(?,?,?)");
            cs.setInt(1, cate.getIdCategoria());
            cs.setString(2, cate.getDescripcion());
            cs.setString(3, String.valueOf(cate.getEstado()));
            res = cs.executeUpdate();
            if (res == 1) {
                insert = true;
            }
        } catch (SQLException ex) {
            //Agregar codigo deseado
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                //Agregar Codigo deseado
            }
        }
        }

        //proceso
        return insert;
    }
    

    @Override
    public boolean ActualizarCategoria(Categoria cate) {
        boolean update = false;
        int res;
        conexion conn = new conexion();
        Connection cn = conn.getConnection();
        //proceso
        //preguntar si se ha llegado a conectar
        if (cn != null) {
            try {
                //se ha conectado exitosamente
                CallableStatement cs = cn.prepareCall("CALL sp_actualizarcategoria(?,?,?)");

                cs.setString(1, cate.getDescripcion());
                cs.setString(2, String.valueOf(cate.getEstado()));
                cs.setInt(3, cate.getIdCategoria());
                res = cs.executeUpdate();

                if (res == 1);
                update = true;
            } catch (SQLException ex) {

            }

        }
    return update ;
}

@Override
        public boolean EliminarCategoria(int idCategoria) {
       int res;
       boolean delete=false;
       conexion conn=new conexion();
       Connection cn=conn.getConnection();
       
       if(cn!=null){
        
           try {
               CallableStatement cs=cn.prepareCall("CALL sp_eliminararcategoria(?)");
           
               cs.setInt(1,idCategoria);
               res=cs.executeUpdate();
               
               if(res==1)
               delete=true;
               
               } catch (SQLException ex) {

                
           }
           
       }
     //proceso
     return delete; 
    
        }
}
