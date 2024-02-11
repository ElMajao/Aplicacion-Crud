/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espoch.appcrud.modelos;

/**
 *
 * @author ElMajao
 */
/**
 * Clase que representa un producto.
 */
public class Productos {
    // Atributos del producto
    private String id;    
    private String nombre;
    private String marca;   
    private Integer gramaje;
    private Integer stock;
    private Double pvp; 

    /**
     * Constructor de la clase Productos.
     * 
     * @param id El ID del producto.
     * @param nombre El nombre del producto.
     * @param marca La marca del producto.
     * @param gramaje El gramaje del producto.
     * @param stock El stock del producto.
     * @param pvp El precio de venta al público del producto.
     */
    public Productos(String id, String nombre, String marca, Integer gramaje, Integer stock, Double pvp) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.gramaje = gramaje;
        this.stock = stock;
        this.pvp = pvp;        
    }

    // Métodos getter y setter para cada atributo del producto

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getPvp() {
        return pvp;
    }

    public void setPvp(Double pvp) {
        this.pvp = pvp;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getGramaje() {
        return gramaje;
    }

    public void setGramaje(Integer gramaje) {
        this.gramaje = gramaje;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
