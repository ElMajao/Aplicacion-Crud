
package ec.edu.espoch.appcrud;
import ec.edu.espoch.appcrud.vistas.Vista;

/**
 *
 * @author ElMajao
 */
public class AppCrud {
    public static void main(String args[]) {
        //Creación del Objeto Vista e inicio de la interfaz 
        Vista vista=new Vista();
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }
}
