/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espoch.appcrud.modelos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author ElMajao
 *
 * 
 * Clase para el manejo de archivos.
 */
public class Archivo {
    // Nombre del archivo
    private String nombre;

    /**
     * Constructor de la clase Archivo.
     *
     * @param nombre El nombre del archivo.
     */
    public Archivo(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para obtener el archivo correspondiente al nombre especificado.
     *
     * @return El objeto File que representa el archivo.
     */
    private File obtenerArchivo() {
        try {
            // Obtiene la ruta del directorio del escritorio
            String escritorio = System.getProperty("user.home") + "/Documents/";
            // Concatena el nombre del archivo al final de la ruta del escritorio
            File archivo = new File(escritorio + nombre);

            if (archivo.exists()) {
                return archivo;
            } else {
                // Si el archivo no existe, se crea uno nuevo en el escritorio
                archivo.createNewFile();
                return archivo;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Método para obtener el texto del archivo y almacenarlo en una lista enlazada.
     *
     * @return Una lista enlazada de cadenas de texto representando cada línea del archivo.
     */
    public LinkedList<String> obtenerTextoDelArchivo() {
        LinkedList<String> lineasDeTexto = null;
        try {
            File archivo = obtenerArchivo();
            if (archivo != null && archivo.exists()) {
                lineasDeTexto = new LinkedList<>();
                BufferedReader br = new BufferedReader(new FileReader(archivo));
                String linea;
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                    lineasDeTexto.add(linea);
                }
                br.close();
            } else {
                JOptionPane.showMessageDialog(null, "El archivo de texto no existe");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Se produjo un error");
        }
        return lineasDeTexto;
    }

    /**
     * Método para registrar una línea de texto en el archivo.
     *
     * @param linea La línea de texto a registrar en el archivo.
     * @return true si se registró correctamente, false en caso contrario.
     */
    public boolean registrar(String linea) {
        File archivo = obtenerArchivo();
        try {
            if (archivo.exists()) {
                FileWriter fw = new FileWriter(archivo, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println(linea);
                pw.flush();
                pw.close();
                return true;
            }
        } catch (Exception error) {
            error.printStackTrace();
        }
        return false;
    }

    /**
     * Método para borrar el contenido del archivo.
     *
     * @return true si se borró el contenido correctamente, false en caso contrario.
     */
    public boolean borrarContenido() {
        try {
            File archivo = obtenerArchivo();
            if (archivo.exists()) {
                PrintWriter writer = new PrintWriter(archivo);
                writer.print("");
                writer.close();
                return true;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}