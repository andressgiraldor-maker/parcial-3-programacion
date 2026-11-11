import java.util.ArrayList;
import java.util.List;
public class Restaurante {

    //Atributos de la clase Restaurante
    private String nombre;
    private String nit;
    private String direccion;

    //Relaciones de la clase Restaurante
    private List<Cliente> listRestauranteClientes;
    private List<Pedido> listRestaurantePedidos;
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
        this.listRestaurantePedidos = new ArrayList<>();
        this.listRestauranteProductos = new ArrayList<>();
    }

    /**
     * metodo para agregar un cliente al restaurante
     * @param documento del cliente
     * @param nombre del cliente
     * @param telefono del cliente
     * @param gmail del cliente
     * @param direccion del cliente
     * @return
     */

    public boolean agregarClienteARestaurante(int documento, String nombre, int telefono, String gmail, String direccion){
        boolean existe= false;
        Cliente cliente= buscarClienteEnRestaurante(documento);

        if(cliente==null){
            Cliente cliente1= new Cliente(documento, nombre, telefono, gmail, direccion);
            listRestauranteClientes.add(cliente1);
            existe= true;
        }
        return existe;
    }

    /**
     * metodo para buscar un cliente en el restaurante
     * @param documento del cliente
     * @return
     */

    public Cliente buscarClienteEnRestaurante(int documento){
        Cliente encontrado= null;

        for(int i=0; i<listRestauranteClientes.size(); i++){
            Cliente cliente= listRestauranteClientes.get(i);

            if(cliente.getDocumento()== documento){
                encontrado= cliente;
            }
        }
        return encontrado;
    }

    /**
     * metodo para agregar un producto al restaurante
     * @param producto producto
     * @return
     */
    public boolean agregarProductoARestaurante(Producto producto){
        boolean agregado= false;
        Producto producto1= buscarProductoEnRestaurante(producto.getCodigo());

        if(producto1==null){
            listRestauranteProductos.add(producto1);
            agregado= true;
        }
        return agregado;

    }

    /**
     * metodo para buscar un producto en el restaurante
     * @param codigo del producto
     * @return
     */

    public Producto buscarProductoEnRestaurante(int codigo){
        Producto encontrado= null;

        for(int i=0; i<listRestauranteProductos.size(); i++){
            Producto producto= listRestauranteProductos.get(i);

            if(producto.getCodigo()== codigo){
                encontrado= producto;
            }
        }
        return encontrado;
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
        return listRestaurantePedidos;
    }

    public void setListRestaurantePedido(List<Pedido> listRestaurantePedido) {
        this.listRestaurantePedidos = listRestaurantePedido;
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
                ", listRestaurantePedido=" + listRestaurantePedidos + "\n" +
                ", listRestauranteProductos=" + listRestauranteProductos + "\n" +
                '}';
    }
}
