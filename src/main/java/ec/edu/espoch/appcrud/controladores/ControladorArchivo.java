/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espoch.appcrud.controladores;

import ec.edu.espoch.appcrud.modelos.Archivo;
import ec.edu.espoch.appcrud.modelos.Productos;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 *
 * @author ElMajao
 */
public class ControladorArchivo {
    
    /**
     * Método para obtener una lista de productos desde un archivo de texto.
     * 
     * @return Una lista enlazada de productos obtenidos desde el arc<hivo. Si el archivo no existe o está vacío, retorna null.
     */
    public LinkedList<Productos> obtener(){
        LinkedList<Productos> productos=null;
        Archivo archivo=new Archivo("productosTienda");
        LinkedList<String> lineas=archivo.obtenerTextoDelArchivo();
        if(lineas!=null){
            productos=new LinkedList();
            for(int i=0;i<lineas.size();i++){
                String linea=lineas.get(i);
                StringTokenizer tokens=new StringTokenizer(linea,";");
                String id=tokens.nextToken();
                String nombre=tokens.nextToken();
                String marca=tokens.nextToken();       
                int gramaje=Integer.parseInt(tokens.nextToken());
                int stock=Integer.parseInt(tokens.nextToken());  
                double pvp=Double.parseDouble(tokens.nextToken());
                productos.add(new Productos(id, nombre, marca, gramaje, stock, pvp));
            }
        } 
        return productos;
    }
    
    /**
     * Método para registrar un nuevo producto en el archivo de productos.
     * 
     * @param p El objeto Producto que se registrará en el archivo.
     * @return true si el producto se registró correctamente, false en caso contrario.
     */
    public boolean registrarProducto(Productos p){
        Archivo archivo=new Archivo("productosTienda");
        return archivo.registrar(p.getId()+";"
               + p.getNombre() + ";"
               + p.getMarca() + ";"
               + p.getGramaje() + ";"
               + p.getStock() + ";"
               + p.getPvp()
        );
    }
    
    /**
     * Método para borrar todo el contenido del archivo de productos.
     * 
     * @return true si se borró el contenido correctamente, false en caso contrario.
     */
    public boolean borrarTodo(){
        Archivo archivo=new Archivo("productosTienda");
        return archivo.borrarContenido();                
    }
}
