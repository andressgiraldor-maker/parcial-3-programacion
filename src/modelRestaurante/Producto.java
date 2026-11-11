import java.util.ArrayList;
import java.util.List;
public class Producto {

    //Atributos de la clase Prodcuto
    private int codigo;
    private String nombre;
    private String descripcion;
    private double precio;
    private String tiempoPreparacion;

    //Relaciones de la clase Producoto
    private List<DetallePedido> listProdcutoDetallePedidos;

    /**
     * metodo constructor de la clase Prodcuto
     * @param codigo del producto
     * @param nombre del produtco
     * @param descripcion del producto
     * @param precio del producto
     * @param tiempoPreparacion del producto
     */
    public Producto(int codigo, String nombre, String descripcion, double precio, String tiempoPreparacion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tiempoPreparacion = tiempoPreparacion;
        this.listProdcutoDetallePedidos =new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(String tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public List<DetallePedido> getListProdcutoDetallePedidos() {
        return listProdcutoDetallePedidos;
    }

    public void setListProdcutoDetallePedidos(List<DetallePedido> listProdcutoDetallePedidos) {
        this.listProdcutoDetallePedidos = listProdcutoDetallePedidos;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + "\n" +
                ", descripcion='" + descripcion + "'n" +
                ", precio=" + precio + "\n" +
                ", tiempoPreparacion='" + tiempoPreparacion + "\n" +
                ", listProdcutoDetallePedidos=" + listProdcutoDetallePedidos + "\n" +
                '}';
    }
}
