/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import TranferObject.Categoria;
import java.util.ArrayList;


/**
 *
 * @author USUARIO
 */
public interface ICategoria {
    public abstract ArrayList<Categoria> listarCategorias();
    public abstract boolean insertarCategoria (Categoria cate);
    public abstract boolean ActualizarCategoria (Categoria cate);
    public abstract boolean EliminarCategoria (int idCategoria);
    
}
