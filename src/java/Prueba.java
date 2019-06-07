
import Dao.CategoriaDao;
import TranferObject.Categoria;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USUARIO
 * 3
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CategoriaDao catedao=new CategoriaDao();
        ArrayList<Categoria>lista=new ArrayList<>();
//        Categoria cate=new Categoria();
//        cate.setIdCategoria(1);
//        cate.setDescripcion("Metal");
//        cate.setEstado('B');
//        
//        catedao.insertarCategoria(cate);
        
        catedao.listarCategorias();
        lista=catedao.listarCategorias();
        for (int i = 0; i < lista.size(); i++) {
        System.out.println("dato:"+lista.get(i).getDescripcion());
            
        }
        catedao.EliminarCategoria(1);
        
        
    }
    
}
