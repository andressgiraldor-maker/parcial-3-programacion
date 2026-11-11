import java.util.ArrayList;
import java.util.List;
public class Restaurante {

    //Atributos de la clase Restaurante
    private String nombre;
    private String nit;
    private String direccion;

    //Relaciones de la clase Restaurante
    private List<Cliente> listRestauranteClientes;
    private List<Pedido> listRestaurantePedido;
    private List<Producto> listRestauranteProductos;

    /**
     * metodo constructor de la clase Resturante
     * @param nombre del reaturante
     * @param nit del restaurante
     * @param direccion del restaurante
     */
    public Restaurante(String nombre, String nit, String direccion) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.listRestauranteClientes = new ArrayList<>();
        this.listRestaurantePedido = new ArrayList<>();
        this.listRestauranteProductos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Cliente> getListRestauranteClientes() {
        return listRestauranteClientes;
    }

    public void setListRestauranteClientes(List<Cliente> listRestauranteClientes) {
        this.listRestauranteClientes = listRestauranteClientes;
    }

    public List<Pedido> getListRestaurantePedido() {
        return listRestaurantePedido;
    }

    public void setListRestaurantePedido(List<Pedido> listRestaurantePedido) {
        this.listRestaurantePedido = listRestaurantePedido;
    }

    public List<Producto> getListRestauranteProductos() {
        return listRestauranteProductos;
    }

    public void setListRestauranteProductos(List<Producto> listRestauranteProductos) {
        this.listRestauranteProductos = listRestauranteProductos;
    }

    @Override
    public String toString() {
        return "Restaurante{" +
                "nombre='" + nombre + "\n" +
                ", nit='" + nit  + "\n" +
                ", direccion='" + direccion + "\n" +
                ", listRestauranteClientes=" + listRestauranteClientes + "\n" +
                ", listRestaurantePedido=" + listRestaurantePedido + "\n" +
                ", listRestauranteProductos=" + listRestauranteProductos + "\n" +
                '}';
    }
}
