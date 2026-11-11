import java.util.ArrayList;
import java.util.List;
public abstract  class Producto {

    //Atributos de la clase Prodcuto
    private int codigo;
    private String nombre;
    private String descripcion;
    private double precio;
    private int tiempoPreparacion;

    //Relaciones de la clase Producoto
    private List<DetallePedido> listProductoDetallePedidos;

    /**
     * metodo constructor de la clase Prodcuto
     * @param codigo del producto
     * @param nombre del produtco
     * @param descripcion del producto
     * @param precio del producto
     * @param tiempoPreparacion del producto
     */
    public Producto(int codigo, String nombre, String descripcion, double precio, int tiempoPreparacion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tiempoPreparacion = tiempoPreparacion;
        this.listProductoDetallePedidos =new ArrayList<>();
    }

    /**
     * metodo para clacular el precio de la venta que heredaran sus clases hijas
     * @return
     */

    public abstract double calcularPrecioVenta();

    /**
     * metodo para confimar si cumplen las condiciones de calidad que heredaran sus hijas
     * @return
     */

    public abstract  boolean cumpleCondicionesCalidad();

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

    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(int tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public List<DetallePedido> getListProdcutoDetallePedidos() {
        return listProductoDetallePedidos;
    }

    public void setListProductoDetallePedidos(List<DetallePedido> listProdcutoDetallePedidos) {
        this.listProductoDetallePedidos = listProdcutoDetallePedidos;
    }


    @Override
    public String toString() {
        return "Producto{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + "\n" +
                ", descripcion='" + descripcion + "'n" +
                ", precio=" + precio + "\n" +
                ", tiempoPreparacion='" + tiempoPreparacion + "\n" +
                ", listProductoDetallePedidos=" + listProductoDetallePedidos + "\n" +
                '}';
    }
}
