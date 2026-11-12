import java.time.LocalDate;
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
            listRestauranteProductos.add(producto);
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

    /**
     * metodo para buscar un pedido en el restuarante
     * @param codigo del pedido
     * @return
     */
    public Pedido buscarPedidoEnRestaurante(int codigo){
        Pedido encontrado= null;

        for(int i=0; i<listRestaurantePedidos.size(); i++){
            Pedido pedido1 = listRestaurantePedidos.get(i);

            if(pedido1.getCodigo()== codigo){
                encontrado= pedido1;
            }
        }
        return encontrado;
    }

    /**
     * metodos para agregar un pedido al restaurante
     * @param codigo del pedido
     * @param fecha del pedido
     * @param cliente del pedido
     * @param distanciaKm del pedido
     * @param servicioAceptado del pedido
     * @param costoDomicilio del pedido
     * @return
     */
    public boolean agregarPedidoARestaurante(int codigo, LocalDate fecha, Cliente cliente, double distanciaKm, boolean servicioAceptado, double costoDomicilio, ModalidaEntrega entrega, EstadoPedido esstado){
        boolean agregado= false;
        Pedido pedido = buscarPedidoEnRestaurante(codigo);

        if(pedido==null){
            Pedido pedido1 = new Pedido(codigo, fecha, cliente, distanciaKm, servicioAceptado, costoDomicilio, entrega, esstado);
            listRestaurantePedidos.add(pedido1);
            agregado= true;
        }
        return agregado;
    }

    public double calcularTotalPedido(int codigo) {
        Pedido pedido = buscarPedidoEnRestaurante(codigo);
        if (pedido == null) {
            return 0;
        }
        return pedido.calcularValorProductos();
    }

    /**
     * metodo para confirmar un pedido y agregar al historial de ventas del cliente un pedido
     * @param pedido
     * @return
     */
    public boolean confirmarPedido(Pedido pedido) {
        if (pedido == null) {
            return false;
        }
        // Código no duplicado (evita confirmaciones repetidas)
        if (buscarPedidoEnRestaurante(pedido.getCodigo()) != null) {
            return false;
        }
        // Cliente registrado
        if (buscarClienteEnRestaurante(pedido.getCliente().getDocumento()) == null) {
            return false;
        }
        // Productos pertenecen al menú
        for (DetallePedido detalle : pedido.getListPedidoDetallePedidos()) {
            if (buscarProductoEnRestaurante(detalle.getProducto().getCodigo()) == null) {
                return false;
            }
        }
        // Cantidades, calidad y domicilio aceptado
        if (!pedido.confirmar()) {
            return false;
        }
        // Registrar en historial del restaurante y del cliente
        listRestaurantePedidos.add(pedido);
        pedido.getCliente().agregarPedidoAUnCliente(pedido);
        return true;
    }

    /**
     * metodo para conultar el hitorial de pedidos del cliente
     * @param documento
     * @return
     */
    public String consultarHistorialCliente(int documento) {
        Cliente cliente = buscarClienteEnRestaurante(documento);
        if (cliente == null) {
            return "Cliente no registrado.";
        }
        List<Pedido> pedidos = cliente.getListClientePedidos();
        if (pedidos.size() == 0) {
            return "El cliente no tiene pedidos.";
        }
        String resultado = "";
        for (Pedido pedido : pedidos) {
            resultado += "Código: " + pedido.getCodigo()
                    + " | Fecha: " + pedido.getFecha()
                    + " | Estado: " + pedido.getEstado()
                    + " | Total: $" + pedido.calcularValorProductos() + "\n";
        }
        return resultado;
    }

    /**
     * metodo para consultar los productos disponibles
     * @return
     */
    public List<Producto> consultarProductosDisponibles() {
        List<Producto> disponibles = new ArrayList<>();
        for (Producto producto : listRestauranteProductos) {
            if (producto.cumpleCondicionesCalidad()) {
                disponibles.add(producto);
            }
        }
        return disponibles;
    }

    /**
     * metodo para consultar los productos que no cumplen la calidad
     * @return
     */
    public List<Producto> consultarProductosNoCumplenCalidad() {
        List<Producto> noConformes = new ArrayList<>();
        for (Producto producto : listRestauranteProductos) {
            if (!producto.cumpleCondicionesCalidad()) {
                noConformes.add(producto);
            }
        }
        return noConformes;
    }

    /**
     * metodo para calcular los ingresos totales
     * @return
     */
    public double calcularIngresos() {
        double total = 0;
        for (Pedido pedido : listRestaurantePedidos) {
            if (pedido.getEstado() == EstadoPedido.CONFIRMADO
                    || pedido.getEstado() == EstadoPedido.ENTREGADO) {
                for (DetallePedido detalle : pedido.getListPedidoDetallePedidos()) {
                    total += detalle.calcularSubtotal();
                }
            }
        }
        return total;
    }

    /**
     * metodo para calcular los ingresos por domicilio
     * @return
     */
    public double calcularIngresosDomicilios() {
        double total = 0;
        for (Pedido pedido : listRestaurantePedidos) {
            if (pedido.getEstado() == EstadoPedido.CONFIRMADO
                    || pedido.getEstado() == EstadoPedido.ENTREGADO) {
                total += pedido.getCostoDomicilio();
            }
        }
        return total;
    }

    /**
     * metodo para ver el producto mas vendido
     * @return
     */
    public Producto productoMasVendido() {
        Producto masVendido = null;
        int maxUnidades = 0;

        for (Producto producto : listRestauranteProductos) {
            int unidades = 0;
            for (Pedido pedido : listRestaurantePedidos) {
                if (pedido.getEstado() == EstadoPedido.CONFIRMADO
                        || pedido.getEstado() == EstadoPedido.ENTREGADO) {
                    for (DetallePedido detalle : pedido.getListPedidoDetallePedidos()) {
                        if (detalle.getProducto().getCodigo() == producto.getCodigo()) {
                            unidades += detalle.getCantidad();
                        }
                    }
                }
            }
            if (unidades > maxUnidades) {
                maxUnidades = unidades;
                masVendido = producto;
            }
        }
        return masVendido;
    }

    /**
     * metodo para ver la categoria o producto con mas ingresos
     * @return
     */
    public String categoriaMayorIngreso() {
        double platos = 0;
        double bebidas = 0;
        double postres = 0;

        for (Pedido pedido : listRestaurantePedidos) {
            if (pedido.getEstado() == EstadoPedido.CONFIRMADO
                    || pedido.getEstado() == EstadoPedido.ENTREGADO) {
                for (DetallePedido detalle : pedido.getListPedidoDetallePedidos()) {
                    Producto producto = detalle.getProducto();
                    double subtotal = detalle.calcularSubtotal();
                    if (producto instanceof PlatoFuerte) {
                        platos += subtotal;
                    } else if (producto instanceof Bebida) {
                        bebidas += subtotal;
                    } else if (producto instanceof Postre) {
                        postres += subtotal;
                    }
                }
            }
        }

        if (platos == 0 && bebidas == 0 && postres == 0) {
            return "Sin ventas registradas";
        }
        if (platos >= bebidas && platos >= postres) {
            return "Platos fuertes";
        }
        if (bebidas >= postres) {
            return "Bebidas";
        }
        return "Postres";
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
