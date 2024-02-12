package ec.edu.espoch.appcrud.controladores;

import ec.edu.espoch.appcrud.modelos.ListaProductos;
import ec.edu.espoch.appcrud.modelos.Productos;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author el profe ariel
 *
 * Clase para el control de una tabla de productos.
 */
public class ControladorTabla extends AbstractTableModel {

    // Lista de productos manejada por el controlador de la tabla  
    private ListaProductos productos;
    
    /**
     * Constructor. Inicializa la lista de productos y carga los productos desde un archivo.
     */
    public ControladorTabla() {
        productos = new ListaProductos();
        productos.cargarProductos();
    }
    
    @Override
    public int getRowCount() {
        // Devuelve el número total de filas en la tabla, que es igual al número total de productos
        return productos.total();
    }

    @Override
    public int getColumnCount() {
        // Devuelve el número de columnas en la tabla, que es igual a 6 para los diferentes atributos de los productos
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Devuelve el valor que se mostrará en la celda de la fila y columna especificadas
        Productos aux = productos.obtener(rowIndex);
        switch (columnIndex) {
            case 0:
                return aux.getId();
            case 1:
                return aux.getNombre();
            case 2:
                return aux.getMarca();
            case 3:
                return aux.getGramaje();
            case 4:
                return aux.getStock();
            default:
                return aux.getPvp();
        }
    }

    @Override
    public String getColumnName(int col) {
        // Devuelve el nombre de la columna en la posición especificada
        switch (col) {
            case 0:
                return "ID";
            case 1:
                return "NOMBRE";
            case 2:
                return "MARCA";
            case 3:
                return "GRAMAJE";
            case 4:
                return "STOCK";
            default:
                return "PVP";
        }
    }

    @Override
    public Class getColumnClass(int col) {
        // Devuelve la clase de datos para la columna en la posición especificada
        switch (col) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return Integer.class;
            case 4:
                return Integer.class;
            default:
                return Double.class;
        }
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        // Indica si la celda en la fila y columna especificadas es editable
        return true;
    }

    @Override
    public void setValueAt(Object value, int fila, int columna) {
        // Establece el valor de la celda en la fila y columna especificadas
        Productos aux = productos.obtener(fila);
        switch (columna) {
            case 0:
                aux.setId((String) value);
                break;
            case 1:
                aux.setNombre((String) value);
                break;
            case 2:
                aux.setMarca((String) value);
                break;
            case 3:
                aux.setGramaje((Integer) value);
                break;
            case 4:
                aux.setStock((Integer) value);
            default:
                aux.setPvp((Double) value);
        }
        fireTableCellUpdated(fila, columna);
    }
    
    /**
     * Método para agregar un nuevo producto a la tabla y actualizar la vista.
     * 
     * @param producto El producto a agregar.
     */
    public void agregarProducto(Productos producto) {
        productos.agregarProducto(producto);
        this.fireTableDataChanged();
    }
    
    /**
     * Método para eliminar un producto de la tabla y actualizar la vista.
     * 
     * @param indice El índice del producto a eliminar.
     */
    public void eliminarProducto(int indice) {
        productos.eliminar(indice);
        this.fireTableDataChanged();
    }
    
    /**
     * Método para guardar los productos en un archivo.
     */
    public void guardarEnArchivo() {
        productos.guardarEnArchivo();
    }
}
