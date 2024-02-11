/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espoch.appcrud.modelos;
import ec.edu.espoch.appcrud.controladores.ControladorArchivo;
import java.util.LinkedList;

/**
 *
 * @author ElMajao
 */

/**
 * Clase para manejar una lista de productos.
 */
public class ListaProductos {
    
    // Lista enlazada de productos
    private LinkedList<Productos> productos;
    
    /**
     * Constructor de la clase ListaProductos.
     */
    public ListaProductos(){
        productos=new LinkedList();
    }
    
    /**
     * Método para agregar un producto a la lista.
     * 
     * @param producto El producto a agregar.
     */
    public void agregarProducto(Productos producto){
        productos.add(producto);
    }
    
    /**
     * Método para eliminar un producto de la lista por su índice.
     * 
     * @param indice El índice del producto a eliminar.
     */
    public void eliminar(int indice){
        productos.remove(indice);
    }
    
    /**
     * Método para obtener el número total de productos en la lista.
     * 
     * @return El número total de productos.
     */
    public Integer total(){
        return productos.size();
    }
    
    /**
     * Método para obtener un producto de la lista por su índice.
     * 
     * @param indice El índice del producto a obtener.
     * @return El producto en el índice especificado.
     */
    public Productos obtener(int indice){
        return productos.get(indice);
    }
    
    /**
     * Método para cargar productos desde un archivo y actualizar la lista.
     */
    public void cargarProductos(){
        ControladorArchivo bd=new ControladorArchivo();
        productos=bd.obtener();
    }
    
    /**
     * Método para guardar la lista de productos en un archivo.
     */
    public void guardarEnArchivo(){
        ControladorArchivo bd=new ControladorArchivo();
        bd.borrarTodo();
        for (int i=0;i<productos.size();i++){
            bd.registrarProducto(productos.get(i));            
        }
    }
}
